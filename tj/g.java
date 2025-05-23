package tj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltj/g;", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "onInitView", "", tl.h.F, "I", "shadowMaskHeight", "i", "Landroid/view/View;", "footerView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends com.qzone.reborn.albumx.common.layer.part.i<QZIntimateLayerExtraInfoBean> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int shadowMaskHeight = 200;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View footerView;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        D9(rootView);
    }

    private final void D9(View rootView) {
        LayoutInflater from = LayoutInflater.from(rootView != null ? rootView.getContext() : null);
        View inflate = from != null ? from.inflate(R.layout.cjp, (ViewGroup) null) : null;
        this.footerView = inflate;
        if (inflate == null) {
            RFWLog.e(getLogTag(), RFWLog.USR, "bottom operate view is null");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ar.d(this.shadowMaskHeight));
        layoutParams.gravity = 80;
        View view = this.footerView;
        Intrinsics.checkNotNull(view);
        view.setClickable(false);
        View view2 = this.footerView;
        Intrinsics.checkNotNull(view2);
        view2.setEnabled(false);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.footerView, layoutParams);
    }
}
