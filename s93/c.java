package s93;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.smtt.utils.Md5Utils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s93.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B8\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00050\u0017\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0005R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R/\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00050\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Ls93/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "videoView", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "o0", "release", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "templateList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "template", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onItemClick", "", "Ljava/lang/ref/WeakReference;", "D", "Ljava/util/Set;", "videoViewsRefList", "E", "I", "selectedPosition", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", UserInfo.SEX_FEMALE, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int G = ViewUtils.dpToPx(400.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<MetaMaterial, Unit> onItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Set<WeakReference<BaseVideoView>> videoViewsRefList;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MetaMaterial> templateList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010B\u001a\u00020\u0011\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0002R\u0014\u0010!\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010(R\u0014\u0010,\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010-\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u0014\u00105\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010 R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Ls93/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "v", "u", "r", "H", "", "url", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", "t", "E", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Pair;", "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "btn", "D", BdhLogUtil.LogTag.Tag_Conn, "position", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "show", "needAnimate", "J", "y", "Landroid/view/View;", "cardView", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "videoContainer", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "templateNameView", "describeView", "I", "usageCountView", "tagView", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "K", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "nextBtnBlurView", "L", "nextTextBtn", "M", "nextBtnClickArea", "Lcom/airbnb/lottie/LottieAnimationView;", "N", "Lcom/airbnb/lottie/LottieAnimationView;", "nextBtnAnimView", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "P", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "videoView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "template", "itemView", "<init>", "(Ls93/c;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View cardView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final FrameLayout videoContainer;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView templateNameView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView describeView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView usageCountView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView tagView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final QQBlurViewWrapper nextBtnBlurView;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final TextView nextTextBtn;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final View nextBtnClickArea;

        /* renamed from: N, reason: from kotlin metadata */
        @NotNull
        private final LottieAnimationView nextBtnAnimView;

        /* renamed from: P, reason: from kotlin metadata */
        private BaseVideoView videoView;

        /* renamed from: Q, reason: from kotlin metadata */
        private MetaMaterial template;
        final /* synthetic */ c R;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"s93/c$b$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f433531e;

            a(int i3) {
                this.f433531e = i3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animation) {
                b.this.nextBtnClickArea.setVisibility(this.f433531e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull c cVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.R = cVar;
            View findViewById = itemView.findViewById(R.id.f124277ix);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.wink_template_item_card)");
            this.cardView = findViewById;
            View findViewById2 = itemView.findViewById(R.id.f124617ju);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026template_video_container)");
            this.videoContainer = (FrameLayout) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f124407j_);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.wink_template_name)");
            this.templateNameView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f124267iw);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.wink_template_describe)");
            this.describeView = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f124607jt);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026ink_template_usage_count)");
            this.usageCountView = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f124487jh);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.wink_template_tag)");
            this.tagView = (TextView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.f123897hw);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.\u2026.wink_next_btn_blur_view)");
            this.nextBtnBlurView = (QQBlurViewWrapper) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.f123877hu);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.wink_next_btn)");
            this.nextTextBtn = (TextView) findViewById8;
            View findViewById9 = itemView.findViewById(R.id.f123907hx);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.\u2026.wink_next_btn_container)");
            this.nextBtnClickArea = findViewById9;
            View findViewById10 = itemView.findViewById(R.id.f123887hv);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.\u2026_next_btn_animation_view)");
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById10;
            this.nextBtnAnimView = lottieAnimationView;
            lottieAnimationView.setAnimationFromUrl("https://downv6.qq.com/shadow_qqcamera/magicstudio/qzone_magicstudio_btn_lottie_animation.zip", Md5Utils.getMD5("https://downv6.qq.com/shadow_qqcamera/magicstudio/qzone_magicstudio_btn_lottie_animation.zip"));
            v();
            u();
        }

        private final void C(View btn) {
            Map<String, ?> mutableMapOf;
            Pair[] pairArr = new Pair[2];
            MetaMaterial metaMaterial = this.template;
            MetaMaterial metaMaterial2 = null;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            pairArr[0] = TuplesKt.to("material_id", metaMaterial.f30533id);
            MetaMaterial metaMaterial3 = this.template;
            if (metaMaterial3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial3 = null;
            }
            pairArr[1] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, com.tencent.mobileqq.wink.editor.c.p(metaMaterial3));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            MetaMaterial metaMaterial4 = this.template;
            if (metaMaterial4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
            } else {
                metaMaterial2 = metaMaterial4;
            }
            eVar.l(btn, WinkDaTongReportConstant.ElementId.EM_QZ_START_MAKING_BUTTONS, mutableMapOf, metaMaterial2.f30533id);
        }

        private final void D(View btn) {
            Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            MetaMaterial metaMaterial = this.template;
            MetaMaterial metaMaterial2 = null;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            params.put("material_id", metaMaterial.f30533id);
            MetaMaterial metaMaterial3 = this.template;
            if (metaMaterial3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial3 = null;
            }
            params.put(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, com.tencent.mobileqq.wink.editor.c.p(metaMaterial3));
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_MODEL_DETAIL);
            params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_START_MAKING_BUTTONS);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            MetaMaterial metaMaterial4 = this.template;
            if (metaMaterial4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
            } else {
                metaMaterial2 = metaMaterial4;
            }
            eVar.e(btn, WinkDaTongReportConstant.ElementId.EM_QZ_START_MAKING_BUTTONS, params, metaMaterial2.f30533id);
        }

        private final void E() {
            BaseVideoView baseVideoView = this.videoView;
            BaseVideoView baseVideoView2 = null;
            if (baseVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView = null;
            }
            baseVideoView.seekTo(0);
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView2 = baseVideoView3;
            }
            baseVideoView2.pause();
        }

        private final void H() {
            this.cardView.setOnClickListener(new View.OnClickListener() { // from class: s93.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.b.I(c.b.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MetaMaterial metaMaterial = this$0.template;
            BaseVideoView baseVideoView = null;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            if (!com.tencent.mobileqq.wink.editor.c.b1(metaMaterial)) {
                BaseVideoView baseVideoView2 = this$0.videoView;
                if (baseVideoView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    baseVideoView2 = null;
                }
                if (baseVideoView2.isPlaying()) {
                    BaseVideoView baseVideoView3 = this$0.videoView;
                    if (baseVideoView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    } else {
                        baseVideoView = baseVideoView3;
                    }
                    baseVideoView.pause();
                } else {
                    BaseVideoView baseVideoView4 = this$0.videoView;
                    if (baseVideoView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    } else {
                        baseVideoView = baseVideoView4;
                    }
                    baseVideoView.play();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public static /* synthetic */ void K(b bVar, boolean z16, boolean z17, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z17 = true;
            }
            bVar.J(z16, z17);
        }

        private final void o() {
            ViewGroup.LayoutParams layoutParams = this.cardView.getLayoutParams();
            Pair<Integer, Integer> x16 = x();
            layoutParams.width = x16.getFirst().intValue();
            layoutParams.height = x16.getSecond().intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(c this$0, b this$1, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Function1 function1 = this$0.onItemClick;
            MetaMaterial metaMaterial = this$1.template;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            function1.invoke(metaMaterial);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$1.C(it);
            EventCollector.getInstance().onViewClicked(it);
        }

        private final void r() {
            try {
                BaseVideoView baseVideoView = this.videoView;
                MetaMaterial metaMaterial = null;
                if (baseVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    baseVideoView = null;
                }
                MetaMaterial metaMaterial2 = this.template;
                if (metaMaterial2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                } else {
                    metaMaterial = metaMaterial2;
                }
                baseVideoView.setCoverDrawable(URLDrawable.getDrawable(com.tencent.mobileqq.wink.editor.c.s0(metaMaterial), ViewUtilsKt.d()));
            } catch (Exception e16) {
                w53.b.h("WinkQZoneTemplateLibDetailListAdapter", "[bindCover] exception", e16);
            }
        }

        private final void s() {
            MetaMaterial metaMaterial = this.template;
            BaseVideoView baseVideoView = null;
            MetaMaterial metaMaterial2 = null;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            if (HttpUtil.isValidUrl(com.tencent.mobileqq.wink.editor.c.S0(metaMaterial))) {
                BaseVideoView baseVideoView2 = this.videoView;
                if (baseVideoView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    baseVideoView2 = null;
                }
                MetaMaterial metaMaterial3 = this.template;
                if (metaMaterial3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                } else {
                    metaMaterial2 = metaMaterial3;
                }
                baseVideoView2.setVideoParam(t(com.tencent.mobileqq.wink.editor.c.S0(metaMaterial2)));
                return;
            }
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView = baseVideoView3;
            }
            baseVideoView.setVideoParam(t(""));
            E();
        }

        private final VideoPlayParam t(String url) {
            VideoPlayParam videoPlayParam = new VideoPlayParam();
            videoPlayParam.mUrls = new String[]{url};
            videoPlayParam.mVideoFormat = 101;
            videoPlayParam.mIsLocal = false;
            videoPlayParam.mIsLoop = true;
            videoPlayParam.mNeedPlayProgress = true;
            videoPlayParam.mSceneId = 163;
            return videoPlayParam;
        }

        private final void u() {
            float f16;
            com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c cVar = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a;
            boolean b16 = cVar.b();
            if (cVar.b()) {
                f16 = ViewUtils.dpToPx(20.0f);
            } else {
                f16 = 0.0f;
            }
            f.a aVar = new f.a(b16, f16, this.videoContainer, 0, new ColorDrawable(0), Integer.valueOf(R.drawable.m5v));
            aVar.l(true);
            this.nextBtnBlurView.a(aVar);
            this.nextBtnBlurView.setEnableBlur(cVar.b());
        }

        private final void v() {
            BaseVideoView baseVideoView = null;
            IBaseVideoView createBaseVideoViewFS = QQVideoViewFactory.createBaseVideoViewFS(this.itemView.getContext(), 153L, null, null);
            if (createBaseVideoViewFS instanceof BaseVideoView) {
                BaseVideoView baseVideoView2 = (BaseVideoView) createBaseVideoViewFS;
                this.videoView = baseVideoView2;
                c cVar = this.R;
                if (baseVideoView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    baseVideoView2 = null;
                }
                cVar.n0(baseVideoView2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                FrameLayout frameLayout = this.videoContainer;
                BaseVideoView baseVideoView3 = this.videoView;
                if (baseVideoView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                } else {
                    baseVideoView = baseVideoView3;
                }
                frameLayout.addView(baseVideoView, layoutParams);
            }
        }

        private final Pair<Integer, Integer> x() {
            int screenHeight = (int) (ViewUtils.getScreenHeight() * 0.8f);
            int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(44.0f);
            if (screenWidth > c.G) {
                screenWidth = c.G;
            }
            int i3 = (int) (screenWidth * 1.77f);
            if (i3 > screenHeight) {
                screenWidth = (int) (screenHeight / 1.77f);
            } else {
                screenHeight = i3;
            }
            MetaMaterial metaMaterial = this.template;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            if (com.tencent.mobileqq.wink.editor.c.b1(metaMaterial)) {
                screenHeight = (int) ((screenHeight * 1.33f) / 1.77f);
            }
            return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(screenHeight));
        }

        public final void A() {
            if (com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.b()) {
                this.nextBtnAnimView.playAnimation();
            }
        }

        public final void B() {
            BaseVideoView baseVideoView = this.videoView;
            if (baseVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView = null;
            }
            baseVideoView.play();
        }

        public final void J(boolean show, boolean needAnimate) {
            int i3;
            long j3;
            float f16 = 0.0f;
            float f17 = 1.0f;
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
                f17 = 0.0f;
                f16 = 1.0f;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nextBtnClickArea, com.tencent.luggage.wxa.c8.c.f123400v, f16, f17);
            if (needAnimate) {
                j3 = 200;
            } else {
                j3 = 0;
            }
            ofFloat.setDuration(j3);
            ofFloat.start();
            ofFloat.addListener(new a(i3));
        }

        public final void p(int position) {
            boolean z16;
            List split$default;
            Object firstOrNull;
            int i3;
            this.template = (MetaMaterial) this.R.templateList.get(position);
            o();
            TextView textView = this.templateNameView;
            MetaMaterial metaMaterial = this.template;
            MetaMaterial metaMaterial2 = null;
            if (metaMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial = null;
            }
            textView.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            TextView textView2 = this.usageCountView;
            com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c cVar = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a;
            MetaMaterial metaMaterial3 = this.template;
            if (metaMaterial3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial3 = null;
            }
            textView2.setText(cVar.i(Integer.valueOf(metaMaterial3.usageCnt)));
            TextView textView3 = this.describeView;
            MetaMaterial metaMaterial4 = this.template;
            if (metaMaterial4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial4 = null;
            }
            textView3.setText(com.tencent.mobileqq.wink.editor.c.O(metaMaterial4));
            TextView textView4 = this.nextTextBtn;
            MetaMaterial metaMaterial5 = this.template;
            if (metaMaterial5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                metaMaterial5 = null;
            }
            String Q = com.tencent.mobileqq.wink.editor.c.Q(metaMaterial5);
            if (Q.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Q = HardCodeUtil.qqStr(R.string.f240877qc);
            }
            textView4.setText(Q);
            TextView textView5 = this.tagView;
            MetaMaterial metaMaterial6 = this.template;
            if (metaMaterial6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
            } else {
                metaMaterial2 = metaMaterial6;
            }
            split$default = StringsKt__StringsKt.split$default((CharSequence) com.tencent.mobileqq.wink.editor.c.B0(metaMaterial2), new String[]{"\uff5c"}, false, 0, 6, (Object) null);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) split$default);
            String str = (String) firstOrNull;
            if (str == null) {
                str = "";
            }
            textView5.setText(str);
            LottieAnimationView lottieAnimationView = this.nextBtnAnimView;
            if (cVar.b()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            lottieAnimationView.setVisibility(i3);
            r();
            s();
            if (this.R.selectedPosition == position) {
                B();
                A();
            } else {
                J(false, false);
                y();
            }
            H();
            View view = this.nextBtnClickArea;
            final c cVar2 = this.R;
            view.setOnClickListener(new View.OnClickListener() { // from class: s93.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.q(c.this, this, view2);
                }
            });
            D(this.nextTextBtn);
        }

        public final boolean w() {
            BaseVideoView baseVideoView = this.videoView;
            if (baseVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView = null;
            }
            return baseVideoView.isPlaying();
        }

        public final void y() {
            if (com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.b()) {
                this.nextBtnAnimView.pauseAnimation();
            }
        }

        public final void z() {
            BaseVideoView baseVideoView = this.videoView;
            if (baseVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView = null;
            }
            baseVideoView.pause();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull List<MetaMaterial> templateList, @NotNull Function1<? super MetaMaterial, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(templateList, "templateList");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.templateList = templateList;
        this.onItemClick = onItemClick;
        this.videoViewsRefList = new LinkedHashSet();
        this.selectedPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(BaseVideoView videoView) {
        boolean z16;
        Set<WeakReference<BaseVideoView>> set = this.videoViewsRefList;
        boolean z17 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((WeakReference) it.next()).get() == videoView) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        if (!z17) {
            this.videoViewsRefList.add(new WeakReference<>(videoView));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.templateList.size();
    }

    public final void o0(int position) {
        if (position == this.selectedPosition) {
            return;
        }
        this.selectedPosition = position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            ((b) holder).p(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i7m, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(this, itemView);
    }

    public final void release() {
        Iterator<T> it = this.videoViewsRefList.iterator();
        while (it.hasNext()) {
            BaseVideoView baseVideoView = (BaseVideoView) ((WeakReference) it.next()).get();
            if (baseVideoView != null) {
                baseVideoView.releasePlayer(false);
            }
        }
        this.videoViewsRefList.clear();
    }
}
