package r80;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchOpenCommentPanelEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b>, View.OnClickListener {
    private TextView I;
    private ImageView J;
    private FeedCloudMeta$StFeed K;
    private e30.b L;
    private View M;

    private void g1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        i.k(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BUTTON, hashMap, feedCloudMeta$StFeed.hashCode());
    }

    private QFSCommentInfo h1() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = new e30.b(this.K);
        qFSCommentInfo.mFeed = this.K;
        qFSCommentInfo.mRelocationScrollType = 100;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mExtraTypeInfo = r();
        qFSCommentInfo.mCmtPanelSource = 11;
        qFSCommentInfo.mIsShowMask = true;
        return qFSCommentInfo;
    }

    private void i1(QCircleCommentCountUpdateEvent qCircleCommentCountUpdateEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qCircleCommentCountUpdateEvent.getFeedId())) {
            this.K.commentCount.set(qCircleCommentCountUpdateEvent.getCount());
            m1(this.K);
        }
    }

    private void l1(String str) {
        ImageView imageView = this.J;
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(str);
    }

    private void m1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.I == null) {
            QLog.d("QFSSearchFeedResultCommentPresenter", 1, "[updateCommentText] mCommentText should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.commentCount.get() <= 0) {
            this.I.setText(R.string.f183253io);
            l1(h.a(R.string.f183253io));
            return;
        }
        this.I.setText(r.f(feedCloudMeta$StFeed.commentCount.get()));
        l1(h.a(R.string.f187793uy) + ((Object) this.I.getText()));
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
        this.M = view.findViewById(R.id.f52522a1);
        this.I = (TextView) view.findViewById(R.id.f52582a7);
        this.J = (ImageView) view.findViewById(R.id.f52572a6);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleCommentCountUpdateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.M.setVisibility(0);
        if (feedCloudMeta$StFeed == null) {
            QLog.w("QFSSearchFeedResultCommentPresenter", 1, "onBindData feed should not be null.");
            return;
        }
        this.K = feedCloudMeta$StFeed;
        if (p.w(feedCloudMeta$StFeed)) {
            this.M.setVisibility(8);
            return;
        }
        m1(feedCloudMeta$StFeed);
        this.L = new e30.b(this.K);
        g1(feedCloudMeta$StFeed, i3);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        m1(bVar.g());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int hashCode;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.K != null && !fb0.a.a("QFSSearchFeedResultCommentPresenter")) {
            if (m0() == null) {
                hashCode = 0;
            } else {
                hashCode = m0().hashCode();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchOpenCommentPanelEvent(h1(), false, hashCode));
            EventCollector.getInstance().onViewClicked(this.J);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleCommentCountUpdateEvent) {
            i1((QCircleCommentCountUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultCommentPresenter";
    }
}
