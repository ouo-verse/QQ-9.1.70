package wj;

import com.qzone.reborn.intimate.request.QZoneIntimateGetLayerListByOneRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetMediasListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lwj/c;", "Lwj/d;", "Lsj/c;", "requestBean", "", "U1", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(c this$0, sj.c requestBean, BaseRequest request, boolean z16, long j3, String errMsg, QZIntimateSpaceAlbum$GetMediasListRsp qZIntimateSpaceAlbum$GetMediasListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.N1("[GetMediasListByOneReq]", z16, request, j3, errMsg, requestBean.getIsFetchRight());
        this$0.T1(z16, j3, errMsg, qZIntimateSpaceAlbum$GetMediasListRsp, requestBean);
    }

    @Override // wj.d
    public void U1(final sj.c requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (getLoadInfo().getCurrentState() != 4) {
            RFWLog.e(getTAG(), RFWLog.USR, "GetMediasListByOneReq  mLoadInfo.currentState = " + getLoadInfo().getCurrentState());
            return;
        }
        QZoneIntimateGetLayerListByOneRequest qZoneIntimateGetLayerListByOneRequest = new QZoneIntimateGetLayerListByOneRequest(requestBean);
        b2(requestBean);
        sendRequest(qZoneIntimateGetLayerListByOneRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: wj.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.d2(c.this, requestBean, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$GetMediasListRsp) obj);
            }
        });
    }
}
