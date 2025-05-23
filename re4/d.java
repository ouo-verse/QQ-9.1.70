package re4;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d f431178c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f431179a = false;

    /* renamed from: b, reason: collision with root package name */
    private c f431180b = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f431181a;

        a(c cVar) {
            this.f431181a = cVar;
        }

        @Override // re4.c
        public void log(String str, String str2) {
            this.f431181a.log(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements com.tencent.tbs.one.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f431183a;

        b(c cVar) {
            this.f431183a = cVar;
        }

        @Override // com.tencent.tbs.one.a
        public void log(String str, String str2) {
            this.f431183a.log(str, str2);
        }
    }

    d() {
    }

    public static d a() {
        if (f431178c == null) {
            synchronized (d.class) {
                if (f431178c == null) {
                    f431178c = new d();
                }
            }
        }
        return f431178c;
    }

    public c b() {
        return this.f431180b;
    }

    public boolean c() {
        return this.f431179a;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("\u514b\u9686\u4e0d\u88ab\u652f\u6301");
    }

    public synchronized void d(c cVar, re4.a aVar) {
        if (cVar != null && aVar != null) {
            this.f431180b = cVar;
            String str = "setLoggingHandler: " + aVar.d() + ", " + aVar.e() + ", " + aVar.b() + ", " + aVar.c();
            re4.b.d("LogController", str);
            Log.i("LogController", str);
            if (aVar.d()) {
                re4.b.e(new a(cVar));
            }
            if (aVar.e()) {
                aVar.a().setTBSOneLoggingHandler(new b(cVar));
            }
            aVar.b();
            this.f431179a = aVar.c();
            return;
        }
        re4.b.b("LogController", "setLoggingHandler, param has null");
    }
}
