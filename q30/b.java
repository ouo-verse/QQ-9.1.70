package q30;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010$R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lq30/b;", "Landroid/graphics/drawable/Drawable;", "", "g", "", "getIntrinsicWidth", "getIntrinsicHeight", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "c", "enable", "e", "d", "", "width", "f", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "a", "Z", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/LinearGradient;", "Landroid/graphics/LinearGradient;", "mShader", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mRectF", UserInfo.SEX_FEMALE, "mRotateAngle", "mEnableAnim", "mHasAnim", tl.h.F, "mIsAnim", "i", "I", "mDisableColor", "", "j", "[I", NodeProps.COLORS, "k", "grayColors", "", "l", "[F", "positions", "<init>", "(Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient mShader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mRectF;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mRotateAngle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mEnableAnim;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mHasAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mDisableColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] colors;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] grayColors;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] positions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"q30/b$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: q30.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C11054b extends AnimatorListenerAdapter {
        C11054b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            b.this.mIsAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            b.this.mIsAnim = false;
        }
    }

    public b(boolean z16) {
        int parseColor;
        this.enable = z16;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        this.mRectF = new RectF();
        this.mEnableAnim = true;
        if (!ThemeUtil.isDefaultNightTheme() && !ThemeUtil.isVasDarkTheme()) {
            parseColor = Color.parseColor("#1F000000");
        } else {
            parseColor = Color.parseColor("#12FFFFFF");
        }
        this.mDisableColor = parseColor;
        this.colors = new int[]{Color.parseColor("#FCC06C"), Color.parseColor("#FF8A74"), Color.parseColor("#C862FB"), Color.parseColor("#026EFF"), Color.parseColor("#0099FF"), Color.parseColor("#5DBEFB")};
        this.grayColors = new int[]{parseColor, parseColor, parseColor, parseColor, parseColor, parseColor};
        this.positions = new float[]{0.0f, 0.04f, 0.1f, 0.44f, 0.85f, 1.0f};
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ViewUtils.f352270a.a(2.0f));
    }

    private final void g() {
        if (!this.mHasAnim && this.enable && this.mEnableAnim) {
            this.mHasAnim = true;
            this.mIsAnim = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            ofFloat.setDuration(2500L);
            ofFloat.setRepeatCount(0);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: q30.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.h(b.this, valueAnimator);
                }
            });
            ofFloat.addListener(new C11054b());
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(b this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.mRotateAngle = ((Float) animatedValue).floatValue();
        this$0.invalidateSelf();
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMIsAnim() {
        return this.mIsAnim;
    }

    public final void d() {
        this.mHasAnim = false;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        g();
        int width = getBounds().width();
        int i3 = width / 2;
        int height = getBounds().height() / 2;
        float f16 = width;
        float strokeWidth = (f16 / 2.0f) - (this.mPaint.getStrokeWidth() / 2);
        float f17 = i3;
        float f18 = height;
        this.mRectF.set(f17 - strokeWidth, f18 - strokeWidth, f17 + strokeWidth, strokeWidth + f18);
        if (this.mShader == null) {
            if (this.enable) {
                iArr = this.colors;
            } else {
                iArr = this.grayColors;
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f16, 0.0f, iArr, this.positions, Shader.TileMode.CLAMP);
            this.mShader = linearGradient;
            this.mPaint.setShader(linearGradient);
        }
        canvas.save();
        canvas.rotate(this.mRotateAngle + 45.0f, f17, f18);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        canvas.restore();
    }

    public final void e(boolean enable) {
        this.mEnableAnim = enable;
    }

    public final void f(float width) {
        this.mPaint.setStrokeWidth(ViewUtils.f352270a.a(width));
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
