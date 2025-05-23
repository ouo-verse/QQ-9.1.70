package qc0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleDitto$StPymkItemInfoBizData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends QCircleRecommendBaseAdapter.a implements View.OnClickListener {
    private LinearLayout M;
    private QCircleAvatarView N;
    private TextView P;
    private TextView Q;
    private QFSFollowView R;
    private ImageView S;
    private ImageView T;
    private final Size U;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.E(view.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.R.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleDitto$StItemInfo f428827d;

        c(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
            this.f428827d = qQCircleDitto$StItemInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.z(view.getContext(), this.f428827d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(View view) {
        super(view);
        D(view);
        C(view);
        this.U = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d4q);
    }

    private void A() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.H;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[closeItemAction] feed should not be null.");
        } else {
            I(feedCloudMeta$StFeed);
        }
    }

    private void B(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            this.N.setVisibility(0);
            this.P.setVisibility(0);
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.S.setVisibility(0);
            this.T.setVisibility(8);
            return;
        }
        this.N.setVisibility(8);
        this.P.setVisibility(8);
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.T.setVisibility(0);
        L(qQCircleDitto$StItemInfo);
    }

    private void C(View view) {
        this.S.setOnClickListener(this);
        this.N.setOnClickListener(this);
        view.setOnClickListener(new a());
    }

    private void D(View view) {
        this.M = (LinearLayout) view.findViewById(R.id.f47711y1);
        this.N = (QCircleAvatarView) view.findViewById(R.id.f47691xz);
        this.P = (TextView) view.findViewById(R.id.f47761y6);
        this.Q = (TextView) view.findViewById(R.id.f47721y2);
        this.R = (QFSFollowView) view.findViewById(R.id.f47731y3);
        this.S = (ImageView) view.findViewById(R.id.f47701y0);
        this.T = (ImageView) view.findViewById(R.id.f47741y4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Context context) {
        Object obj = this.E;
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[jumpPersonDetailPage] current data type not is StItemInfo.");
            return;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = (QQCircleDitto$StItemInfo) obj;
        if (TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[jumpPersonDetailPage] current user id not is empty.");
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(qQCircleDitto$StItemInfo.f429300id.get());
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            qCircleInitBean.setFromReportBean(reportBean.m466clone());
        } else {
            QLog.e("QFSNewUserPYMKGuideItemViewHolder", 1, "[jumpPersonDetailPage] report bean is null, error: ", new NullPointerException());
        }
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    private void H(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        if (qQCircleDitto$StPymkItemInfoBizData != null && !TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = qQCircleDitto$StPymkItemInfoBizData.recomUser.get();
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
            if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.datongJsonData.get())) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleDitto$StItemInfo.datongJsonData.get());
            }
            VideoReport.setElementId(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CARD);
            VideoReport.setElementParams(this.M, buildElementParams);
            VideoReport.setElementId(this.N, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_AVATAR);
            VideoReport.setElementParams(this.N, buildElementParams);
            VideoReport.setElementId(this.R, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_FOLLOW_BUTTON);
            VideoReport.setElementParams(this.R, buildElementParams);
            VideoReport.setElementId(this.S, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CLOSE_BUTTON);
            VideoReport.setElementParams(this.S, buildElementParams);
        }
    }

    private void I(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleRecommendBaseAdapter qCircleRecommendBaseAdapter = this.J;
        if (qCircleRecommendBaseAdapter == null) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[closeItemAction] adapter should not be null.");
            return;
        }
        qCircleRecommendBaseAdapter.l0(this.E, 1);
        int itemCount = this.J.getItemCount();
        String str = feedCloudMeta$StFeed.f398449id.get();
        if (itemCount <= 0) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[removeItemAndNotify] adapter delete success and count is empty, delete feed id: ", str);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(str, 3));
        } else {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[removeItemAndNotify] adapter delete success, delete feed id:", str);
        }
    }

    private void J() {
        List<Integer> list;
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (this.S == null) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[setShowCloseButton] close button should not be null.");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.H;
        if (feedCloudMeta$StFeed == null) {
            list = null;
        } else {
            list = feedCloudMeta$StFeed.opMask2.get();
        }
        int i3 = 0;
        if (list != null && list.contains(6)) {
            z16 = true;
        } else {
            z16 = false;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.H;
        if (feedCloudMeta$StFeed2 != null && !QCirclePluginUtil.isOwner(feedCloudMeta$StFeed2.poster.get())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 || !z17) {
            z18 = false;
        }
        ImageView imageView = this.S;
        if (!z18) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void K(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        if (this.R == null) {
            return;
        }
        if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            this.R.setUserData(qQCircleDitto$StPymkItemInfoBizData.recomUser.get());
        }
        this.R.setFollowedDismiss(false);
        this.R.setFollowedDrawable(R.drawable.knf);
        this.R.setFollowedTextColor(R.color.czi);
        this.R.setOnClickListener(new b());
    }

    private void L(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("pymk_userguide_lastbg")).setRequestWidth(cx.a(279.0f)).setRequestHeight(cx.a(306.0f)).setTargetView(this.T));
        this.T.setClickable(true);
        this.T.setOnClickListener(new c(qQCircleDitto$StItemInfo));
    }

    private void M(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            this.N.setUser(qQCircleDitto$StPymkItemInfoBizData.recomUser.get(), this.U);
        }
    }

    private void N(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo.des.get() != null && qQCircleDitto$StItemInfo.des.size() > 0) {
            this.Q.setText(qQCircleDitto$StItemInfo.des.get().get(0));
            this.Q.setVisibility(0);
        } else {
            this.Q.setVisibility(8);
        }
    }

    private void O(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        this.P.setText(qQCircleDitto$StItemInfo.name.get());
        M(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
        N(qQCircleDitto$StItemInfo);
        K(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
        H(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
    }

    private void y(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QFSNewUserPYMKGuideItemViewHolder", 1, "[bindPersonInfo] info should not be null.");
            return;
        }
        QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData = new QQCircleDitto$StPymkItemInfoBizData();
        try {
            qQCircleDitto$StPymkItemInfoBizData.mergeFrom(qQCircleDitto$StItemInfo.bizData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSNewUserPYMKGuideItemViewHolder", 1, "[bindPersonInfo] error: ", e16);
        }
        O(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData = new QQCircleDitto$StPymkItemInfoBizData();
        try {
            qQCircleDitto$StPymkItemInfoBizData.mergeFrom(qQCircleDitto$StItemInfo.bizData.get().toByteArray());
            com.tencent.biz.qqcircle.launcher.c.o0(context, qQCircleDitto$StPymkItemInfoBizData.newUserPageMoreButton.jumpUrl.get(), null, -1);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSNewUserPYMKGuideItemViewHolder", 1, "[JumpToMoreInterestURL] error: ", e16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f47691xz) {
            E(view.getContext());
        } else if (id5 == R.id.f47701y0) {
            A();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.a
    public void q(Object obj, int i3, int i16) {
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.w("QFSNewUserPYMKGuideItemViewHolder", 1, "[setData] data not is StItemInfo type.");
            return;
        }
        this.E = obj;
        this.F = i3;
        J();
        this.R.setVisibility(0);
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = (QQCircleDitto$StItemInfo) this.E;
        y(qQCircleDitto$StItemInfo);
        B(qQCircleDitto$StItemInfo);
        QLog.d("QFSNewUserPYMKGuideItemViewHolder", 4, "[setData] style:", Integer.valueOf(i16));
    }
}
