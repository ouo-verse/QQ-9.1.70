package xy2;

import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import com.tencent.mapsdk.internal.by;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public static final f f449110e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public static final f f449111f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public static final f f449112g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public static final f f449113h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public static final f f449114i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public static final f f449115j;

    /* renamed from: a, reason: collision with root package name */
    final float[] f449116a;

    /* renamed from: b, reason: collision with root package name */
    final float[] f449117b;

    /* renamed from: c, reason: collision with root package name */
    final float[] f449118c = new float[3];

    /* renamed from: d, reason: collision with root package name */
    boolean f449119d = true;

    static {
        f fVar = new f();
        f449110e = fVar;
        m(fVar);
        p(fVar);
        f fVar2 = new f();
        f449111f = fVar2;
        o(fVar2);
        p(fVar2);
        f fVar3 = new f();
        f449112g = fVar3;
        l(fVar3);
        p(fVar3);
        f fVar4 = new f();
        f449113h = fVar4;
        m(fVar4);
        n(fVar4);
        f fVar5 = new f();
        f449114i = fVar5;
        o(fVar5);
        n(fVar5);
        f fVar6 = new f();
        f449115j = fVar6;
        l(fVar6);
        n(fVar6);
    }

    f() {
        float[] fArr = new float[3];
        this.f449116a = fArr;
        float[] fArr2 = new float[3];
        this.f449117b = fArr2;
        r(fArr);
        r(fArr2);
        q();
    }

    private static void l(f fVar) {
        float[] fArr = fVar.f449117b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void m(f fVar) {
        float[] fArr = fVar.f449117b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void n(f fVar) {
        float[] fArr = fVar.f449116a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void o(f fVar) {
        float[] fArr = fVar.f449117b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void p(f fVar) {
        float[] fArr = fVar.f449116a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private void q() {
        float[] fArr = this.f449118c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f449118c[1];
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float b() {
        return this.f449117b[2];
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float c() {
        return this.f449116a[2];
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float d() {
        return this.f449117b[0];
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float e() {
        return this.f449116a[0];
    }

    public float f() {
        return this.f449118c[2];
    }

    public float g() {
        return this.f449118c[0];
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float h() {
        return this.f449117b[1];
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float i() {
        return this.f449116a[1];
    }

    public boolean j() {
        return this.f449119d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        int length = this.f449118c.length;
        float f16 = 0.0f;
        for (int i3 = 0; i3 < length; i3++) {
            float f17 = this.f449118c[i3];
            if (f17 > 0.0f) {
                f16 += f17;
            }
        }
        if (f16 != 0.0f) {
            int length2 = this.f449118c.length;
            for (int i16 = 0; i16 < length2; i16++) {
                float[] fArr = this.f449118c;
                float f18 = fArr[i16];
                if (f18 > 0.0f) {
                    fArr[i16] = f18 / f16;
                }
            }
        }
    }
}
