package s8;

import java.io.File;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    static k f433443a;

    /* renamed from: b, reason: collision with root package name */
    static a f433444b;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface a {
        void a(String str, boolean z16);

        String b(String str);
    }

    public static k b() {
        k kVar = f433443a;
        if (kVar != null) {
            return kVar;
        }
        throw new RuntimeException("FeedGlobalEnv does not init");
    }

    public static void d(k kVar, a aVar) {
        f433443a = kVar;
        f433444b = aVar;
    }

    public abstract boolean a(File file);

    public a c() {
        return f433444b;
    }

    public abstract boolean e(File file, File file2);
}
