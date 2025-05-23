package wl;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.g;
import tl.h;
import yl.b;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lwl/a;", "Ltl/g;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "imagePath", "", "ha", "Lyl/b;", "G", "Lyl/b;", "getParams", "()Lyl/b;", "params", "Ltl/h;", "H", "Ltl/h;", "mediaPickViewModel", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateWriteMoodInitBean;", "I", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateWriteMoodInitBean;", "initBean", "<init>", "(Lyl/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends g {

    /* renamed from: G, reason: from kotlin metadata */
    private final b params;

    /* renamed from: H, reason: from kotlin metadata */
    private h mediaPickViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private QZoneIntimateWriteMoodInitBean initBean;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tl.g
    public boolean ha(String imagePath) {
        if (TextUtils.isEmpty(imagePath)) {
            return true;
        }
        QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = this.initBean;
        if (qZoneIntimateWriteMoodInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZoneIntimateWriteMoodInitBean = null;
        }
        Iterator<String> it = qZoneIntimateWriteMoodInitBean.getFilePathList().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(imagePath, it.next())) {
                return false;
            }
        }
        return super.ha(imagePath);
    }

    @Override // tl.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneMediaPickViewModel::class.java)");
        this.mediaPickViewModel = (h) viewModel;
        Intent intent = getActivity().getIntent();
        h hVar = null;
        if ((intent != null ? intent.getSerializableExtra("key_bundle_common_init_bean") : null) instanceof QZoneIntimateWriteMoodInitBean) {
            Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean");
            QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = (QZoneIntimateWriteMoodInitBean) serializableExtra;
            this.initBean = qZoneIntimateWriteMoodInitBean;
            if (qZoneIntimateWriteMoodInitBean == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
                qZoneIntimateWriteMoodInitBean = null;
            }
            ArrayList<String> filePathList = qZoneIntimateWriteMoodInitBean.getFilePathList();
            DynamicArrayList<String> dynamicArrayList = new DynamicArrayList<>();
            dynamicArrayList.addAll(filePathList);
            h hVar2 = this.mediaPickViewModel;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaPickViewModel");
            } else {
                hVar = hVar2;
            }
            hVar.P1().setValue(dynamicArrayList);
            this.f436499f = dynamicArrayList;
            ja();
        }
    }
}
