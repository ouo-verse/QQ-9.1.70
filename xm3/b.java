package xm3;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.GetRecommendAnchorsRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.z;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private z f448173a = null;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(z zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(a aVar, QQLiveResponse qQLiveResponse) {
        this.f448173a = (z) qQLiveResponse.getRsp();
        if (qQLiveResponse.isFailed()) {
            AegisLogger.e("PK_Biz|RecommendDataModel", "requestAnchorInfo", "errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            aVar.a(null);
            return;
        }
        AegisLogger.i("PK_Biz|RecommendDataModel", "requestAnchor, rsp=" + this.f448173a);
        aVar.a(this.f448173a);
    }

    public void d(final a aVar) {
        String str;
        if (aVar == null) {
            AegisLogger.i("PK_Biz|RecommendDataModel", "request requestAnchor fail, callback=null");
            return;
        }
        z zVar = this.f448173a;
        if (zVar == null) {
            str = "";
        } else {
            str = zVar.f401406c;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetRecommendAnchorsRequest(str), new ILiveNetRequest.Callback() { // from class: xm3.a
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
