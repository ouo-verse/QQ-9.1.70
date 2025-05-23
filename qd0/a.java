package qd0;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public RectF f428857a;

    /* renamed from: c, reason: collision with root package name */
    public BitmapShader f428859c;

    /* renamed from: e, reason: collision with root package name */
    public float f428861e;

    /* renamed from: f, reason: collision with root package name */
    public float f428862f;

    /* renamed from: g, reason: collision with root package name */
    public float f428863g;

    /* renamed from: h, reason: collision with root package name */
    public float f428864h;

    /* renamed from: i, reason: collision with root package name */
    public int f428865i;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap f428866j;

    /* renamed from: k, reason: collision with root package name */
    public int f428867k;

    /* renamed from: l, reason: collision with root package name */
    public int f428868l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f428869m;

    /* renamed from: b, reason: collision with root package name */
    public Path f428858b = new Path();

    /* renamed from: d, reason: collision with root package name */
    public Paint f428860d = new Paint(1);

    private void a(Canvas canvas) {
        int i3 = this.f428868l;
        if (i3 != 0) {
            if (i3 == 1) {
                if (this.f428866j == null) {
                    return;
                }
                if (this.f428859c == null) {
                    Bitmap bitmap = this.f428866j;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    this.f428859c = new BitmapShader(bitmap, tileMode, tileMode);
                }
                this.f428860d.setShader(this.f428859c);
                f();
            }
        } else {
            this.f428860d.setColor(this.f428865i);
        }
        d(this.f428867k, this.f428858b);
        canvas.drawPath(this.f428858b, this.f428860d);
    }

    private void b(RectF rectF, Path path) {
        if (this.f428869m) {
            this.f428864h = ((rectF.right - rectF.left) / 2.0f) - (this.f428861e / 2.0f);
        }
        path.moveTo(rectF.left + this.f428862f, rectF.top);
        path.lineTo(rectF.width() - this.f428862f, rectF.top);
        float f16 = rectF.right;
        float f17 = this.f428862f;
        float f18 = rectF.top;
        path.arcTo(new RectF(f16 - f17, f18, f16, f17 + f18), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.f428863g) - this.f428862f);
        float f19 = rectF.right;
        float f26 = this.f428862f;
        float f27 = rectF.bottom;
        float f28 = this.f428863g;
        path.arcTo(new RectF(f19 - f26, (f27 - f26) - f28, f19, f27 - f28), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f428861e + this.f428864h, rectF.bottom - this.f428863g);
        path.lineTo(rectF.left + this.f428864h + (this.f428861e / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.f428864h, rectF.bottom - this.f428863g);
        path.lineTo(rectF.left + Math.min(this.f428862f, this.f428864h), rectF.bottom - this.f428863g);
        float f29 = rectF.left;
        float f36 = rectF.bottom;
        float f37 = this.f428862f;
        float f38 = this.f428863g;
        path.arcTo(new RectF(f29, (f36 - f37) - f38, f37 + f29, f36 - f38), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f428862f);
        float f39 = rectF.left;
        float f46 = rectF.top;
        float f47 = this.f428862f;
        path.arcTo(new RectF(f39, f46, f47 + f39, f47 + f46), 180.0f, 90.0f);
        path.close();
    }

    private void c(RectF rectF, Path path) {
        if (this.f428869m) {
            this.f428864h = ((rectF.bottom - rectF.top) / 2.0f) - (this.f428861e / 2.0f);
        }
        path.moveTo(this.f428861e + rectF.left + this.f428862f, rectF.top);
        path.lineTo(rectF.width() - this.f428862f, rectF.top);
        float f16 = rectF.right;
        float f17 = this.f428862f;
        float f18 = rectF.top;
        path.arcTo(new RectF(f16 - f17, f18, f16, f17 + f18), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f428862f);
        float f19 = rectF.right;
        float f26 = this.f428862f;
        float f27 = rectF.bottom;
        path.arcTo(new RectF(f19 - f26, f27 - f26, f19, f27), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f428861e + this.f428862f, rectF.bottom);
        float f28 = rectF.left;
        float f29 = this.f428861e;
        float f36 = rectF.bottom;
        float f37 = this.f428862f;
        path.arcTo(new RectF(f28 + f29, f36 - f37, f37 + f28 + f29, f36), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.f428861e, this.f428863g + this.f428864h);
        path.lineTo(rectF.left, this.f428864h + (this.f428863g / 2.0f));
        path.lineTo(rectF.left + this.f428861e, this.f428864h);
        path.lineTo(rectF.left + this.f428861e, rectF.top + this.f428862f);
        float f38 = rectF.left;
        float f39 = this.f428861e;
        float f46 = rectF.top;
        float f47 = this.f428862f;
        path.arcTo(new RectF(f38 + f39, f46, f38 + f47 + f39, f47 + f46), 180.0f, 90.0f);
        path.close();
    }

    private void d(int i3, Path path) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        b(this.f428857a, path);
                        return;
                    }
                    return;
                }
                g(this.f428857a, path);
                return;
            }
            e(this.f428857a, path);
            return;
        }
        c(this.f428857a, path);
    }

    private void e(RectF rectF, Path path) {
        if (this.f428869m) {
            this.f428864h = ((rectF.bottom - rectF.top) / 2.0f) - (this.f428861e / 2.0f);
        }
        path.moveTo(rectF.left + this.f428862f, rectF.top);
        path.lineTo((rectF.width() - this.f428862f) - this.f428861e, rectF.top);
        float f16 = rectF.right;
        float f17 = this.f428862f;
        float f18 = this.f428861e;
        float f19 = rectF.top;
        path.arcTo(new RectF((f16 - f17) - f18, f19, f16 - f18, f17 + f19), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.f428861e, this.f428864h);
        path.lineTo(rectF.right, this.f428864h + (this.f428863g / 2.0f));
        path.lineTo(rectF.right - this.f428861e, this.f428864h + this.f428863g);
        path.lineTo(rectF.right - this.f428861e, rectF.bottom - this.f428862f);
        float f26 = rectF.right;
        float f27 = this.f428862f;
        float f28 = this.f428861e;
        float f29 = rectF.bottom;
        path.arcTo(new RectF((f26 - f27) - f28, f29 - f27, f26 - f28, f29), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f428861e, rectF.bottom);
        float f36 = rectF.left;
        float f37 = rectF.bottom;
        float f38 = this.f428862f;
        path.arcTo(new RectF(f36, f37 - f38, f38 + f36, f37), 90.0f, 90.0f);
        float f39 = rectF.left;
        float f46 = rectF.top;
        float f47 = this.f428862f;
        path.arcTo(new RectF(f39, f46, f47 + f39, f47 + f46), 180.0f, 90.0f);
        path.close();
    }

    private void f() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.f428866j.getWidth(), getIntrinsicHeight() / this.f428866j.getHeight());
        RectF rectF = this.f428857a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f428859c.setLocalMatrix(matrix);
    }

    private void g(RectF rectF, Path path) {
        if (this.f428869m) {
            this.f428864h = ((rectF.right - rectF.left) / 2.0f) - (this.f428861e / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.f428864h, this.f428862f), rectF.top + this.f428863g);
        path.lineTo(rectF.left + this.f428864h, rectF.top + this.f428863g);
        path.lineTo(rectF.left + (this.f428861e / 2.0f) + this.f428864h, rectF.top);
        path.lineTo(rectF.left + this.f428861e + this.f428864h, rectF.top + this.f428863g);
        path.lineTo(rectF.right - this.f428862f, rectF.top + this.f428863g);
        float f16 = rectF.right;
        float f17 = this.f428862f;
        float f18 = rectF.top;
        float f19 = this.f428863g;
        path.arcTo(new RectF(f16 - f17, f18 + f19, f16, f17 + f18 + f19), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f428862f);
        float f26 = rectF.right;
        float f27 = this.f428862f;
        float f28 = rectF.bottom;
        path.arcTo(new RectF(f26 - f27, f28 - f27, f26, f28), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f428862f, rectF.bottom);
        float f29 = rectF.left;
        float f36 = rectF.bottom;
        float f37 = this.f428862f;
        path.arcTo(new RectF(f29, f36 - f37, f37 + f29, f36), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f428863g + this.f428862f);
        float f38 = rectF.left;
        float f39 = rectF.top;
        float f46 = this.f428863g;
        float f47 = this.f428862f;
        path.arcTo(new RectF(f38, f39 + f46, f47 + f38, f47 + f39 + f46), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f428857a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f428857a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f428860d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f428860d.setColorFilter(colorFilter);
    }
}
