package q80;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private QCircleAvatarView I;
    private TextView J;
    private TextView K;
    private QFSExpandableAsyncTextView L;
    private Size M;
    private p70.i N;
    private QFSSearchInfo P;

    private void i1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 1);
        VideoReport.setElementParams(this.C, hashMap);
        EventCollector.getInstance().onViewClicked(this.C);
    }

    private QCirclePolymerizationBean j1(String str) {
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(str);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setFromReportBean(getReportBean().m466clone());
        qCirclePolymerizationBean.setPolymerizationType(7);
        qCirclePolymerizationBean.setExt1From(3);
        return qCirclePolymerizationBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(String str) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(str);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(String str) {
        QLog.d("QFSSearchFeedResultWidgetPresenter", 1, "[setOnClickHashTagText] keyword = " + str);
        com.tencent.biz.qqcircle.launcher.c.G(this.L.getContext(), j1(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m1() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poster != null) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(((FeedCloudMeta$StFeed) this.f85017h).poster);
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            qCircleInitBean.setClientFromType(9);
            com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
        }
    }

    private void o1(View view, int i3) {
        p.E(this.E, view, this.f85018i, i3);
    }

    private void q1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.content.get())) {
            this.L.setText((CharSequence) null);
            this.L.setVisibility(8);
            return;
        }
        this.L.setVisibility(0);
        this.L.setSpecialClickAreaColor(R.color.qui_common_text_link_selector);
        this.L.setNeedSpecialAreaBold(false);
        this.L.setNeedSpecialHashTagAreaBackground(false);
        this.L.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: q80.l
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
            public final void onClick(String str) {
                n.this.k1(str);
            }
        });
        this.L.setOnClickHashTagTextListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: q80.m
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
            public final void onClick(String str) {
                n.this.l1(str);
            }
        });
        if (com.tencent.biz.qqcircle.immersive.utils.a.g()) {
            this.L.setLimitLines(2);
        }
        this.L.w();
        if (this.L.l() == 0) {
            this.L.setExactWidth(cx.c(m0()));
        }
        this.L.setText(feedCloudMeta$StFeed.content.get());
        this.L.setShowCollapse(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (QCircleAvatarView) view.findViewById(R.id.f56892lu);
        this.J = (TextView) view.findViewById(R.id.f56962m1);
        this.K = (TextView) view.findViewById(R.id.f41011fx);
        this.L = (QFSExpandableAsyncTextView) view.findViewById(R.id.f365814y);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.M = com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.c__);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.K.setVisibility(0);
        if (feedCloudMeta$StFeed == null) {
            QLog.w("QFSSearchFeedResultWidgetPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        if (this.N == null) {
            this.N = (p70.i) A0(p70.i.class);
        }
        this.I.setUser(feedCloudMeta$StFeed.poster, this.M);
        this.J.setText(feedCloudMeta$StFeed.poster.nick.get());
        if (p.w(feedCloudMeta$StFeed)) {
            this.K.setVisibility(8);
        } else {
            this.K.setText(com.tencent.biz.qqcircle.widgets.comment.b.d(feedCloudMeta$StFeed.createTime.get() * 1000));
        }
        q1(feedCloudMeta$StFeed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (p.w((FeedCloudMeta$StFeed) this.f85017h)) {
            if (view == this.I) {
                i3 = 2;
            } else if (view == this.J) {
                i3 = 3;
            } else if (view == this.K) {
                i3 = 44;
            } else {
                i3 = 1000;
            }
            o1(view, i3);
        } else if (view == this.I || view == this.J) {
            m1();
            i1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p1(QFSSearchInfo qFSSearchInfo) {
        this.P = qFSSearchInfo;
        if (qFSSearchInfo != null) {
            QLog.d("QFSSearchFeedResultWidgetPresenter", 2, "[setSearchInfo] mSearchInfo.getSearchKeyword() = " + this.P.f());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultWidgetPresenter";
    }
}
