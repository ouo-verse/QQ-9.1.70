package y1;

import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static float[] f449252g;

    /* renamed from: h, reason: collision with root package name */
    private static final float[] f449253h;

    /* renamed from: i, reason: collision with root package name */
    private static final FloatBuffer f449254i;

    /* renamed from: j, reason: collision with root package name */
    private static final FloatBuffer f449255j;

    /* renamed from: a, reason: collision with root package name */
    private FloatBuffer f449256a = f449254i;

    /* renamed from: b, reason: collision with root package name */
    private FloatBuffer f449257b = f449255j;

    /* renamed from: d, reason: collision with root package name */
    private int f449259d = 2;

    /* renamed from: e, reason: collision with root package name */
    private int f449260e = 2 * 4;

    /* renamed from: c, reason: collision with root package name */
    private int f449258c = f449252g.length / 2;

    /* renamed from: f, reason: collision with root package name */
    private int f449261f = 8;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f449252g = fArr;
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f449253h = fArr2;
        f449254i = b.b(fArr);
        f449255j = b.b(fArr2);
    }

    public int a() {
        return this.f449259d;
    }

    public FloatBuffer b() {
        return this.f449257b;
    }

    public int c() {
        return this.f449261f;
    }

    public FloatBuffer d() {
        return this.f449256a;
    }

    public int e() {
        return this.f449258c;
    }

    public int f() {
        return this.f449260e;
    }
}
