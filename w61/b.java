package w61;

import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private double f444643a = -0.8d;

    /* renamed from: b, reason: collision with root package name */
    private int f444644b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f444645c = 0;

    /* renamed from: d, reason: collision with root package name */
    private c f444646d;

    public b(c cVar) {
        this.f444646d = cVar;
    }

    private void c(int i3, Rect rect, RectF rectF) {
        double d16;
        double d17 = 0.0d;
        if ((i3 & 1) > 0) {
            d16 = (rectF.left - rect.left) * (-1.8d);
            this.f444646d.f444648b.f444655a *= -0.8d;
        } else {
            d16 = 0.0d;
        }
        if ((i3 & 2) > 0) {
            d16 = (rectF.right - rect.right) * (-1.8d);
            this.f444646d.f444648b.f444655a *= -0.8d;
        }
        if ((i3 & 4) > 0) {
            d17 = (rectF.top - rect.top) * (-1.8d);
            this.f444646d.f444648b.f444656b *= -0.8d;
        }
        if ((i3 & 8) > 0) {
            double d18 = rectF.bottom - rect.bottom;
            double d19 = this.f444643a;
            d17 = d18 * ((-1.0d) + d19);
            this.f444646d.f444648b.f444656b *= d19;
        }
        this.f444646d.f444647a.offset((float) d16, (float) d17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(Rect rect, RectF rectF) {
        int i3;
        if (rect.left > rectF.left) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (rect.right < rectF.right) {
            i3 ^= 2;
        }
        if (rect.top > rectF.top) {
            i3 ^= 4;
        }
        if (rect.bottom < rectF.bottom) {
            return i3 ^ 8;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Rect rect, long j3) {
        int a16 = a(rect, this.f444646d.f444647a);
        if (a16 != 0) {
            if ((a16 & 8) > 0) {
                int i3 = this.f444644b + 1;
                this.f444644b = i3;
                c cVar = this.f444646d;
                cVar.f444648b.f444655a *= 0.95d;
                if (cVar.f444650d != 2 && i3 >= 3) {
                    cVar.f444650d = 2;
                    cVar.f444652f = j3;
                }
            }
            int i16 = this.f444645c + 1;
            this.f444645c = i16;
            if (i16 == 3) {
                c cVar2 = this.f444646d;
                cVar2.f444651e = cVar2.f444647a.left;
                cVar2.f444649c.f444654b = 2000.0d;
                this.f444643a = -0.5d;
            }
            c(a16, rect, this.f444646d.f444647a);
        }
    }
}
