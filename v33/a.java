package v33;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.SurfaceHolder;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.image.ApngDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class a implements s33.b {

    /* renamed from: a, reason: collision with root package name */
    protected SurfaceHolder f440915a;

    /* renamed from: b, reason: collision with root package name */
    protected Rect f440916b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private boolean f440917c = true;

    public a(SurfaceHolder surfaceHolder) {
        this.f440915a = surfaceHolder;
    }

    private void c(Drawable drawable) {
        if (drawable instanceof IGLDrawable) {
            ((IGLDrawable) drawable).setLockWH(true);
            drawable.setBounds(this.f440916b);
            return;
        }
        Rect rect = new Rect();
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            rect.set(0, 0, bitmapDrawable.getBitmap().getWidth(), bitmapDrawable.getBitmap().getHeight());
        } else if (drawable instanceof ApngDrawable) {
            ApngDrawable apngDrawable = (ApngDrawable) drawable;
            rect.set(0, 0, apngDrawable.getImage().getWidth(), apngDrawable.getImage().getHeight());
        }
        float width = this.f440916b.width() / rect.width();
        float height = this.f440916b.height() / rect.height();
        if (width > height) {
            rect.right = this.f440916b.right;
            rect.bottom = (int) (rect.bottom * width);
        } else {
            rect.bottom = this.f440916b.bottom;
            rect.right = (int) (rect.right * height);
        }
        Gravity.apply(17, rect.width(), rect.height(), this.f440916b, rect);
        drawable.setBounds(rect);
    }

    @Override // s33.b
    public final void b(Drawable drawable) {
        SurfaceHolder surfaceHolder;
        Canvas d16;
        if (drawable != null && (surfaceHolder = this.f440915a) != null && surfaceHolder.getSurface() != null && this.f440915a.getSurface().isValid() && (d16 = d(this.f440915a)) != null) {
            if (this.f440917c) {
                if (this.f440916b.width() == 0) {
                    this.f440916b.set(0, 0, d16.getWidth(), d16.getHeight());
                }
                this.f440917c = false;
                c(drawable);
            }
            drawable.draw(d16);
            this.f440915a.unlockCanvasAndPost(d16);
        }
    }

    abstract Canvas d(SurfaceHolder surfaceHolder);

    @Override // s33.b
    public void reset() {
        this.f440917c = true;
    }

    @Override // s33.b
    public final void setBounds(Rect rect) {
        this.f440916b.set(rect);
        this.f440917c = true;
    }
}
