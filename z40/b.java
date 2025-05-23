package z40;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSPersonalProductLayerViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import j30.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import u30.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSLayerBaseMiddleListPart implements j30.c {

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f451878d;

    /* renamed from: e, reason: collision with root package name */
    private IDataDisplaySurface<e30.b> f451879e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f451880f = true;

    /* renamed from: h, reason: collision with root package name */
    private List<j30.b> f451881h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, e30.b> f451882i;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            if (b.this.f451878d != null && b.this.f451878d.getTransInitBean() != null && b.this.f451878d.getTransInitBean().getExtraTypeInfo() != null && ((QFSLayerBasePart) b.this).mLayerPageAdapter != null && ((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList() != null && !((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList().isEmpty() && ((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList().size() > i3 && i3 > -1 && ((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList().get(i3).g() != null) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFeedPosSyncEvent(b.this.f451878d.getPageCode(), i3, ((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList().get(i3).g().f398449id.get()).setCoverUrl(((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList().get(i3).g().cover.picUrl.get()).setIsVertical(!gb0.b.z(((QFSLayerBasePart) b.this).mLayerPageAdapter.getDataList().get(i3).g())));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: z40.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C11650b extends RecyclerView.AdapterDataObserver {
        C11650b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            super.onItemRangeRemoved(i3, i16);
            b.this.checkEmptyContentOperation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Observer<UIStateData<List<e30.b>>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<e30.b>> uIStateData) {
            UIStateData da5 = b.this.da(uIStateData);
            if (da5 == null) {
                QLog.e(b.this.getTAG(), 1, "filterUiStateData == null");
                return;
            }
            if (da5.getData() != null) {
                da5.setDataList(b.this.la((List) da5.getData(), 0, ((List) da5.getData()).size(), b.this.f451882i));
            }
            if (b.this.f451880f) {
                da5.setState(2);
                b.this.ea(da5);
            } else {
                da5.setPos(-1);
            }
            QLog.d(b.this.getTAG(), 1, "listUIStateData's selected position : " + da5.getPos());
            b.this.Z9(da5);
            b.this.f451880f = false;
        }
    }

    public b(QCircleLayerBean qCircleLayerBean) {
        this.f451878d = qCircleLayerBean;
    }

    private int ba(List<e30.b> list) {
        if (this.f451878d != null && list != null && list.size() != 0) {
            if (list.size() > this.f451878d.getDataPosInList() && TextUtils.equals(this.f451878d.getFeed().f398449id.get(), list.get(this.f451878d.getDataPosInList()).g().f398449id.get())) {
                QLog.i(getTAG(), 1, "checkFindRealPosition return mInitBean.getFeedPosition() = " + this.f451878d.getDataPosInList());
                return this.f451878d.getDataPosInList();
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                e30.b bVar = list.get(i3);
                if (TextUtils.equals(bVar.g().f398449id.get(), this.f451878d.getFeed().f398449id.get())) {
                    QLog.i(getTAG(), 1, "checkFindRealPosition return position = " + i3 + " , feedId = " + bVar.g().f398449id.get());
                    return i3;
                }
            }
            QLog.i(getTAG(), 1, "checkFindRealPosition return default position = 0");
            return 0;
        }
        QLog.e(getTAG(), 1, "checkFindRealPosition return unusual position = -1 UIStateData dataList is null");
        return -1;
    }

    private void ca(QCircleFeedEvent qCircleFeedEvent) {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && !RFSafeListUtils.isEmpty(mVar.getDataList())) {
            ArrayList arrayList = new ArrayList(this.mLayerPageAdapter.getDataList());
            String str = qCircleFeedEvent.mTargetId;
            Iterator it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                e30.b bVar = (e30.b) it.next();
                if (bVar != null && TextUtils.equals(str, bVar.g().f398449id.get())) {
                    it.remove();
                    z16 = true;
                }
            }
            HashMap<String, e30.b> hashMap = this.f451882i;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.mLayerPageAdapter.setDatas(arrayList);
            QLog.d(getTAG(), 1, "deleteFeedById removeFeed end result: ", Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UIStateData<List<e30.b>> da(UIStateData<List<e30.b>> uIStateData) {
        try {
            if (uIStateData.getData() != null && uIStateData.getData().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = new CopyOnWriteArrayList(uIStateData.getData()).iterator();
                while (it.hasNext()) {
                    e30.b bVar = (e30.b) it.next();
                    if (!TextUtils.isEmpty(bVar.g().f398449id.get())) {
                        arrayList.add(bVar);
                    }
                }
                UIStateData<List<e30.b>> copy = uIStateData.copy();
                copy.setDataList(arrayList);
                return copy;
            }
            return uIStateData;
        } catch (Exception unused) {
            QLog.d(getTAG(), 2, "error to filter ditto id");
            return uIStateData;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData != null && uIStateData.getData() != null) {
            int ba5 = ba(uIStateData.getData());
            if (ba5 >= 0 && uIStateData.getData().size() > ba5) {
                uIStateData.setPos(ba5);
                QLog.i(getTAG(), 1, "firstEnterSelectPosition  position == " + ba5);
                return;
            }
            QLog.i(getTAG(), 1, "firstEnterSelectPosition return, list.size = " + uIStateData.getData().size() + " , position = " + ba5);
        }
    }

    private e30.b ga(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        e30.b p16 = new e30.b(feedCloudMeta$StFeed).p();
        if (i3 == 1) {
            p16.o("feed_source", "personal_layer");
        }
        return p16;
    }

    private void ia(QCircleFeedEvent qCircleFeedEvent) {
        int i3 = qCircleFeedEvent.mState;
        if (i3 == 3) {
            ca(qCircleFeedEvent);
        } else if (i3 == 8 && !TextUtils.isEmpty(qCircleFeedEvent.mTargetId)) {
            ha();
        }
    }

    private IDataDisplaySurface<e30.b> ja() {
        String str;
        QCircleLayerBean qCircleLayerBean = this.f451878d;
        if (qCircleLayerBean != null && qCircleLayerBean.getGlobalViewModelKey() != null) {
            if (this.f451878d.getGlobalViewModelKey().equals("key_personal_detail_source")) {
                QFSPersonalProductLayerViewModel qFSPersonalProductLayerViewModel = (QFSPersonalProductLayerViewModel) getViewModel(QFSPersonalProductLayerViewModel.class);
                if (this.f451878d.getFeed() == null) {
                    str = "";
                } else {
                    str = this.f451878d.getFeed().poster.f398463id.get();
                }
                QLog.d(getTAG(), 1, "initViewModel by default personal detail source" + str);
                qFSPersonalProductLayerViewModel.N1(new ArrayList(), str, "");
                w20.a.j().registerDisplaySurface(this.f451878d.getGlobalViewModelKey(), qFSPersonalProductLayerViewModel);
            }
            IDataDisplaySurface<e30.b> displaySurface = w20.a.j().getDisplaySurface(e30.b.class, this.f451878d.getGlobalViewModelKey());
            this.f451879e = displaySurface;
            if (displaySurface != null && displaySurface.getDisplaySurfaceData(this.f451878d.getTransInitBean(), this.f451878d) != null) {
                this.f451879e.getDisplaySurfaceData(this.f451878d.getTransInitBean(), this.f451878d).observe(getHostFragment(), new c());
                return this.f451879e;
            }
            QLog.e(getTAG(), 1, "initViewModel  params error. mDataDisplaySurface or data == null");
            return null;
        }
        QLog.e(getTAG(), 1, "initViewModel  viewModelKey == null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e30.b> la(List<e30.b> list, int i3, int i16, Map<String, e30.b> map) {
        if (list != null && i3 >= 0 && i3 < list.size() && map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            ListIterator listIterator = arrayList.listIterator(i3);
            if (map.containsKey("0")) {
                listIterator.add(map.get("0"));
                i16++;
            }
            while (listIterator.hasNext() && i3 <= i16) {
                e30.b bVar = (e30.b) listIterator.next();
                e30.b bVar2 = map.get(bVar.g().f398449id.get());
                if (bVar2 != null) {
                    QLog.d(getTAG(), 1, "[insertFeedData] insertFeedData after feed ", bVar.g().f398449id.get());
                    listIterator.add(bVar2);
                    i16++;
                }
                i3++;
            }
            return arrayList;
        }
        return list;
    }

    private void ma(int i3) {
        if (i3 == -1) {
            QLog.d(getTAG(), 1, "setCurrentItem  position == -1");
            return;
        }
        this.mCurrentFeedPos = i3;
        QLog.d(getTAG(), 1, "[setCurrentItem] position: " + i3);
        if (this.mLayerPageContainer.B().getCurrentItem() != i3) {
            this.mLayerPageContainer.B().setCurrentItem(i3, false);
        } else {
            notifyCurrentFeedChange(i3);
        }
    }

    @Override // j30.c
    public void K7(int i3, int i16, Map<String, FeedCloudMeta$StFeed> map, int i17) {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null && i3 >= 0 && i3 <= this.mLayerPageAdapter.getDataList().size()) {
            if (this.f451882i == null) {
                this.f451882i = new HashMap<>();
            }
            for (Map.Entry<String, FeedCloudMeta$StFeed> entry : map.entrySet()) {
                if (!entry.getKey().equals("0")) {
                    this.f451882i.put(entry.getKey(), ga(entry.getValue(), i17));
                } else if (i3 == 0) {
                    this.f451882i.put("0", ga(entry.getValue(), i17));
                } else {
                    List<String> o26 = o2(i3 - 1, i3);
                    if (o26 != null && o26.size() > 0) {
                        this.f451882i.put(o26.get(0), ga(entry.getValue(), i17));
                    }
                }
            }
            QLog.d(getTAG(), 1, "[insertFeedData] insertFeedData start, outputData size ", Integer.valueOf(map.size()));
            QCircleLayerBean qCircleLayerBean = this.f451878d;
            if (qCircleLayerBean == null || qCircleLayerBean.getTransInitBean() == null) {
                QLog.d(getTAG(), 1, "[insertFeedData] mInitBean or mInitBean.getTransInitBean() == null");
                return;
            }
            UIStateData<List<e30.b>> value = this.f451879e.getDisplaySurfaceData(this.f451878d.getTransInitBean()).getValue();
            if (value != null) {
                List<e30.b> data = value.getData();
                if (data == null) {
                    QLog.d(getTAG(), 1, "[insertFeedData] originalFeedList == null");
                    return;
                } else {
                    this.mLayerPageAdapter.submitList(la(data, 0, data.size(), this.f451882i));
                    return;
                }
            }
            return;
        }
        QLog.d(getTAG(), 1, "[insertFeedData] insertFeedData is fail");
    }

    @Override // j30.c
    public boolean L4() {
        QCircleLayerBean qCircleLayerBean = this.f451878d;
        if (qCircleLayerBean != null) {
            Serializable businessData = qCircleLayerBean.getBusinessData("isOpenShareAd");
            if (businessData instanceof Boolean) {
                return ((Boolean) businessData).booleanValue();
            }
            return false;
        }
        return false;
    }

    @Override // j30.c
    public void M4() {
        j.f90213a.O(getInitBean(), getReportBean());
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected MutableLiveData<UIStateData<List<e30.b>>> getDisplayFeedControl() {
        QCircleLayerBean qCircleLayerBean;
        IDataDisplaySurface<e30.b> iDataDisplaySurface = this.f451879e;
        if (iDataDisplaySurface != null && (qCircleLayerBean = this.f451878d) != null) {
            return iDataDisplaySurface.getDisplaySurfaceData(qCircleLayerBean.getTransInitBean(), this.f451878d);
        }
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCircleFeedEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f451878d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerDataShareListPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public String getViewModelKey() {
        QCircleLayerBean qCircleLayerBean = this.f451878d;
        if (qCircleLayerBean != null) {
            return qCircleLayerBean.getGlobalViewModelKey();
        }
        return super.getViewModelKey();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return ja();
    }

    void ha() {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && !RFSafeListUtils.isEmpty(mVar.getDataList())) {
            ArrayList arrayList = new ArrayList(this.mLayerPageAdapter.getDataList());
            Iterator it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                e30.b bVar = (e30.b) it.next();
                if (bVar != null && bVar.g().feedType.get() == 4) {
                    it.remove();
                    z16 = true;
                }
            }
            HashMap<String, e30.b> hashMap = this.f451882i;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.mLayerPageAdapter.setDatas(arrayList);
            QLog.d(getTAG(), 1, "deleteAdFeed removeFeed end result: ", Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleEmptyState() {
        super.handleEmptyState();
        QCircleLayerBean qCircleLayerBean = this.f451878d;
        if (qCircleLayerBean != null && qCircleLayerBean.getTransInitBean() != null && this.f451878d.getTransInitBean().getExtraTypeInfo() != null) {
            int i3 = this.f451878d.getTransInitBean().getExtraTypeInfo().sourceType;
            if (i3 == 20101 || i3 == 20105 || i3 == 20106) {
                getActivity().onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleSuccessState(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        boolean z17;
        hideLoadingView();
        QCircleStatusView qCircleStatusView = this.mFaultHintView;
        if (qCircleStatusView == null) {
            return;
        }
        qCircleStatusView.o0();
        this.mLayerPageAdapter.setDatas(uIStateData.getData());
        int pos = uIStateData.getPos();
        ma(pos);
        d.d().n(uIStateData.getData(), pos);
        if (!this.f451880f && uIStateData.getIsLoadMore()) {
            z17 = true;
        } else {
            z17 = false;
        }
        noticeLazyLoadRightPersonalPage(z17);
        QFSEcommercePreloadManager.j().n(getContext(), getPageId(), uIStateData.getData());
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        return true;
    }

    @Override // j30.c
    public List<String> o2(int i3, int i16) {
        List<e30.b> feedList = getFeedList();
        if (feedList != null && i3 >= 0 && i3 < feedList.size()) {
            ArrayList arrayList = new ArrayList();
            for (e30.b bVar : feedList.subList(i3, Math.min(i16, feedList.size()))) {
                if (bVar != null && bVar.g() != null) {
                    arrayList.add(bVar.g().f398449id.get());
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // j30.c
    public FeedCloudMeta$StUser o6() {
        if (getInitBean() != null) {
            return getInitBean().getUser();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.f451879e != null && this.f451878d != null && getHostFragment() != null && this.f451879e.getDisplaySurfaceData(this.f451878d.getTransInitBean()) != null) {
            this.f451879e.getDisplaySurfaceData(this.f451878d.getTransInitBean()).removeObservers(getHostFragment());
        }
        List<j30.b> list = this.f451881h;
        if (list != null) {
            Iterator<j30.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.mLayerPageContainer.setRefreshEnable(false);
        this.mLayerPageContainer.setLoadMoreEnable(true);
        this.mLayerPageContainer.B().registerOnPageChangeCallback(new a());
        this.mLayerPageAdapter.registerAdapterDataObserver(new C11650b());
        this.f451881h = e.a(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            ia((QCircleFeedEvent) simpleBaseEvent);
        }
        super.onReceiveEvent(simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void pageContainerOnPageSelected(int i3) {
        super.pageContainerOnPageSelected(i3);
        List<j30.b> list = this.f451881h;
        if (list != null) {
            Iterator<j30.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        IDataDisplaySurface<e30.b> iDataDisplaySurface;
        if (!z16 || (iDataDisplaySurface = this.f451879e) == null) {
            return;
        }
        iDataDisplaySurface.loadMoreForDisplaySurface(this.f451878d.getTransInitBean(), getContext());
    }
}
