package w61;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import w61.c;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f444632a;

    /* renamed from: b, reason: collision with root package name */
    private c f444633b;

    /* renamed from: c, reason: collision with root package name */
    private b f444634c;

    /* renamed from: d, reason: collision with root package name */
    private d f444635d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f444636e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f444637f;

    /* renamed from: g, reason: collision with root package name */
    private long f444638g;

    /* renamed from: h, reason: collision with root package name */
    private long f444639h = 0;

    /* renamed from: i, reason: collision with root package name */
    private double f444640i;

    /* renamed from: j, reason: collision with root package name */
    private String f444641j;

    /* renamed from: k, reason: collision with root package name */
    private InterfaceC11464a f444642k;

    /* compiled from: P */
    /* renamed from: w61.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC11464a {
        void a(a aVar);
    }

    public a(Drawable drawable, Point point, c.b bVar, c.a aVar, long j3, double d16, boolean z16, String str, int i3) {
        this.f444632a = drawable;
        this.f444641j = str;
        this.f444640i = d16;
        this.f444638g = j3;
        double intrinsicWidth = drawable.getIntrinsicWidth() * this.f444640i;
        double intrinsicHeight = this.f444632a.getIntrinsicHeight() * this.f444640i;
        c cVar = new c();
        this.f444633b = cVar;
        cVar.a(point, intrinsicWidth, intrinsicHeight, i3);
        this.f444633b.f444648b.a(bVar);
        this.f444633b.f444649c.a(aVar);
        if (z16) {
            this.f444633b.f444650d = 3;
        }
        this.f444634c = new b(this.f444633b);
        this.f444635d = new d(this.f444633b, this.f444632a, this.f444640i);
    }

    private void a(long j3) {
        double d16 = (j3 - this.f444638g) / 1000.0d;
        c cVar = this.f444633b;
        double d17 = d(cVar.f444648b.f444655a, cVar.f444649c.f444653a, d16);
        c cVar2 = this.f444633b;
        double d18 = d(cVar2.f444648b.f444656b, cVar2.f444649c.f444654b, d16);
        c cVar3 = this.f444633b;
        c.b bVar = cVar3.f444648b;
        double d19 = bVar.f444655a;
        c.a aVar = cVar3.f444649c;
        double d26 = d19 + (aVar.f444653a * d16);
        bVar.f444655a = d26;
        double d27 = bVar.f444656b + (aVar.f444654b * d16);
        double d28 = d16 * 0.0d;
        bVar.f444655a = d26 + (d28 * d26);
        bVar.f444656b = d27 + (d28 * d27);
        cVar3.f444647a.offset((float) d17, (float) d18);
    }

    private double d(double d16, double d17, double d18) {
        return (((d16 * 2.0d) + (d17 * d18)) / 2.0d) * d18;
    }

    private void g(long j3) {
        double d16;
        double d17;
        double d18;
        long j16 = this.f444639h;
        if (j16 > 0) {
            long j17 = j3 - j16;
            double d19 = 1.0d;
            if (j17 > 500) {
                this.f444633b.f444650d = 0;
                d16 = 1.0d;
            } else if (j17 < 100) {
                double d26 = j17;
                double d27 = ((d26 * 1.0d) / 100.0d) + 1.0d;
                d16 = 1.0d + ((d26 * 0.4d) / 100.0d);
                d19 = d27;
            } else {
                if (j17 < 200) {
                    double d28 = j17 - 100;
                    d19 = (((-0.4d) * d28) / 100.0d) + 2.0d;
                    d17 = (d28 * (-0.6d)) / 100.0d;
                    d18 = 1.4d;
                } else if (j17 < 300) {
                    double d29 = j17 - 200;
                    d19 = (((-0.6d) * d29) / 100.0d) + 1.6d;
                    d17 = (d29 * 0.5d) / 100.0d;
                    d18 = 0.8d;
                } else if (j17 < 400) {
                    double d36 = j17 - 300;
                    d19 = 1.0d + ((0.2d * d36) / 100.0d);
                    d17 = (d36 * (-0.3d)) / 100.0d;
                    d18 = 1.3d;
                } else {
                    double d37 = (((j17 - 400) * (-0.2d)) / 100.0d) + 1.2d;
                    d16 = 1.0d;
                    d19 = d37;
                }
                d16 = d17 + d18;
            }
            this.f444635d.a(d19, d16);
            h();
        }
    }

    private void h() {
        RectF rectF = this.f444633b.f444647a;
        float f16 = rectF.left;
        int i3 = this.f444636e.left;
        if (f16 < i3) {
            rectF.offset(i3 - f16, 0.0f);
        }
        RectF rectF2 = this.f444633b.f444647a;
        float f17 = rectF2.right;
        int i16 = this.f444636e.right;
        if (f17 > i16) {
            rectF2.offset(i16 - f17, 0.0f);
        }
        RectF rectF3 = this.f444633b.f444647a;
        float f18 = rectF3.top;
        int i17 = this.f444636e.top;
        if (f18 < i17) {
            rectF3.offset(0.0f, i17 - f18);
        }
        RectF rectF4 = this.f444633b.f444647a;
        float f19 = rectF4.bottom;
        int i18 = this.f444636e.bottom;
        if (f19 > i18) {
            rectF4.offset(0.0f, i18 - f19);
        }
    }

    private int j(long j3) {
        c cVar = this.f444633b;
        if (cVar.f444650d == 2) {
            long j16 = (j3 - cVar.f444652f) - 2000;
            if (j16 > 0) {
                if (j16 > 700) {
                    cVar.f444650d = 1;
                    return 0;
                }
                return (int) (255 - ((j16 * 255) / 700));
            }
        }
        return 255;
    }

    private void k(Canvas canvas) {
        float f16;
        double d16 = this.f444633b.f444651e;
        if (d16 > 0.0d) {
            f16 = (float) (((r0.f444647a.left - d16) * 360.0d) / ((this.f444632a.getIntrinsicHeight() * 3.141592653589793d) * this.f444640i));
        } else {
            f16 = 0.0f;
        }
        canvas.rotate(f16, this.f444633b.f444647a.centerX(), this.f444633b.f444647a.centerY());
    }

    public void b(Canvas canvas) {
        if (this.f444636e == null) {
            Rect rect = new Rect();
            this.f444636e = rect;
            rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        if (this.f444637f == null) {
            this.f444637f = new Rect();
        }
    }

    public void c(Canvas canvas, long j3, Drawable drawable) {
        int i3;
        b(canvas);
        if (this.f444633b.f444650d == 3) {
            g(j3);
        } else {
            this.f444635d.e(j3, this.f444638g);
        }
        if (this.f444633b.f444650d != 1) {
            a(j3);
            int a16 = this.f444634c.a(this.f444636e, this.f444633b.f444647a);
            if (a16 != 0) {
                this.f444634c.b(this.f444636e, j3);
                int b16 = this.f444635d.b(a16);
                if (b16 != 0 && (i3 = this.f444633b.f444650d) != 2 && i3 != 3) {
                    this.f444635d.g(b16, j3);
                }
            }
        }
        if (this.f444633b.f444650d != 1) {
            int save = canvas.save();
            k(canvas);
            int j16 = j(j3);
            this.f444633b.f444647a.round(this.f444637f);
            drawable.setAlpha(j16);
            drawable.setBounds(this.f444637f);
            drawable.draw(canvas);
            canvas.restoreToCount(save);
        } else {
            InterfaceC11464a interfaceC11464a = this.f444642k;
            if (interfaceC11464a != null) {
                interfaceC11464a.a(this);
            }
        }
        this.f444638g = j3;
        if (this.f444639h == 0) {
            this.f444639h = j3;
        }
    }

    public String e() {
        return this.f444641j;
    }

    public long f() {
        return this.f444639h;
    }

    public void i(InterfaceC11464a interfaceC11464a) {
        this.f444642k = interfaceC11464a;
    }
}
