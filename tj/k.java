package tj;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ltj/k;", "Ltj/f;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "bottomOperateLayout", BdhLogUtil.LogTag.Tag_Conn, "descRoot", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "descText", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k extends f<QZIntimateLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private View descRoot;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView descText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View bottomOperateLayout;

    private final void E9() {
        QZIntimateLayerExtraInfoBean x95 = x9();
        if (TextUtils.isEmpty(x95 != null ? x95.getDesc() : null)) {
            View view = this.descRoot;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        TextView textView = this.descText;
        if (textView != null) {
            QZIntimateLayerExtraInfoBean x96 = x9();
            textView.setText(x96 != null ? x96.getDesc() : null);
        }
        View view2 = this.descRoot;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.bottomOperateLayout = rootView.findViewById(R.id.n4f);
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.cjq, (ViewGroup) null);
        this.descRoot = inflate;
        if (this.bottomOperateLayout == null || inflate == null) {
            return;
        }
        Intrinsics.checkNotNull(inflate);
        this.descText = (TextView) inflate.findViewById(R.id.n4n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 83;
        layoutParams.setMarginStart(ImmersiveUtils.dpToPx(16.0f));
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(30.0f);
        fo.c.n(this.descRoot, "em_qz_floating_layer_description");
        ((ViewGroup) rootView).addView(this.descRoot, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }
}
