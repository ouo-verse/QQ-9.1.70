package ud0;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile td0.b f438807a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f438808b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static int f438809c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static int f438810d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static int f438811e = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ThreadLocal<StringBuilder> f438812a = new ThreadLocal<>();

        public static String a(Object... objArr) {
            StringBuilder b16 = b();
            for (Object obj : objArr) {
                b16.append(obj);
            }
            return b16.toString();
        }

        public static StringBuilder b() {
            ThreadLocal<StringBuilder> threadLocal = f438812a;
            StringBuilder sb5 = threadLocal.get();
            if (sb5 == null) {
                StringBuilder sb6 = new StringBuilder();
                threadLocal.set(sb6);
                return sb6;
            }
            sb5.setLength(0);
            return sb5;
        }
    }

    public static void a(String str, int i3, Object... objArr) {
        td0.b e16 = e();
        if (e16 != null) {
            e16.d(str, j(i3), objArr);
        } else {
            Log.d(str, a.a(objArr));
        }
    }

    public static void b(String str, int i3, Object... objArr) {
        td0.b e16 = e();
        if (e16 != null) {
            e16.e(str, j(i3), objArr);
        } else {
            Log.e(str, a.a(objArr));
        }
    }

    public static void c(String str, String str2) {
        if (h()) {
            a(str, f438811e, str2);
        }
    }

    public static void d(String str, String str2) {
        if (h()) {
            k(str, f438811e, str2);
        }
    }

    private static td0.b e() {
        if (f438807a == null) {
            synchronized (d.class) {
                if (f438807a == null) {
                    f438807a = (td0.b) c.a(td0.b.class);
                }
            }
        }
        return f438807a;
    }

    public static String f(Throwable th5) {
        td0.b e16 = e();
        if (e16 != null) {
            return e16.a(th5);
        }
        return Log.getStackTraceString(th5);
    }

    public static void g(String str, int i3, String str2) {
        td0.b e16 = e();
        if (e16 != null) {
            e16.i(str, j(i3), str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static boolean h() {
        td0.b e16 = e();
        if (e16 != null) {
            return e16.isColorLevel();
        }
        Log.e("QUILog", "isColorLevel() get delegate is null!");
        return true;
    }

    public static boolean i() {
        td0.b e16 = e();
        if (e16 != null) {
            return e16.isDevelopLevel();
        }
        Log.e("QUILog", "isDevelopLevel() get delegate is null!");
        return true;
    }

    private static int j(int i3) {
        if (i3 == f438810d && f438808b.get()) {
            return f438811e;
        }
        return i3;
    }

    public static void k(String str, int i3, String str2) {
        td0.b e16 = e();
        if (e16 != null) {
            e16.w(str, j(i3), str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void l(String str, int i3, Object... objArr) {
        td0.b e16 = e();
        if (e16 != null) {
            e16.b(str, j(i3), objArr);
        } else {
            Log.e(str, a.a(objArr));
        }
    }
}
