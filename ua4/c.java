package ua4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0006\u0010\u001c\u001a\u00020\u0007R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010.R\u0011\u00102\u001a\u0002008F\u00a2\u0006\u0006\u001a\u0004\b\"\u00101\u00a8\u00065"}, d2 = {"Lua4/c;", "Landroid/graphics/drawable/Drawable;", "", "start", "end", "percent", "e", "", "j", "i", "Lua4/a;", DownloadInfo.spKey_Config, "f", "g", h.F, "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "d", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "a", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mUpdateListener", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "mShimmerPaint", "c", "Landroid/graphics/Rect;", "mDrawRect", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "mShaderMatrix", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mValueAnimator", "Lua4/a;", "shimmerConfig", "", "()Z", "isShimmerStarted", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ua4.b
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.c(c.this, valueAnimator);
        }
    };

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Paint mShimmerPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Rect mDrawRect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Matrix mShaderMatrix;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mValueAnimator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a shimmerConfig;

    public c() {
        Paint paint = new Paint();
        this.mShimmerPaint = paint;
        this.mDrawRect = new Rect();
        this.mShaderMatrix = new Matrix();
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateSelf();
    }

    private final float e(float start, float end, float percent) {
        return start + ((end - start) * percent);
    }

    private final void i() {
        a aVar;
        int width = getBounds().width();
        int height = getBounds().height();
        if (width == 0 || height == 0 || (aVar = this.shimmerConfig) == null) {
            return;
        }
        this.mShimmerPaint.setShader(new LinearGradient(0.0f, 0.0f, aVar.j(width), 0.0f, aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String(), aVar.getPositions(), Shader.TileMode.CLAMP));
    }

    private final void j() {
        boolean z16;
        a aVar = this.shimmerConfig;
        if (aVar == null) {
            return;
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator == null || valueAnimator == null) {
            z16 = false;
        } else {
            z16 = valueAnimator.isStarted();
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatMode(aVar.getRepeatMode());
            ofFloat.setRepeatCount(aVar.getRepeatCount());
            ofFloat.setDuration(aVar.getAnimationDuration());
            ofFloat.addUpdateListener(this.mUpdateListener);
            if (z16) {
                ofFloat.start();
            }
        }
    }

    public final boolean b() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            return valueAnimator != null && valueAnimator.isStarted();
        }
        return false;
    }

    public final void d() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator == null || valueAnimator.isStarted() || this.shimmerConfig == null || getCallback() == null) {
            return;
        }
        valueAnimator.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        a aVar = this.shimmerConfig;
        if (aVar == null || this.mShimmerPaint.getShader() == null) {
            return;
        }
        float width = this.mDrawRect.width() + (aVar.getTiltTan() * this.mDrawRect.height());
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            f16 = ((Float) animatedValue).floatValue();
        } else {
            f16 = 0.0f;
        }
        this.mShaderMatrix.reset();
        this.mShaderMatrix.setRotate(aVar.getTilt(), this.mDrawRect.width() / 2.0f, this.mDrawRect.height() / 2.0f);
        this.mShaderMatrix.postTranslate(e(-width, width, f16), 0.0f);
        this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
        canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
    }

    public final void f(a config) {
        this.shimmerConfig = config;
        if (config != null) {
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        i();
        j();
        invalidateSelf();
    }

    public final void g() {
        ValueAnimator valueAnimator;
        if (this.mValueAnimator == null || b() || getCallback() == null || (valueAnimator = this.mValueAnimator) == null) {
            return;
        }
        valueAnimator.start();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.shimmerConfig != null ? -3 : -1;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        if (this.mValueAnimator == null || !b() || (valueAnimator = this.mValueAnimator) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.mDrawRect.set(bounds);
        i();
        d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
