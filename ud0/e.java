package ud0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile td0.e f438813a;

    public static boolean a(String str, boolean z16) {
        td0.e b16 = b();
        if (b16 == null) {
            return z16;
        }
        return b16.getBoolean(str, z16);
    }

    private static td0.e b() {
        if (f438813a == null) {
            synchronized (e.class) {
                if (f438813a == null) {
                    f438813a = (td0.e) c.a(td0.e.class);
                }
            }
        }
        return f438813a;
    }
}
