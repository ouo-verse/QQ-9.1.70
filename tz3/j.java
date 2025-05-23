package tz3;

/* compiled from: P */
/* loaded from: classes25.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f437951a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void a(String str, Object... objArr);

        void d(String str, Object... objArr);

        void e(String str, String str2, Throwable th5);

        void e(String str, Object... objArr);

        void i(String str, Object... objArr);
    }

    private static boolean a() {
        return true;
    }

    public static boolean b() {
        if (f437951a && a()) {
            return true;
        }
        return false;
    }

    public static void c(a aVar) {
        if (aVar != null) {
            wz3.b.g(aVar);
        }
    }
}
