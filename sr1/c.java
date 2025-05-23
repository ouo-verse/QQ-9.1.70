package sr1;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static int f434313b;

    /* renamed from: c, reason: collision with root package name */
    public static int f434314c;

    /* renamed from: d, reason: collision with root package name */
    public static int f434315d;

    /* renamed from: e, reason: collision with root package name */
    public static int f434316e;

    /* renamed from: f, reason: collision with root package name */
    public static int f434317f;

    /* renamed from: g, reason: collision with root package name */
    public static int f434318g;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<Integer, b> f434319a = new HashMap<>();

    static {
        int i3 = 0 + 1;
        int i16 = i3 + 1;
        f434315d = i3;
        int i17 = i16 + 1;
        f434316e = i16;
        int i18 = i17 + 1;
        f434317f = i17;
        f434313b = i18 + 1;
        f434318g = i18;
    }

    public c(h hVar) {
        b(hVar);
    }

    private void b(h hVar) {
        this.f434319a.put(Integer.valueOf(f434314c), new k(hVar));
        this.f434319a.put(Integer.valueOf(f434315d), new i(hVar));
        this.f434319a.put(Integer.valueOf(f434316e), new a(hVar));
        this.f434319a.put(Integer.valueOf(f434317f), new l(hVar));
        this.f434319a.put(Integer.valueOf(f434318g), new j(hVar));
    }

    public b a(int i3) {
        return this.f434319a.get(Integer.valueOf(i3));
    }
}
