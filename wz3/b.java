package wz3;

import tz3.j;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static j.a f446791a;

    /* renamed from: b, reason: collision with root package name */
    private static final StringBuilder f446792b = new StringBuilder();

    public static void a(String str, String str2) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.d(str, str2);
        }
    }

    public static void b(String str, Object... objArr) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.d(str, objArr);
        }
    }

    public static void c(String str, String str2) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.e(str, str2, th5);
        }
    }

    public static void e(String str, Object... objArr) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.e(str, objArr);
        }
    }

    public static void f(String str, String str2) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.i(str, str2);
        }
    }

    public static void g(j.a aVar) {
        f446791a = aVar;
    }

    public static void h(String str, String str2) {
        j.a aVar = f446791a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public static void i(String str, Object... objArr) {
        if (f446791a != null) {
            f446792b.setLength(0);
            for (Object obj : objArr) {
                f446792b.append(obj);
            }
            f446791a.a(str, f446792b.toString());
        }
    }
}
