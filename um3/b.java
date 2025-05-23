package um3;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.GetAnchorPKHistoryRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.o;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private o f439222a = null;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(o oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(a aVar, QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.e("PK_Biz|PKHistoryDataModel", "requestPKHistory", "error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            aVar.a(null);
            return;
        }
        this.f439222a = (o) qQLiveResponse.getRsp();
        AegisLogger.i("PK_Biz|PKHistoryDataModel", "requestPKHistory, rsp=" + this.f439222a);
        aVar.a(this.f439222a);
    }

    public void d(long j3, String str, final a aVar) {
        if (aVar == null) {
            AegisLogger.i("PK_Biz|PKHistoryDataModel", "requestPKHistory fail, callback=null");
            return;
        }
        AegisLogger.i("PK_Biz|PKHistoryDataModel", "requestPKHistory, roomId=" + j3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetAnchorPKHistoryRequest(j3, str), new ILiveNetRequest.Callback() { // from class: um3.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                b.this.c(aVar, qQLiveResponse);
            }
        });
    }

    public void b() {
    }

    public void e() {
    }
}
