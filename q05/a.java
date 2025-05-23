package q05;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f428164b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static a f428165c;

    /* renamed from: a, reason: collision with root package name */
    private List<InterfaceC11050a> f428166a = new Vector();

    /* compiled from: P */
    /* renamed from: q05.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public interface InterfaceC11050a {
        boolean onCall(String str, Bundle bundle);
    }

    public static a b() {
        if (f428165c == null) {
            synchronized (f428164b) {
                if (f428165c == null) {
                    f428165c = new a();
                }
            }
        }
        return f428165c;
    }

    public boolean a(String str, Bundle bundle) {
        boolean z16 = false;
        try {
            for (InterfaceC11050a interfaceC11050a : this.f428166a) {
                if (interfaceC11050a != null && interfaceC11050a.onCall(str, bundle)) {
                    z16 = true;
                }
            }
        } catch (Throwable th5) {
            QLog.e("IliveLiteEventCenter", 1, "call error", th5);
        }
        return z16;
    }

    public void c(InterfaceC11050a interfaceC11050a) {
        synchronized (this.f428166a) {
            this.f428166a.remove(interfaceC11050a);
        }
    }
}
