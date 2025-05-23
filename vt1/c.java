package vt1;

import com.tencent.mobileqq.guild.message.base.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.synclogic.synclogic$FirstViewRsp;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<f> f443348a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static c f443349b;

    c() {
        b();
    }

    public static c a() {
        if (f443349b == null) {
            synchronized (c.class) {
                if (f443349b == null) {
                    f443349b = new c();
                }
            }
        }
        return f443349b;
    }

    public static void c(AppRuntime appRuntime, boolean z16, ArrayList<synclogic$GuildNode> arrayList) {
        Iterator<f> it = f443348a.iterator();
        while (it.hasNext()) {
            it.next().a(appRuntime, z16, arrayList);
        }
    }

    public static void d(AppRuntime appRuntime, boolean z16, synclogic$FirstViewRsp synclogic_firstviewrsp) {
        Iterator<f> it = f443348a.iterator();
        while (it.hasNext()) {
            it.next().b(appRuntime, z16, synclogic_firstviewrsp);
        }
    }

    void b() {
        ArrayList<Class<? extends f>> arrayList = a.f443345g;
        if (arrayList != null) {
            Iterator<Class<? extends f>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f443348a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("GuildMsgRegisterProxyConfig", 1, "Init Fail", th5);
                }
            }
        }
    }
}
