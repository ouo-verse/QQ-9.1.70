package sv;

import com.tencent.av.opengl.ui.b;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    private InterfaceC11254a H;

    /* renamed from: e, reason: collision with root package name */
    private b f434803e;

    /* renamed from: a, reason: collision with root package name */
    private int f434799a = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f434801c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private long f434802d = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f434804f = false;

    /* renamed from: g, reason: collision with root package name */
    private float f434805g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f434806h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f434807i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f434808j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    private float f434809k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    private float f434810l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f434811m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f434812n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    private float f434813o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    private boolean f434814p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f434815q = false;

    /* renamed from: r, reason: collision with root package name */
    private float f434816r = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    private float f434817s = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f434818t = 1.0f;

    /* renamed from: u, reason: collision with root package name */
    private float f434819u = 1.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f434820v = 0.0f;

    /* renamed from: w, reason: collision with root package name */
    private float f434821w = 0.0f;

    /* renamed from: x, reason: collision with root package name */
    private boolean f434822x = false;

    /* renamed from: y, reason: collision with root package name */
    private float f434823y = 0.0f;

    /* renamed from: z, reason: collision with root package name */
    private float f434824z = 0.0f;
    private float A = 0.0f;
    private float B = 0.0f;
    private float C = 0.0f;
    private float D = 0.0f;
    private float E = 0.0f;
    private float F = 0.0f;
    private float G = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private boolean f434800b = false;

    /* compiled from: P */
    /* renamed from: sv.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC11254a {
        void onAnimationEnd();
    }

    public void a() {
        b bVar = this.f434803e;
        if (bVar != null) {
            synchronized (bVar.j()) {
                this.f434803e.j().remove(this);
            }
        }
        InterfaceC11254a interfaceC11254a = this.H;
        if (interfaceC11254a != null) {
            interfaceC11254a.onAnimationEnd();
            this.H = null;
        }
    }

    public float b() {
        return this.E;
    }

    public float c() {
        return this.F;
    }

    public float d() {
        return this.G;
    }

    public float e() {
        return this.f434820v;
    }

    public float f() {
        return this.f434821w;
    }

    public float g() {
        return this.f434807i;
    }

    public float h() {
        return this.f434810l;
    }

    public float i() {
        return this.f434813o;
    }

    public boolean j() {
        return this.f434822x;
    }

    public boolean k() {
        return this.f434815q;
    }

    public boolean l() {
        return this.f434804f;
    }

    public boolean m(long j3) {
        if (this.f434800b) {
            a();
        } else {
            if (this.f434802d == -1) {
                this.f434802d = j3;
            }
            long j16 = j3 - this.f434802d;
            if (j16 == 0) {
                return false;
            }
            int i3 = this.f434801c;
            if (j16 >= i3) {
                j16 = i3;
                this.f434800b = true;
                a();
            }
            int i16 = this.f434799a;
            float f16 = 1.0f;
            if (i16 == 0) {
                f16 = (((float) j16) * 1.0f) / this.f434801c;
            } else if (i16 == 1) {
                float f17 = (float) j16;
                float f18 = 1.0f * f17 * f17;
                int i17 = this.f434801c;
                f16 = (f18 / i17) / i17;
            } else if (i16 == 2) {
                long j17 = this.f434801c;
                if (j16 == 0) {
                    f16 = 0.0f;
                } else {
                    float f19 = (float) j16;
                    float f26 = (float) j17;
                    f16 = ((((f19 * 1.0f) * f19) / f26) / f26) * (((f26 * 2.0f) / f19) - 1.0f);
                }
            }
            if (this.f434804f) {
                float f27 = this.f434805g;
                this.f434807i = f27 + ((this.f434806h - f27) * f16);
                float f28 = this.f434808j;
                this.f434810l = f28 + ((this.f434809k - f28) * f16);
                float f29 = this.f434811m;
                this.f434813o = f29 + ((this.f434812n - f29) * f16);
            }
            if (this.f434815q) {
                float f36 = this.f434816r;
                this.f434820v = f36 + ((this.f434818t - f36) * f16);
                float f37 = this.f434817s;
                this.f434821w = f37 + ((this.f434819u - f37) * f16);
            }
            if (this.f434822x) {
                float f38 = this.f434823y;
                this.E = f38 + ((this.f434824z - f38) * f16);
                float f39 = this.A;
                this.F = f39 + ((this.B - f39) * f16);
                float f46 = this.C;
                this.G = f46 + (f16 * (this.D - f46));
            }
        }
        return this.f434800b;
    }

    public void n(InterfaceC11254a interfaceC11254a) {
        this.H = interfaceC11254a;
    }

    public void o(int i3) {
        int abs = Math.abs(i3);
        this.f434801c = abs;
        if (abs == 0) {
            this.f434801c = 1;
        }
    }

    public void p(float f16, float f17, float f18, float f19, float f26, float f27) {
        this.f434822x = true;
        this.f434823y = f16;
        this.E = f16;
        this.f434824z = f17;
        this.A = f18;
        this.F = f18;
        this.B = f19;
        this.C = f26;
        this.G = f26;
        this.D = f27;
    }

    public void q(float f16, float f17, float f18, float f19) {
        this.f434815q = true;
        this.f434816r = f16;
        this.f434820v = f16;
        this.f434817s = f17;
        this.f434821w = f17;
        this.f434818t = f18;
        this.f434819u = f19;
    }

    public void r(int i3) {
        this.f434799a = i3;
    }

    public void s(float f16, float f17, float f18, float f19, float f26, float f27) {
        this.f434804f = true;
        this.f434805g = f16;
        this.f434807i = f16;
        this.f434808j = f17;
        this.f434810l = f17;
        this.f434811m = f18;
        this.f434813o = f18;
        this.f434806h = f19;
        this.f434809k = f26;
        this.f434812n = f27;
    }

    public void t(b bVar) {
        this.f434803e = bVar;
    }

    public void u() {
        this.f434802d = -1L;
    }
}
