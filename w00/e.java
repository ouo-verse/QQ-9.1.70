package w00;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, w00.a> f444127a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f444128a = new e();
    }

    e() {
    }

    public static e b() {
        return a.f444128a;
    }

    public w00.a a(String str, String str2) {
        String str3 = str + str2;
        w00.a aVar = this.f444127a.get(str3);
        if (aVar != null) {
            return aVar;
        }
        w00.a a16 = d.a(str);
        this.f444127a.put(str3, a16);
        return a16;
    }

    public void c(String str, String str2) {
        this.f444127a.remove(str + str2);
    }
}
