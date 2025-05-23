package wj;

import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vj.c;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lwj/a;", "Lwj/d;", "", "e2", "f2", "Lsj/c;", "requestBean", "U1", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "K", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "d2", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", SemanticAttributes.DbSystemValues.H2, "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;)V", "initBean", "Lvj/c;", "L", "Lvj/c;", "c2", "()Lvj/c;", "g2", "(Lvj/c;)V", "dataRepo", "", "M", "I", "getRightBoundIndex", "()I", "i2", "(I)V", "rightBoundIndex", "<init>", "()V", "N", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends d {

    /* renamed from: K, reason: from kotlin metadata */
    public QZoneIntimateAlbumDetailInitBean initBean;

    /* renamed from: L, reason: from kotlin metadata */
    private vj.c dataRepo;

    /* renamed from: M, reason: from kotlin metadata */
    private int rightBoundIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"wj/a$b", "Lvj/c$b;", "Lsj/a;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements c.b {
        b() {
        }

        @Override // vj.c.b
        public void a(sj.a repoBean) {
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            a.this.i2(repoBean.getRightBoundIndex());
            a.this.M1().postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(repoBean.getErrMsg())).setDataList(repoBean.getLayerListBean()));
        }
    }

    private final void e2() {
        vj.c cVar = this.dataRepo;
        if (cVar != null) {
            cVar.C(d2());
        }
        vj.c cVar2 = this.dataRepo;
        if (cVar2 != null) {
            cVar2.E(this.rightBoundIndex);
        }
        f2();
    }

    private final void f2() {
        ArrayList<c.b> l3;
        b bVar = new b();
        vj.c cVar = this.dataRepo;
        if (cVar == null || (l3 = cVar.l()) == null) {
            return;
        }
        l3.add(bVar);
    }

    @Override // wj.d
    public void U1(sj.c requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (getLoadInfo().getCurrentState() != 4) {
            RFWLog.e(getTAG(), RFWLog.USR, "GetMediasListByOneReq  mLoadInfo.currentState = " + getLoadInfo().getCurrentState());
            return;
        }
        e2();
        vj.c cVar = this.dataRepo;
        if (cVar != null) {
            cVar.w(requestBean);
        }
    }

    /* renamed from: c2, reason: from getter */
    public final vj.c getDataRepo() {
        return this.dataRepo;
    }

    public final QZoneIntimateAlbumDetailInitBean d2() {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = this.initBean;
        if (qZoneIntimateAlbumDetailInitBean != null) {
            return qZoneIntimateAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void g2(vj.c cVar) {
        this.dataRepo = cVar;
    }

    public final void h2(QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean) {
        Intrinsics.checkNotNullParameter(qZoneIntimateAlbumDetailInitBean, "<set-?>");
        this.initBean = qZoneIntimateAlbumDetailInitBean;
    }

    public final void i2(int i3) {
        this.rightBoundIndex = i3;
    }
}
