package yp2;

import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b> {
    private String C;
    private String D;
    private boolean E;

    /* renamed from: m, reason: collision with root package name */
    private final MediatorLiveData<UIStateData<List<e30.b>>> f450778m = new MediatorLiveData<>();
    private final Collection<String> F = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetSearchPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f450779a;

        a(c cVar) {
            this.f450779a = new WeakReference<>(cVar);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
            int i3;
            c cVar = this.f450779a.get();
            if (cVar == null) {
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
            if (feedCloudRead$StGetSearchPageRsp != null) {
                i3 = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.d("QSearchVideoViewModel", 1, sb5.toString());
            if (!z16 || j3 != 0) {
                cVar.d2(UIStateData.obtainError(str).setRetCode(j3).setData(true, cVar.T1()).setLoadMore(true));
            } else {
                cVar.W1(feedCloudRead$StGetSearchPageRsp);
            }
        }
    }

    private boolean Q1() {
        int i3;
        if (this.f450778m.getValue() != null) {
            i3 = this.f450778m.getValue().getState();
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        QLog.d("QSearchVideoViewModel", 1, hashCode() + "|requestFeed is loading");
        return true;
    }

    private QFSGetSearchPageRequest R1() {
        return new QFSGetSearchPageRequest.a(this.D).h(this.C).a();
    }

    private List<e30.b> S1(Collection<e30.b> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && !collection.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (e30.b bVar : collection) {
                if (!TextUtils.isEmpty(bVar.g().f398449id.get())) {
                    arrayList.add(bVar);
                }
                if (this.F.contains(bVar.g().f398449id.get())) {
                    arrayList2.add(bVar);
                }
            }
            collection.removeAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e30.b> T1() {
        UIStateData<List<e30.b>> value = this.f450778m.getValue();
        if (value == null) {
            return new ArrayList(0);
        }
        return value.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(final FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: yp2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.X1(feedCloudRead$StGetSearchPageRsp);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        a2(feedCloudRead$StGetSearchPageRsp);
        c2(feedCloudRead$StGetSearchPageRsp, b2(feedCloudRead$StGetSearchPageRsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(boolean z16, Collection collection, UIStateData uIStateData) {
        if (this.f450778m.getValue() != null) {
            List<e30.b> data = this.f450778m.getValue().getData();
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
        this.f450778m.setValue(uIStateData);
    }

    private void a2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp == null) {
            return;
        }
        this.C = feedCloudRead$StGetSearchPageRsp.searchFeedInfo.attachInfo.get();
    }

    private static boolean b2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (feedCloudRead$StGetSearchPageRsp == null || feedCloudRead$StGetSearchPageRsp.searchFeedInfo.isOver.get() > 0) {
            return true;
        }
        return false;
    }

    private void c2(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z16) {
        Object obj;
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.get());
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
        QLog.d("QSearchVideoViewModel", 1, sb5.toString());
        List<e30.b> S1 = S1(b16);
        QLog.d("QSearchVideoViewModel", 1, hashCode() + "| filter ditto size:" + S1.size());
        w20.a.j().initOrUpdateGlobalState((List) S1, true);
        e2(UIStateData.obtainSuccess(false).setFinish(z16).setLoadMore(true), true, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(UIStateData<List<e30.b>> uIStateData) {
        this.f450778m.postValue(uIStateData);
    }

    private void e2(final UIStateData<List<e30.b>> uIStateData, final boolean z16, final Collection<e30.b> collection) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: yp2.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.Z1(z16, collection, uIStateData);
            }
        });
    }

    private void g2() {
        if (Q1()) {
            return;
        }
        sendRequest(R1(), new a(this));
    }

    public String U1() {
        return String.valueOf(hashCode());
    }

    public void f2(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            this.F.clear();
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
                    this.F.add(feedCloudMeta$StFeed.f398449id.get());
                }
            }
            ArrayList<e30.b> b16 = e30.d.b(list);
            UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, b16);
            obtainSuccess.setFinish(!this.E);
            this.f450778m.setValue(obtainSuccess);
            if (b16 == null || b16.isEmpty()) {
                QLog.w("QSearchVideoViewModel", 1, "#refreshData: no feedBlockDataList, stFeeds.size=" + list.size());
                return;
            }
            return;
        }
        this.f450778m.setValue(null);
        QLog.i("QSearchVideoViewModel", 2, "#refreshData: empty data");
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        UIStateData<List<e30.b>> value = this.f450778m.getValue();
        if (value == null) {
            QLog.w("QSearchVideoViewModel", 1, "#getDisplaySurfaceData: uiStateData is null");
        } else {
            List<e30.b> data = value.getData();
            if (data == null) {
                QLog.w("QSearchVideoViewModel", 1, "#getDisplaySurfaceData: blockDataList is null");
            } else {
                QLog.d("QSearchVideoViewModel", 1, "#getDisplaySurfaceData: blockDataList size=" + data.size());
            }
        }
        return this.f450778m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QSearchVideoViewModel";
    }

    public void h2(String str) {
        this.D = str;
    }

    public void i2(boolean z16) {
        this.E = z16;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        g2();
    }
}
