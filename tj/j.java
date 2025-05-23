package tj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Ltj/j;", "Lcom/qzone/reborn/albumx/common/layer/part/c;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "i", "Landroid/view/View;", "mHeaderView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mPageTitlePageIndicator", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j extends com.qzone.reborn.albumx.common.layer.part.c<QZIntimateLayerExtraInfoBean> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mHeaderView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mPageTitlePageIndicator;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            this$0.getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cfm, (ViewGroup) null);
        this.mHeaderView = inflate;
        Intrinsics.checkNotNull(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.nm5);
        this.mPageTitlePageIndicator = textView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        View view = this.mHeaderView;
        Intrinsics.checkNotNull(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.n0j);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tj.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                j.F9(j.this, view2);
            }
        });
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.mHeaderView, layoutParams);
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (x9() == null) {
            TextView textView = this.mPageTitlePageIndicator;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        View view = this.mHeaderView;
        if (view != null) {
            view.setVisibility(0);
        }
        if (C9(layerState) == 1) {
            TextView textView2 = this.mPageTitlePageIndicator;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
            return;
        }
        String str = B9(layerState) + "/" + C9(layerState);
        TextView textView3 = this.mPageTitlePageIndicator;
        if (textView3 != null) {
            textView3.setText(str);
        }
        TextView textView4 = this.mPageTitlePageIndicator;
        if (textView4 == null) {
            return;
        }
        textView4.setVisibility(0);
    }
}
