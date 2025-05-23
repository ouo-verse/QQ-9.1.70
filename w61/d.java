package w61;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f444657a;

    /* renamed from: b, reason: collision with root package name */
    private double f444658b = 1.0d;

    /* renamed from: c, reason: collision with root package name */
    private double f444659c = 1.0d;

    /* renamed from: d, reason: collision with root package name */
    private double f444660d = 1.0d;

    /* renamed from: e, reason: collision with root package name */
    private double f444661e = 1.0d;

    /* renamed from: f, reason: collision with root package name */
    private c f444662f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f444663g;

    /* renamed from: h, reason: collision with root package name */
    private double f444664h;

    public d(c cVar, Drawable drawable, double d16) {
        this.f444662f = cVar;
        this.f444663g = drawable;
        this.f444664h = d16;
    }

    private double c(long j3, long j16) {
        if (Math.abs(this.f444660d - this.f444658b) < 0.01d) {
            return this.f444658b;
        }
        long j17 = j3 - j16;
        double d16 = this.f444660d;
        double d17 = this.f444658b;
        if (d16 < d17) {
            double d18 = d16 + ((j17 * 2) / 1000.0d);
            this.f444660d = d18;
            this.f444660d = Math.min(d17, d18);
        } else {
            double d19 = d16 - ((j17 * 2) / 1000.0d);
            this.f444660d = d19;
            this.f444660d = Math.max(d17, d19);
        }
        return this.f444660d;
    }

    private double d(long j3, long j16) {
        if (Math.abs(this.f444661e - this.f444659c) < 0.01d) {
            return this.f444659c;
        }
        long j17 = j3 - j16;
        double d16 = this.f444661e;
        double d17 = this.f444659c;
        if (d16 < d17) {
            double d18 = d16 + ((j17 * 2) / 1000.0d);
            this.f444661e = d18;
            this.f444661e = Math.min(d17, d18);
        } else {
            double d19 = d16 - ((j17 * 2) / 1000.0d);
            this.f444661e = d19;
            this.f444661e = Math.max(d17, d19);
        }
        return this.f444661e;
    }

    private void f() {
        this.f444658b = 1.0d;
        this.f444659c = 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(double d16, double d17) {
        double centerX = this.f444662f.f444647a.centerX();
        double centerY = this.f444662f.f444647a.centerY();
        double intrinsicWidth = this.f444663g.getIntrinsicWidth() * this.f444664h;
        double intrinsicHeight = this.f444663g.getIntrinsicHeight() * this.f444664h;
        RectF rectF = this.f444662f.f444647a;
        double d18 = (intrinsicWidth * d16) / 2.0d;
        rectF.left = (float) (centerX - d18);
        rectF.right = (float) (centerX + d18);
        double d19 = (intrinsicHeight * d17) / 2.0d;
        rectF.top = (float) (centerY - d19);
        rectF.bottom = (float) (centerY + d19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i3) {
        int i16;
        if ((i3 & 1) > 0 && Math.abs(this.f444662f.f444648b.f444655a) > 100.0d) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        if ((i3 & 2) > 0 && Math.abs(this.f444662f.f444648b.f444655a) > 100.0d) {
            i16 |= 2;
        }
        if ((i3 & 4) > 0 && Math.abs(this.f444662f.f444648b.f444656b) > 100.0d) {
            i16 |= 4;
        }
        if ((i3 & 8) > 0 && Math.abs(this.f444662f.f444648b.f444656b) > 100.0d) {
            return i16 | 8;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(long j3, long j16) {
        if (j3 - this.f444657a > 170) {
            f();
        }
        this.f444660d = c(j3, j16);
        double d16 = d(j3, j16);
        this.f444661e = d16;
        a(this.f444660d, d16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3, long j3) {
        this.f444657a = j3;
        this.f444658b = 1.0d;
        this.f444659c = 1.0d;
        if ((i3 & 1) > 0 || (i3 & 2) > 0) {
            this.f444658b = Math.max(0.8d, 1.0d - (Math.abs(this.f444662f.f444648b.f444655a) * 3.0E-4d));
        }
        if ((i3 & 4) > 0 || (i3 & 8) > 0) {
            this.f444659c = Math.max(0.8d, 1.0d - (Math.abs(this.f444662f.f444648b.f444656b) * 3.0E-4d));
        }
    }
}
