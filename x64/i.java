package x64;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.PopupWindow;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.bottomdialog.behavior.BottomSheetDialogGestureBehavior;
import com.tencent.robot.widget.bottomdialog.behavior.DialogBehaviorUIOperator;
import com.tencent.robot.widget.bottomdialog.behavior.c;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w64.j;
import w64.o;
import x64.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\b*\u0002Mg\u0018\u0000 m*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0015B\u0011\u0012\b\b\u0002\u00105\u001a\u000203\u00a2\u0006\u0004\bk\u0010lJ\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\u0016\u0010!\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\u001a\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u0016H\u0002J\b\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020'2\u0006\u0010%\u001a\u00020$H\u0002J\b\u00100\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u000e2\u0006\u00101\u001a\u00020'H\u0002R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00104R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u00106R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u00108R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010:R\u001a\u0010=\u001a\u0006\u0012\u0002\b\u00030\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010<R\u0016\u0010?\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010Y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010i\u00a8\u0006n"}, d2 = {"Lx64/i;", "Lw64/j;", "T", "Lw64/d;", "Landroid/view/View;", "viewOfBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "g", "Lw64/e;", "dialogContext", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "Lml3/b;", "emitterService", "", "c", "Lw64/o;", "dialog", "d", "f", "b", "a", "", "needAnim", "e", tl.h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$UpdateLayoutMsgIntent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "K", "O", "B", BdhLogUtil.LogTag.Tag_Conn, "u", "Landroid/graphics/Rect;", "viewport", "P", "", "newDisplayMode", "I", "isHalfMode", HippyTKDListViewAdapter.X, "isHalfToFull", "y", "L", "J", UserInfo.SEX_FEMALE, com.tencent.luggage.wxa.c8.c.f123400v, "N", "Lx64/l;", "Lx64/l;", "mBusinessDetailAdornApi", "Lw64/o;", "mDialog", "Lcom/tencent/mvi/runtime/strategy/b;", "mStrategyService", "Lml3/b;", "mEmitterService", "Lw64/e;", "mDialogContext", "Landroid/graphics/Rect;", "mViewport", "Landroid/view/View;", "mBusinessRootView", "Lcom/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior;", "Lcom/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior;", "mBehavior", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "i", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "mUIOperator", "Lx64/j;", "j", "Lx64/j;", "mUIMeasureHelper", "x64/i$e", "k", "Lx64/i$e;", "mViewportProvider", "Landroid/animation/Animator;", "l", "Landroid/animation/Animator;", "mShowAnimator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mDismissAnimator", DomainData.DOMAIN_NAME, "Z", "mIsManualTraversalScheduled", "Lcom/tencent/robot/widget/bottomdialog/behavior/c$b;", "o", "Lcom/tencent/robot/widget/bottomdialog/behavior/c$b;", "mOnScrollChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "p", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mGlobalLayoutListener", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "[Ljava/lang/String;", "mMessageArray", "x64/i$d", "r", "Lx64/i$d;", "mAction", "<init>", "(Lx64/l;)V", ReportConstant.COSTREPORT_PREFIX, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i<T extends w64.j> implements w64.d<T> {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final a f447313s = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l mBusinessDetailAdornApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private o mDialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mvi.runtime.strategy.b mStrategyService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ml3.b mEmitterService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private w64.e<?> mDialogContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect mViewport;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mBusinessRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BottomSheetDialogGestureBehavior mBehavior;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.robot.widget.bottomdialog.behavior.c mUIOperator;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private j mUIMeasureHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mViewportProvider;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator mShowAnimator;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator mDismissAnimator;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mIsManualTraversalScheduled;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c.b mOnScrollChangeListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] mMessageArray;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lx64/i$a;", "", "", "COLOR_BIT_MAX", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"x64/i$b", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lx64/j;", "c", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends IStrategyFetcher<j> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f447332b;

        b(j jVar) {
            this.f447332b = jVar;
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: from getter and merged with bridge method [inline-methods] */
        public j a() {
            return this.f447332b;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0000\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"x64/i$c", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/robot/widget/bottomdialog/behavior/d;", "x64/i$e", "c", "()Lx64/i$e;", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends IStrategyFetcher<com.tencent.robot.widget.bottomdialog.behavior.d> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i<T> f447333b;

        c(i<T> iVar) {
            this.f447333b = iVar;
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e a() {
            return ((i) this.f447333b).mViewportProvider;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"x64/i$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i<T> f447334d;

        d(i<T> iVar) {
            this.f447334d = iVar;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f447334d.z(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"x64/i$e", "Lcom/tencent/robot/widget/bottomdialog/behavior/d;", "Landroid/graphics/Rect;", "getViewport", "()Landroid/graphics/Rect;", "viewport", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements com.tencent.robot.widget.bottomdialog.behavior.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<T> f447335a;

        e(i<T> iVar) {
            this.f447335a = iVar;
        }

        @Override // com.tencent.robot.widget.bottomdialog.behavior.d
        @NotNull
        public Rect getViewport() {
            return ((i) this.f447335a).mViewport;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"x64/i$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i<T> f447336d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f447337e;

        f(i<T> iVar, int i3) {
            this.f447336d = iVar;
            this.f447337e = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f447336d.N(this.f447337e);
            o oVar = ((i) this.f447336d).mDialog;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialog");
                oVar = null;
            }
            oVar.b(false);
            if (animation != null) {
                animation.removeAllListeners();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"x64/i$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i<T> f447338d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f447339e;

        g(i<T> iVar, int i3) {
            this.f447338d = iVar;
            this.f447339e = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f447338d.N(this.f447339e);
            animation.removeAllListeners();
        }
    }

    public i(@NotNull l mBusinessDetailAdornApi) {
        Intrinsics.checkNotNullParameter(mBusinessDetailAdornApi, "mBusinessDetailAdornApi");
        this.mBusinessDetailAdornApi = mBusinessDetailAdornApi;
        this.mViewport = new Rect();
        this.mViewportProvider = new e(this);
        this.mOnScrollChangeListener = new c.b() { // from class: x64.f
            @Override // com.tencent.robot.widget.bottomdialog.behavior.c.b
            public final void a(View view, int i3, int i16, int i17, int i18, int i19) {
                i.E(i.this, view, i3, i16, i17, i18, i19);
            }
        };
        this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: x64.g
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                i.D(i.this);
            }
        };
        this.mMessageArray = new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.class).getQualifiedName()};
        this.mAction = new d(this);
    }

    private final void A(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent event) {
        j jVar = this.mUIMeasureHelper;
        if (jVar != null && this.mDialog != null) {
            o oVar = null;
            if (jVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
                jVar = null;
            }
            o oVar2 = this.mDialog;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            } else {
                oVar = oVar2;
            }
            Rect h16 = jVar.h(oVar.a());
            Intrinsics.checkNotNullExpressionValue(h16, "mUIMeasureHelper.getViewport(mDialog.anchor)");
            List<Object> a16 = event.a();
            boolean z16 = false;
            if (a16 != null && a16.contains(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a)) {
                z16 = true;
            }
            P(h16, z16);
        }
    }

    private final void B(w64.e<T> dialogContext) {
        l lVar = this.mBusinessDetailAdornApi;
        Context requireContext = dialogContext.c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "dialogContext.fragment.requireContext()");
        j b16 = lVar.b(requireContext);
        com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategyService");
            bVar = null;
        }
        bVar.c(j.class, new b(b16));
        this.mUIMeasureHelper = b16;
    }

    private final void C() {
        com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategyService");
            bVar = null;
        }
        bVar.c(com.tencent.robot.widget.bottomdialog.behavior.d.class, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j jVar = this$0.mUIMeasureHelper;
        if (jVar == null) {
            return;
        }
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
            jVar = null;
        }
        o oVar = this$0.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        Rect h16 = jVar.h(oVar.a());
        if (!(!Intrinsics.areEqual(h16, this$0.mViewport))) {
            h16 = null;
        }
        if (h16 != null) {
            QLog.d("BottomSheetDialogAdorn", 1, "onGlobalLayout viewport changed old=" + this$0.mViewport + " new=" + h16);
            Q(this$0, h16, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(i this$0, View view, int i3, int i16, int i17, int i18, int i19) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        BottomSheetDialogGestureBehavior bottomSheetDialogGestureBehavior = this$0.mBehavior;
        if (bottomSheetDialogGestureBehavior == null) {
            return;
        }
        o oVar = this$0.mDialog;
        w64.e<?> eVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        if (oVar.getMTransitionState() != 0) {
            return;
        }
        if (i3 == 0 && i17 >= bottomSheetDialogGestureBehavior.l() && i19 <= i17) {
            w64.e<?> eVar2 = this$0.mDialogContext;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
            } else {
                eVar = eVar2;
            }
            eVar.e().h(BottomSheetDialogAdornMsgIntent.OnScrollToTop.f368651d);
            return;
        }
        if (i3 == 1 && i17 == bottomSheetDialogGestureBehavior.g()) {
            w64.e<?> eVar3 = this$0.mDialogContext;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
            } else {
                eVar = eVar3;
            }
            eVar.e().h(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.f368650d);
        }
    }

    private final void F() {
        int i3;
        ColorDrawable colorDrawable;
        final int i16;
        int height = this.mViewport.height();
        View view = this.mBusinessRootView;
        final int i17 = 0;
        if (view != null) {
            i3 = view.getTop();
        } else {
            i3 = 0;
        }
        final int i18 = height - i3;
        com.tencent.robot.widget.bottomdialog.behavior.c cVar = this.mUIOperator;
        if (cVar != null) {
            i17 = cVar.getMTranslationY();
        }
        o oVar = this.mDialog;
        w64.e<?> eVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        Drawable background = oVar.d().getBackground();
        if (background instanceof ColorDrawable) {
            colorDrawable = (ColorDrawable) background;
        } else {
            colorDrawable = null;
        }
        if (colorDrawable != null) {
            i16 = colorDrawable.getAlpha();
        } else {
            i16 = 255;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.mBusinessDetailAdornApi.getMConfiguration().getSmoothScrollDuration() >> 1);
        ofFloat.setInterpolator(new Interpolator() { // from class: x64.b
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float G;
                G = i.G(f16);
                return G;
            }
        });
        ofFloat.addListener(new f(this, i16));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: x64.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.H(i.this, i16, i17, i18, valueAnimator);
            }
        });
        this.mDismissAnimator = ofFloat;
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.start();
        w64.e<?> eVar2 = this.mDialogContext;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
        } else {
            eVar = eVar2;
        }
        eVar.e().h(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.f368649d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float G(float f16) {
        return (float) ((Math.cos((f16 + 1) * 3.141592653589793d) * 0.5d) + 0.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(i this$0, int i3, int i16, int i17, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N((int) (i3 * (1.0f - valueAnimator.getAnimatedFraction())));
        com.tencent.robot.widget.bottomdialog.behavior.c cVar = this$0.mUIOperator;
        if (cVar != null) {
            cVar.b((int) (i16 + ((i17 - i16) * valueAnimator.getAnimatedFraction())));
        }
    }

    private final void I(int newDisplayMode, boolean needAnim) {
        boolean z16;
        Integer num;
        int i3;
        boolean z17 = false;
        if (newDisplayMode == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        BottomSheetDialogGestureBehavior bottomSheetDialogGestureBehavior = this.mBehavior;
        w64.e<?> eVar = null;
        if (bottomSheetDialogGestureBehavior != null) {
            num = Integer.valueOf(bottomSheetDialogGestureBehavior.getMDisplayMode());
        } else {
            num = null;
        }
        w64.e<?> eVar2 = this.mDialogContext;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
        } else {
            eVar = eVar2;
        }
        com.tencent.mvi.base.route.j e16 = eVar.e();
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        e16.h(new BottomSheetDialogAdornMsgIntent.DisplayModeChange(newDisplayMode, i3));
        x(z16, needAnim);
        L();
        if (num != null && num.intValue() == 1 && !z16) {
            z17 = true;
        }
        y(z17);
        BottomSheetDialogGestureBehavior bottomSheetDialogGestureBehavior2 = this.mBehavior;
        if (bottomSheetDialogGestureBehavior2 != null) {
            bottomSheetDialogGestureBehavior2.y(newDisplayMode);
        }
    }

    private final int J(Rect viewport) {
        o oVar = this.mDialog;
        o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        oVar.d().update(viewport.left, viewport.top, viewport.width(), viewport.height(), true);
        j jVar = this.mUIMeasureHelper;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
            jVar = null;
        }
        o oVar3 = this.mDialog;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
        } else {
            oVar2 = oVar3;
        }
        return jVar.a(oVar2.a());
    }

    private final void K() {
        for (String str : this.mMessageArray) {
            w64.e<?> eVar = this.mDialogContext;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
                eVar = null;
            }
            eVar.e().d(str, this.mAction);
        }
    }

    private final void L() {
        boolean z16;
        final int i3;
        o oVar = this.mDialog;
        ColorDrawable colorDrawable = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        if (oVar.getMTransitionState() == 1) {
            com.tencent.robot.widget.bottomdialog.behavior.c cVar = this.mUIOperator;
            if (cVar != null) {
                cVar.c(0, this.mBusinessDetailAdornApi.getMConfiguration().getSmoothScrollDuration());
            }
            o oVar2 = this.mDialog;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialog");
                oVar2 = null;
            }
            Drawable background = oVar2.d().getBackground();
            if (background instanceof ColorDrawable) {
                colorDrawable = (ColorDrawable) background;
            }
            if (colorDrawable != null) {
                i3 = colorDrawable.getAlpha();
            } else {
                i3 = 255;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(this.mBusinessDetailAdornApi.getMConfiguration().getSmoothScrollDuration());
            ofFloat.addListener(new g(this, i3));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: x64.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i.M(i.this, i3, valueAnimator);
                }
            });
            this.mShowAnimator = ofFloat;
            Intrinsics.checkNotNull(ofFloat);
            ofFloat.start();
            return;
        }
        Animator animator = this.mShowAnimator;
        if (animator != null && animator.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("BottomSheetDialogAdorn", 1, "scrollToShowStatePosition anim running, return");
            return;
        }
        com.tencent.robot.widget.bottomdialog.behavior.c cVar2 = this.mUIOperator;
        if (cVar2 != null) {
            c.a.b(cVar2, 0, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(i this$0, int i3, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N((int) (i3 * valueAnimator.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(int alpha) {
        o oVar = this.mDialog;
        o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        Drawable background = oVar.d().getBackground();
        if (background instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) background;
            colorDrawable.setColor(ColorUtils.setAlphaComponent(colorDrawable.getColor(), alpha));
            return;
        }
        o oVar3 = this.mDialog;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
        } else {
            oVar2 = oVar3;
        }
        oVar2.d().setBackgroundDrawable(new ColorDrawable(Color.argb(alpha, 0, 0, 0)));
    }

    private final void O() {
        for (String str : this.mMessageArray) {
            w64.e<?> eVar = this.mDialogContext;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
                eVar = null;
            }
            eVar.e().b(str, this.mAction);
        }
    }

    private final void P(Rect viewport, boolean needAnim) {
        this.mViewport.set(viewport);
        I(J(viewport), needAnim);
    }

    static /* synthetic */ void Q(i iVar, Rect rect, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        iVar.P(rect, z16);
    }

    private final void u() {
        Drawable drawable;
        o oVar = this.mDialog;
        o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        PopupWindow d16 = oVar.d();
        Drawable background = this.mBusinessDetailAdornApi.getMConfiguration().getBackground();
        if (background != null) {
            drawable = background.mutate();
        } else {
            drawable = null;
        }
        d16.setBackgroundDrawable(drawable);
        l.a mConfiguration = this.mBusinessDetailAdornApi.getMConfiguration();
        o oVar3 = this.mDialog;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar3 = null;
        }
        PopupWindow d17 = oVar3.d();
        d17.setFocusable(mConfiguration.getIsFocusable());
        d17.setOutsideTouchable(mConfiguration.getIsOutsideTouchable());
        d17.setClippingEnabled(mConfiguration.getIsClippingEnable());
        d17.setInputMethodMode(mConfiguration.getInputMethodMode());
        if (mConfiguration.getLaidOutInScreen() != null && Build.VERSION.SDK_INT >= 29) {
            d17.setIsLaidOutInScreen(mConfiguration.getLaidOutInScreen().booleanValue());
        }
        o oVar4 = this.mDialog;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
        } else {
            oVar2 = oVar4;
        }
        oVar2.d().getContentView().setOnClickListener(new View.OnClickListener() { // from class: x64.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.w(i.this, view);
            }
        });
        View view = this.mBusinessRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: x64.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.v(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("BottomSheetDialogAdorn", 4, "click on business root view");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        o oVar = this$0.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        oVar.b(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(boolean isHalfMode, boolean needAnim) {
        j jVar = this.mUIMeasureHelper;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
            jVar = null;
        }
        ml3.b bVar = this.mEmitterService;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmitterService");
            bVar = null;
        }
        int d16 = jVar.d(bVar, this.mViewport, isHalfMode);
        View view = this.mBusinessRootView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = d16;
                view.setLayoutParams(layoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        j jVar2 = this.mUIMeasureHelper;
        if (jVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
            jVar2 = null;
        }
        ml3.b bVar2 = this.mEmitterService;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmitterService");
            bVar2 = null;
        }
        int e16 = jVar2.e(bVar2, this.mViewport, d16, isHalfMode);
        if (needAnim) {
            com.tencent.robot.widget.bottomdialog.behavior.c cVar = this.mUIOperator;
            if (cVar != null) {
                c.a.d(cVar, e16, 0, 2, null);
                return;
            }
            return;
        }
        com.tencent.robot.widget.bottomdialog.behavior.c cVar2 = this.mUIOperator;
        if (cVar2 != null) {
            cVar2.b(e16);
        }
    }

    private final void y(boolean isHalfToFull) {
        Object m476constructorimpl;
        if (isHalfToFull && !this.mIsManualTraversalScheduled) {
            o oVar = this.mDialog;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialog");
                oVar = null;
            }
            ViewParent parent = oVar.d().getContentView().getRootView().getParent();
            if (parent == null) {
                QLog.e("BottomSheetDialogAdorn", 1, "viewRoot is null");
                return;
            }
            this.mIsManualTraversalScheduled = true;
            try {
                Result.Companion companion = Result.INSTANCE;
                Method declaredMethod = parent.getClass().getDeclaredMethod("doTraversal", new Class[0]);
                declaredMethod.setAccessible(true);
                m476constructorimpl = Result.m476constructorimpl(declaredMethod.invoke(parent, new Object[0]));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.e("BottomSheetDialogAdorn", 1, "doTraversalManually | " + m479exceptionOrNullimpl.getMessage());
            }
            this.mIsManualTraversalScheduled = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent) {
            A((BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent) event);
        }
    }

    @Override // w64.d
    public void a() {
        o oVar = this.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        oVar.a().getViewTreeObserver().removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
        com.tencent.robot.widget.bottomdialog.behavior.c cVar = this.mUIOperator;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // w64.d
    public void b() {
        j jVar = this.mUIMeasureHelper;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
            jVar = null;
        }
        o oVar = this.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        Rect it = jVar.h(oVar.a());
        o oVar2 = this.mDialog;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar2 = null;
        }
        PopupWindow d16 = oVar2.d();
        o oVar3 = this.mDialog;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar3 = null;
        }
        d16.showAtLocation(oVar3.a(), 0, it.left, it.top);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Q(this, it, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w64.d
    public void c(@NotNull w64.e<T> dialogContext, @NotNull com.tencent.mvi.runtime.strategy.b strategyService, @NotNull ml3.b emitterService) {
        Intrinsics.checkNotNullParameter(dialogContext, "dialogContext");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        Intrinsics.checkNotNullParameter(emitterService, "emitterService");
        this.mDialogContext = dialogContext;
        this.mStrategyService = strategyService;
        this.mEmitterService = emitterService;
        K();
        B(dialogContext);
        C();
    }

    @Override // w64.d
    public void d(@NotNull o dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.mDialog = dialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            dialog = null;
        }
        PopupWindow d16 = dialog.d();
        d16.setWidth(-1);
        d16.setHeight(-1);
        u();
    }

    @Override // w64.d
    public void e(boolean needAnim) {
        Animator animator = this.mShowAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (needAnim) {
            F();
            return;
        }
        o oVar = this.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        oVar.d().dismiss();
    }

    @Override // w64.d
    public void f() {
        boolean z16;
        int b16;
        o oVar = this.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        oVar.a().getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        com.tencent.robot.widget.bottomdialog.behavior.c cVar = this.mUIOperator;
        if (cVar != null) {
            o oVar2 = this.mDialog;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialog");
                oVar2 = null;
            }
            Integer valueOf = Integer.valueOf(oVar2.d().getHeight());
            if (valueOf.intValue() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                b16 = valueOf.intValue();
            } else {
                j jVar = this.mUIMeasureHelper;
                if (jVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
                    jVar = null;
                }
                o oVar3 = this.mDialog;
                if (oVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialog");
                    oVar3 = null;
                }
                b16 = jVar.b(oVar3.a());
            }
            c.a.b(cVar, -b16, 0, 2, null);
        }
    }

    @Override // w64.d
    @NotNull
    public CoordinatorLayout.Behavior<?> g(@NotNull View viewOfBehavior) {
        Intrinsics.checkNotNullParameter(viewOfBehavior, "viewOfBehavior");
        this.mBusinessRootView = viewOfBehavior;
        DialogBehaviorUIOperator dialogBehaviorUIOperator = new DialogBehaviorUIOperator(viewOfBehavior, this.mOnScrollChangeListener, this.mViewportProvider);
        this.mUIOperator = dialogBehaviorUIOperator;
        l lVar = this.mBusinessDetailAdornApi;
        Intrinsics.checkNotNull(dialogBehaviorUIOperator);
        j jVar = this.mUIMeasureHelper;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMeasureHelper");
            jVar = null;
        }
        BottomSheetDialogGestureBehavior a16 = lVar.a(dialogBehaviorUIOperator, jVar);
        this.mBehavior = a16;
        Intrinsics.checkNotNull(a16);
        return a16;
    }

    @Override // w64.d
    public void h() {
        O();
        o oVar = this.mDialog;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialog");
            oVar = null;
        }
        oVar.a().getViewTreeObserver().removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    public /* synthetic */ i(l lVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new k() : lVar);
    }
}
