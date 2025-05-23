package vo2;

import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageCommDataRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b> {
    private String C;
    private String D;

    /* renamed from: m, reason: collision with root package name */
    private final MediatorLiveData<UIStateData<List<e30.b>>> f442114m = new MediatorLiveData<>();
    private final Collection<FeedCloudMeta$StFeed> E = new ArrayList(3);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetMainPageCommDataRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<d> f442115a;

        a(d dVar) {
            this.f442115a = new WeakReference<>(dVar);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
            int i3;
            d dVar = this.f442115a.get();
            if (dVar == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode());
            sb5.append("|requestFeedsData onReceive: dispatch Success:");
            sb5.append(z16);
            sb5.append(" | TraceId:");
            sb5.append(baseRequest.getTraceId());
            sb5.append(" | SeqId:");
            sb5.append(baseRequest.getCurrentSeq());
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | size:");
            if (feedCloudRead$StGetMainPageCommDataRsp != null) {
                i3 = feedCloudRead$StGetMainPageCommDataRsp.vecFeed.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            com.tencent.xaction.log.b.a("QCircleSearchUserDataViewModel", 1, sb5.toString());
            if (z16 && j3 == 0) {
                dVar.S1(feedCloudRead$StGetMainPageCommDataRsp);
            } else {
                dVar.b2(UIStateData.obtainError(str).setRetCode(j3).setData(true, dVar.R1()).setLoadMore(true));
            }
        }
    }

    private boolean O1() {
        int i3;
        if (this.f442114m.getValue() != null) {
            i3 = this.f442114m.getValue().getState();
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            com.tencent.xaction.log.b.a("QCircleSearchUserDataViewModel", 1, hashCode() + "|requestFeed is loading");
            return true;
        }
        return TextUtils.isEmpty(this.D);
    }

    private QFSGetMainPageCommDataRequest P1() {
        return new QFSGetMainPageCommDataRequest.b(this.D).h(this.C).k(9).f(this.E).b();
    }

    private static List<e30.b> Q1(Collection<e30.b> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && !collection.isEmpty()) {
            for (e30.b bVar : collection) {
                if (!TextUtils.isEmpty(bVar.g().f398449id.get())) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        X1(feedCloudRead$StGetMainPageCommDataRsp);
        a2(feedCloudRead$StGetMainPageCommDataRsp, Z1(feedCloudRead$StGetMainPageCommDataRsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(UIStateData uIStateData) {
        this.f442114m.setValue(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(boolean z16, Collection collection, UIStateData uIStateData) {
        if (this.f442114m.getValue() != null) {
            List<e30.b> data = this.f442114m.getValue().getData();
            ArrayList arrayList = new ArrayList();
            if (z16 && data != null && !data.isEmpty()) {
                arrayList.addAll(data);
            }
            if (collection != null && !collection.isEmpty()) {
                arrayList.addAll(collection);
            }
            uIStateData.setDataList(arrayList);
            if (collection != null && arrayList.isEmpty()) {
                uIStateData.setState(0);
            }
        }
        this.f442114m.setValue(uIStateData);
    }

    private void X1(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        if (feedCloudRead$StGetMainPageCommDataRsp == null) {
            return;
        }
        this.C = feedCloudRead$StGetMainPageCommDataRsp.feedAttchInfo.get();
    }

    private static boolean Z1(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        if (feedCloudRead$StGetMainPageCommDataRsp == null || feedCloudRead$StGetMainPageCommDataRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    private void a2(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp, boolean z16) {
        Object obj;
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetMainPageCommDataRsp.vecFeed.get());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(hashCode());
        sb5.append("| transForm size:");
        if (b16 != null) {
            obj = Integer.valueOf(b16.size());
        } else {
            obj = "0";
        }
        sb5.append(obj);
        sb5.append(" |isFinish: ");
        sb5.append(z16);
        com.tencent.xaction.log.b.a("QCircleSearchUserDataViewModel", 1, sb5.toString());
        List<e30.b> Q1 = Q1(b16);
        com.tencent.xaction.log.b.a("QCircleSearchUserDataViewModel", 1, hashCode() + "| filter ditto size:" + Q1.size());
        w20.a.j().initOrUpdateGlobalState((List) Q1, true);
        c2(UIStateData.obtainSuccess(false).setFinish(z16).setLoadMore(true), true, b16);
    }

    private void c2(final UIStateData<List<e30.b>> uIStateData, final boolean z16, final Collection<e30.b> collection) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: vo2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.W1(z16, collection, uIStateData);
            }
        });
    }

    private void e2() {
        if (O1()) {
            return;
        }
        sendRequest(P1(), new a(this));
    }

    List<e30.b> R1() {
        UIStateData<List<e30.b>> value = this.f442114m.getValue();
        if (value == null) {
            return new ArrayList(0);
        }
        return value.getData();
    }

    void S1(final FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: vo2.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.T1(feedCloudRead$StGetMainPageCommDataRsp);
            }
        }, 16, null, false);
    }

    void b2(final UIStateData<List<e30.b>> uIStateData) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: vo2.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.U1(uIStateData);
            }
        });
    }

    public void d2(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f442114m.getValue() != null) {
                return;
            }
            this.E.clear();
            this.E.addAll(list);
            this.D = list.get(0).poster.f398463id.get();
            ArrayList<e30.b> b16 = e30.d.b(list);
            UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, b16);
            this.f442114m.setValue(obtainSuccess);
            return;
        }
        this.f442114m.setValue(null);
        com.tencent.xaction.log.b.a("QCircleSearchUserDataViewModel", 2, "#refreshData: empty data");
    }

    public void f2() {
        this.f442114m.setValue(null);
        this.E.clear();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f442114m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QCircleSearchUserDataViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        e2();
    }
}
