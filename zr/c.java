package zr;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    private boolean A;

    /* renamed from: g, reason: collision with root package name */
    private float f453025g;

    /* renamed from: h, reason: collision with root package name */
    private float f453026h;

    /* renamed from: i, reason: collision with root package name */
    private float f453027i;

    /* renamed from: j, reason: collision with root package name */
    private float f453028j;

    /* renamed from: k, reason: collision with root package name */
    private float f453029k;

    /* renamed from: l, reason: collision with root package name */
    private float f453030l;

    /* renamed from: m, reason: collision with root package name */
    private float f453031m;

    /* renamed from: n, reason: collision with root package name */
    private float f453032n;

    /* renamed from: o, reason: collision with root package name */
    private float f453033o;

    /* renamed from: p, reason: collision with root package name */
    private float f453034p;

    /* renamed from: q, reason: collision with root package name */
    private float f453035q;

    /* renamed from: r, reason: collision with root package name */
    private float f453036r;

    /* renamed from: z, reason: collision with root package name */
    private a f453044z;

    /* renamed from: a, reason: collision with root package name */
    private final int f453019a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final int f453020b = 1;

    /* renamed from: c, reason: collision with root package name */
    private final int f453021c = 2;

    /* renamed from: d, reason: collision with root package name */
    private final int f453022d = 3;

    /* renamed from: e, reason: collision with root package name */
    private final int f453023e = 4;

    /* renamed from: f, reason: collision with root package name */
    private int f453024f = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f453037s = -1;

    /* renamed from: t, reason: collision with root package name */
    private boolean f453038t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f453039u = false;

    /* renamed from: v, reason: collision with root package name */
    private float f453040v = 2.14748365E9f;

    /* renamed from: w, reason: collision with root package name */
    private float f453041w = 0.0f;

    /* renamed from: x, reason: collision with root package name */
    private Matrix f453042x = new Matrix();

    /* renamed from: y, reason: collision with root package name */
    private Matrix f453043y = new Matrix();

    private void b(MotionEvent motionEvent, boolean z16) {
        if (!this.f453039u) {
            this.f453039u = true;
            a(motionEvent, z16);
            return;
        }
        this.f453044z.f453063s = true;
        int pointerCount = g() ? motionEvent.getPointerCount() : 1;
        if (pointerCount == 1 && this.f453024f == 1) {
            if (this.f453038t) {
                this.f453038t = false;
                this.f453025g = motionEvent.getX(0);
                this.f453026h = motionEvent.getY(0);
                a aVar = this.f453044z;
                this.f453033o = aVar.f453048d;
                this.f453034p = aVar.f453049e;
                return;
            }
            float x16 = motionEvent.getX(0) - this.f453025g;
            float y16 = motionEvent.getY(0) - this.f453026h;
            a aVar2 = this.f453044z;
            aVar2.f453048d = this.f453033o + (x16 / aVar2.b());
            a aVar3 = this.f453044z;
            aVar3.f453049e = this.f453034p + (y16 / aVar3.b());
            return;
        }
        if (pointerCount == 2 && this.f453024f == 2) {
            float d16 = e.d(motionEvent);
            float b16 = e.b(motionEvent);
            float[] a16 = e.a(motionEvent);
            float f16 = a16[0];
            float f17 = a16[1];
            a aVar4 = this.f453044z;
            aVar4.f453046b = this.f453035q * (d16 / this.f453027i);
            aVar4.f453047c = (this.f453036r + (b16 - this.f453028j)) % 360.0f;
            aVar4.f453048d = this.f453033o + ((f16 - this.f453029k) / aVar4.b());
            a aVar5 = this.f453044z;
            aVar5.f453049e = this.f453034p + ((f17 - this.f453030l) / aVar5.b());
            a aVar6 = this.f453044z;
            if (aVar6.f453053i) {
                float f18 = aVar6.f453046b;
                float f19 = this.f453040v;
                if (f18 > f19) {
                    aVar6.f453046b = f19;
                }
                float f26 = aVar6.f453046b;
                float f27 = this.f453041w;
                if (f26 < f27) {
                    aVar6.f453046b = f27;
                }
                float f28 = aVar6.f453047c;
                if (f28 < 0.0f) {
                    aVar6.f453047c = f28 + 360.0f;
                    return;
                }
                return;
            }
            aVar6.f453046b = this.f453035q;
            aVar6.f453047c = this.f453036r;
            return;
        }
        if (pointerCount == 1 && this.f453024f == 3 && z16) {
            float x17 = motionEvent.getX();
            a aVar7 = this.f453044z;
            float b17 = ((x17 - aVar7.f453045a.x) - aVar7.f453048d) / aVar7.b();
            float y17 = motionEvent.getY();
            a aVar8 = this.f453044z;
            float b18 = ((y17 - aVar8.f453045a.y) - aVar8.f453049e) / aVar8.b();
            float e16 = e.e(b17, b18);
            float c16 = e.c(b17, b18);
            a aVar9 = this.f453044z;
            float f29 = this.f453035q;
            float f36 = (e16 / this.f453027i) * f29;
            aVar9.f453046b = f36;
            float f37 = this.f453036r;
            float f38 = ((c16 - this.f453028j) + f37) % 360.0f;
            aVar9.f453047c = f38;
            if (aVar9.f453053i) {
                float f39 = this.f453040v;
                if (f36 > f39) {
                    aVar9.f453046b = f39;
                }
                float f46 = aVar9.f453046b;
                float f47 = this.f453041w;
                if (f46 < f47) {
                    aVar9.f453046b = f47;
                }
                if (f38 < 0.0f) {
                    aVar9.f453047c = f38 + 360.0f;
                    return;
                }
                return;
            }
            aVar9.f453046b = f29;
            aVar9.f453047c = f37;
        }
    }

    private void d(MotionEvent motionEvent) {
        this.f453044z.f453064t = false;
        if (this.f453024f == 2) {
            this.f453038t = true;
            this.f453024f = 1;
        }
    }

    private void f(MotionEvent motionEvent) {
        a aVar = this.f453044z;
        aVar.f453063s = false;
        aVar.f453064t = false;
        this.f453024f = 0;
        w();
    }

    public void A(boolean z16) {
        this.A = z16;
    }

    public void e(MotionEvent motionEvent, boolean z16) {
        if (this.f453044z == null) {
            return;
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f453037s = motionEvent.getPointerId(0);
        }
        if (g() || this.f453037s == motionEvent.getPointerId(motionEvent.getActionIndex())) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                a(motionEvent, z16);
                return;
            }
            if (action == 1) {
                f(motionEvent);
                return;
            }
            if (action == 2) {
                b(motionEvent, z16);
                return;
            }
            if (action != 5) {
                if (action == 6 && g()) {
                    d(motionEvent);
                    return;
                }
                return;
            }
            if (g()) {
                c(motionEvent);
            }
        }
    }

    protected boolean g() {
        return false;
    }

    protected int h() {
        return 10;
    }

    public Matrix j(a aVar, boolean z16) {
        this.f453042x.reset();
        if (aVar == null) {
            return this.f453042x;
        }
        this.f453042x.postRotate(aVar.f453047c);
        Matrix matrix = this.f453042x;
        PointF pointF = aVar.f453045a;
        matrix.postTranslate(pointF.x, pointF.y);
        this.f453042x.postTranslate(aVar.f453048d, aVar.f453049e);
        if (z16) {
            this.f453042x.postConcat(aVar.f453050f);
        }
        return this.f453042x;
    }

    public Matrix k(a aVar) {
        this.f453043y.reset();
        if (aVar == null) {
            return this.f453043y;
        }
        Matrix n3 = n(aVar);
        this.f453042x = n3;
        n3.invert(this.f453043y);
        return this.f453043y;
    }

    public Matrix o(a aVar, boolean z16) {
        this.f453042x.reset();
        if (aVar == null) {
            return this.f453042x;
        }
        this.f453042x.postRotate(aVar.f453047c);
        this.f453042x.postScale(m(aVar, false), m(aVar, false));
        PointF pointF = aVar.f453045a;
        if (pointF != null) {
            this.f453042x.postTranslate(pointF.x, pointF.y);
        }
        this.f453042x.postTranslate(aVar.f453048d, aVar.f453049e);
        if (z16) {
            this.f453042x.postConcat(aVar.f453050f);
        }
        return this.f453042x;
    }

    public void x(a aVar) {
        w();
        this.f453044z = aVar;
    }

    private void c(MotionEvent motionEvent) {
        motionEvent.getX(1);
        motionEvent.getY(1);
        a aVar = this.f453044z;
        aVar.f453064t = true;
        int i3 = this.f453024f;
        if (i3 == 1 || i3 == 3) {
            this.f453024f = 2;
            this.f453035q = aVar.f453046b;
            this.f453036r = aVar.f453047c;
            this.f453033o = aVar.f453048d;
            this.f453034p = aVar.f453049e;
            this.f453027i = e.d(motionEvent);
            this.f453028j = e.b(motionEvent);
            float[] a16 = e.a(motionEvent);
            this.f453029k = a16[0];
            this.f453030l = a16[1];
        }
    }

    protected void a(MotionEvent motionEvent, boolean z16) {
        this.f453039u = true;
        this.f453024f = 1;
        float x16 = motionEvent.getX(0);
        float y16 = motionEvent.getY(0);
        this.f453025g = x16;
        this.f453026h = y16;
        a aVar = this.f453044z;
        this.f453033o = aVar.f453048d;
        this.f453034p = aVar.f453049e;
        aVar.f453063s = false;
        aVar.f453064t = false;
        if (t(aVar, x16, y16) && z16) {
            this.f453024f = 3;
            a aVar2 = this.f453044z;
            this.f453035q = aVar2.f453046b;
            this.f453036r = aVar2.f453047c;
            float b16 = ((x16 - aVar2.f453045a.x) - aVar2.f453048d) / aVar2.b();
            a aVar3 = this.f453044z;
            float b17 = ((y16 - aVar3.f453045a.y) - aVar3.f453049e) / aVar3.b();
            this.f453027i = e.e(b16, b17);
            this.f453028j = e.c(b16, b17);
            PointF pointF = this.f453044z.f453045a;
            this.f453029k = pointF.x;
            this.f453030l = pointF.y;
        }
    }

    public Matrix i(a aVar) {
        return j(aVar, true);
    }

    public float l(a aVar) {
        return m(aVar, true);
    }

    public Matrix n(a aVar) {
        return o(aVar, true);
    }

    public void w() {
        this.f453044z = null;
        this.f453025g = 0.0f;
        this.f453026h = 0.0f;
        this.f453027i = 0.0f;
        this.f453028j = 0.0f;
        this.f453029k = 0.0f;
        this.f453030l = 0.0f;
        this.f453033o = 0.0f;
        this.f453034p = 0.0f;
        this.f453035q = 0.0f;
        this.f453036r = 0.0f;
        this.f453031m = 0.0f;
        this.f453032n = 0.0f;
        this.f453038t = false;
        this.f453039u = false;
        this.f453042x.reset();
        this.f453043y.reset();
    }

    public float m(a aVar, boolean z16) {
        if (aVar == null) {
            return 1.0f;
        }
        float f16 = aVar.f453046b * aVar.f453055k;
        return z16 ? f16 * aVar.b() : f16;
    }

    public boolean q(a aVar, float f16, boolean z16) {
        if (aVar == null) {
            return false;
        }
        float f17 = aVar.f453051g;
        float f18 = aVar.f453052h / 2.0f;
        float f19 = f17 / 2.0f;
        float f26 = -f19;
        float f27 = -f18;
        float[] fArr = {f26, f27};
        float[] fArr2 = {f19, f27};
        float[] fArr3 = {f26, f18};
        float[] fArr4 = {f19, f18};
        Matrix n3 = n(aVar);
        this.f453042x = n3;
        n3.mapPoints(fArr);
        n3.mapPoints(fArr2);
        n3.mapPoints(fArr3);
        n3.mapPoints(fArr4);
        if (QLog.isDevelopLevel()) {
            QLog.d("GestureHelper", 2, "isCloseToXLine x=" + f16 + " leftReach=" + z16 + "\nf[" + fArr[0] + "," + fArr[1] + "]\nf1[" + fArr2[0] + "," + fArr2[1] + "]\nf2[" + fArr3[0] + "," + fArr3[1] + "]\nf3[" + fArr4[0] + "," + fArr4[1] + "]\n");
        }
        if (z16) {
            if (fArr[0] <= f16 || fArr2[0] <= f16 || fArr3[0] <= f16 || fArr4[0] <= f16) {
                return true;
            }
        } else if (fArr[0] >= f16 || fArr2[0] >= f16 || fArr3[0] >= f16 || fArr4[0] >= f16) {
            return true;
        }
        return false;
    }

    public boolean r(a aVar, float f16, boolean z16) {
        if (aVar == null) {
            return false;
        }
        float f17 = aVar.f453051g;
        float f18 = aVar.f453052h / 2.0f;
        float f19 = f17 / 2.0f;
        float f26 = -f19;
        float f27 = -f18;
        float[] fArr = {f26, f27};
        float[] fArr2 = {f19, f27};
        float[] fArr3 = {f26, f18};
        float[] fArr4 = {f19, f18};
        Matrix n3 = n(aVar);
        this.f453042x = n3;
        n3.mapPoints(fArr);
        n3.mapPoints(fArr2);
        n3.mapPoints(fArr3);
        n3.mapPoints(fArr4);
        if (QLog.isDevelopLevel()) {
            QLog.d("GestureHelper", 2, "isCloseToYLine y=" + f16 + " topReach=" + z16 + "\nf[" + fArr[0] + "," + fArr[1] + "]\nf1[" + fArr2[0] + "," + fArr2[1] + "]\nf2[" + fArr3[0] + "," + fArr3[1] + "]\nf3[" + fArr4[0] + "," + fArr4[1] + "]\n");
        }
        if (z16) {
            if (fArr[1] <= f16 || fArr2[1] <= f16 || fArr3[1] <= f16 || fArr4[1] <= f16) {
                return true;
            }
        } else if (fArr[1] >= f16 || fArr2[1] >= f16 || fArr3[1] >= f16 || fArr4[1] >= f16) {
            return true;
        }
        return false;
    }

    public int p(g.c cVar, float f16, float f17) {
        if (cVar == null) {
            return -1;
        }
        float[] fArr = {f16, f17};
        k(cVar).mapPoints(fArr);
        float f18 = cVar.f453051g;
        float f19 = cVar.f453052h;
        if (this.A) {
            float f26 = cVar.f453046b;
            if (f18 * f26 < 200.0f) {
                f18 = 200.0f / f26;
            }
            if (f19 * f26 < 200.0f) {
                f19 = 200.0f / f26;
            }
        }
        return cVar.f68001z.t(f18, f19, fArr[0], fArr[1]);
    }

    public boolean s(a aVar, float f16, float f17, boolean z16) {
        if (aVar == null) {
            return false;
        }
        float[] fArr = {f16, f17};
        k(aVar).mapPoints(fArr);
        float l3 = l(aVar);
        float f18 = aVar.f453051g;
        float f19 = aVar.f453052h;
        if (z16) {
            int i3 = aVar.f453058n;
            f18 += (i3 / l3) * 2.0f;
            f19 += (i3 / l3) * 2.0f;
        }
        if (this.A) {
            float f26 = aVar.f453046b;
            if (f18 * f26 < 200.0f) {
                f18 = 200.0f / f26;
            }
            if (f19 * f26 < 200.0f) {
                f19 = 200.0f / f26;
            }
        }
        float f27 = f18 / 2.0f;
        float f28 = f19 / 2.0f;
        float f29 = -f27;
        float f36 = -f28;
        float d16 = (zr.a.d() / l(aVar)) / 2.0f;
        int h16 = h();
        float f37 = fArr[0];
        if (f37 >= f29 && f37 <= f27) {
            float f38 = fArr[1];
            if (f38 >= f36 && f38 <= f28) {
                return true;
            }
        }
        float f39 = h16;
        if (f37 >= (f29 - d16) - f39 && f37 <= f29 + d16 + f39) {
            float f46 = fArr[1];
            if (f46 >= (f36 - d16) - f39 && f46 <= f36 + d16 + f39) {
                return true;
            }
        }
        float f47 = (f27 - d16) - f39;
        if (f37 >= f47 && f37 <= f27 + d16 + f39) {
            float f48 = fArr[1];
            if (f48 >= (f36 - d16) - f39 && f48 <= f36 + d16 + f39) {
                return true;
            }
        }
        if (f37 >= f47 && f37 <= f27 + d16 + f39) {
            float f49 = fArr[1];
            if (f49 >= (f28 - d16) - f39 && f49 <= f28 + d16 + f39) {
                return true;
            }
        }
        return false;
    }

    public boolean t(a aVar, float f16, float f17) {
        if (aVar == null) {
            return false;
        }
        float[] fArr = {f16, f17};
        k(aVar).mapPoints(fArr);
        float l3 = l(aVar);
        float f18 = aVar.f453051g;
        int i3 = aVar.f453058n;
        float f19 = (f18 + ((i3 / l3) * 2.0f)) / 2.0f;
        float f26 = (aVar.f453052h + ((i3 / l3) * 2.0f)) / 2.0f;
        float d16 = (zr.a.d() / l3) / 2.0f;
        int h16 = h();
        float f27 = fArr[0];
        float f28 = h16;
        if (f27 >= (f19 - d16) - f28 && f27 <= f19 + d16 + f28) {
            float f29 = fArr[1];
            if (f29 >= (f26 - d16) - f28 && f29 <= f26 + d16 + f28) {
                return true;
            }
        }
        return false;
    }

    public boolean u(a aVar, float f16, float f17) {
        if (aVar == null) {
            return false;
        }
        float[] fArr = {f16, f17};
        k(aVar).mapPoints(fArr);
        float l3 = l(aVar);
        float f18 = aVar.f453051g;
        int i3 = aVar.f453058n;
        float f19 = f18 + ((i3 / l3) * 2.0f);
        float f26 = (aVar.f453052h + ((i3 / l3) * 2.0f)) / 2.0f;
        float d16 = (zr.a.d() / l3) / 2.0f;
        int h16 = h();
        float f27 = fArr[0];
        float f28 = -(f19 / 2.0f);
        float f29 = h16;
        if (f27 >= (f28 - d16) - f29 && f27 <= f28 + d16 + f29) {
            float f36 = fArr[1];
            float f37 = -f26;
            if (f36 >= (f37 - d16) - f29 && f36 <= f37 + d16 + f29) {
                return true;
            }
        }
        return false;
    }

    public boolean v(a aVar, float f16, float f17) {
        if (aVar == null) {
            return false;
        }
        float[] fArr = {f16, f17};
        k(aVar).mapPoints(fArr);
        float l3 = l(aVar);
        float f18 = aVar.f453051g;
        int i3 = aVar.f453058n;
        float f19 = (f18 + ((i3 / l3) * 2.0f)) / 2.0f;
        float f26 = (aVar.f453052h + ((i3 / l3) * 2.0f)) / 2.0f;
        float d16 = (zr.a.d() / l3) / 2.0f;
        int h16 = h();
        float f27 = fArr[0];
        float f28 = h16;
        if (f27 >= (f19 - d16) - f28 && f27 <= f19 + d16 + f28) {
            float f29 = fArr[1];
            float f36 = -f26;
            if (f29 >= (f36 - d16) - f28 && f29 <= f36 + d16 + f28) {
                return true;
            }
        }
        return false;
    }

    public void y(float f16) {
        if (f16 >= 0.0f) {
            this.f453040v = f16;
        }
    }

    public void z(float f16) {
        if (f16 >= 0.0f) {
            this.f453041w = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public PointF f453045a;

        /* renamed from: b, reason: collision with root package name */
        public float f453046b;

        /* renamed from: c, reason: collision with root package name */
        public float f453047c;

        /* renamed from: d, reason: collision with root package name */
        public float f453048d;

        /* renamed from: e, reason: collision with root package name */
        public float f453049e;

        /* renamed from: f, reason: collision with root package name */
        public Matrix f453050f;

        /* renamed from: g, reason: collision with root package name */
        public float f453051g;

        /* renamed from: h, reason: collision with root package name */
        public float f453052h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f453053i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f453054j;

        /* renamed from: k, reason: collision with root package name */
        public float f453055k;

        /* renamed from: l, reason: collision with root package name */
        public ValueAnimator f453056l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f453057m;

        /* renamed from: n, reason: collision with root package name */
        public int f453058n;

        /* renamed from: o, reason: collision with root package name */
        public int f453059o;

        /* renamed from: p, reason: collision with root package name */
        public int[] f453060p;

        /* renamed from: q, reason: collision with root package name */
        public int f453061q;

        /* renamed from: r, reason: collision with root package name */
        public int f453062r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f453063s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f453064t;

        /* renamed from: u, reason: collision with root package name */
        public SegmentKeeper f453065u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f453066v;

        /* renamed from: w, reason: collision with root package name */
        private float[] f453067w;

        public a(PointF pointF, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
            this.f453046b = 1.0f;
            this.f453047c = 0.0f;
            this.f453048d = 0.0f;
            this.f453049e = 0.0f;
            this.f453050f = new Matrix();
            this.f453053i = true;
            this.f453054j = false;
            this.f453055k = 1.0f;
            this.f453056l = null;
            this.f453058n = 0;
            this.f453059o = -1;
            this.f453061q = -1;
            this.f453062r = -1;
            this.f453063s = false;
            this.f453064t = false;
            this.f453065u = new SegmentKeeper();
            this.f453066v = false;
            this.f453067w = new float[9];
            this.f453045a = new PointF(pointF.x, pointF.y);
            this.f453046b = f16;
            this.f453047c = f17;
            this.f453048d = f18;
            this.f453049e = f19;
            this.f453051g = f26;
            this.f453052h = f27;
            this.f453053i = z16;
            this.f453066v = DeviceInfoMonitor.getModel().equals("MI 5C");
        }

        public float b() {
            this.f453050f.getValues(this.f453067w);
            return this.f453067w[0];
        }

        public boolean c() {
            return !this.f453065u.isEmpty();
        }

        public a(a aVar, float f16) {
            this.f453046b = 1.0f;
            this.f453047c = 0.0f;
            this.f453048d = 0.0f;
            this.f453049e = 0.0f;
            this.f453050f = new Matrix();
            this.f453053i = true;
            this.f453054j = false;
            this.f453055k = 1.0f;
            this.f453056l = null;
            this.f453058n = 0;
            this.f453059o = -1;
            this.f453061q = -1;
            this.f453062r = -1;
            this.f453063s = false;
            this.f453064t = false;
            this.f453065u = new SegmentKeeper();
            this.f453066v = false;
            this.f453067w = new float[9];
            PointF pointF = aVar.f453045a;
            this.f453045a = new PointF(pointF.x * f16, pointF.y * f16);
            this.f453046b = aVar.f453046b * f16;
            this.f453047c = aVar.f453047c;
            this.f453048d = aVar.f453048d * f16;
            this.f453049e = aVar.f453049e * f16;
            this.f453051g = aVar.f453051g;
            this.f453052h = aVar.f453052h;
            this.f453053i = aVar.f453053i;
            this.f453065u.set(aVar.f453065u);
        }

        public void a(Canvas canvas) {
        }

        public a() {
            this.f453046b = 1.0f;
            this.f453047c = 0.0f;
            this.f453048d = 0.0f;
            this.f453049e = 0.0f;
            this.f453050f = new Matrix();
            this.f453053i = true;
            this.f453054j = false;
            this.f453055k = 1.0f;
            this.f453056l = null;
            this.f453058n = 0;
            this.f453059o = -1;
            this.f453061q = -1;
            this.f453062r = -1;
            this.f453063s = false;
            this.f453064t = false;
            this.f453065u = new SegmentKeeper();
            this.f453066v = false;
            this.f453067w = new float[9];
        }
    }
}
