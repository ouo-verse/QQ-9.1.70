package ye0;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private String f450218a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetMainPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f450219a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f450219a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
            OnPreLoadListener onPreLoadListener = this.f450219a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, certifiedAccountRead$StGetMainPageRsp);
            }
        }
    }

    public b(String str) {
        this.f450218a = str;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        SubscribePersonalDetailRequest subscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.f450218a, null);
        a aVar = new a(onPreLoadListener);
        subscribePersonalDetailRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(subscribePersonalDetailRequest, aVar);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
