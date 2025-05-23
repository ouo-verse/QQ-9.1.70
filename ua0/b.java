package ua0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.adapter.u;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTalentPeopleItemView;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTalentPeopleView;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends RecyclerView.OnScrollListener implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean>, QCircleFeedReportScroller.b {
    private static String F = "QCircleFeedCardReportHelper";
    private int C;
    private QCircleReportBean D;
    private RecyclerView E;

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f438608d;

    /* renamed from: e, reason: collision with root package name */
    private int f438609e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f438610f = false;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<u.a> f438611h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<u.a, Long> f438612i = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private boolean f438613m;

    private void d(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        for (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
            if (!(findViewHolderForLayoutPosition instanceof u.a)) {
                return;
            }
            u.a aVar = (u.a) findViewHolderForLayoutPosition;
            int i3 = 0;
            Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
            findViewByPosition.getGlobalVisibleRect(rect);
            int width = findViewByPosition.getWidth();
            int i16 = rect.right;
            if (i16 > 0) {
                i3 = i16 - rect.left;
            }
            if (i3 / width >= 0.5d) {
                l(aVar);
            }
        }
    }

    private void e(u.a aVar) {
        if (aVar != null) {
            try {
                QFSMixFeedTalentPeopleItemView qFSMixFeedTalentPeopleItemView = aVar.M;
                if (qFSMixFeedTalentPeopleItemView == null) {
                    return;
                }
                int i3 = 0;
                Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
                qFSMixFeedTalentPeopleItemView.getGlobalVisibleRect(rect);
                int width = qFSMixFeedTalentPeopleItemView.getWidth();
                int i16 = rect.right;
                if (i16 > 0) {
                    i3 = i16 - rect.left;
                }
                if (i3 / width >= 0.5d) {
                    l(aVar);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(F, 2, "checkCardExpose exception:", e16);
                }
            }
        }
    }

    private void f(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        for (int i3 = findFirstVisibleItemPosition; i3 <= findLastVisibleItemPosition; i3++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(i3);
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(i3);
            if (!(findViewHolderForLayoutPosition instanceof u.a)) {
                return;
            }
            u.a aVar = (u.a) findViewHolderForLayoutPosition;
            findViewByPosition.getGlobalVisibleRect(new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
            float width = ((r7.right - r7.left) * (r7.bottom - r7.top)) / (findViewByPosition.getWidth() * findViewByPosition.getHeight());
            if (width >= 0.8f && !this.f438612i.keySet().contains(aVar)) {
                this.f438612i.put(aVar, Long.valueOf(System.currentTimeMillis()));
                if (QLog.isColorLevel()) {
                    QLog.d(F, 2, "tpScrollReport checkCardExposeTimeHorizontal addMapList rate = " + width);
                }
            }
        }
        m(false, findFirstVisibleItemPosition, findLastVisibleItemPosition);
    }

    private void g(RecyclerView recyclerView) {
        int i3;
        if (recyclerView != null && (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager)) {
            SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) recyclerView.getLayoutManager();
            int[] findFirstVisibleItemPositions = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            int[] findLastVisibleItemPositions = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
            if (findFirstVisibleItemPositions.length >= 1 && findLastVisibleItemPositions.length >= 1 && (i3 = findFirstVisibleItemPositions[0]) <= findLastVisibleItemPositions[0]) {
                for (i3 = findFirstVisibleItemPositions[0]; i3 <= findLastVisibleItemPositions[0]; i3++) {
                    View findViewByPosition = safeStaggeredGridLayoutManager.findViewByPosition(i3);
                    if (findViewByPosition instanceof QFSMixFeedTalentPeopleView) {
                        RecyclerView m06 = ((QFSMixFeedTalentPeopleView) findViewByPosition).m0();
                        if (m06 == null) {
                            return;
                        }
                        findViewByPosition.getGlobalVisibleRect(new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
                        if ((r6.bottom - r6.top) / findViewByPosition.getHeight() >= 0.8f) {
                            f(m06);
                        } else {
                            m(true, -1, -1);
                        }
                    }
                }
            }
        }
    }

    private void h() {
        if (!this.f438610f) {
            for (int i3 = 0; i3 < this.f438611h.size(); i3++) {
                e(this.f438611h.get(i3));
            }
            this.f438610f = true;
        }
        this.f438611h.clear();
    }

    private void l(u.a aVar) {
        int i3;
        RecyclerView recyclerView = this.E;
        if (recyclerView != null) {
            i3 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        } else {
            i3 = 0;
        }
        QQCircleDitto$StItemInfo l3 = aVar.l();
        if (l3 != null) {
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(c.a(this.f438608d).setToUin(l3.f429300id.get()).setActionType(2).setSubActionType(1).setExt2(String.valueOf((aVar.m() - i3) + 1)).setIndex(this.f438609e).setContainerSeq(aVar.m()).setPageId(this.C)));
        }
    }

    private void m(boolean z16, int i3, int i16) {
        float width;
        Iterator<Map.Entry<u.a, Long>> it = this.f438612i.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<u.a, Long> next = it.next();
            if (z16) {
                RecyclerView recyclerView = this.E;
                width = 0.0f;
                if (recyclerView != null) {
                    i3 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                }
            } else {
                next.getKey().M.getGlobalVisibleRect(new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
                width = ((r3.right - r3.left) * (r3.bottom - r3.top)) / (r2.getWidth() * r2.getHeight());
            }
            if (z16 || next.getKey().m() < i3 || next.getKey().m() > i16 || (next.getKey().m() >= i3 && next.getKey().m() <= i16 && width < 0.8f)) {
                long currentTimeMillis = System.currentTimeMillis() - next.getValue().longValue();
                QQCircleDitto$StItemInfo l3 = next.getKey().l();
                if (l3 != null) {
                    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(c.a(this.f438608d).setToUin(l3.f429300id.get()).setActionType(1).setSubActionType(1).setIndex(this.f438609e).setExt2(String.valueOf((next.getKey().m() - i3) + 1)).setContainerSeq(next.getKey().m()).setPageId(this.C)));
                }
                if (QLog.isColorLevel()) {
                    QLog.d(F, 2, "tpScrollReport reportCardExposeTime  tpPos = " + next.getKey().m() + " , durationTime = " + currentTimeMillis + " , notCompute = " + z16 + " , firstVisiblePos = " + i3);
                }
                it.remove();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.b
    public void a(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        if (Math.abs(i16) < 10) {
            return;
        }
        g(recyclerView);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean getReportBean() {
        return this.D;
    }

    public void j() {
        h();
    }

    public void k(u.a aVar) {
        if (!this.f438610f) {
            this.f438611h.add(aVar);
        }
    }

    public void n(int i3) {
        this.C = i3;
    }

    public void o(RecyclerView recyclerView) {
        this.E = recyclerView;
    }

    @Override // com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.b
    public void onPause() {
        m(true, -1, -1);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.b
    public void onResume() {
        f(this.E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        if (i3 == 0) {
            try {
                d(recyclerView);
                f(recyclerView);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (this.f438613m) {
                QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(c.a(this.f438608d).setActionType(1).setSubActionType(1).setIndex(this.f438609e).setPageId(this.C)));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        super.onScrolled(recyclerView, i3, i16);
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f438613m = z16;
        h();
    }
}
