package ye0;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private CertifiedAccountMeta$StFeed f450215a;

    /* compiled from: P */
    /* renamed from: ye0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C11607a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetFeedDetailRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f450216a;

        C11607a(OnPreLoadListener onPreLoadListener) {
            this.f450216a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp) {
            OnPreLoadListener onPreLoadListener = this.f450216a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, certifiedAccountRead$StGetFeedDetailRsp);
            }
        }
    }

    public a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.f450215a = certifiedAccountMeta$StFeed;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        GetSubscribeFeedDetailRequest getSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.f450215a, null);
        C11607a c11607a = new C11607a(onPreLoadListener);
        getSubscribeFeedDetailRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(getSubscribeFeedDetailRequest, c11607a);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
