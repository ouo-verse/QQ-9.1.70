package qc0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class n extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected Object E;
    private QCircleAvatarView F;
    private View G;
    private TextView H;
    private TextView I;
    private QFSFollowView J;
    private ImageView K;
    private ImageView L;
    private TextView M;
    private RelativeLayout N;
    private int P;
    QQCircleBase$StUserBusiData Q;
    private Size R;
    private c S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            n.this.u(view.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void onClick(int i3);
    }

    public n(View view) {
        super(view);
        t(view);
        s(view);
        this.R = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d4r);
    }

    private void D(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        if (!TextUtils.isEmpty(feedCloudMeta$StUserRecomInfo.user.f398463id.get())) {
            this.F.setUser(feedCloudMeta$StUserRecomInfo.user.get(), this.R);
            this.G.setVisibility(0);
        } else {
            this.G.setVisibility(8);
        }
        if (this.L != null && feedCloudMeta$StUserRecomInfo.isNew.get()) {
            this.L.setVisibility(0);
            this.F.setIsAuth(0);
        } else {
            ImageView imageView = this.L;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private void E(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        String str = feedCloudMeta$StUserRecomInfo.recomReason.get();
        if (!TextUtils.isEmpty(str)) {
            this.I.setText(str);
        } else {
            this.I.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1916945h));
        }
    }

    private void H(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        this.H.setText(feedCloudMeta$StUserRecomInfo.user.nick.get());
        D(feedCloudMeta$StUserRecomInfo);
        E(feedCloudMeta$StUserRecomInfo);
        z(feedCloudMeta$StUserRecomInfo.user);
        q(608, 1);
    }

    private void p(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        if (feedCloudMeta$StUserRecomInfo == null) {
            QLog.d("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] info should not be null.");
        } else {
            H(feedCloudMeta$StUserRecomInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, int i16) {
        Object obj = this.E;
        if (!(obj instanceof FeedCloudMeta$StUserRecomInfo)) {
            return;
        }
        FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo = (FeedCloudMeta$StUserRecomInfo) obj;
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
        dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(feedCloudMeta$StUserRecomInfo.user.f398463id.get()).setExt1(String.valueOf(this.Q.feedNum.get())).setExt2(String.valueOf(feedCloudMeta$StUserRecomInfo.user.fansCount.get())).setPosition(this.P).setPageId(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED).setActTime(System.currentTimeMillis());
        if (feedCloudMeta$StUserRecomInfo.busiReport.has()) {
            dataBuilder.setReportInfo(feedCloudMeta$StUserRecomInfo.busiReport.get().toByteArray());
        }
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private void r(View view, String str, Map<String, String> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
    }

    private void s(View view) {
        this.K.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.N.setOnClickListener(new a());
    }

    private void t(View view) {
        this.G = view.findViewById(R.id.f32380tl);
        this.F = (QCircleAvatarView) view.findViewById(R.id.f32370tk);
        this.H = (TextView) view.findViewById(R.id.f32440tr);
        this.I = (TextView) view.findViewById(R.id.f32410to);
        this.J = (QFSFollowView) view.findViewById(R.id.f32430tq);
        this.K = (ImageView) view.findViewById(R.id.f32390tm);
        this.L = (ImageView) view.findViewById(R.id.y6_);
        this.M = (TextView) view.findViewById(R.id.zrw);
        this.N = (RelativeLayout) view.findViewById(R.id.f71563oh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context) {
        Object obj = this.E;
        if (!(obj instanceof FeedCloudMeta$StUserRecomInfo)) {
            QLog.d("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] current data type not is StUserRecomInfo.");
            return;
        }
        FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo = (FeedCloudMeta$StUserRecomInfo) obj;
        if (TextUtils.isEmpty(feedCloudMeta$StUserRecomInfo.user.f398463id.get())) {
            QLog.d("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] current user id not is empty.");
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(feedCloudMeta$StUserRecomInfo.user.f398463id.get());
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.J.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void x(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_target_qq", feedCloudMeta$StUserRecomInfo.user.f398463id.get());
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudMeta$StUserRecomInfo.recomReason.get());
        if (!TextUtils.isEmpty(feedCloudMeta$StUserRecomInfo.datongJsonData.get())) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudMeta$StUserRecomInfo.datongJsonData.get());
        }
        this.J.setItemReportListener(new b(hashMap));
    }

    private void z(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        int i3;
        int i16;
        if (feedCloudMeta$StUser == null) {
            QLog.d("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "[setFollowImgStatus] stUser should not be null, id: ");
            return;
        }
        this.J.setFollowedDismiss(false);
        this.J.setUserData(feedCloudMeta$StUser);
        if (QCircleFollowManager.getInstance().hasUin(feedCloudMeta$StUser.f398463id.get())) {
            i3 = QCircleFollowManager.getInstance().getUinFollowed(feedCloudMeta$StUser.f398463id.get()).intValue();
        } else {
            i3 = feedCloudMeta$StUser.followState.get();
        }
        QFSFollowView qFSFollowView = this.J;
        if (QCirclePluginUtil.isFollow(i3)) {
            i16 = R.string.f1905342c;
        } else {
            i16 = R.string.f19049429;
        }
        qFSFollowView.setText(i16);
        this.J.setOnClickListener(new View.OnClickListener() { // from class: qc0.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.this.v(view);
            }
        });
    }

    public void A(c cVar) {
        this.S = cVar;
    }

    public void B(int i3) {
        this.P = i3;
    }

    public void C(boolean z16) {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null && this.M != null) {
            if (z16) {
                relativeLayout.setVisibility(4);
                this.M.setVisibility(0);
                return;
            } else {
                relativeLayout.setVisibility(0);
                this.M.setVisibility(4);
                return;
            }
        }
        QLog.d("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "container is null");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f32440tr) {
            q(608, 11);
            u(view.getContext());
        } else if (id5 == R.id.f32370tk) {
            q(608, 10);
            u(view.getContext());
        } else if (id5 == R.id.f32390tm) {
            q(609, 3);
            this.S.onClick(this.P);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void w(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        if (feedCloudMeta$StUserRecomInfo == null) {
            return;
        }
        VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_AUTHOR_UIN, feedCloudMeta$StUserRecomInfo.user.f398463id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUserRecomInfo.user.f398463id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudMeta$StUserRecomInfo.recomReason.get());
        if (!TextUtils.isEmpty(feedCloudMeta$StUserRecomInfo.datongJsonData.get())) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudMeta$StUserRecomInfo.datongJsonData.get());
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_AUTHOR_INDEX, String.valueOf(this.P));
        VideoReport.setElementParams(this.itemView, hashMap);
        VideoReport.setElementReuseIdentifier(this.itemView, String.valueOf(this.P));
        r(this.K, "em_xsj_close_button", hashMap);
        r(this.H, "em_xsj_author_name", hashMap);
        r(this.F, "em_xsj_author_avatar", hashMap);
        r(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_RECOM_BUTTON, hashMap);
        x(feedCloudMeta$StUserRecomInfo);
    }

    public void y(Object obj) {
        if (!(obj instanceof FeedCloudMeta$StUserRecomInfo)) {
            QLog.w("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "[setData] data is not StUserRecomInfo type.");
            return;
        }
        this.E = obj;
        this.J.setVisibility(0);
        FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo = (FeedCloudMeta$StUserRecomInfo) this.E;
        this.Q = QCircleHostUtil.getUserExtraData(feedCloudMeta$StUserRecomInfo.user);
        QLog.d("PYMK-QCirclePYMKRecommendItemViewHolder", 1, "user recom info: " + feedCloudMeta$StUserRecomInfo.user.nick);
        p(feedCloudMeta$StUserRecomInfo);
        w(feedCloudMeta$StUserRecomInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements QFSFollowView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f428838a;

        b(Map map) {
            this.f428838a = map;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            VideoReport.setElementId(n.this.J, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
            HashMap hashMap = new HashMap(this.f428838a);
            hashMap.put("xsj_action_type", "cancel");
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, n.this.J, hashMap);
            n.this.q(608, 3);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            if (i3 == 0) {
                VideoReport.setElementId(n.this.J, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
                HashMap hashMap = new HashMap(this.f428838a);
                hashMap.put("xsj_action_type", "follow");
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, n.this.J, hashMap);
                n.this.q(608, 2);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }
}
