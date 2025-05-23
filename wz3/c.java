package wz3;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f446793b;

    /* renamed from: a, reason: collision with root package name */
    private Handler f446794a = new Handler(Looper.getMainLooper());

    c() {
    }

    public static c a() {
        if (f446793b == null) {
            synchronized (c.class) {
                if (f446793b == null) {
                    f446793b = new c();
                }
            }
        }
        return f446793b;
    }

    public void b(Runnable runnable) {
        Handler handler = this.f446794a;
        if (handler == null) {
            b.a("RFWBarrageThreadUtils", "[post] main handler should not be null.");
        } else if (runnable == null) {
            b.a("RFWBarrageThreadUtils", "[post] runnable should not be null.");
        } else {
            handler.post(runnable);
        }
    }
}
