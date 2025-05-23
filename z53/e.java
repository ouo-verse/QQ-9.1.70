package z53;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\b\u0016\u0012\u0006\u0010L\u001a\u00020\u0015\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\bN\u0010OB%\b\u0016\u0012\u0006\u0010L\u001a\u00020\u0015\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010P\u001a\u0004\u0018\u000108\u00a2\u0006\u0004\bN\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0010R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010!R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001eR\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\u001eR\u0016\u0010A\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010C\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bB\u0010\u001eR\u0014\u0010E\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bD\u00104R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010!\u00a8\u0006R"}, d2 = {"Lz53/e;", "", "", "g", "Landroid/view/MotionEvent;", "event", "i", "scales", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "", "d", "e", "f", "", "minSpan", "j", "spanSlop", "l", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lz53/e$a;", "b", "Lz53/e$a;", "mListener", "c", UserInfo.SEX_FEMALE, "mFocusX", "mFocusY", "Z", "mQuickScaleEnabled", "mStylusScaleEnabled", "mCurrSpan", "mPrevSpan", "mInitialSpan", "mCurrSpanX", "mCurrSpanY", "mPrevSpanX", "mPrevSpanY", "", DomainData.DOMAIN_NAME, "J", "mCurrTime", "o", "mPrevTime", "p", "mInProgress", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", "mSpanSlop", "r", "mMinSpan", "Landroid/os/Handler;", ReportConstant.COSTREPORT_PREFIX, "Landroid/os/Handler;", "mHandler", "t", "mAnchoredScaleStartX", "u", "mAnchoredScaleStartY", "v", "mAnchoredScaleMode", "w", "SCALE_FACTOR", HippyTKDListViewAdapter.X, "ANCHORED_SCALE_MODE_DOUBLE_TAP", "Landroid/view/GestureDetector;", "y", "Landroid/view/GestureDetector;", "mGestureDetector", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mEventBeforeOrAboveStartingGestureEvent", "context", "listener", "<init>", "(Landroid/content/Context;Lz53/e$a;)V", "handler", "(Landroid/content/Context;Lz53/e$a;Landroid/os/Handler;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float mFocusX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mFocusY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mQuickScaleEnabled;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mStylusScaleEnabled;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mCurrSpan;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mPrevSpan;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mInitialSpan;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float mCurrSpanX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float mCurrSpanY;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float mPrevSpanX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mPrevSpanY;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long mCurrTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long mPrevTime;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean mInProgress;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int mSpanSlop;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int mMinSpan;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler mHandler;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private float mAnchoredScaleStartX;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private float mAnchoredScaleStartY;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int mAnchoredScaleMode;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final float SCALE_FACTOR;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final int ANCHORED_SCALE_MODE_DOUBLE_TAP;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean mEventBeforeOrAboveStartingGestureEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lz53/e$a;", "", "Lz53/e;", "var1", "", "a", "c", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        boolean a(@NotNull e var1);

        void b(@NotNull e var1);

        boolean c(@NotNull e var1);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"z53/e$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            e.this.mAnchoredScaleStartX = e16.getX();
            e.this.mAnchoredScaleStartY = e16.getY();
            e.this.mAnchoredScaleMode = 1;
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context, @Nullable a aVar) {
        this(context, aVar, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean g() {
        if (this.mAnchoredScaleMode != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: from getter */
    public final float getMFocusX() {
        return this.mFocusX;
    }

    /* renamed from: e, reason: from getter */
    public final float getMFocusY() {
        return this.mFocusY;
    }

    public final float f() {
        boolean z16;
        if (!g()) {
            float f16 = this.mPrevSpan;
            if (f16 <= 0.0f) {
                return 1.0f;
            }
            return this.mCurrSpan / f16;
        }
        boolean z17 = this.mEventBeforeOrAboveStartingGestureEvent;
        if ((z17 && this.mCurrSpan < this.mPrevSpan) || (!z17 && this.mCurrSpan > this.mPrevSpan)) {
            z16 = true;
        } else {
            z16 = false;
        }
        float abs = Math.abs(1.0f - (this.mCurrSpan / this.mPrevSpan)) * 0.5f;
        if (this.mPrevSpan <= 0.0f) {
            return 1.0f;
        }
        if (z16) {
            return 1.0f + abs;
        }
        return 1.0f - abs;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getMInProgress() {
        return this.mInProgress;
    }

    public final boolean i(@NotNull MotionEvent event) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i3;
        float f16;
        float f17;
        float hypot;
        int i16;
        a aVar;
        boolean z27;
        boolean z28;
        GestureDetector gestureDetector;
        Intrinsics.checkNotNullParameter(event, "event");
        this.mCurrTime = event.getEventTime();
        int actionMasked = event.getActionMasked();
        if (this.mQuickScaleEnabled && (gestureDetector = this.mGestureDetector) != null) {
            gestureDetector.onTouchEvent(event);
        }
        int pointerCount = event.getPointerCount();
        boolean z29 = false;
        if ((event.getButtonState() & 32) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mAnchoredScaleMode == 2 && !z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (actionMasked != 1 && actionMasked != 3 && !z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        float f18 = 0.0f;
        if (actionMasked == 0 || z18) {
            if (this.mInProgress) {
                a aVar2 = this.mListener;
                if (aVar2 != null) {
                    aVar2.b(this);
                }
                this.mInProgress = false;
                this.mInitialSpan = 0.0f;
                this.mAnchoredScaleMode = 0;
            } else if (g() && z18) {
                this.mInProgress = false;
                this.mInitialSpan = 0.0f;
                this.mAnchoredScaleMode = 0;
            }
            if (z18) {
                return true;
            }
        }
        if (!this.mInProgress && this.mStylusScaleEnabled && !g() && !z18 && z16) {
            this.mAnchoredScaleStartX = event.getX();
            this.mAnchoredScaleStartY = event.getY();
            this.mAnchoredScaleMode = 2;
            this.mInitialSpan = 0.0f;
        }
        if (actionMasked != 0 && actionMasked != 6 && actionMasked != 5 && !z17) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (actionMasked == 6) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            i3 = event.getActionIndex();
        } else {
            i3 = -1;
        }
        int i17 = z26 ? pointerCount - 1 : pointerCount;
        if (g()) {
            f17 = this.mAnchoredScaleStartX;
            f16 = this.mAnchoredScaleStartY;
            if (event.getY() < f16) {
                z28 = true;
            } else {
                z28 = false;
            }
            this.mEventBeforeOrAboveStartingGestureEvent = z28;
        } else {
            float f19 = 0.0f;
            float f26 = 0.0f;
            for (int i18 = 0; i18 < pointerCount; i18++) {
                if (i3 != i18) {
                    f19 += event.getX(i18);
                    f26 += event.getY(i18);
                }
            }
            float f27 = i17;
            float f28 = f19 / f27;
            f16 = f26 / f27;
            f17 = f28;
        }
        float f29 = 0.0f;
        for (int i19 = 0; i19 < pointerCount; i19++) {
            if (i3 != i19) {
                f18 += Math.abs(event.getX(i19) - f17);
                f29 += Math.abs(event.getY(i19) - f16);
            }
        }
        float f36 = i17;
        float f37 = (f18 / f36) * 2.0f;
        float f38 = (f29 / f36) * 2.0f;
        if (g()) {
            hypot = f38;
        } else {
            hypot = (float) Math.hypot(f37, f38);
        }
        boolean z36 = this.mInProgress;
        this.mFocusX = f17;
        this.mFocusY = f16;
        if (!g() && this.mInProgress && (hypot < this.mMinSpan || z19)) {
            a aVar3 = this.mListener;
            if (aVar3 != null) {
                aVar3.b(this);
            }
            this.mInProgress = false;
            this.mInitialSpan = hypot;
        }
        if (z19) {
            this.mCurrSpanX = f37;
            this.mPrevSpanX = f37;
            this.mCurrSpanY = f38;
            this.mPrevSpanY = f38;
            this.mCurrSpan = hypot;
            this.mPrevSpan = hypot;
            this.mInitialSpan = hypot;
        }
        if (g()) {
            i16 = this.mSpanSlop;
        } else {
            i16 = this.mMinSpan;
        }
        if (!this.mInProgress && hypot >= i16 && (z36 || Math.abs(hypot - this.mInitialSpan) > this.mSpanSlop)) {
            this.mCurrSpanX = f37;
            this.mPrevSpanX = f37;
            this.mCurrSpanY = f38;
            this.mPrevSpanY = f38;
            this.mCurrSpan = hypot;
            this.mPrevSpan = hypot;
            this.mPrevTime = this.mCurrTime;
            a aVar4 = this.mListener;
            if (aVar4 != null && aVar4.c(this)) {
                z27 = true;
            } else {
                z27 = false;
            }
            this.mInProgress = z27;
        }
        if (actionMasked == 2) {
            this.mCurrSpanX = f37;
            this.mCurrSpanY = f38;
            this.mCurrSpan = hypot;
            if (!this.mInProgress || ((aVar = this.mListener) != null && aVar.a(this))) {
                z29 = true;
            }
            if (z29) {
                this.mPrevSpanX = this.mCurrSpanX;
                this.mPrevSpanY = this.mCurrSpanY;
                this.mPrevSpan = this.mCurrSpan;
                this.mPrevTime = this.mCurrTime;
            }
        }
        return true;
    }

    public final void j(int minSpan) {
        this.mMinSpan = minSpan;
    }

    public final void k(boolean scales) {
        this.mQuickScaleEnabled = scales;
        if (scales && this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(this.mContext, new b(), this.mHandler);
        }
    }

    public final void l(int spanSlop) {
        this.mSpanSlop = spanSlop;
    }

    public final void m(boolean scales) {
        this.mStylusScaleEnabled = scales;
    }

    public e(@NotNull Context context, @Nullable a aVar, @Nullable Handler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.SCALE_FACTOR = 0.5f;
        this.ANCHORED_SCALE_MODE_DOUBLE_TAP = 1;
        this.mAnchoredScaleMode = 0;
        this.mContext = context;
        this.mListener = aVar;
        this.mSpanSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.mMinSpan = 27;
        this.mHandler = handler;
        int i3 = context.getApplicationInfo().targetSdkVersion;
        if (i3 > 18) {
            k(true);
        }
        if (i3 > 22) {
            m(true);
        }
    }
}
