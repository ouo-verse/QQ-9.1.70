package ua0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RecyclerView.OnScrollListener implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean>, QCircleFeedReportScroller.b {
    private static String F = "QCircleFeedCardReportHelper";
    private int C;
    private QCircleReportBean D;
    private RecyclerView E;

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f438602d;

    /* renamed from: e, reason: collision with root package name */
    private int f438603e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f438604f = false;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<qc0.a> f438605h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<qc0.a, Long> f438606i = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private boolean f438607m;

    private void e(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        for (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
            if (!(findViewHolderForLayoutPosition instanceof qc0.a)) {
                return;
            }
            qc0.a aVar = (qc0.a) findViewHolderForLayoutPosition;
            int i3 = 0;
            Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
            findViewByPosition.getGlobalVisibleRect(rect);
            int width = findViewByPosition.getWidth();
            int i16 = rect.right;
            if (i16 > 0) {
                i3 = i16 - rect.left;
            }
            if (i3 / width >= 0.5d) {
                QLog.d(F, 2, "PYMKScrollReport report card expose index:" + findFirstVisibleItemPosition);
                m(aVar);
            }
        }
    }

    private void f(qc0.a aVar) {
        if (aVar != null) {
            try {
                View view = aVar.itemView;
                if (view == null) {
                    return;
                }
                int i3 = 0;
                Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
                view.getGlobalVisibleRect(rect);
                int width = view.getWidth();
                int i16 = rect.right;
                if (i16 > 0) {
                    i3 = i16 - rect.left;
                }
                if (i3 / width >= 0.5d) {
                    QLog.d(F, 2, "PYMKScrollReport report card expose index:" + aVar.m());
                    m(aVar);
                }
            } catch (Exception e16) {
                QLog.e(F, 1, "checkCardExpose exception:" + e16.toString());
            }
        }
    }

    private void g(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        for (int i3 = findFirstVisibleItemPosition; i3 <= findLastVisibleItemPosition; i3++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(i3);
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(i3);
            if (!(findViewHolderForLayoutPosition instanceof qc0.a)) {
                return;
            }
            qc0.a aVar = (qc0.a) findViewHolderForLayoutPosition;
            findViewByPosition.getGlobalVisibleRect(new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
            float width = ((r7.right - r7.left) * (r7.bottom - r7.top)) / (findViewByPosition.getWidth() * findViewByPosition.getHeight());
            if (width >= 0.8f && !this.f438606i.keySet().contains(aVar)) {
                this.f438606i.put(aVar, Long.valueOf(System.currentTimeMillis()));
                QLog.d(F, 2, "PYMKScrollReport checkCardExposeTimeHorizontal addMapList rate = " + width);
            }
        }
        n(false, findFirstVisibleItemPosition, findLastVisibleItemPosition);
    }

    private void h(RecyclerView recyclerView) {
        int i3;
        if (recyclerView != null && (recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager)) {
            SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = (SafeStaggeredGridLayoutManager) recyclerView.getLayoutManager();
            int[] findFirstVisibleItemPositions = safeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            int[] findLastVisibleItemPositions = safeStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
            if (findFirstVisibleItemPositions.length >= 1 && findLastVisibleItemPositions.length >= 1 && (i3 = findFirstVisibleItemPositions[0]) <= findLastVisibleItemPositions[0]) {
                for (i3 = findFirstVisibleItemPositions[0]; i3 <= findLastVisibleItemPositions[0]; i3++) {
                    View findViewByPosition = safeStaggeredGridLayoutManager.findViewByPosition(i3);
                    if (findViewByPosition instanceof QCirclePYMKRecommendView) {
                        RecyclerView r06 = ((QCirclePYMKRecommendView) findViewByPosition).r0();
                        if (r06 == null) {
                            return;
                        }
                        findViewByPosition.getGlobalVisibleRect(new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
                        if ((r6.bottom - r6.top) / findViewByPosition.getHeight() >= 0.8f) {
                            g(r06);
                        } else {
                            n(true, -1, -1);
                        }
                    }
                }
            }
        }
    }

    private void i() {
        if (!this.f438604f) {
            QLog.d(F, 2, "PYMKScrollReport checkFirstScreenCardExpose report expose size:" + this.f438605h.size());
            for (int i3 = 0; i3 < this.f438605h.size(); i3++) {
                f(this.f438605h.get(i3));
            }
            this.f438604f = true;
        }
        this.f438605h.clear();
    }

    private void m(qc0.a aVar) {
        int i3;
        RecyclerView recyclerView = this.E;
        if (recyclerView != null) {
            i3 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        } else {
            i3 = 0;
        }
        QQCircleDitto$StItemInfo l3 = aVar.l();
        if (l3 != null) {
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(c.a(this.f438602d).setToUin(l3.f429300id.get()).setFeedType1(3).setFeedType2(1).setActionType(3).setSubActionType(1).setExt2(String.valueOf((aVar.m() - i3) + 1)).setIndex(this.f438603e).setContainerSeq(aVar.m()).setPageId(this.C)));
        }
    }

    private void n(boolean z16, int i3, int i16) {
        float width;
        Iterator<Map.Entry<qc0.a, Long>> it = this.f438606i.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<qc0.a, Long> next = it.next();
            if (z16) {
                RecyclerView recyclerView = this.E;
                width = 0.0f;
                if (recyclerView != null) {
                    i3 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                }
            } else {
                next.getKey().itemView.getGlobalVisibleRect(new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
                width = ((r3.right - r3.left) * (r3.bottom - r3.top)) / (r2.getWidth() * r2.getHeight());
            }
            if (z16 || next.getKey().m() < i3 || next.getKey().m() > i16 || (next.getKey().m() >= i3 && next.getKey().m() <= i16 && width < 0.8f)) {
                long currentTimeMillis = System.currentTimeMillis() - next.getValue().longValue();
                QQCircleDitto$StItemInfo l3 = next.getKey().l();
                if (l3 != null) {
                    QCircleLpReportDc05502.report(new QCircleLpReportDc05502.DataBuilder(c.b(this.f438602d).setToUin(l3.f429300id.get()).setFeedType1(3).setFeedType2(1).setFeedType3(1).setIndex(this.f438603e).setExt2(String.valueOf((next.getKey().m() - i3) + 1)).setStayTime(currentTimeMillis).setContainerSeq(next.getKey().m()).setPageId(this.C)));
                }
                QLog.d(F, 2, "PYMKScrollReport reportCardExposeTime  pymkPos = " + next.getKey().m() + " , durationTime = " + currentTimeMillis + " , notCompute = " + z16 + " , firstVisiblePos = " + i3);
                it.remove();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.b
    public void a(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        if (Math.abs(i16) < 10) {
            return;
        }
        h(recyclerView);
    }

    public void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f438602d = feedCloudMeta$StFeed;
        this.f438603e = i3;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean getReportBean() {
        return this.D;
    }

    public void k() {
        i();
    }

    public void l(qc0.a aVar) {
        if (!this.f438604f) {
            this.f438605h.add(aVar);
        }
    }

    public void o(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.b
    public void onPause() {
        n(true, -1, -1);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.b
    public void onResume() {
        g(this.E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        if (i3 == 0) {
            QLog.d(F, 2, "PYMKScrollReport onScrollStateChanged" + i3);
            try {
                e(recyclerView);
                g(recyclerView);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (this.f438607m) {
                QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(c.a(this.f438602d).setFeedType1(3).setFeedType2(1).setActionType(30).setSubActionType(2).setIndex(this.f438603e).setPageId(this.C)));
            }
            VideoReport.traverseExposure();
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
        this.f438607m = z16;
        i();
    }

    public void p(RecyclerView recyclerView) {
        this.E = recyclerView;
    }
}
