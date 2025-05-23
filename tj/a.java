package tj;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u0015"}, d2 = {"Ltj/a;", "Ltj/e;", "Landroid/os/Bundle;", "data", "", "initIntentData", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "U9", "Lsj/c;", "da", "Lq9/a;", "Lsj/b;", "L9", "preLayerState", "newLayerState", "H9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<sj.b> L9() {
        ViewModel viewModel = getViewModel(wj.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateA\u2026ataViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected boolean U9() {
        return true;
    }

    @Override // tj.e
    protected sj.c da() {
        String str;
        sj.c cVar = new sj.c();
        QZIntimateLayerExtraInfoBean x95 = x9();
        cVar.k(x95 != null ? x95.getBatchId() : 0L);
        cVar.s(ca().getSpaceId());
        QZIntimateLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str = x96.getAlbumId()) == null) {
            str = "";
        }
        cVar.j(str);
        cVar.o(ca().getLeftAttachInfo());
        cVar.r(ca().getRightAttachInfo());
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tj.e, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data != null) {
            wj.a aVar = (wj.a) getViewModel(wj.a.class);
            if (data.containsKey("key_album_detail_init_bean")) {
                Object obj = data.get("key_album_detail_init_bean");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean");
                aVar.h2((QZoneIntimateAlbumDetailInitBean) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        vj.c dataRepo = ((wj.a) getViewModel(wj.a.class)).getDataRepo();
        if (dataRepo == null) {
            return;
        }
        dataRepo.B(x9());
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void H9(RFWLayerState preLayerState, RFWLayerState newLayerState) {
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        if (preLayerState.getSelectedPosition() > 0) {
            newLayerState.setSelectedPosition(preLayerState.getSelectedPosition() - 1);
        } else {
            newLayerState.setSelectedPosition(0);
        }
    }
}
