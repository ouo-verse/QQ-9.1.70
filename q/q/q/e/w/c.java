package q.q.q.e.w;

import j45.a;

/* compiled from: P */
/* loaded from: classes29.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f428116a;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface a {
        void a(String str);
    }

    private static void a(j45.a aVar) {
        e(aVar);
        a aVar2 = f428116a;
        if (aVar2 != null) {
            aVar2.a(aVar.toString());
        }
    }

    public static void b(String str, String str2) {
        if (d(6)) {
            a.b b16 = j45.a.b(6, str);
            b16.b(str2);
            a(b16.c());
        }
    }

    public static void c(a aVar) {
        f428116a = aVar;
    }

    private static boolean d(int i3) {
        return true;
    }

    public static void f(String str, String str2) {
        if (d(4)) {
            a.b b16 = j45.a.b(4, str);
            b16.b(str2);
            a(b16.c());
        }
    }

    private static void e(j45.a aVar) {
    }
}
