package q80;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSFakeCommentSendEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchOpenCommentPanelEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchCommentAsyncTextView;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.cm;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$goodsInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, e80.h {

    /* renamed from: c0, reason: collision with root package name */
    private static final int f428700c0 = ViewUtils.dpToPx(30.0f);

    /* renamed from: d0, reason: collision with root package name */
    private static final int f428701d0 = ViewUtils.dpToPx(32.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f428702e0 = ViewUtils.dpToPx(52.0f);
    private LinearLayout I;
    private QCircleAvatarView J;
    private QCircleAsyncTextView K;
    private ImageView L;
    private QFSSearchCommentAsyncTextView M;
    private QFSCommentPraiseLayout N;
    private ImageView P;
    private ImageView Q;
    private FeedCloudMeta$StFeed R;
    private FeedCloudMeta$StComment S;
    private FeedCloudMeta$StUser T;
    private int U;
    private Drawable V;
    private Drawable W;
    private Drawable X;
    private Drawable Y;
    private Drawable Z;

    /* renamed from: a0, reason: collision with root package name */
    private Size f428703a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f428704b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QCircleAsyncTextView.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
        public void onClick() {
            j.this.D1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1(int i3) {
        k1(2);
    }

    private void B1() {
        if (!this.T.has()) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.T);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        int hashCode;
        if (this.R != null && this.S != null) {
            if (m0() == null) {
                hashCode = 0;
            } else {
                hashCode = m0().hashCode();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchOpenCommentPanelEvent(m1(), false, hashCode));
        }
    }

    private void E1(String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.R;
        if (feedCloudMeta$StFeed != null && !feedCloudMeta$StFeed.vecComment.get().isEmpty() && !TextUtils.isEmpty(str)) {
            List<FeedCloudMeta$StComment> list = this.R.vecComment.get();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (TextUtils.equals(list.get(i3).f398447id.get(), str)) {
                    list.remove(i3);
                    return;
                }
            }
        }
    }

    private void F1() {
        VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT_GOODS_LINK);
        ua0.i.h(this.I, "ev_xsj_abnormal_clck", n1());
    }

    private void G1() {
        String str = this.S.content.get();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!TextUtils.isEmpty(this.S.commentPic.picUrl.get())) {
            spannableStringBuilder.append(" ").append((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f196554hm));
            int length = str.length();
            int i3 = length + 5;
            this.M.j(length, i3);
            this.M.d(spannableStringBuilder, length, i3, new a(), R.color.cay, false);
        }
        J1(spannableStringBuilder);
        this.M.setText(spannableStringBuilder);
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            this.M.setVisibility(8);
            if (this.Z != null) {
                this.P.setVisibility(0);
                this.P.setImageDrawable(this.Z);
                return;
            } else {
                this.P.setVisibility(8);
                return;
            }
        }
        this.M.setVisibility(0);
        this.P.setVisibility(8);
    }

    private void H1() {
        if (!this.T.has()) {
            return;
        }
        this.J.setUser(this.T, this.f428703a0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.T.nick.get());
        if (!TextUtils.equals(this.T.f398463id.get(), this.R.poster.f398463id.get())) {
            this.K.showEllipseEndImageSpan(false);
            this.K.setText(spannableStringBuilder);
            cm.d(m0(), this.L, this.T.get());
            return;
        }
        if (this.V == null) {
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.qvideo_skin_comment_tag_author);
            this.V = drawable;
            drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        }
        QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.V);
        this.K.showEllipseEndImageSpan(true);
        this.K.setText(spannableStringBuilder);
        this.L.setVisibility(8);
    }

    private void I1() {
        this.N.setData(1, this.R, this.S, null, true);
        this.N.setOnClickHookListener(new QFSCommentPraiseLayout.i() { // from class: q80.i
            @Override // com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout.i
            public final void onClick(int i3) {
                j.this.A1(i3);
            }
        });
    }

    private void J1(SpannableStringBuilder spannableStringBuilder) {
        if (this.S.typeFlag.get() == 1) {
            if (this.W == null) {
                this.W = q1();
            }
            this.Z = q1();
            this.P.getLayoutParams().width = f428700c0;
            QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.W);
            return;
        }
        if (QFSCommentHelper.V(this.S.typeFlag2.get(), 4)) {
            if (this.X == null) {
                this.X = o1();
            }
            this.Z = o1();
            this.P.getLayoutParams().width = f428701d0;
            QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.X);
            return;
        }
        if (this.S.likeInfo.ownerStatus.get() == 1) {
            if (this.Y == null) {
                this.Y = p1();
            }
            this.Z = p1();
            this.P.getLayoutParams().width = f428702e0;
            QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.Y);
            return;
        }
        this.Z = null;
    }

    private void k1(int i3) {
        VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_DETAIL);
        VideoReport.setElementParam(this.I, QCircleDaTongConstant.ElementParamKey.XSJ_CLICK_AREA_COMMENT, Integer.valueOf(i3));
        EventCollector.getInstance().onViewClicked(this.I);
    }

    private void l1() {
        Map<String, Object> n16 = n1();
        n16.put("xsj_item_index", Integer.valueOf(this.U));
        if (!this.f428704b0) {
            ua0.i.k(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_DETAIL, n16, this.R.hashCode());
        } else {
            ua0.i.h(this.I, "dt_imp", n16);
        }
        this.f428704b0 = true;
    }

    private QFSCommentInfo m1() {
        if (this.R != null && this.S != null) {
            QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
            qFSCommentInfo.mFeedBlockData = new e30.b(this.R);
            qFSCommentInfo.mFeed = this.R;
            qFSCommentInfo.mRelocationScrollType = 100;
            qFSCommentInfo.mReportBean = getReportBean();
            qFSCommentInfo.mExtraTypeInfo = r();
            FeedCloudMeta$StComment feedCloudMeta$StComment = this.S;
            qFSCommentInfo.mTargetComment = feedCloudMeta$StComment;
            qFSCommentInfo.mNeedLocateComment = true;
            qFSCommentInfo.mCmtPanelSource = 11;
            qFSCommentInfo.mIsShowMask = true;
            qFSCommentInfo.mHotCommentId = feedCloudMeta$StComment.f398447id.get();
            QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
            QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
            qCircleActionBean.mItemTopAnimationCommentId = this.S.f398447id.get();
            actionBean.mCommentInitBeanActionBean = qCircleActionBean;
            qFSCommentInfo.mActionBean = actionBean;
            return qFSCommentInfo;
        }
        return new QFSCommentInfo();
    }

    @NonNull
    private Map<String, Object> n1() {
        String str;
        int i3;
        int i16;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.R.f398449id.get());
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        if (!this.T.has()) {
            str = "";
        } else {
            str = this.T.f398463id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_AUTHOR_UIN, str);
        int i17 = 1;
        if (TextUtils.equals(str, HostDataTransUtils.getAccount())) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_SOURCE, Integer.valueOf(i3));
        if (!this.T.has() || this.T.label.get() != 1) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_GENGWANG, Integer.valueOf(i16));
        if (this.S.typeFlag2.get() != 4) {
            i17 = 0;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_BURN, Integer.valueOf(i17));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, this.S.f398447id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_LIKE_NUM, Integer.valueOf(this.S.likeInfo.count.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 0);
        FeedCloudMeta$goodsInfo feedCloudMeta$goodsInfo = this.S.goodsInfo;
        if (feedCloudMeta$goodsInfo.has()) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_BUSINESS_RECALL_CHANNEL, Integer.valueOf(feedCloudMeta$goodsInfo.goodsType.get()));
            buildElementParams.put("xsj_business_ad_id", feedCloudMeta$goodsInfo.goodsID.get());
        }
        return buildElementParams;
    }

    private Drawable o1() {
        Drawable drawable = ResourcesCompat.getDrawable(m0().getResources(), R.drawable.f162035nq0, null);
        if (drawable != null) {
            drawable.setBounds(ImmersiveUtils.dpToPx(2.5f), ImmersiveUtils.dpToPx(0.0f), ImmersiveUtils.dpToPx(33.75f), ImmersiveUtils.dpToPx(18.0f));
        }
        return drawable;
    }

    private Drawable p1() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.qvideo_skin_comment_tag_authorlike);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(55.5f), ImmersiveUtils.dpToPx(16.0f));
        return drawable;
    }

    private Drawable q1() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.qvideo_skin_comment_tag_top);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        return drawable;
    }

    private void r1(QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.R;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mFeedId, feedCloudMeta$StFeed.f398449id.get()) && qCircleCommentPraiseUpdateEvent.mType == 1 && (feedCloudMeta$StComment = this.S) != null && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mCommentId, feedCloudMeta$StComment.f398447id.get())) {
            if (QCirclePluginUtil.isOwner(this.R.poster.get())) {
                this.S.likeInfo.ownerStatus.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            }
            this.S.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            this.S.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
            G1();
        }
    }

    private void s1(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (qCircleCommentUpdateEvent.eventStatus == 4 && (feedCloudMeta$StComment = qCircleCommentUpdateEvent.comment) != null && this.S != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), this.S.f398447id.get())) {
            E1(this.S.f398447id.get());
            L0(this.R, this.U);
        }
    }

    private void t1(String str) {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.S;
        if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.goodsInfo.has() && TextUtils.equals(str, this.S.goodsInfo.goodsID.get()) && !TextUtils.isEmpty(this.S.goodsInfo.goodsURL.get())) {
            com.tencent.biz.qqcircle.helpers.l.e().i(this.S.goodsInfo.goodsURL.get());
            F1();
        }
    }

    private void u1(QFSFakeCommentSendEvent qFSFakeCommentSendEvent) {
        if (qFSFakeCommentSendEvent.getTargetFeed() != null && this.R != null && qFSFakeCommentSendEvent.getFakeComment() != null && TextUtils.equals(qFSFakeCommentSendEvent.getTargetFeed().f398449id.get(), this.R.f398449id.get())) {
            this.R = qFSFakeCommentSendEvent.getTargetFeed();
            FeedCloudMeta$StComment fakeComment = qFSFakeCommentSendEvent.getFakeComment();
            this.S = fakeComment;
            this.T = fakeComment.postUser;
            updateView();
        }
    }

    private void updateView() {
        x1();
        this.I.setVisibility(0);
        H1();
        I1();
        G1();
        l1();
    }

    private void v1() {
        if (!this.T.has()) {
            return;
        }
        int i3 = this.T.label.get();
        if (i3 != 1) {
            if (i3 == 3) {
                cm.i(m0());
                return;
            }
            return;
        }
        cm.h(m0());
    }

    private void w1() {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.S;
        if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.goodsInfo.has() && !TextUtils.isEmpty(this.S.goodsInfo.goodsURL.get())) {
            com.tencent.biz.qqcircle.helpers.l.e().i(this.S.goodsInfo.goodsURL.get());
            F1();
        }
    }

    private void x1() {
        if (this.I != null) {
            return;
        }
        View view = this.C;
        this.I = (LinearLayout) view.findViewById(R.id.b3r);
        this.J = (QCircleAvatarView) view.findViewById(R.id.a2o);
        this.K = (QCircleAsyncTextView) view.findViewById(R.id.fxo);
        this.L = (ImageView) view.findViewById(R.id.yce);
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView = (QFSSearchCommentAsyncTextView) view.findViewById(R.id.fxm);
        this.M = qFSSearchCommentAsyncTextView;
        qFSSearchCommentAsyncTextView.setSpecialClickAreaColor(R.color.qui_common_text_link_selector);
        this.N = (QFSCommentPraiseLayout) view.findViewById(R.id.f26700e9);
        this.P = (ImageView) view.findViewById(R.id.f87184to);
        this.Q = (ImageView) view.findViewById(R.id.f370916b);
        this.I.setVisibility(8);
        this.N.I();
        this.f428703a0 = com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.d4z);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.M.seOnClickableImageSpanListener(new RFWAsyncRichTextView.OnClickableImageSpanListener() { // from class: q80.g
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickableImageSpanListener
            public final void onClick(int i3, String str) {
                j.this.y1(i3, str);
            }
        });
        this.M.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: q80.h
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
            public final void onClick(String str) {
                j.this.z1(str);
            }
        });
        this.M.showEllipseEndImageSpan(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1(int i3, String str) {
        if (i3 == 0) {
            t1(str);
        } else if (i3 == 59) {
            w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1(String str) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(str);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.U = i3;
        this.R = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed != null && !feedCloudMeta$StFeed.vecComment.get().isEmpty() && feedCloudMeta$StFeed.vecComment.get(0).f398447id.has()) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = feedCloudMeta$StFeed.vecComment.get(0);
            this.S = feedCloudMeta$StComment;
            this.T = feedCloudMeta$StComment.postUser;
            this.f428704b0 = false;
            updateView();
            return;
        }
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QLog.w("QFSSearchFeedResultOutCommentPresenter", 1, "[onBindData] data should not be null.");
    }

    @Override // e80.h
    public void H() {
        L0(this.R, this.U);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        arrayList.add(QFSFakeCommentSendEvent.class);
        arrayList.add(QCircleCommentUpdateEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.a2o && id5 != R.id.fxo) {
            if (id5 == R.id.yce) {
                v1();
            } else if (id5 == R.id.fxm || id5 == R.id.b3r) {
                D1();
                k1(1);
            }
        } else {
            B1();
            k1(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            r1((QCircleCommentPraiseUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFakeCommentSendEvent) {
            u1((QFSFakeCommentSendEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleCommentUpdateEvent) {
            s1((QCircleCommentUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultOutCommentPresenter";
    }
}
