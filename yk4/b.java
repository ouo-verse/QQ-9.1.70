package yk4;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveGetArkInfoRequest;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(zi4.a aVar, QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            AegisLogger.d("Share|ShareArkJsonModel", "getShareJson", "success, " + ((nq4.b) qQLiveResponse.getRsp()).f420728a);
            aVar.success((nq4.b) qQLiveResponse.getRsp());
            return;
        }
        AegisLogger.e("Share|ShareArkJsonModel", "getShareJson", "failed, retCode=" + qQLiveResponse.getRetCode() + ", msg=" + qQLiveResponse.getErrMsg());
        aVar.fail((int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg());
    }

    public void b(String str, final zi4.a<nq4.b> aVar) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetArkInfoRequest(str), new ILiveNetRequest.Callback() { // from class: yk4.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                b.c(zi4.a.this, qQLiveResponse);
            }
        });
    }
}
