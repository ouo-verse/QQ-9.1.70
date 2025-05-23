package yr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipConstant;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.b;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f451037a;

    /* renamed from: j, reason: collision with root package name */
    private ClipConstant.Anchor f451046j;

    /* renamed from: p, reason: collision with root package name */
    public CropNewView f451052p;

    /* renamed from: b, reason: collision with root package name */
    private RectF f451038b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    private RectF f451039c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    private RectF f451040d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    private float f451041e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f451042f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f451043g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f451044h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f451045i = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f451047k = true;

    /* renamed from: l, reason: collision with root package name */
    private b f451048l = new b();

    /* renamed from: m, reason: collision with root package name */
    private RectF f451049m = new RectF();

    /* renamed from: n, reason: collision with root package name */
    private boolean f451050n = false;

    /* renamed from: o, reason: collision with root package name */
    private Matrix f451051o = new Matrix();

    private void L() {
        if (this.f451039c.isEmpty()) {
            return;
        }
        float min = Math.min(this.f451049m.width() / this.f451039c.width(), this.f451049m.height() / this.f451039c.height());
        this.f451051o.setScale(min, min, this.f451039c.centerX(), this.f451039c.centerY());
        this.f451051o.postTranslate(this.f451049m.centerX() - this.f451039c.centerX(), this.f451049m.centerY() - this.f451039c.centerY());
        this.f451051o.mapRect(this.f451038b);
        this.f451051o.mapRect(this.f451039c);
    }

    private void q(float f16, float f17) {
        this.f451038b.set(0.0f, 0.0f, this.f451037a.getWidth(), this.f451037a.getHeight());
        this.f451039c.set(this.f451038b);
        this.f451048l.m(f16, f17);
        if (this.f451039c.isEmpty()) {
            return;
        }
        L();
        this.f451050n = true;
        r();
        CropNewView cropNewView = this.f451052p;
        if (cropNewView != null) {
            cropNewView.k();
        }
    }

    private void r() {
        this.f451048l.l(this.f451039c, g());
    }

    public void A() {
        J(d() - (d() % 360.0f));
        this.f451039c.set(this.f451038b);
        this.f451048l.l(this.f451039c, g());
    }

    public void B(int i3) {
        this.f451042f = this.f451042f % 360.0f;
        this.f451043g = Math.round((r0 + i3) / 90.0f) * 90;
        this.f451048l.l(this.f451039c, g());
    }

    public void D(CropNewView cropNewView) {
        this.f451052p = cropNewView;
    }

    public void E() {
        this.f451041e = d();
        this.f451040d.set(this.f451039c);
        float e16 = 1.0f / e();
        Matrix matrix = this.f451051o;
        RectF rectF = this.f451038b;
        matrix.setTranslate(-rectF.left, -rectF.top);
        this.f451051o.postScale(e16, e16);
        this.f451051o.mapRect(this.f451040d);
    }

    public void F(boolean z16) {
        this.f451048l.p(z16);
    }

    public void G(float f16) {
        this.f451042f = f16;
    }

    public void H(float f16) {
        I(f16, this.f451039c.centerX(), this.f451039c.centerY());
    }

    public void I(float f16, float f17, float f18) {
        s(f16 / e(), f17, f18);
    }

    public void J(float f16) {
        this.f451043g = f16;
    }

    public void K() {
        this.f451051o.setScale(e(), e());
        Matrix matrix = this.f451051o;
        RectF rectF = this.f451038b;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f451051o.mapRect(this.f451039c, this.f451040d);
        J(this.f451041e);
        this.f451044h = true;
    }

    public xr.b a(float f16, float f17) {
        RectF b16 = this.f451048l.b(f16, f17);
        this.f451051o.setRotate(-d(), this.f451039c.centerX(), this.f451039c.centerY());
        this.f451051o.mapRect(this.f451039c, b16);
        return new xr.b(f16 + (this.f451039c.centerX() - b16.centerX()), f17 + (this.f451039c.centerY() - b16.centerY()), e(), d());
    }

    public RectF b() {
        return this.f451039c;
    }

    public xr.b c(float f16, float f17) {
        xr.b bVar = new xr.b(f16, f17, e(), g());
        RectF rectF = new RectF(this.f451048l.c());
        rectF.offset(f16, f17);
        if (this.f451048l.h()) {
            RectF rectF2 = new RectF();
            this.f451051o.setRotate(g(), this.f451039c.centerX(), this.f451039c.centerY());
            this.f451051o.mapRect(rectF2, this.f451039c);
            bVar.b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.a.b(rectF, rectF2));
        } else {
            RectF rectF3 = new RectF();
            if (this.f451048l.g()) {
                this.f451051o.setRotate(g() - d(), this.f451039c.centerX(), this.f451039c.centerY());
                this.f451051o.mapRect(rectF3, this.f451048l.b(f16, f17));
                bVar.b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.a.f(rectF, rectF3, this.f451039c.centerX(), this.f451039c.centerY()));
            } else {
                this.f451051o.setRotate(g(), this.f451039c.centerX(), this.f451039c.centerY());
                this.f451051o.mapRect(rectF3, this.f451038b);
                bVar.b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.a.c(rectF, rectF3, this.f451039c.centerX(), this.f451039c.centerY()));
            }
        }
        return bVar;
    }

    public float d() {
        return this.f451042f;
    }

    public float e() {
        return (this.f451038b.width() * 1.0f) / this.f451037a.getWidth();
    }

    public xr.b f(float f16, float f17) {
        return new xr.b(f16, f17, e(), d());
    }

    public float g() {
        return this.f451043g;
    }

    public boolean h() {
        return this.f451048l.e();
    }

    public void i(Canvas canvas, float f16, float f17) {
        this.f451048l.i(canvas);
    }

    public void j(Canvas canvas) {
        RectF rectF;
        if (this.f451048l.f()) {
            rectF = this.f451038b;
        } else {
            rectF = this.f451039c;
        }
        canvas.clipRect(rectF);
        if (this.f451037a.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f451037a, (Rect) null, this.f451038b, (Paint) null);
    }

    public void k(Canvas canvas) {
        if (this.f451047k) {
            RectF rectF = this.f451038b;
            canvas.clipRect(rectF.left, rectF.top, rectF.right, rectF.bottom);
            canvas.clipRect(this.f451039c, Region.Op.DIFFERENCE);
            canvas.drawColor(-872415232);
        }
    }

    public void l(float f16) {
        this.f451048l.d(f16);
    }

    public boolean n(float f16, float f17, boolean z16) {
        boolean z17 = !this.f451045i;
        this.f451048l.o(false);
        this.f451048l.n(true);
        this.f451048l.p(false);
        return z17;
    }

    public xr.b v(float f16, float f17, float f18, float f19) {
        this.f451048l.q(false);
        ClipConstant.Anchor anchor = this.f451046j;
        if (anchor == null) {
            return null;
        }
        this.f451048l.j(anchor, f18, f19);
        RectF rectF = new RectF();
        this.f451051o.setRotate(d(), this.f451039c.centerX(), this.f451039c.centerY());
        this.f451051o.mapRect(rectF, this.f451038b);
        RectF b16 = this.f451048l.b(f16, f17);
        xr.b bVar = new xr.b(f16, f17, e(), g());
        bVar.b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.a.c(b16, rectF, this.f451039c.centerX(), this.f451039c.centerY()));
        return bVar;
    }

    public void y(float f16, float f17) {
        if (this.f451046j != null) {
            this.f451046j = null;
        }
    }

    private void p() {
        this.f451050n = false;
        z(this.f451049m.width(), this.f451049m.height());
        this.f451048l.l(this.f451039c, g());
    }

    public void m(boolean z16) {
        this.f451045i = true;
    }

    public void o(boolean z16) {
        this.f451045i = false;
    }

    public void w(float f16, float f17) {
        this.f451047k = true;
        h();
        this.f451048l.q(true);
    }

    public void x(float f16, float f17) {
        this.f451047k = false;
        this.f451046j = this.f451048l.a(f16, f17);
    }

    public void C(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f451037a = bitmap;
        G(0.0f);
        J(0.0f);
        p();
    }

    public void s(float f16, float f17, float f18) {
        if (f16 == 1.0f) {
            return;
        }
        if (Math.min(this.f451039c.width(), this.f451039c.height()) <= 500.0f) {
            f16 += (1.0f - f16) / 2.0f;
        }
        this.f451051o.setScale(f16, f16, f17, f18);
        this.f451051o.mapRect(this.f451038b);
        this.f451051o.mapRect(this.f451039c);
    }

    public void z(float f16, float f17) {
        if (f16 == 0.0f || f17 == 0.0f) {
            return;
        }
        this.f451049m.set(0.0f, 0.0f, f16, f17);
        if (!this.f451050n) {
            q(f16, f17);
        } else {
            this.f451051o.setTranslate(this.f451049m.centerX() - this.f451039c.centerX(), this.f451049m.centerY() - this.f451039c.centerY());
            this.f451051o.mapRect(this.f451038b);
            this.f451051o.mapRect(this.f451039c);
        }
        this.f451048l.m(f16, f17);
    }

    public void t() {
    }

    public void u() {
    }
}
