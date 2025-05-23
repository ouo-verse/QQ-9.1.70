package w61;

import android.graphics.Point;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public double f444651e = 0.0d;

    /* renamed from: f, reason: collision with root package name */
    public long f444652f = 0;

    /* renamed from: a, reason: collision with root package name */
    public RectF f444647a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public b f444648b = new b(0.0d, 0.0d);

    /* renamed from: c, reason: collision with root package name */
    public a f444649c = new a(0.0d, 0.0d);

    /* renamed from: d, reason: collision with root package name */
    public int f444650d = 0;

    public void a(Point point, double d16, double d17, int i3) {
        if (i3 == 85) {
            RectF rectF = this.f444647a;
            int i16 = point.x;
            int i17 = point.y;
            rectF.set((float) (i16 - d16), (float) (i17 - d17), i16, i17);
            return;
        }
        if (i3 == 81) {
            RectF rectF2 = this.f444647a;
            int i18 = point.x;
            double d18 = d16 / 2.0d;
            int i19 = point.y;
            rectF2.set((float) (i18 - d18), (float) (i19 - d17), (float) (i18 + d18), i19);
            return;
        }
        RectF rectF3 = this.f444647a;
        int i26 = point.x;
        double d19 = d16 / 2.0d;
        int i27 = point.y;
        rectF3.set((float) (i26 - d19), i27, (float) (i26 + d19), (float) (i27 + d17));
    }

    public String toString() {
        return "ItemStatus{hashCode=" + hashCode() + ", rect=" + this.f444647a + ", velocity=" + this.f444648b + ", acceleration=" + this.f444649c + '}';
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public double f444653a;

        /* renamed from: b, reason: collision with root package name */
        public double f444654b;

        public a(double d16, double d17) {
            this.f444653a = d16;
            this.f444654b = d17;
        }

        public void a(a aVar) {
            this.f444653a = aVar.f444653a;
            this.f444654b = aVar.f444654b;
        }

        public String toString() {
            return "Acceleration{ax=" + this.f444653a + ", ay=" + this.f444654b + '}';
        }

        public a(a aVar) {
            a(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f444655a;

        /* renamed from: b, reason: collision with root package name */
        public double f444656b;

        public b(double d16, double d17) {
            this.f444655a = d16;
            this.f444656b = d17;
        }

        public void a(b bVar) {
            this.f444655a = bVar.f444655a;
            this.f444656b = bVar.f444656b;
        }

        public String toString() {
            return "Velocity{vx=" + this.f444655a + ", vy=" + this.f444656b + '}';
        }

        public b(b bVar) {
            a(bVar);
        }
    }
}
