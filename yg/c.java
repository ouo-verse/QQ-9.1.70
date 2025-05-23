package yg;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerApi;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.h;
import com.tencent.mobileqq.cardcontainer.i;
import com.tencent.mobileqq.cardcontainer.j;
import com.tencent.mobileqq.cardcontainer.k;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import cooperation.qzone.QZoneTopGestureLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends vg.a {
    i F = null;
    yg.a G = new yg.a();
    private final j H = new b();
    com.tencent.mobileqq.pymk.api.a I = new C11613c();

    /* compiled from: P */
    /* renamed from: yg.c$c, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11613c extends com.tencent.mobileqq.pymk.api.d {
        C11613c() {
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void c(String str) {
            c.this.K(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(boolean z16) {
        QLog.i("QZonePYMKFeedContentPresenter", 1, "disallowIntercept:" + z16);
        QZoneTopGestureLayout.setBackEnabled(z16 ^ true);
        QZoneTopGestureLayout.shouldInterceptEvent(z16 ^ true);
        Activity i3 = i();
        if (i3 instanceof BaseActivity) {
            FrameHelperActivity.ji((BaseActivity) i3).E.requestDisallowInterceptTouchEvent(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            QLog.e("QZonePYMKFeedContentPresenter", 1, "updatePYMKData fail because mFeedData is null");
            return;
        }
        ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
        Iterator<BusinessFeedData> it = recBusinessFeedDatas.iterator();
        while (it.hasNext()) {
            CellRecommItem cellRecommItem = it.next().cellRecommItem;
            if (cellRecommItem == null || ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(cellRecommItem.userInfo.uid, "QZonePYMKFeedContentPresenter") || str.equals(String.valueOf(cellRecommItem.userInfo.uin))) {
                it.remove();
            }
        }
        yg.a aVar = this.G;
        if (aVar != null) {
            aVar.X1(this.f441565h);
        }
        if (recBusinessFeedDatas.isEmpty()) {
            QLog.e("QZonePYMKFeedContentPresenter", 1, "remove pymk item because mFeedData is null");
            this.f441565h.cellNegativeFeedback = null;
            EventCenter.getInstance().post("WriteOperation", 38, this.f441565h.getFeedCommInfo().feedskey);
        }
        QLog.e("QZonePYMKFeedContentPresenter", 1, "updatePYMKData success remove uin:" + str);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        K("");
    }

    @Override // vg.a
    protected void C(View view) {
        QLog.i("QZonePYMKFeedContentPresenter", 1, "onInitView");
        if (this.F == null) {
            BasePartFragment p16 = p();
            if (p16 == null) {
                QLog.i("QZonePYMKFeedContentPresenter", 1, "onInitView fail because fragment is null");
                return;
            }
            this.F = ((ICardContainerApi) QRoute.api(ICardContainerApi.class)).createCardContainerView(this.f441562d.getContext(), p16.getLifecycleOwner(), this.G, this.H, new k() { // from class: yg.b
                @Override // com.tencent.mobileqq.cardcontainer.k
                public final void requestDisallowInterceptTouchEvent(boolean z16) {
                    c.this.J(z16);
                }
            }, new a());
        }
        View view2 = this.F.getView();
        FrameLayout frameLayout = (FrameLayout) view;
        if (frameLayout.indexOfChild(view2) == -1) {
            view2.setId(R.id.n9x);
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(168.0f)));
            frameLayout.addView(view2);
            return;
        }
        view2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZonePYMKFeedContentPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nle;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        QLog.i("QZonePYMKFeedContentPresenter", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeListener(this.I);
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        QLog.i("QZonePYMKFeedContentPresenter", 1, "onViewHolderAttachedToWindow");
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).addListener(this.I);
    }

    @Override // vg.a, vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        QLog.i("QZonePYMKFeedContentPresenter", 1, "onViewHolderDetachedFromWindow");
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeListener(this.I);
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements h {
        a() {
        }

        @Override // com.tencent.mobileqq.cardcontainer.h
        public void a() {
        }

        @Override // com.tencent.mobileqq.cardcontainer.h
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements j {
        b() {
        }

        private void d(String str, String str2, Map<String, ?> map) {
            Map<String, Object> b16 = new fo.a().b();
            if (map != null) {
                b16.putAll(map);
                b16.put("qq_pgid", "pg_bas_social_updates");
                b16.put("qq_eid", str2);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QZonePYMKFeedContentPresenter", 1, "report " + str + " ToDaTong, elementId=" + str2 + ", params=" + b16);
            }
            VideoReport.reportEvent(str, b16);
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void b(String str, Map<String, ?> map) {
            d("qq_imp", str, map);
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void c(String str, Map<String, ?> map) {
            d("qq_clck", str, map);
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void a(ContainerData containerData, int i3, String str) {
        }
    }
}
