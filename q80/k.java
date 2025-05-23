package q80;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$RecommendItem;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private static final int L = ViewUtils.dip2px(8.0f);
    private LinearLayout I;
    private RecyclerView J;
    private p80.d K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if (recyclerView.getAdapter() == null) {
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            rect.bottom = k.L;
            if (childAdapterPosition % 2 == 0) {
                rect.right = k.L;
            }
        }
    }

    private static String h1(List<FeedCloudMeta$RecommendItem> list) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size() - 1; i3++) {
            sb5.append(list.get(i3).suggestion_word.get());
            sb5.append(',');
        }
        sb5.append(list.get(list.size() - 1).suggestion_word.get());
        return sb5.toString();
    }

    private void i1() {
        this.J.setAdapter(this.K);
        this.J.setLayoutManager(new SafeStaggeredGridLayoutManager(2, 1));
        if (this.J.getItemDecorationCount() == 0) {
            this.J.addItemDecoration(new a());
        }
    }

    private void j1() {
        if (this.I != null) {
            return;
        }
        this.I = (LinearLayout) this.C.findViewById(R.id.f518729_);
        this.J = (RecyclerView) this.C.findViewById(R.id.f518829a);
        this.K = new p80.d();
        i1();
    }

    private void l1(String str, String str2, int i3, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_feed_id", str);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_NUMBER, Integer.valueOf(i3));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_QUERY_TEXT, str2);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_RELATED_SEARCH_TRANSFER_INFO, str3);
        ua0.i.k(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_RELATED_SEARCH_MODE, hashMap, str.hashCode());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        List<FeedCloudMeta$RecommendItem> list = feedCloudMeta$StFeed.recommend_info.items.get();
        if (list != null && !list.isEmpty()) {
            j1();
            String str = feedCloudMeta$StFeed.recommend_info.trans_info.get();
            String str2 = feedCloudMeta$StFeed.f398449id.get();
            this.I.setVisibility(0);
            this.K.setDatas(list);
            this.K.i0(str2, str);
            l1(str2, h1(list), list.size(), str);
            return;
        }
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QLog.w("QFSSearchFeedResultRelatePresenter", 1, "[onBindData] data should not be null.");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultRelatePresenter";
    }
}
