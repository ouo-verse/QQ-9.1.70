package pw2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static a f427773a;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        int a(String str, Throwable th5, String str2);

        int b(String str, Throwable th5, String str2);

        int d(String str, String str2);

        int e(String str, String str2);

        int e(String str, Throwable th5);

        int i(String str, String str2);

        int v(String str, String str2);

        int w(String str, String str2);
    }

    public static int a(String str, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.d(str, str2);
        }
        return -1;
    }

    public static int b(String str, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.e(str, str2);
        }
        return -1;
    }

    public static int c(String str, Throwable th5) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.e(str, th5);
        }
        return -1;
    }

    public static int d(String str, Throwable th5, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.b(str, th5, str2);
        }
        return -1;
    }

    public static int e(String str, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.i(str, str2);
        }
        return -1;
    }

    public static void f(a aVar) {
        f427773a = aVar;
    }

    public static int g(String str, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.v(str, str2);
        }
        return -1;
    }

    public static int h(String str, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.w(str, str2);
        }
        return -1;
    }

    public static int i(String str, Throwable th5, String str2) {
        a aVar = f427773a;
        if (aVar != null) {
            return aVar.a(str, th5, str2);
        }
        return -1;
    }
}
