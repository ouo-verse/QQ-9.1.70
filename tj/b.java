package tj;

import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0014J,\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Ltj/b;", "Ltj/e;", "Lsj/c;", "da", "Lq9/a;", "Lsj/b;", "L9", "", "U9", "layerListBean", "", "ia", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "preLayerState", "newLayerState", "canFindPrePic", "isRefreshByDeleteEvent", "G9", "", "L", "I", "getInitMediaPositionInAlbum", "()I", "setInitMediaPositionInAlbum", "(I)V", "initMediaPositionInAlbum", "M", "getInitMediaPositionInLayerList", "setInitMediaPositionInLayerList", "initMediaPositionInLayerList", "N", "getOffset", "setOffset", "offset", "P", "Z", "isRefresh", "()Z", "setRefresh", "(Z)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends e {

    /* renamed from: L, reason: from kotlin metadata */
    private int initMediaPositionInAlbum;

    /* renamed from: M, reason: from kotlin metadata */
    private int initMediaPositionInLayerList;

    /* renamed from: N, reason: from kotlin metadata */
    private int offset;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isRefresh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<sj.b> L9() {
        ViewModel viewModel = getViewModel(wj.c.class);
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
        String albumId;
        sj.c cVar = new sj.c();
        QZIntimateLayerExtraInfoBean x95 = x9();
        String str2 = "";
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        cVar.p(str);
        cVar.s(ca().getSpaceId());
        QZIntimateLayerExtraInfoBean x96 = x9();
        if (x96 != null && (albumId = x96.getAlbumId()) != null) {
            str2 = albumId;
        }
        cVar.j(str2);
        cVar.o(ca().getLeftAttachInfo());
        cVar.r(ca().getRightAttachInfo());
        return cVar;
    }

    @Override // tj.e
    protected void ia(sj.b layerListBean) {
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
        this.isRefresh = layerListBean.getIsRefresh();
        if (this.initMediaPositionInAlbum == 0) {
            this.initMediaPositionInAlbum = layerListBean.getInitMediaPositionInAlbum();
        }
        if (!this.isRefresh && layerListBean.getIsFetchLeft()) {
            this.initMediaPositionInLayerList += layerListBean.g().size();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void G9(RFWLayerState preLayerState, RFWLayerState newLayerState, boolean canFindPrePic, boolean isRefreshByDeleteEvent) {
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        if (this.isRefresh) {
            this.initMediaPositionInLayerList = newLayerState.getSelectedPosition();
        } else {
            this.offset = newLayerState.getSelectedPosition() - this.initMediaPositionInLayerList;
        }
        newLayerState.setPositionOffset(((this.initMediaPositionInAlbum + this.offset) - newLayerState.getSelectedPosition()) - 1);
    }
}
