package vd0;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: k, reason: collision with root package name */
    public static final d f441445k = a(50.0d);

    /* renamed from: a, reason: collision with root package name */
    private final double f441446a;

    /* renamed from: b, reason: collision with root package name */
    private final double f441447b;

    /* renamed from: c, reason: collision with root package name */
    private final double f441448c;

    /* renamed from: d, reason: collision with root package name */
    private final double f441449d;

    /* renamed from: e, reason: collision with root package name */
    private final double f441450e;

    /* renamed from: f, reason: collision with root package name */
    private final double f441451f;

    /* renamed from: g, reason: collision with root package name */
    private final double[] f441452g;

    /* renamed from: h, reason: collision with root package name */
    private final double f441453h;

    /* renamed from: i, reason: collision with root package name */
    private final double f441454i;

    /* renamed from: j, reason: collision with root package name */
    private final double f441455j;

    d(double d16, double d17, double d18, double d19, double d26, double d27, double[] dArr, double d28, double d29, double d36) {
        this.f441451f = d16;
        this.f441446a = d17;
        this.f441447b = d18;
        this.f441448c = d19;
        this.f441449d = d26;
        this.f441450e = d27;
        this.f441452g = dArr;
        this.f441453h = d28;
        this.f441454i = d29;
        this.f441455j = d36;
    }

    public static d a(double d16) {
        return l(wd0.a.l(), (wd0.a.n(50.0d) * 63.66197723675813d) / 100.0d, d16, 2.0d, false);
    }

    public static d l(double[] dArr, double d16, double d17, double d18, boolean z16) {
        double c16;
        double exp;
        double max = Math.max(0.1d, d17);
        double[][] dArr2 = a.f441425k;
        double d19 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d26 = dArr3[0] * d19;
        double d27 = dArr[1];
        double d28 = d26 + (dArr3[1] * d27);
        double d29 = dArr[2];
        double d36 = d28 + (dArr3[2] * d29);
        double[] dArr4 = dArr2[1];
        double d37 = (dArr4[0] * d19) + (dArr4[1] * d27) + (dArr4[2] * d29);
        double[] dArr5 = dArr2[2];
        double d38 = (d19 * dArr5[0]) + (d27 * dArr5[1]) + (d29 * dArr5[2]);
        double d39 = (d18 / 10.0d) + 0.8d;
        if (d39 >= 0.9d) {
            c16 = wd0.b.c(0.59d, 0.69d, (d39 - 0.9d) * 10.0d);
        } else {
            c16 = wd0.b.c(0.525d, 0.59d, (d39 - 0.8d) * 10.0d);
        }
        double d46 = c16;
        if (z16) {
            exp = 1.0d;
        } else {
            exp = (1.0d - (Math.exp(((-d16) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d39;
        }
        double a16 = wd0.b.a(0.0d, 1.0d, exp);
        double[] dArr6 = {(((100.0d / d36) * a16) + 1.0d) - a16, (((100.0d / d37) * a16) + 1.0d) - a16, (((100.0d / d38) * a16) + 1.0d) - a16};
        double d47 = 5.0d * d16;
        double d48 = 1.0d / (d47 + 1.0d);
        double d49 = d48 * d48 * d48 * d48;
        double d56 = 1.0d - d49;
        double cbrt = (d49 * d16) + (0.1d * d56 * d56 * Math.cbrt(d47));
        double n3 = wd0.a.n(max) / dArr[1];
        double sqrt = Math.sqrt(n3) + 1.48d;
        double pow = 0.725d / Math.pow(n3, 0.2d);
        double pow2 = Math.pow(((dArr6[2] * cbrt) * d38) / 100.0d, 0.42d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d36) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d37) / 100.0d, 0.42d), pow2};
        double d57 = dArr7[0];
        double d58 = (d57 * 400.0d) / (d57 + 27.13d);
        double d59 = dArr7[1];
        return new d(n3, ((d58 * 2.0d) + ((d59 * 400.0d) / (d59 + 27.13d)) + (((400.0d * pow2) / (pow2 + 27.13d)) * 0.05d)) * pow, pow, pow, d46, d39, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public double b() {
        return this.f441446a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.f441449d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double d() {
        return this.f441453h;
    }

    public double e() {
        return this.f441454i;
    }

    public double f() {
        return this.f441451f;
    }

    public double g() {
        return this.f441447b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        return this.f441450e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double i() {
        return this.f441448c;
    }

    public double[] j() {
        return this.f441452g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double k() {
        return this.f441455j;
    }
}
