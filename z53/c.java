package z53;

import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleShape;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import z53.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 m2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001$B\u000f\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\bk\u0010lJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J*\u0010\u0014\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\u0018\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0006J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010(\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010/R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010/R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010/R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010/R\u0018\u0010<\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010;R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010/R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010/R\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010I\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010/R\u0016\u0010Y\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010/R\u0018\u0010[\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010TR\u0016\u0010]\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010/R\u0016\u0010_\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010/R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010CR\u0014\u0010c\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010+R\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010CR\u0016\u0010g\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010/R\u0016\u0010i\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010/R\u0016\u0010j\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010/\u00a8\u0006n"}, d2 = {"Lz53/c;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lz53/e$a;", "Landroid/view/MotionEvent;", "e", "", "onDown", "", "onShowPress", "isScrollEnable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "event", "j", "k", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "velocityX", "velocityY", "onFling", "onSingleTapUp", "f", "anim", h.F, "supportScaleItem", DomainData.DOMAIN_NAME, "onSingleTapConfirmed", "onDoubleTap", "onDoubleTapEvent", "Lz53/e;", "detector", "a", "var1", "c", "b", "l", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;", "d", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;", "getDoodle", "()Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;", "doodle", UserInfo.SEX_FEMALE, "VALUE", "mTouchX", "mTouchY", "i", "mLastTouchX", "mLastTouchY", BdhLogUtil.LogTag.Tag_Conn, "mTouchDownX", "D", "mTouchDownY", "E", "Ljava/lang/Float;", "mLastFocusX", "mLastFocusY", "G", "mTouchCentreX", "H", "mTouchCentreY", "I", "Z", "mHasScaled", "J", "mIsScrolling", "K", "Landroid/view/MotionEvent;", "mLastScrollMotionEvent", "Landroid/graphics/Path;", "L", "Landroid/graphics/Path;", "mCurrPath", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/a;", "M", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/a;", "mCurrDoodlePath", "Landroid/animation/ValueAnimator;", "N", "Landroid/animation/ValueAnimator;", "mScaleAnimator", "P", "mScaleAnimTransX", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mScaleAnimTranY", BdhLogUtil.LogTag.Tag_Req, "mTranslateAnimator", ExifInterface.LATITUDE_SOUTH, "mTransAnimOldY", "T", "mTransAnimY", "U", "mSupportScaleItem", "V", "mDoodle", "W", "mScrollEnable", "X", "pendingX", "Y", "pendingY", "pendingScale", "<init>", "(Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;)V", "a0", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, e.a {

    /* renamed from: C, reason: from kotlin metadata */
    private float mTouchDownX;

    /* renamed from: D, reason: from kotlin metadata */
    private float mTouchDownY;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Float mLastFocusX;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Float mLastFocusY;

    /* renamed from: G, reason: from kotlin metadata */
    private float mTouchCentreX;

    /* renamed from: H, reason: from kotlin metadata */
    private float mTouchCentreY;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mHasScaled;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsScrolling;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private MotionEvent mLastScrollMotionEvent;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Path mCurrPath;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a mCurrDoodlePath;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mScaleAnimator;

    /* renamed from: P, reason: from kotlin metadata */
    private float mScaleAnimTransX;

    /* renamed from: Q, reason: from kotlin metadata */
    private float mScaleAnimTranY;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mTranslateAnimator;

    /* renamed from: S, reason: from kotlin metadata */
    private float mTransAnimOldY;

    /* renamed from: T, reason: from kotlin metadata */
    private float mTransAnimY;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mSupportScaleItem;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final DoodleView mDoodle;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mScrollEnable;

    /* renamed from: X, reason: from kotlin metadata */
    private float pendingX;

    /* renamed from: Y, reason: from kotlin metadata */
    private float pendingY;

    /* renamed from: Z, reason: from kotlin metadata */
    private float pendingScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DoodleView doodle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float VALUE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mTouchX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mTouchY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mLastTouchX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mLastTouchY;

    public c(@NotNull DoodleView doodle) {
        Intrinsics.checkNotNullParameter(doodle, "doodle");
        this.doodle = doodle;
        this.VALUE = 1.0f;
        this.mSupportScaleItem = true;
        this.mDoodle = doodle;
        this.pendingScale = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float animatedFraction = valueAnimator.getAnimatedFraction();
        DoodleView doodleView = this$0.mDoodle;
        doodleView.setDoodleScale(floatValue, doodleView.V(this$0.mTouchCentreX), this$0.mDoodle.W(this$0.mTouchCentreY));
        float f16 = 1 - animatedFraction;
        this$0.mDoodle.setDoodleTranslation(this$0.mScaleAnimTransX * f16, this$0.mScaleAnimTranY * f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float animatedFraction = valueAnimator.getAnimatedFraction();
        DoodleView doodleView = this$0.mDoodle;
        float f16 = this$0.mTransAnimOldY;
        doodleView.setDoodleTranslation(floatValue, f16 + ((this$0.mTransAnimY - f16) * animatedFraction));
    }

    @Override // z53.e.a
    public boolean a(@NotNull e detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        w53.b.a("DoodleOnTouchGestureListener", "onScale");
        this.mTouchCentreX = detector.getMFocusX();
        this.mTouchCentreY = detector.getMFocusY();
        Float f16 = this.mLastFocusX;
        if (f16 != null && this.mLastFocusY != null) {
            float f17 = this.mTouchCentreX;
            Intrinsics.checkNotNull(f16);
            float floatValue = f17 - f16.floatValue();
            float f18 = this.mTouchCentreY;
            Float f19 = this.mLastFocusY;
            Intrinsics.checkNotNull(f19);
            float floatValue2 = f18 - f19.floatValue();
            if (Math.abs(floatValue) <= 1.0f && Math.abs(floatValue2) <= 1.0f) {
                this.pendingX += floatValue;
                this.pendingY += floatValue2;
            } else {
                DoodleView doodleView = this.mDoodle;
                doodleView.setDoodleTranslationX(doodleView.getMTransX() + floatValue + this.pendingX);
                DoodleView doodleView2 = this.mDoodle;
                doodleView2.setDoodleTranslationY(doodleView2.getMTransY() + floatValue2 + this.pendingY);
                this.pendingY = 0.0f;
                this.pendingX = 0.0f;
            }
        }
        if (Math.abs(1 - detector.f()) > 0.005f) {
            float A = this.mDoodle.A() * detector.f() * this.pendingScale;
            DoodleView doodleView3 = this.mDoodle;
            doodleView3.setDoodleScale(A, doodleView3.V(this.mTouchCentreX), this.mDoodle.W(this.mTouchCentreY));
            this.pendingScale = 1.0f;
        } else {
            this.pendingScale *= detector.f();
        }
        this.mLastFocusX = Float.valueOf(this.mTouchCentreX);
        this.mLastFocusY = Float.valueOf(this.mTouchCentreY);
        return true;
    }

    @Override // z53.e.a
    public void b(@NotNull e var1) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        w53.b.a("DoodleOnTouchGestureListener", "onScaleEnd");
        f();
    }

    @Override // z53.e.a
    public boolean c(@NotNull e var1) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        w53.b.a("DoodleOnTouchGestureListener", "onScaleBegin");
        this.mHasScaled = true;
        if (this.mIsScrolling) {
            this.mIsScrolling = false;
            k(this.mLastScrollMotionEvent);
        }
        this.mLastFocusX = null;
        this.mLastFocusY = null;
        return true;
    }

    public final void f() {
        if (this.mDoodle.A() < 1.0f) {
            if (this.mScaleAnimator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.mScaleAnimator = valueAnimator;
                valueAnimator.setDuration(100L);
                ValueAnimator valueAnimator2 = this.mScaleAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: z53.a
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                            c.g(c.this, valueAnimator3);
                        }
                    });
                }
            }
            ValueAnimator valueAnimator3 = this.mScaleAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
            this.mScaleAnimTransX = this.mDoodle.getMTransX();
            this.mScaleAnimTranY = this.mDoodle.getMTransY();
            ValueAnimator valueAnimator4 = this.mScaleAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.setFloatValues(this.mDoodle.A(), 1.0f);
            }
            ValueAnimator valueAnimator5 = this.mScaleAnimator;
            if (valueAnimator5 != null) {
                valueAnimator5.start();
                return;
            }
            return;
        }
        h(true);
    }

    public final void h(boolean anim) {
        float mTransX = this.mDoodle.getMTransX();
        float mTransY = this.mDoodle.getMTransY();
        RectF z16 = this.mDoodle.z();
        float mTransX2 = this.mDoodle.getMTransX();
        float mTransY2 = this.mDoodle.getMTransY();
        float mCenterWidth = this.mDoodle.getMCenterWidth();
        float mCenterHeight = this.mDoodle.getMCenterHeight();
        if (z16.height() <= this.mDoodle.getHeight()) {
            mTransY2 = (mCenterHeight - (this.mDoodle.A() * mCenterHeight)) / 2;
        } else {
            float f16 = z16.top;
            if (f16 > 0.0f && z16.bottom >= this.mDoodle.getHeight()) {
                mTransY2 -= f16;
            } else if (z16.bottom < this.mDoodle.getHeight() && z16.top <= 0.0f) {
                mTransY2 += this.mDoodle.getHeight() - z16.bottom;
            }
        }
        if (z16.width() <= this.mDoodle.getWidth()) {
            mTransX2 = (mCenterWidth - (this.mDoodle.A() * mCenterWidth)) / 2;
        } else {
            float f17 = z16.left;
            if (f17 > 0.0f && z16.right >= this.mDoodle.getWidth()) {
                mTransX2 -= f17;
            } else if (z16.right < this.mDoodle.getWidth() && z16.left <= 0.0f) {
                mTransX2 += this.mDoodle.getWidth() - z16.right;
            }
        }
        if (anim) {
            if (this.mTranslateAnimator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.mTranslateAnimator = valueAnimator;
                valueAnimator.setDuration(100L);
                ValueAnimator valueAnimator2 = this.mTranslateAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: z53.b
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                            c.i(c.this, valueAnimator3);
                        }
                    });
                }
            }
            ValueAnimator valueAnimator3 = this.mTranslateAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.setFloatValues(mTransX, mTransX2);
            }
            this.mTransAnimOldY = mTransY;
            this.mTransAnimY = mTransY2;
            ValueAnimator valueAnimator4 = this.mTranslateAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.start();
                return;
            }
            return;
        }
        this.mDoodle.setDoodleTranslation(mTransX2, mTransY2);
    }

    public final void j(@NotNull MotionEvent event) {
        com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a aVar;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.mScrollEnable) {
            return;
        }
        w53.b.a("DoodleOnTouchGestureListener", "onScrollBegin");
        float x16 = event.getX();
        this.mTouchX = x16;
        this.mLastTouchX = x16;
        float y16 = event.getY();
        this.mTouchY = y16;
        this.mLastTouchY = y16;
        this.mDoodle.setScrollingDoodle(true);
        Path path = new Path();
        this.mCurrPath = path;
        path.moveTo(this.mDoodle.V(this.mTouchX), this.mDoodle.W(this.mTouchY));
        if (this.mDoodle.getMShape() == DoodleShape.HAND_WRITE) {
            aVar = com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a.INSTANCE.a(this.mDoodle, this.mCurrPath);
        } else {
            aVar = null;
        }
        this.mCurrDoodlePath = aVar;
        this.mDoodle.I(aVar);
        this.mDoodle.refresh();
    }

    public final void k(@Nullable MotionEvent e16) {
        if (!this.mScrollEnable) {
            return;
        }
        w53.b.a("DoodleOnTouchGestureListener", TkdListView.EVENT_TYPE_SCROLL_END);
        if (e16 == null) {
            return;
        }
        this.mLastTouchX = this.mTouchX;
        this.mLastTouchY = this.mTouchY;
        this.mTouchX = e16.getX();
        this.mTouchY = e16.getY();
        boolean z16 = false;
        this.mDoodle.setScrollingDoodle(false);
        w53.b.a("DoodleOnTouchGestureListener", "onScrollEnd mLastTouchX:" + this.mLastTouchX + ",mLastTouchY:" + this.mLastTouchY + ",mTouchX:" + this.mTouchX + ",mTouchY:" + this.mTouchY);
        if (this.mDoodle.getMShape() == DoodleShape.HAND_WRITE) {
            com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a aVar = this.mCurrDoodlePath;
            if (aVar != null && aVar.q(this.mDoodle.V(this.mTouchX), this.mDoodle.W(this.mTouchY))) {
                z16 = true;
            }
            if (z16) {
                this.mDoodle.J(this.mCurrDoodlePath);
                this.mCurrDoodlePath = null;
            }
        }
        this.mDoodle.refresh();
    }

    public final void l(@Nullable MotionEvent e16) {
        if (this.mIsScrolling) {
            this.mIsScrolling = false;
            this.mLastScrollMotionEvent = null;
            if (e16 != null) {
                k(e16);
            }
        }
    }

    public final void m(boolean isScrollEnable) {
        this.mScrollEnable = isScrollEnable;
    }

    public final void n(boolean supportScaleItem) {
        this.mSupportScaleItem = supportScaleItem;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(@Nullable MotionEvent e16) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(@Nullable MotionEvent e16) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        w53.b.a("DoodleOnTouchGestureListener", "onDown");
        this.mHasScaled = false;
        this.mIsScrolling = false;
        float x16 = e16.getX();
        this.mTouchDownX = x16;
        this.mTouchX = x16;
        float y16 = e16.getY();
        this.mTouchDownY = y16;
        this.mTouchY = y16;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
        com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a aVar;
        Intrinsics.checkNotNullParameter(e26, "e2");
        boolean z16 = false;
        if (!this.mScrollEnable) {
            return false;
        }
        if (this.mHasScaled) {
            this.mIsScrolling = false;
            return false;
        }
        if (!this.mIsScrolling && e16 != null) {
            this.mIsScrolling = true;
            j(e16);
        }
        this.mLastScrollMotionEvent = MotionEvent.obtain(e26);
        w53.b.a("DoodleOnTouchGestureListener", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        this.mLastTouchX = this.mTouchX;
        this.mLastTouchY = this.mTouchY;
        this.mTouchX = e26.getX();
        this.mTouchY = e26.getY();
        if (this.mDoodle.getMShape() == DoodleShape.HAND_WRITE) {
            Path path = this.mCurrPath;
            if (path != null) {
                float f16 = 2;
                path.quadTo(this.mDoodle.V(this.mLastTouchX), this.mDoodle.W(this.mLastTouchY), this.mDoodle.V((this.mTouchX + this.mLastTouchX) / f16), this.mDoodle.W((this.mTouchY + this.mLastTouchY) / f16));
            }
            com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a aVar2 = this.mCurrDoodlePath;
            if (aVar2 != null && aVar2.p(this.mDoodle.V(this.mTouchX), this.mDoodle.W(this.mTouchY))) {
                z16 = true;
            }
            if (z16 && (aVar = this.mCurrDoodlePath) != null) {
                aVar.y(this.mCurrPath);
            }
            w53.b.a("DoodleOnTouchGestureListener", "onScroll mLastTouchX:" + this.mLastTouchX + ",mLastTouchY:" + this.mLastTouchY + ",mTouchX:" + this.mTouchX + ",mTouchY:" + this.mTouchY);
        }
        this.mDoodle.refresh();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        w53.b.a("DoodleOnTouchGestureListener", "onSingleTapUp");
        this.mLastTouchX = this.mTouchX;
        this.mLastTouchY = this.mTouchY;
        this.mTouchX = e16.getX();
        this.mTouchY = e16.getY();
        for (com.tencent.mobileqq.wink.editor.aielimination.doodle.view.e eVar : this.mDoodle.r()) {
            if ((eVar instanceof com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a) && ((com.tencent.mobileqq.wink.editor.aielimination.doodle.view.a) eVar).d(this.mDoodle.V(this.mTouchX), this.mDoodle.W(this.mTouchY))) {
                this.mDoodle.X(eVar);
                return true;
            }
        }
        j(e16);
        float f16 = this.VALUE;
        e16.offsetLocation(f16, f16);
        float f17 = this.VALUE;
        onScroll(e16, e16, f17, f17);
        k(e16);
        this.mDoodle.refresh();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(@Nullable MotionEvent e16) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(@Nullable MotionEvent e16) {
    }
}
