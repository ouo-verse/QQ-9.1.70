package tw4;

/* compiled from: P */
/* loaded from: classes27.dex */
public class g implements sw4.h {

    /* renamed from: a, reason: collision with root package name */
    private static g f437871a;

    public static g e() {
        if (f437871a == null) {
            synchronized (g.class) {
                if (f437871a == null) {
                    f437871a = new g();
                }
            }
        }
        return f437871a;
    }

    @Override // sw4.h
    public sw4.b a() {
        return new b();
    }

    @Override // sw4.h
    public sw4.e b() {
        return new h();
    }

    @Override // sw4.h
    public sw4.a c() {
        return new a();
    }

    @Override // sw4.h
    public sw4.g d() {
        return new f();
    }

    @Override // sw4.h
    public sw4.c getDbManager() {
        return new c();
    }

    @Override // sw4.h
    public sw4.d getHttpDownloader() {
        return new d();
    }

    @Override // sw4.h
    public sw4.f getReportManager() {
        return new e();
    }
}
