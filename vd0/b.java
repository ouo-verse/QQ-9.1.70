package vd0;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private double f441437a;

    /* renamed from: b, reason: collision with root package name */
    private double f441438b;

    /* renamed from: c, reason: collision with root package name */
    private double f441439c;

    /* renamed from: d, reason: collision with root package name */
    private int f441440d;

    b(int i3) {
        g(i3);
    }

    public static b a(double d16, double d17, double d18) {
        return new b(c.q(d16, d17, d18));
    }

    public static b b(int i3) {
        return new b(i3);
    }

    private void g(int i3) {
        this.f441440d = i3;
        a a16 = a.a(i3);
        this.f441437a = a16.e();
        this.f441438b = a16.d();
        this.f441439c = wd0.a.j(i3);
    }

    public double c() {
        return this.f441438b;
    }

    public double d() {
        return this.f441437a;
    }

    public double e() {
        return this.f441439c;
    }

    public void f(double d16) {
        g(c.q(this.f441437a, d16, this.f441439c));
    }

    public void h(double d16) {
        g(c.q(this.f441437a, this.f441438b, d16));
    }

    public int i() {
        return this.f441440d;
    }
}
