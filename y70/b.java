package y70;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.cf;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.richframework.widget.looplist.LoopLayoutManagerHelper;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$ExpressionInfo;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends y70.a implements View.OnClickListener, Observer<e30.b> {
    private FeedCloudMeta$StFeed J;
    private e30.b K;
    private RecyclerView L;
    private w70.b M;
    private com.tencent.biz.qqcircle.richframework.widget.looplist.a N;
    private LoopLayoutManagerHelper P;
    private RoundCorneredFrameLayout Q;
    private LinearLayout R;
    private TextView S;
    private ImageView T;
    private String U;
    private int V;

    private void A1() {
        VideoReport.setElementId(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_EXCON_COMMENT_FRAME);
    }

    private void B1() {
        if (!uq3.c.F6()) {
            return;
        }
        if (this.M.getNUM_BACKGOURND_ICON() == 0) {
            cf.b().e();
        } else {
            cf.b().g();
        }
    }

    private void C1(List<FeedCloudCommon$Entry> list) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if ("comment_show_like_button".equals(feedCloudCommon$Entry.key.get()) && feedCloudCommon$Entry.value.get().equals("like_button")) {
                this.R.setVisibility(8);
                this.T.setVisibility(0);
                o1();
                return;
            }
            this.R.setVisibility(0);
            this.T.setVisibility(8);
        }
    }

    private void D1() {
        int i3;
        if (this.T == null) {
            return;
        }
        boolean z16 = true;
        if (this.J.likeInfo.status.get() != 1) {
            z16 = false;
        }
        ImageView imageView = this.T;
        Resources resources = imageView.getResources();
        if (z16) {
            i3 = R.drawable.qvideo_skin_icon_general_like_solid;
        } else {
            i3 = R.drawable.nrs;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
    }

    private void o1() {
        if (this.T.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cx.a(220.0f), cx.a(28.0f));
        layoutParams.leftMargin = cx.a(12.0f);
        layoutParams.topMargin = cx.a(12.0f);
        layoutParams.rightMargin = cx.a(12.0f);
        layoutParams.bottomMargin = cx.a(12.0f);
        this.Q.setLayoutParams(layoutParams);
        DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(this.Q).setDefaultWidth(cx.a(220.0f)).setDefaultHeight(cx.a(28.0f)).setTargetWidth(bz.j()).setMaxCardWidthScale(1.5f).setLayoutParams(layoutParams).setEnableAdjustHeight(false).setFixWidth((cx.a(12.0f) * 6) + (cx.a(10.0f) * 2)));
    }

    private List<FeedCloudMeta$StComment> p1(List<FeedCloudMeta$StComment> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4) && !TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                    arrayList.add(feedCloudMeta$StComment);
                }
            }
        }
        return arrayList;
    }

    private String q1(List<FeedCloudCommon$Entry> list) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if ("comment_guide_copywriting".equals(feedCloudCommon$Entry.key.get())) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return h.a(R.string.f19041421);
    }

    private void r1() {
        o1();
    }

    private void s1(View view) {
        boolean z16;
        int i3;
        if (this.T == null) {
            return;
        }
        FeedCloudMeta$StFeed feed = getFeed();
        if (this.J.likeInfo.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        ha0.b.h(feed, !z16, view.getContext());
        ImageView imageView = this.T;
        Resources resources = imageView.getResources();
        if (!z16) {
            i3 = R.drawable.orm;
        } else {
            i3 = R.drawable.nrs;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
        y1(!z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        FeedCloudMeta$ExpressionInfo feedCloudMeta$ExpressionInfo;
        if (this.P != null && this.M != null) {
            if (feedCloudMeta$StComment != null && (feedCloudMeta$ExpressionInfo = feedCloudMeta$StComment.expressionInfo) != null && !TextUtils.isEmpty(feedCloudMeta$ExpressionInfo.expressionURL.get())) {
                feedCloudMeta$StComment.content.set(feedCloudMeta$StComment.content.get() + "\u3010\u81ea\u5b9a\u4e49\u8868\u60c5\u3011");
            }
            B1();
            this.P.r(i3);
            int i16 = i3 + 1;
            this.M.addData(feedCloudMeta$StComment, i16);
            this.P.k(i16);
            this.P.j(i16);
        }
    }

    private void u1() {
        this.Q.setOnClickListener(this);
        this.T.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(boolean z16) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (this.L != null && this.P != null && (feedCloudMeta$StFeed = this.J) != null) {
            List<FeedCloudMeta$StComment> p16 = p1(feedCloudMeta$StFeed.vecComment.get());
            if (z16 && p16 != null && p16.size() > 1) {
                if (!this.P.h()) {
                    this.P.n();
                    return;
                }
                return;
            }
            this.P.v();
        }
    }

    private void y1(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.J.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.J.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.V));
        if (z16) {
            str = "like";
        } else {
            str = "cancel";
        }
        buildElementParams.put("xsj_action_type", str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_TYPE, "clck");
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_target_qq", this.J.poster.f398463id.get());
        VideoReport.setElementId(this.T, QCircleDaTongConstant.ElementId.EM_XSJ_INFO_MODULE);
        VideoReport.setElementParams(this.T, buildElementParams);
        VideoReport.setElementExposePolicy(this.T, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.T, ClickPolicy.REPORT_ALL);
        j0(this.T, QCircleDaTongConstant.EventId.EV_XSJ_LIKE_WORK, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_action_type", "cmt");
        FeedCloudMeta$StFeed feed = getFeed();
        if (feed != null) {
            buildElementParams.put("xsj_target_qq", feed.poster.f398463id.get());
            buildElementParams.put("xsj_feed_id", feed.f398449id.get());
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTPANEL_SOURCE, 1);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTBAR_TYPE, 2);
        VideoReport.setElementId(this.S, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION, this.S, buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        o1();
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        this.L = (RecyclerView) view.findViewById(R.id.f3590134);
        com.tencent.biz.qqcircle.richframework.widget.looplist.a aVar = new com.tencent.biz.qqcircle.richframework.widget.looplist.a(view.getContext(), 1, false);
        this.N = aVar;
        this.P = aVar.s();
        this.L.setLayoutManager(this.N);
        w70.b bVar = new w70.b();
        this.M = bVar;
        bVar.i0(this);
        this.L.setAdapter(this.M);
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) view.findViewById(R.id.f44011o1);
        this.Q = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(cx.a(4.0f));
        this.Q.a(true);
        this.R = (LinearLayout) view.findViewById(R.id.f44041o4);
        this.S = (TextView) view.findViewById(R.id.f44021o2);
        this.T = (ImageView) view.findViewById(R.id.dw_);
        u1();
        A1();
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        v1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.dw_) {
                s1(view);
            } else if (id5 == R.id.f44011o1) {
                v1(false);
                QFSFeedCommentInfo qFSFeedCommentInfo = new QFSFeedCommentInfo(getFeed(), null);
                qFSFeedCommentInfo.mHintText = this.U;
                if (QFSCommentHelper.L().y0((Activity) this.C.getContext(), qFSFeedCommentInfo, new a(this.N.r()), false, getReportBean())) {
                    k1();
                    j1();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            r1();
        }
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        v1(false);
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        v1(true);
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSMixFeedRecommendCommentPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void L0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        super.L0(qQCircleDitto$StItemInfo, i3);
        FeedCloudMeta$StFeed feed = getFeed();
        if (feed == null) {
            return;
        }
        this.V = i3;
        this.J = feed;
        this.K = new e30.b(feed);
        this.M.j0(r());
        this.M.setDatas(p1(feed.vecComment.get()));
        this.M.k0(feed);
        String q16 = q1(qQCircleDitto$StItemInfo.busiInfo.get());
        this.U = q16;
        this.S.setText(q16);
        C1(qQCircleDitto$StItemInfo.busiInfo.get());
        w20.a.j().observerGlobalState(this.K, this);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        D1();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements QFSCommentHelper.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f449530a;

        a(int i3) {
            this.f449530a = i3;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void a(int i3) {
            b.this.v1(true);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void c(FeedCloudMeta$StComment feedCloudMeta$StComment, o20.d dVar) {
            b.this.t1(feedCloudMeta$StComment, this.f449530a);
            b.this.z1();
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void b(FeedCloudMeta$StReply feedCloudMeta$StReply, o20.d dVar) {
        }
    }
}
