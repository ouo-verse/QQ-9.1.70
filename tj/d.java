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
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Ltj/d;", "Lcom/qzone/reborn/albumx/common/layer/part/c;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "", "G9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "onLayerStateUpdate", "i", "Landroid/view/View;", "headerView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "nameTv", BdhLogUtil.LogTag.Tag_Conn, "indicatorTv", "D", "contentContainer", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends com.qzone.reborn.albumx.common.layer.part.c<QZIntimateLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView indicatorTv;

    /* renamed from: D, reason: from kotlin metadata */
    private View contentContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView nameTv;

    private final String F9(RFWLayerState layerState) {
        return "(" + B9(layerState) + "/" + C9(layerState) + ")";
    }

    private final String G9() {
        String albumName;
        QZIntimateLayerExtraInfoBean x95 = x9();
        return (x95 == null || (albumName = x95.getAlbumName()) == null) ? "" : albumName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(d this$0, View view) {
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
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.f167295cj4, (ViewGroup) null);
        this.headerView = inflate;
        this.nameTv = inflate != null ? (TextView) inflate.findViewById(R.id.n3q) : null;
        View view = this.headerView;
        this.contentContainer = view != null ? view.findViewById(R.id.mnc) : null;
        View view2 = this.headerView;
        this.indicatorTv = view2 != null ? (TextView) view2.findViewById(R.id.n3p) : null;
        TextView textView = this.nameTv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.headerView, layoutParams);
        View view3 = this.headerView;
        View findViewById = view3 != null ? view3.findViewById(R.id.n3o) : null;
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tj.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                d.H9(d.this, view4);
            }
        });
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (x9() == null) {
            View view = this.contentContainer;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        View view2 = this.headerView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.contentContainer;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        TextView textView = this.nameTv;
        if (textView != null) {
            textView.setText(G9());
        }
        TextView textView2 = this.indicatorTv;
        if (textView2 == null) {
            return;
        }
        textView2.setText(F9(layerState));
    }
}
