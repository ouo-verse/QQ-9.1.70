package s0;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f433049a;

    public static synchronized void a(b bVar) {
        synchronized (a.class) {
            if (f433049a == null) {
                f433049a = bVar;
            } else {
                throw new IllegalStateException("Cannot re-initialize NativeLoader.");
            }
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (a.class) {
            if (!c()) {
                a(bVar);
            }
        }
    }

    public static synchronized boolean c() {
        boolean z16;
        synchronized (a.class) {
            if (f433049a != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }
}
