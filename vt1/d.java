package vt1;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.base.l;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import st1.h;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<l> f443350a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static d f443351b;

    d() {
        b();
    }

    public static d a() {
        if (f443351b == null) {
            synchronized (d.class) {
                if (f443351b == null) {
                    f443351b = new d();
                }
            }
        }
        return f443351b;
    }

    public static void c(@NonNull AppInterface appInterface, MessageRecord messageRecord, h.a aVar) {
        Iterator<l> it = f443350a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, messageRecord, aVar);
        }
    }

    public static void d(MessageRecord messageRecord) {
        Iterator<l> it = f443350a.iterator();
        while (it.hasNext()) {
            it.next().b(messageRecord);
        }
    }

    public static void e(AppInterface appInterface, long j3) {
        Iterator<l> it = f443350a.iterator();
        while (it.hasNext()) {
            it.next().c(appInterface, j3);
        }
    }

    void b() {
        ArrayList<Class<? extends l>> arrayList = a.f443339a;
        if (arrayList != null) {
            Iterator<Class<? extends l>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f443350a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("GuildSendMessageCallbackConfig", 1, "Init Fail", th5);
                }
            }
        }
    }
}
