package r80;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchShowShareSheetEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.br;
import com.tencent.biz.qqcircle.immersive.feed.event.af;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.utils.o;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b>, View.OnClickListener {
    private TextView I;
    private ImageView J;
    private FeedCloudMeta$StFeed K;
    private e30.b L;
    private int M;
    private View N;

    private QCircleShareInfo g1() {
        QCircleShareInfo c16 = au.c(this.K);
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = o.e(this.K);
        c16.isShowPlayRate = false;
        c16.feedBlockData = this.L;
        c16.extraTypeInfo.mDataPosition = this.f85018i;
        c16.isShowCollect = false;
        c16.isShowUnCollect = false;
        c16.isShowQCircleEnterFloatingWindow = false;
        br.D1(c16);
        if (this.K.type.get() == 2) {
            c16.picDownPos = this.M;
        }
        c16.feed = this.K;
        c16.mReportBean = getReportBean();
        return c16;
    }

    private void j1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        i.k(this.J, "em_xsj_share_button", hashMap, feedCloudMeta$StFeed.hashCode());
    }

    private void k1(String str) {
        ImageView imageView = this.J;
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(str);
    }

    private void l1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.I == null) {
            QLog.d("QFSSearchFeedResultSharePresenter", 1, "[updateShareText] mShareText should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.share.sharedCount.get() <= 0) {
            this.I.setText(R.string.f184893n4);
            k1(h.a(R.string.f184893n4));
            return;
        }
        this.I.setText(r.f(feedCloudMeta$StFeed.share.sharedCount.get()));
        k1(h.a(R.string.f187833v2) + ((Object) this.I.getText()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof af) {
            this.M = ((af) hVar).f86143a;
        }
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
        this.N = view.findViewById(R.id.f54352ez);
        this.I = (TextView) view.findViewById(R.id.f52722ak);
        this.J = (ImageView) view.findViewById(R.id.f52712aj);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.N.setVisibility(0);
        if (feedCloudMeta$StFeed == null) {
            QLog.w("QFSSearchFeedResultSharePresenter", 1, "onBindData feed should not be null.");
            return;
        }
        this.K = feedCloudMeta$StFeed;
        if (p.w(feedCloudMeta$StFeed)) {
            this.N.setVisibility(8);
            return;
        }
        l1(feedCloudMeta$StFeed);
        this.L = new e30.b(this.K);
        j1(feedCloudMeta$StFeed, i3);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        l1(bVar.g());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int hashCode;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.K != null) {
            if (m0() == null) {
                hashCode = 0;
            } else {
                hashCode = m0().hashCode();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchShowShareSheetEvent(g1(), hashCode));
            EventCollector.getInstance().onViewClicked(this.J);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultSharePresenter";
    }
}
