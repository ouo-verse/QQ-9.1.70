package vt1;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.f;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<com.tencent.mobileqq.guild.message.base.d> f443346a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static b f443347b;

    b() {
        b();
    }

    public static b a() {
        if (f443347b == null) {
            synchronized (b.class) {
                if (f443347b == null) {
                    f443347b = new b();
                }
            }
        }
        return f443347b;
    }

    void b() {
        ArrayList<Class<? extends com.tencent.mobileqq.guild.message.base.d>> arrayList = a.f443340b;
        if (arrayList != null) {
            Iterator<Class<? extends com.tencent.mobileqq.guild.message.base.d>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f443346a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("GuildMessageProcessorCallbacks", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(AppInterface appInterface, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.troop.data.c cVar2, MessageRecord messageRecord) {
        Iterator<com.tencent.mobileqq.guild.message.base.d> it = f443346a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, cVar, cVar2, messageRecord);
        }
    }

    public void d(MessageRecord messageRecord, MessageRecord messageRecord2) {
        Iterator<com.tencent.mobileqq.guild.message.base.d> it = f443346a.iterator();
        while (it.hasNext()) {
            it.next().b(messageRecord, messageRecord2);
        }
    }

    public void e(f fVar, MessageRecord messageRecord, MessageRecord messageRecord2) {
        Iterator<com.tencent.mobileqq.guild.message.base.d> it = f443346a.iterator();
        while (it.hasNext()) {
            it.next().c(fVar, messageRecord, messageRecord2);
        }
    }
}
