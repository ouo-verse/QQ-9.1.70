package q80;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.af;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StEveryoneSearchInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements e80.g {
    private static final int T = ViewUtils.dip2px(16.0f);
    private static final int U = ViewUtils.dip2px(8.0f);
    private LinearLayout I;
    private RecyclerView J;
    private p80.c K;
    private List<String> L;
    private int M;
    private int N;
    private int P;
    private boolean Q;
    private String R;
    private Runnable S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getAdapter() == null) {
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                rect.left = f.T;
            } else {
                rect.left = f.U;
            }
            if (f.this.J.getLayoutManager() != null && childAdapterPosition == f.this.J.getLayoutManager().getItemCount() - 1) {
                rect.right = f.T;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    private static void k1() {
        RFWThreadManager.getUIHandler().postDelayed(new com.tencent.biz.qqcircle.immersive.search.prompt.history.j(), 100L);
    }

    private void l1(FeedCloudMeta$StEveryoneSearchInfo feedCloudMeta$StEveryoneSearchInfo) {
        if (feedCloudMeta$StEveryoneSearchInfo != null) {
            this.L = feedCloudMeta$StEveryoneSearchInfo.suggestion_words.get();
            this.N = feedCloudMeta$StEveryoneSearchInfo.plan_time_value.get();
            this.P = feedCloudMeta$StEveryoneSearchInfo.plan_page_value.get();
            this.M = v1(feedCloudMeta$StEveryoneSearchInfo.plan_type.get());
            this.R = feedCloudMeta$StEveryoneSearchInfo.trans_info.get();
        }
    }

    private String m1() {
        if (o1()) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.L.size() - 1; i3++) {
                sb5.append(this.L.get(i3));
                sb5.append(',');
            }
            sb5.append(this.L.get(r1.size() - 1));
            return sb5.toString();
        }
        return "";
    }

    private void n1(int i3) {
        if (i3 == this.P && this.Q && o1()) {
            u1();
        }
    }

    private boolean o1() {
        List<String> list = this.L;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    private void onStop() {
        this.Q = false;
        if (this.S != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.S);
        }
    }

    private void p1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_NUMBER, Integer.valueOf(this.L.size()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_TEXT, m1());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PEOPLE_SEARCH_TRANSFER_INFO, this.R);
        ua0.i.k(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_QUERY_MODE, hashMap, feedCloudMeta$StFeed.hashCode());
    }

    private void q1() {
        this.J.setAdapter(this.K);
        RecyclerView recyclerView = this.J;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
        if (this.J.getItemDecorationCount() == 0) {
            this.J.addItemDecoration(new a());
        }
        this.J.addOnScrollListener(new b());
    }

    private void r1() {
        if (this.I != null) {
            return;
        }
        this.I = (LinearLayout) this.C.findViewById(R.id.f43891np);
        this.J = (RecyclerView) this.C.findViewById(R.id.f43901nq);
        this.K = new p80.c();
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1() {
        if (this.Q) {
            u1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u1() {
        if (o1()) {
            r1();
            this.I.setVisibility(0);
            this.K.setDatas(this.L);
            this.K.i0(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), this.R);
            p1((FeedCloudMeta$StFeed) this.f85017h);
            k1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int v1(int i3) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 2 && i3 == 2 && ((FeedCloudMeta$StFeed) this.f85017h).images.get() != null) {
            int size = ((FeedCloudMeta$StFeed) this.f85017h).images.get().size();
            if (size == 1) {
                return 0;
            }
            if (size < this.P) {
                return 1;
            }
        }
        return i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if ((hVar instanceof af) && this.M == 2) {
            n1(((af) hVar).f86143a);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        onStop();
    }

    @Override // e80.g
    public boolean isPlaying() {
        return false;
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        onStop();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        this.Q = true;
        if (this.M == 1 && o1()) {
            r1();
            if (this.I.getVisibility() == 8) {
                if (this.S == null) {
                    this.S = new Runnable() { // from class: q80.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.this.s1();
                        }
                    };
                }
                RFWThreadManager.getUIHandler().postDelayed(this.S, this.N * 1000);
            }
        }
    }

    @Override // e80.g
    public void stop() {
        onStop();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.w("QFSSearchFeedResultHotPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        l1(feedCloudMeta$StFeed.everyone_search_info.get());
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultHotPresenter";
    }
}
