package s30;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleHalfScreenInitBean;
import com.tencent.biz.qqcircle.events.QFSRecommendPanelStatusEvent;
import com.tencent.biz.qqcircle.half.kuikly.QFSHalfScreenKuiklySheetView;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSStartVideoEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.QFSKuiklyView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0085\u0001B\t\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0002J\u0012\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\"H\u0016J\u0012\u0010+\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010,\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010-\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016J\u001c\u00100\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010/\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u00101\u001a\u00020\bJ\u0012\u00103\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010%H\u0016J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016J \u0010;\u001a\u00020\b2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0012H\u0016J\"\u0010C\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020AH\u0016J\u001c\u0010G\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010%2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u001c\u0010H\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010%2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR6\u0010p\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010lj\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u0001`m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010_R\u0016\u0010u\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010tR\u0016\u0010y\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010tR\u0016\u0010{\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010sR\u0016\u0010}\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010tR\u0016\u0010\u007f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010tR\u0018\u0010\u0081\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010s\u00a8\u0006\u0086\u0001"}, d2 = {"Ls30/e;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Lr30/b;", "Lcom/tencent/biz/qqcircle/immersive/views/QFSKuiklyView$b;", "Lr30/a;", "", "data", "", "L9", "P9", "N9", "Q9", "O9", "M9", "Landroid/widget/LinearLayout;", "linearContainer", "F9", "", "showTitle", "V9", "rounded", "X9", "D9", "", "visibility", "U9", "T9", "W9", "isFixHalf", "Y9", "J9", "I9", "R9", "", "action", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "onBackEvent", "args", "handleBroadcastMessage", "C9", "v", NodeProps.ON_CLICK, "k7", "m5", "l0", "", "slideOffset", "defaultHeight", "topSpaceHeight", ICustomDataEditor.NUMBER_PARAM_6, "withAnim", "l", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "parentView", "Landroid/view/MotionEvent;", "ev", "r7", "p2", "Lcom/tencent/biz/qqcircle/half/kuikly/QFSHalfScreenKuiklySheetView;", "d", "Lcom/tencent/biz/qqcircle/half/kuikly/QFSHalfScreenKuiklySheetView;", "mHalfSheetView", "e", "Landroid/widget/LinearLayout;", "mRootLinearLayout", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "mTitleContainer", h.F, "mTitleOperateContainer", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mBackIv", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mTitleTv", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mTitleName", "Lcom/tencent/biz/qqcircle/immersive/views/QFSKuiklyView;", "D", "Lcom/tencent/biz/qqcircle/immersive/views/QFSKuiklyView;", "mKuiklyView", "E", "Landroid/view/View;", "mHalfClickMaskView", "Lcom/tencent/biz/qqcircle/beans/QCircleHalfScreenInitBean;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/beans/QCircleHalfScreenInitBean;", "mInitBean", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "mKuiklySchemeAttr", "H", "mEntranceFeedId", "I", "Z", "mIsFullShow", "J", "mKuiklyIsTopFromEvent", "K", "mForceEnableFull", "L", "mStandardMode", "M", "mIsFixHalf", "N", "mTitleIsShowing", "P", "mLastStatus", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends u implements View.OnClickListener, r30.b, QFSKuiklyView.b, r30.a {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSKuiklyView mKuiklyView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mHalfClickMaskView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QCircleHalfScreenInitBean mInitBean;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private HashMap<String, String> mKuiklySchemeAttr;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String mEntranceFeedId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsFullShow;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mKuiklyIsTopFromEvent;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mForceEnableFull;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsFixHalf;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mTitleIsShowing;

    /* renamed from: P, reason: from kotlin metadata */
    private int mLastStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSHalfScreenKuiklySheetView mHalfSheetView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mRootLinearLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mTitleContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mTitleOperateContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mBackIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTitleTv;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mTitleName = "";

    /* renamed from: L, reason: from kotlin metadata */
    private int mStandardMode = 3;

    private final void D9() {
        if (this.mHalfClickMaskView != null) {
            return;
        }
        QFSKuiklyView qFSKuiklyView = this.mKuiklyView;
        if (!(qFSKuiklyView instanceof FrameLayout)) {
            qFSKuiklyView = null;
        }
        if (qFSKuiklyView != null) {
            View view = new View(getContext());
            view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            view.setBackground(new ColorDrawable(0));
            this.mHalfClickMaskView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: s30.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.E9(e.this, view2);
                }
            });
            qFSKuiklyView.addView(this.mHalfClickMaskView);
            QLog.d(getTAG(), 1, "[addHalfClickMaskView]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this$0.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            qFSHalfScreenKuiklySheetView.m();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F9(LinearLayout linearContainer) {
        ViewGroup.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        View view;
        ViewGroup viewGroup;
        ImageView imageView;
        if (this.mTitleContainer == null && linearContainer != null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gd8, (ViewGroup) linearContainer, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            this.mTitleContainer = viewGroup2;
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: s30.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        e.G9(e.this, view2);
                    }
                });
            }
            int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight();
            ViewGroup viewGroup3 = this.mTitleContainer;
            TextView textView = null;
            if (viewGroup3 != null) {
                layoutParams = viewGroup3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.height += statusBarHeight;
            }
            ViewGroup viewGroup4 = this.mTitleContainer;
            if (viewGroup4 != null) {
                viewGroup4.setPadding(viewGroup4.getPaddingLeft(), viewGroup4.getPaddingTop() + statusBarHeight, viewGroup4.getPaddingRight(), viewGroup4.getPaddingBottom());
            }
            ViewGroup viewGroup5 = this.mTitleContainer;
            if (viewGroup5 != null) {
                view = viewGroup5.findViewById(R.id.f43521mp);
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            ViewGroup viewGroup6 = this.mTitleContainer;
            if (viewGroup6 != null) {
                viewGroup = (ViewGroup) viewGroup6.findViewById(R.id.f43491mm);
            } else {
                viewGroup = null;
            }
            this.mTitleOperateContainer = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
            }
            ViewGroup viewGroup7 = this.mTitleContainer;
            if (viewGroup7 != null) {
                imageView = (ImageView) viewGroup7.findViewById(R.id.f43501mn);
            } else {
                imageView = null;
            }
            this.mBackIv = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: s30.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        e.H9(e.this, view2);
                    }
                });
            }
            ViewGroup viewGroup8 = this.mTitleContainer;
            if (viewGroup8 != null) {
                textView = (TextView) viewGroup8.findViewById(R.id.f43511mo);
            }
            this.mTitleTv = textView;
            if (textView != null) {
                textView.setText(this.mTitleName);
            }
            linearContainer.addView(this.mTitleContainer, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(e this$0, View view) {
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mIsFullShow && (qFSHalfScreenKuiklySheetView = this$0.mHalfSheetView) != null) {
            qFSHalfScreenKuiklySheetView.l();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9() {
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            qFSHalfScreenKuiklySheetView.k();
        }
    }

    private final void J9() {
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            qFSHalfScreenKuiklySheetView.l();
        }
    }

    private final void K9(String action) {
        QLog.d(getTAG(), 1, "[doStatusChangeReport] action:" + action);
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView == null) {
            return;
        }
        VideoReport.setElementId(qFSHalfScreenKuiklySheetView, QCircleDaTongConstant.ElementId.EM_XSJ_GESTURE_SLIDING);
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_STATE, action);
        map.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SEMI_FLOAT_PAGE);
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GESTURE_SLIDING);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", qFSHalfScreenKuiklySheetView, map);
    }

    private final void L9(Object data) {
        JSONObject jSONObject;
        Unit unit = null;
        if (data instanceof JSONObject) {
            jSONObject = (JSONObject) data;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Object a16 = com.tencent.mobileqq.perf.tool.b.a(jSONObject, "need_collapose", RemoteHandleConst.PARAM_DEFAULT_VALUE);
            QLog.d(getTAG(), 1, "[handleKuiklyNeedCollaposeEvent] needCollapose:" + a16);
            this.mKuiklyIsTopFromEvent = Intrinsics.areEqual(a16, "true");
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleKuiklyNeedCollaposeEvent] data is not JSONObject");
        }
    }

    private final void M9(Object data) {
        JSONObject jSONObject;
        String str;
        Unit unit;
        Unit unit2 = null;
        if (data instanceof JSONObject) {
            jSONObject = (JSONObject) data;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Object a16 = com.tencent.mobileqq.perf.tool.b.a(jSONObject, "target_state", RemoteHandleConst.PARAM_DEFAULT_VALUE);
            if (a16 instanceof String) {
                str = (String) a16;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            QLog.d(getTAG(), 1, "[handleKuiklySetHalfState] targetState:" + str);
            int hashCode = str.hashCode();
            if (hashCode != 3154575) {
                if (hashCode != 3194931) {
                    if (hashCode == 94756344 && str.equals("close")) {
                        J9();
                    }
                } else if (str.equals("half")) {
                    QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
                    if (qFSHalfScreenKuiklySheetView != null) {
                        qFSHalfScreenKuiklySheetView.j();
                        unit = Unit.INSTANCE;
                        unit2 = unit;
                    }
                }
                unit = Unit.INSTANCE;
                unit2 = unit;
            } else {
                if (str.equals("full")) {
                    Y9(false);
                    QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView2 = this.mHalfSheetView;
                    if (qFSHalfScreenKuiklySheetView2 != null) {
                        qFSHalfScreenKuiklySheetView2.m();
                        unit = Unit.INSTANCE;
                        unit2 = unit;
                    }
                }
                unit = Unit.INSTANCE;
                unit2 = unit;
            }
        }
        if (unit2 == null) {
            QLog.e(getTAG(), 1, "[handleKuiklySetHalfState] data is not JSONObject");
        }
    }

    private final void N9() {
        QLog.d(getTAG(), 1, "[handleRequestCurrentState]");
        f fVar = f.f433163a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        fVar.b(context, true ^ this.mIsFullShow);
    }

    private final void O9(Object data) {
        JSONObject jSONObject;
        Unit unit = null;
        String str = null;
        if (data instanceof JSONObject) {
            jSONObject = (JSONObject) data;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Object a16 = com.tencent.mobileqq.perf.tool.b.a(jSONObject, "title_name", RemoteHandleConst.PARAM_DEFAULT_VALUE);
            if (a16 instanceof String) {
                str = (String) a16;
            }
            if (str == null) {
                str = "";
            }
            this.mTitleName = str;
            TextView textView = this.mTitleTv;
            if (textView != null) {
                textView.setText(str);
            }
            QLog.d(getTAG(), 1, "[handleSetTitleInfo] titleName:" + this.mTitleName);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleSetTitleInfo] data is not JSONObject");
        }
    }

    private final void P9(Object data) {
        JSONObject jSONObject;
        int i3;
        int i16;
        Unit unit = null;
        if (data instanceof JSONObject) {
            jSONObject = (JSONObject) data;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Object a16 = com.tencent.mobileqq.perf.tool.b.a(jSONObject, "supprt_full", RemoteHandleConst.PARAM_DEFAULT_VALUE);
            if (Intrinsics.areEqual(a16, "true")) {
                i3 = 1;
            } else if (this.mForceEnableFull) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            this.mStandardMode = i3;
            QLog.d(getTAG(), 1, "[handleSupportFullEvent] isSupportFull:" + a16 + ", standardMode:" + this.mStandardMode);
            boolean z16 = false;
            if (this.mStandardMode == 2) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            U9(i16);
            if (this.mStandardMode == 3) {
                z16 = true;
            }
            Y9(z16);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleSupportFullEvent] data is not JSONObject");
        }
    }

    private final void Q9() {
        Intent intent;
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean;
        String str;
        Activity activity = getActivity();
        Unit unit = null;
        String str2 = null;
        unit = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.mEntranceFeedId = intent.getStringExtra("entranceFeedId");
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleHalfScreenInitBean) {
                qCircleHalfScreenInitBean = (QCircleHalfScreenInitBean) serializableExtra;
            } else {
                qCircleHalfScreenInitBean = null;
            }
            this.mInitBean = qCircleHalfScreenInitBean;
            if (qCircleHalfScreenInitBean != null) {
                str = qCircleHalfScreenInitBean.getH5Url();
            } else {
                str = null;
            }
            HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(str);
            this.mKuiklySchemeAttr = c16;
            if (c16 != null) {
                str2 = c16.get(QCircleSchemeAttr.WebView.FORCEENABLEFULL);
            }
            boolean areEqual = Intrinsics.areEqual(str2, "1");
            this.mForceEnableFull = areEqual;
            if (areEqual) {
                this.mStandardMode = 2;
            }
            QLog.d(getTAG(), 1, "[initParams] feedId:" + this.mEntranceFeedId + ", forceEnableFullAttr:" + str2 + ", standardMode:" + this.mStandardMode + ", hashCode" + hashCode());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[initParams] intent is null, feedId:null");
        }
    }

    private final boolean R9() {
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            return qFSHalfScreenKuiklySheetView.u();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W9();
    }

    private final void T9() {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap<String, String> hashMap = this.mKuiklySchemeAttr;
        if (hashMap == null || (str4 = hashMap.get("page_name")) == null) {
            str = "";
        } else {
            str = str4;
        }
        HashMap<String, String> hashMap2 = this.mKuiklySchemeAttr;
        if (hashMap2 == null || (str3 = hashMap2.get("bundle_name")) == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        QLog.d(getTAG(), 1, "[realLoadData] pageName:" + str + ", bundleName:" + str2);
        QFSKuiklyView qFSKuiklyView = this.mKuiklyView;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.n0(str, str2, null, -1, true, this.mKuiklySchemeAttr);
        }
    }

    private final void U9(int visibility) {
        if (!this.mIsFullShow && this.mStandardMode == 2) {
            View view = this.mHalfClickMaskView;
            if (view != null) {
                view.setVisibility(visibility);
                return;
            }
            return;
        }
        View view2 = this.mHalfClickMaskView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void V9(boolean showTitle) {
        boolean z16 = true;
        int i3 = 0;
        if (showTitle) {
            ViewGroup viewGroup = this.mTitleOperateContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            X9(false);
        } else {
            ViewGroup viewGroup2 = this.mTitleOperateContainer;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            X9(true);
        }
        if (this.mTitleIsShowing != showTitle) {
            Activity activity = getActivity();
            if (activity != null) {
                Window window = activity.getWindow();
                if (!showTitle || QQTheme.isNowThemeIsNight()) {
                    z16 = false;
                }
                RFWImmersiveUtils.setStatusBarTextColor(window, z16);
            }
            ViewGroup viewGroup3 = this.mTitleContainer;
            if (viewGroup3 != null) {
                if (showTitle) {
                    i3 = ie0.a.f().g(getContext(), R.color.qui_common_bg_nav_secondary, 1000);
                }
                viewGroup3.setBackgroundColor(i3);
            }
        }
        this.mTitleIsShowing = showTitle;
    }

    private final void W9() {
        Unit unit;
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            QLog.d(getTAG(), 1, "[showSheetView] success");
            qFSHalfScreenKuiklySheetView.z();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[showSheetView] error, sheet view is null");
        }
    }

    private final void X9(boolean rounded) {
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            qFSHalfScreenKuiklySheetView.A(rounded);
        }
    }

    private final void Y9(boolean isFixHalf) {
        if (this.mIsFixHalf == isFixHalf) {
            return;
        }
        QLog.d(getTAG(), 1, "[updateSheetViewFixStatus] isFixHalf:" + isFixHalf);
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            this.mIsFixHalf = isFixHalf;
            qFSHalfScreenKuiklySheetView.B(isFixHalf);
        }
    }

    public final void C9() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mRootLinearLayout = linearLayout;
        linearLayout.setOrientation(1);
        F9(this.mRootLinearLayout);
        QFSKuiklyView qFSKuiklyView = new QFSKuiklyView(getContext());
        this.mKuiklyView = qFSKuiklyView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = this.mRootLinearLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(qFSKuiklyView, layoutParams);
        }
        qFSKuiklyView.setKuiklyCallback(this);
        LinearLayout linearLayout3 = this.mRootLinearLayout;
        if (linearLayout3 != null) {
            CoordinatorLayout.LayoutParams layoutParams2 = new CoordinatorLayout.LayoutParams(-1, -1);
            QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
            if (qFSHalfScreenKuiklySheetView != null) {
                qFSHalfScreenKuiklySheetView.t(linearLayout3, layoutParams2, this.mKuiklyView);
            }
        }
        T9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSHalfScreenKuiklyPanelManagePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (action != null) {
            switch (action.hashCode()) {
                case -1937400052:
                    if (action.equals("QQCir_Video_From_Kuikly_Half_Screen_Need_Collapose")) {
                        L9(args);
                        return;
                    }
                    return;
                case -1484870802:
                    if (action.equals("QQCir_Video_From_Kuikly_Half_Screen_Support_Full")) {
                        P9(args);
                        return;
                    }
                    return;
                case 1176451722:
                    if (action.equals("QQCir_Video_From_Kuikly_Half_Screen_Set_Screen_State")) {
                        M9(args);
                        return;
                    }
                    return;
                case 1332485425:
                    if (action.equals("QQCir_Video_From_Kuikly_Half_Screen_Need_Current_State")) {
                        N9();
                        return;
                    }
                    return;
                case 1872347236:
                    if (action.equals("QQCir_Video_From_Kuikly_Half_Screen_Title_Info")) {
                        O9(args);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // r30.b
    public void k7() {
        QLog.d(getTAG(), 1, "[showMaxHeight] standardMode:" + this.mStandardMode + ", isFixHalf:" + this.mIsFixHalf);
        if (this.mIsFixHalf) {
            return;
        }
        if (this.mEntranceFeedId != null) {
            QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent = new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 2);
            qFSRecommendPanelStatusEvent.enableCropVideoCover = false;
            SimpleEventBus.getInstance().dispatchEvent(qFSRecommendPanelStatusEvent);
        }
        if (getContext() != null) {
            f fVar = f.f433163a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            fVar.b(context, false);
        }
        this.mIsFullShow = true;
        V9(true);
        U9(8);
        if (this.mLastStatus == 1) {
            K9(QCircleDaTongConstant.ElementParamValue.ACTION_SEMI_UP_SLIDE);
        }
        this.mLastStatus = 2;
    }

    @Override // r30.b
    public void l(boolean withAnim) {
        QLog.d(getTAG(), 1, "[dismiss] withAnim:" + withAnim);
        String str = this.mEntranceFeedId;
        if (str != null) {
            StringsKt__StringsJVMKt.isBlank(str);
            QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent = new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 4);
            qFSRecommendPanelStatusEvent.scene = 1;
            SimpleEventBus.getInstance().dispatchEvent(qFSRecommendPanelStatusEvent, true);
        }
        this.mIsFullShow = false;
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        int i3 = this.mLastStatus;
        if (i3 == 1) {
            K9(QCircleDaTongConstant.ElementParamValue.ACTION_SEMI_DOWN_SLIDE);
        } else if (i3 == 2) {
            K9(QCircleDaTongConstant.ElementParamValue.ACTION_FULL_SLIDE_CLOSE);
        }
        this.mLastStatus = 0;
    }

    @Override // r30.b
    public void l0() {
        QLog.d(getTAG(), 1, "[startShowDefault]");
        if (this.mEntranceFeedId != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 1), true);
        }
        this.mIsFullShow = false;
        U9(8);
    }

    @Override // r30.b
    public void m5() {
        QLog.d(getTAG(), 1, "[showDefaultHeight]");
        if (this.mEntranceFeedId != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, true));
        }
        if (getContext() != null) {
            f fVar = f.f433163a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            fVar.b(context, true);
        }
        this.mIsFullShow = false;
        V9(false);
        if (this.mStandardMode == 2) {
            D9();
        }
        U9(0);
        if (this.mLastStatus == 2) {
            K9(QCircleDaTongConstant.ElementParamValue.ACTION_FULL_DOWN_SLIDE);
        }
        this.mLastStatus = 1;
    }

    @Override // r30.b
    public void n6(float slideOffset, int defaultHeight, int topSpaceHeight) {
        if (slideOffset > 0.0f) {
            if (slideOffset < 1.0f) {
                V9(false);
                return;
            }
            return;
        }
        float f16 = (1 + slideOffset) * defaultHeight;
        String str = this.mEntranceFeedId;
        if (str != null) {
            StringsKt__StringsJVMKt.isBlank(str);
            QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent = new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 3);
            qFSRecommendPanelStatusEvent.height = (int) f16;
            qFSRecommendPanelStatusEvent.defaultHeight = defaultHeight;
            qFSRecommendPanelStatusEvent.topSpaceHeight = topSpaceHeight;
            SimpleEventBus.getInstance().dispatchEvent(qFSRecommendPanelStatusEvent, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean z16;
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView != null) {
            z16 = qFSHalfScreenKuiklySheetView.w();
        } else {
            z16 = false;
        }
        QLog.d(getTAG(), 1, "[onBackEvent] isShowing:" + z16);
        if (z16) {
            J9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f43481ml) {
            J9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView;
        super.onInitView(rootView);
        if (rootView != null) {
            qFSHalfScreenKuiklySheetView = (QFSHalfScreenKuiklySheetView) rootView.findViewById(R.id.f43481ml);
        } else {
            qFSHalfScreenKuiklySheetView = null;
        }
        this.mHalfSheetView = qFSHalfScreenKuiklySheetView;
        boolean z16 = false;
        if (qFSHalfScreenKuiklySheetView != null) {
            qFSHalfScreenKuiklySheetView.setBackgroundColor(0);
        }
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView2 = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView2 != null) {
            qFSHalfScreenKuiklySheetView2.setOnClickListener(this);
        }
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView3 = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView3 != null) {
            qFSHalfScreenKuiklySheetView3.i(this);
        }
        QFSHalfScreenKuiklySheetView qFSHalfScreenKuiklySheetView4 = this.mHalfSheetView;
        if (qFSHalfScreenKuiklySheetView4 != null) {
            qFSHalfScreenKuiklySheetView4.setNestScrollDelegate(this);
        }
        Q9();
        C9();
        if (this.mStandardMode == 3) {
            z16 = true;
        }
        Y9(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSKuiklyView.b
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        W9();
        f fVar = f.f433163a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        fVar.b(context, false);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QFSKuiklyView qFSKuiklyView = this.mKuiklyView;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onDestroy();
        }
        I9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        QFSKuiklyView qFSKuiklyView = this.mKuiklyView;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onPause();
        }
        if (R9()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, false));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        if (!this.mIsFirstResume && R9()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, true));
        }
        super.onPartResume(activity);
        QFSKuiklyView qFSKuiklyView = this.mKuiklyView;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onResume();
        }
        getMainHandler().post(new Runnable() { // from class: s30.c
            @Override // java.lang.Runnable
            public final void run() {
                e.S9(e.this);
            }
        });
    }

    @Override // r30.a
    public boolean p2(@Nullable View parentView, @Nullable MotionEvent ev5) {
        Integer num;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getActionMasked());
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 2) {
            return false;
        }
        int i3 = this.mStandardMode;
        if (i3 == 1) {
            if (this.mIsFullShow) {
                return false;
            }
            return this.mKuiklyIsTopFromEvent;
        }
        if (i3 != 2) {
            return false;
        }
        return !this.mIsFullShow;
    }

    @Override // r30.a
    public boolean r7(@Nullable View parentView, @Nullable MotionEvent ev5) {
        return false;
    }
}
