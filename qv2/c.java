package qv2;

import android.app.Application;
import ev2.e;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Application f429687a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f429688b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f429689c;

    /* renamed from: d, reason: collision with root package name */
    private final int f429690d;

    /* renamed from: e, reason: collision with root package name */
    private final String f429691e;

    /* renamed from: f, reason: collision with root package name */
    private final int f429692f;

    /* renamed from: g, reason: collision with root package name */
    private final String f429693g;

    /* renamed from: h, reason: collision with root package name */
    private final String f429694h;

    /* renamed from: i, reason: collision with root package name */
    private final String f429695i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f429696j;

    /* renamed from: k, reason: collision with root package name */
    private final String f429697k;

    /* renamed from: l, reason: collision with root package name */
    private final long f429698l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f429699m;

    /* renamed from: n, reason: collision with root package name */
    private final n.a f429700n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f429701o;

    /* renamed from: p, reason: collision with root package name */
    private final String f429702p;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Application f429703a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f429704b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f429705c;

        /* renamed from: d, reason: collision with root package name */
        private int f429706d;

        /* renamed from: e, reason: collision with root package name */
        private String f429707e;

        /* renamed from: f, reason: collision with root package name */
        private int f429708f;

        /* renamed from: g, reason: collision with root package name */
        private String f429709g;

        /* renamed from: h, reason: collision with root package name */
        private String f429710h;

        /* renamed from: i, reason: collision with root package name */
        private String f429711i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f429712j = true;

        /* renamed from: k, reason: collision with root package name */
        private String f429713k;

        /* renamed from: l, reason: collision with root package name */
        private long f429714l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f429715m;

        /* renamed from: n, reason: collision with root package name */
        private n.a f429716n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f429717o;

        /* renamed from: p, reason: collision with root package name */
        private String f429718p;

        public a q(int i3) {
            this.f429708f = i3;
            return this;
        }

        public a r(Application application) {
            this.f429703a = application;
            return this;
        }

        public c s() {
            return new c(this);
        }

        public a t(String str) {
            this.f429709g = str;
            return this;
        }

        public a u(boolean z16) {
            this.f429705c = z16;
            return this;
        }

        public a v(boolean z16) {
            this.f429704b = z16;
            return this;
        }

        public a w(String str) {
            this.f429711i = str;
            return this;
        }

        public a x(String str) {
            this.f429718p = str;
            return this;
        }

        public a y(String str) {
            this.f429707e = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f429687a = aVar.f429703a;
        this.f429688b = aVar.f429704b;
        this.f429689c = aVar.f429705c;
        this.f429690d = aVar.f429706d;
        this.f429691e = aVar.f429707e;
        this.f429692f = aVar.f429708f;
        this.f429693g = aVar.f429709g;
        this.f429694h = aVar.f429710h;
        this.f429695i = aVar.f429711i;
        this.f429696j = aVar.f429712j;
        this.f429697k = aVar.f429713k;
        this.f429698l = aVar.f429714l;
        this.f429699m = aVar.f429715m;
        this.f429700n = aVar.f429716n;
        this.f429701o = aVar.f429717o;
        this.f429702p = aVar.f429718p;
    }

    public Application a() {
        return this.f429687a;
    }

    public String b() {
        return this.f429693g;
    }

    public String c() {
        if (!b.e() && !e.e()) {
            return "";
        }
        return this.f429695i;
    }

    public String d() {
        return this.f429691e;
    }

    public String e() {
        return this.f429702p;
    }

    public boolean f() {
        return this.f429689c;
    }
}
