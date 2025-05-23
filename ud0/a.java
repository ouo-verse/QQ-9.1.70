package ud0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile td0.c f438801a;

    private static td0.c a() {
        if (f438801a == null) {
            synchronized (b.class) {
                if (f438801a == null) {
                    f438801a = (td0.c) c.a(td0.c.class);
                }
            }
        }
        return f438801a;
    }

    public static boolean b() {
        if (a() != null) {
            return a().isDebugVersion();
        }
        return false;
    }

    public static boolean c() {
        if (a() != null) {
            return a().a();
        }
        return false;
    }
}
