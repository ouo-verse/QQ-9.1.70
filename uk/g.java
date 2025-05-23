package uk;

import com.qzone.reborn.base.n;
import kotlin.Metadata;
import rk.QZoneLayerPicOriginState;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Luk/g;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Lrk/i;", "i", "Lrk/i;", "M1", "()Lrk/i;", "N1", "(Lrk/i;)V", "picOriginState", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneLayerPicOriginState picOriginState;

    /* renamed from: M1, reason: from getter */
    public final QZoneLayerPicOriginState getPicOriginState() {
        return this.picOriginState;
    }

    public final void N1(QZoneLayerPicOriginState qZoneLayerPicOriginState) {
        this.picOriginState = qZoneLayerPicOriginState;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneLayerOriginStateViewModel";
    }
}
