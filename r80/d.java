package r80;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchLikeImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b> {
    private TextView I;
    private QFSSearchLikeImageView J;
    private FeedCloudMeta$StFeed K;
    private e30.b L;
    private boolean M;
    private View N;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QFSSearchLikeImageView qFSSearchLikeImageView = this.J;
        qFSSearchLikeImageView.onClick(qFSSearchLikeImageView);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void i1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        i.k(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_LIKE_BUTTON, hashMap, feedCloudMeta$StFeed.hashCode());
    }

    private void l1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSSearchLikeImageView qFSSearchLikeImageView = this.J;
        boolean z16 = true;
        if (qFSSearchLikeImageView == null) {
            QLog.d("QFSSearchFeedResultLikePresenter", 1, "[updateLikeIcon] mLikeIcon should not be null.");
            return;
        }
        qFSSearchLikeImageView.setData(feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed.likeInfo.status.get() != 1) {
            z16 = false;
        }
        this.M = z16;
        this.J.n(z16);
    }

    private void m1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.I == null) {
            QLog.d("QFSSearchFeedResultLikePresenter", 1, "[updateLikeText] mLikeText should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.likeInfo.count.get() <= 0) {
            this.I.setText(R.string.f193704_x);
            this.I.setContentDescription(h.a(R.string.f1909843k));
            return;
        }
        this.I.setText(r.f(feedCloudMeta$StFeed.likeInfo.count.get()));
        this.I.setContentDescription(h.a(R.string.f187813v0) + ((Object) this.I.getText()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (this.L != null) {
            w20.a.j().removeObserverGlobalState(this.L, this);
            w20.a.j().observerGlobalState(this.L, this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        if (this.L != null) {
            w20.a.j().removeObserverGlobalState(this.L, this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.N = view.findViewById(R.id.f53612cz);
        this.I = (TextView) view.findViewById(R.id.f52702ai);
        this.J = (QFSSearchLikeImageView) view.findViewById(R.id.f52692ah);
        this.I.setOnClickListener(new View.OnClickListener() { // from class: r80.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.h1(view2);
            }
        });
        this.J.setItemPreClickListener(new QFSLikeImageView.d() { // from class: r80.c
        });
        this.J.setDrawablePadding(cx.a(4.0f));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.N.setVisibility(0);
        if (feedCloudMeta$StFeed == null) {
            QLog.w("QFSSearchFeedResultLikePresenter", 1, "onBindData feed should not be null.");
            return;
        }
        this.K = feedCloudMeta$StFeed;
        if (p.w(feedCloudMeta$StFeed)) {
            this.N.setVisibility(8);
            return;
        }
        m1(feedCloudMeta$StFeed);
        l1(feedCloudMeta$StFeed);
        this.L = new e30.b(this.K);
        i1(feedCloudMeta$StFeed, i3);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        m1(g16);
        l1(g16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultLikePresenter";
    }
}
