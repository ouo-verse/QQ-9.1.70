package qc0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleDitto$StPymkItemInfoBizData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends QCircleRecommendBaseAdapter.a implements View.OnClickListener {
    private QCircleAvatarView M;
    private View N;
    private TextView P;
    private TextView Q;
    private QFSFollowView R;
    private ImageView S;
    private ImageView T;
    private TextView U;
    private LinearLayout V;
    private ImageView W;
    private TextView X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private Size f428816a0;

    /* renamed from: b0, reason: collision with root package name */
    private final QFSFollowView.d f428817b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: qc0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnClickListenerC11070a implements View.OnClickListener {
        ViewOnClickListenerC11070a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.K(view.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleDitto$StButton f428819d;

        b(QQCircleDitto$StButton qQCircleDitto$StButton) {
            this.f428819d = qQCircleDitto$StButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.L(this.f428819d)) {
                QCircleHostLauncher.doJumpAction(view.getContext(), this.f428819d.jumpUrl.get());
            } else {
                a.this.R.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(View view) {
        super(view);
        this.f428817b0 = new c();
        J(view);
        this.R.setDtParentEmId(QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CARD);
        I(view);
        this.f428816a0 = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d4q);
    }

    private void A() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.H;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[closeItemAction] feed should not be null.");
            return;
        }
        M(feedCloudMeta$StFeed);
        N(feedCloudMeta$StFeed);
        C(609, 3);
    }

    private QCircleLpReportDc05501.DataBuilder B(String str) {
        return ua0.c.a(this.H).setToUin(str).setIndex(this.I).setContainerSeq(this.F).setPageId(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i3, int i16) {
        Object obj = this.E;
        if (obj != null && (obj instanceof QQCircleDitto$StItemInfo)) {
            QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = (QQCircleDitto$StItemInfo) obj;
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qQCircleDitto$StItemInfo.f429300id.get()).setExt1(String.valueOf(this.Z)).setExt2(this.Y).setPosition(this.F + 1).setPageId(this.K).setActTime(System.currentTimeMillis());
            if (qQCircleDitto$StItemInfo.busiReport.has()) {
                dataBuilder.setReportInfo(qQCircleDitto$StItemInfo.busiReport.get().toByteArray());
            }
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    private void D(View view, String str, Map<String, Object> map) {
        if (this.E == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
        VideoReport.setElementReuseIdentifier(view, str + view.hashCode() + this.E.hashCode());
    }

    private void E(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTAINER_POSITION, Integer.valueOf(this.F + 1));
        buildElementParams.put("xsj_target_qq", qQCircleDitto$StItemInfo.f429300id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_BOX);
        if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.datongJsonData.get())) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleDitto$StItemInfo.datongJsonData.get());
        }
        D(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CARD, buildElementParams);
        D(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR, buildElementParams);
        D(this.P, "em_xsj_author_name", buildElementParams);
        D(this.R, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, buildElementParams);
        D(this.S, "em_xsj_close_button", buildElementParams);
    }

    private void H(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            R();
        }
    }

    private void I(View view) {
        this.R.setItemReportListener(this.f428817b0);
        this.S.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.P.setOnClickListener(this);
        view.setOnClickListener(new ViewOnClickListenerC11070a());
    }

    private void J(View view) {
        this.N = view.findViewById(R.id.f32380tl);
        this.M = (QCircleAvatarView) view.findViewById(R.id.f32370tk);
        this.P = (TextView) view.findViewById(R.id.f32440tr);
        this.Q = (TextView) view.findViewById(R.id.f32410to);
        this.R = (QFSFollowView) view.findViewById(R.id.f32430tq);
        this.S = (ImageView) view.findViewById(R.id.f32390tm);
        this.T = (ImageView) view.findViewById(R.id.y6_);
        this.U = (TextView) view.findViewById(R.id.f112596oc);
        this.V = (LinearLayout) view.findViewById(R.id.yqn);
        this.W = (ImageView) view.findViewById(R.id.f165969dy0);
        this.X = (TextView) view.findViewById(R.id.k9e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Context context) {
        Object obj = this.E;
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] current data type not is StItemInfo.");
            return;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = (QQCircleDitto$StItemInfo) obj;
        String str = qQCircleDitto$StItemInfo.f429300id.get();
        if (TextUtils.isEmpty(str)) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] current user id not is empty.");
            return;
        }
        O(B(str).setActionType(3).setSubActionType(2).setFeedType1(3).setFeedType2(1));
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(qQCircleDitto$StItemInfo.f429300id.get());
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            qCircleInitBean.setFromReportBean(reportBean.m466clone());
        } else {
            QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] report bean is null, error: ", new NullPointerException());
        }
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L(QQCircleDitto$StButton qQCircleDitto$StButton) {
        if (!qQCircleDitto$StButton.name.get().equals(this.R.getContext().getString(R.string.f19049429)) && TextUtils.isEmpty(qQCircleDitto$StButton.jumpUrl.get())) {
            return true;
        }
        return false;
    }

    private void M(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleRecommendBaseAdapter qCircleRecommendBaseAdapter = this.J;
        if (qCircleRecommendBaseAdapter == null) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[closeItemAction] adapter should not be null.");
            return;
        }
        qCircleRecommendBaseAdapter.l0(this.E, 1);
        int num_backgournd_icon = this.J.getNUM_BACKGOURND_ICON();
        String str = feedCloudMeta$StFeed.f398449id.get();
        if (num_backgournd_icon <= 0) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[removeItemAndNotify] adapter delete success and count is empty, delete feed id: ", str);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(str, 3));
        } else {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[removeItemAndNotify] adapter delete success, delete feed id:", str);
        }
    }

    private void N(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Object obj = this.E;
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[reportRemoveItem] data type not is item info.");
            return;
        }
        String str = ((QQCircleDitto$StItemInfo) obj).f429300id.get();
        O(B(str).setExt3(String.valueOf(feedCloudMeta$StFeed.createTime)).setActionType(65).setSubActionType(1).setFeedType1(3).setFeedType2(1));
    }

    private void O(QCircleLpReportDc05501.DataBuilder dataBuilder) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(dataBuilder));
    }

    private void P(QQCircleDitto$StButton qQCircleDitto$StButton, String str) {
        if (qQCircleDitto$StButton == null) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[setFollowImgStatus] button should not be null, id: ", str);
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        this.R.setFollowedDismiss(false);
        feedCloudMeta$StUser.f398463id.set(str);
        feedCloudMeta$StUser.followState.set(QCirclePluginUtil.getBottonFollowStatus(qQCircleDitto$StButton.buttonValue.get()));
        this.R.setUserData(feedCloudMeta$StUser);
        this.R.setText(qQCircleDitto$StButton.name.get());
        this.R.setOnClickListener(new b(qQCircleDitto$StButton));
    }

    private void Q() {
        List<Integer> list;
        boolean z16;
        boolean z17;
        boolean z18;
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
        if (z16 && z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        ImageView imageView = this.S;
        if (imageView == null) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[setShowCloseButton] close button should not be null.");
            return;
        }
        if (!z18) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void R() {
        ImageView imageView = this.S;
        if (imageView == null) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[updateContainerBackground] close button should not be null.");
        } else {
            imageView.setVisibility(0);
        }
    }

    private void T(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData) {
        if (!TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            this.M.setUser(qQCircleDitto$StPymkItemInfoBizData.recomUser.get(), this.f428816a0);
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
        if (this.T != null && qQCircleDitto$StPymkItemInfoBizData.isNew.get()) {
            this.T.setVisibility(0);
            this.M.setIsAuth(0);
        } else {
            ImageView imageView = this.T;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private void U(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo.des.get() != null && qQCircleDitto$StItemInfo.des.size() > 0) {
            this.Q.setText(qQCircleDitto$StItemInfo.des.get().get(0));
            this.Q.setVisibility(0);
        } else {
            this.Q.setVisibility(4);
        }
    }

    private void W(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData, QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        this.P.setText(qQCircleDitto$StItemInfo.name.get());
        this.U.setVisibility(8);
        this.V.setVisibility(8);
        T(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData);
        j jVar = j.f428831a;
        if (jVar.d()) {
            if (jVar.e()) {
                Z(qQCircleDitto$StPymkItemInfoBizData, qQCircleBase$StUserBusiData);
            }
        } else {
            Y(qQCircleDitto$StPymkItemInfoBizData, qQCircleBase$StUserBusiData);
        }
        U(qQCircleDitto$StItemInfo);
        P(qQCircleDitto$StItemInfo.buttonInfo.get(), qQCircleDitto$StItemInfo.f429300id.get());
    }

    private void Y(@NonNull QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData, @NonNull QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        int i3;
        if (qQCircleBase$StUserBusiData.feedNum.get() != 0 && qQCircleBase$StUserBusiData.fansNum.get() != 0) {
            String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184653mg);
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184663mh);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) a16);
            int length = spannableStringBuilder.length();
            String f16 = com.tencent.biz.qqcircle.immersive.utils.r.f(qQCircleBase$StUserBusiData.feedNum.get());
            this.Z = f16;
            spannableStringBuilder.append((CharSequence) f16);
            spannableStringBuilder.append((CharSequence) "    ");
            spannableStringBuilder.append((CharSequence) a17);
            spannableStringBuilder.length();
            this.Y = String.valueOf(qQCircleBase$StUserBusiData.fansNum.get());
            spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.immersive.utils.r.f(qQCircleBase$StUserBusiData.fansNum.get()));
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_common_text_primary_dot);
            drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(2.0f), ImmersiveUtils.dpToPx(2.0f));
            spannableStringBuilder.setSpan(new nb0.d(drawable), this.Z.length() + length + 2, length + this.Z.length() + 3, 33);
            this.U.setText(spannableStringBuilder);
            this.U.setVisibility(0);
            return;
        }
        if (qQCircleDitto$StPymkItemInfoBizData.recomUser.sex.has() && !TextUtils.isEmpty(qQCircleDitto$StPymkItemInfoBizData.recomUser.location.get())) {
            this.V.setVisibility(0);
            ImageView imageView = this.W;
            if (qQCircleDitto$StPymkItemInfoBizData.recomUser.sex.get() == 1) {
                i3 = R.drawable.kke;
            } else {
                i3 = R.drawable.f161627kj0;
            }
            imageView.setImageResource(i3);
            this.X.setText(qQCircleDitto$StPymkItemInfoBizData.recomUser.location.get());
            return;
        }
        this.U.setVisibility(0);
        this.U.setText(qQCircleDitto$StPymkItemInfoBizData.backupContent.get());
    }

    private void Z(@NonNull QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData, @NonNull QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        int i3;
        if (qQCircleBase$StUserBusiData.fansNum.get() != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "\u7c89\u4e1d ");
            spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.immersive.utils.r.f(qQCircleBase$StUserBusiData.fansNum.get()));
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), 0, 2, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 2, spannableStringBuilder.length(), 33);
            this.U.setText(spannableString);
            this.U.setVisibility(0);
            return;
        }
        if (qQCircleDitto$StPymkItemInfoBizData.recomUser.sex.has() && !TextUtils.isEmpty(qQCircleDitto$StPymkItemInfoBizData.recomUser.location.get())) {
            this.V.setVisibility(0);
            ImageView imageView = this.W;
            if (qQCircleDitto$StPymkItemInfoBizData.recomUser.sex.get() == 1) {
                i3 = R.drawable.kke;
            } else {
                i3 = R.drawable.f161627kj0;
            }
            imageView.setImageResource(i3);
            this.X.setText(qQCircleDitto$StPymkItemInfoBizData.recomUser.location.get());
            return;
        }
        this.U.setVisibility(0);
        this.U.setText("\u5173\u6ce8\u66f4\u7cbe\u5f69");
    }

    private void z(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo == null) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] info should not be null.");
            return;
        }
        QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData = new QQCircleDitto$StPymkItemInfoBizData();
        try {
            qQCircleDitto$StPymkItemInfoBizData.mergeFrom(qQCircleDitto$StItemInfo.bizData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] error: ", e16);
        }
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
        try {
            qQCircleBase$StUserBusiData.mergeFrom(qQCircleDitto$StPymkItemInfoBizData.recomUser.busiData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e17) {
            QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] error: ", e17);
        }
        W(qQCircleDitto$StItemInfo, qQCircleDitto$StPymkItemInfoBizData, qQCircleBase$StUserBusiData);
        String str = qQCircleDitto$StItemInfo.f429300id.get();
        if (TextUtils.isEmpty(str)) {
            QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] user id: ", str);
        } else {
            C(608, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f32440tr) {
            C(608, 11);
            K(view.getContext());
        } else if (id5 == R.id.f32370tk) {
            C(608, 10);
            K(view.getContext());
        } else if (id5 == R.id.f32390tm) {
            A();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.a
    public void q(Object obj, int i3, int i16) {
        if (!(obj instanceof QQCircleDitto$StItemInfo)) {
            QLog.w("QCirclePYMKRecommendItemViewHolder", 1, "[setData] data not is StItemInfo type.");
            return;
        }
        this.E = obj;
        this.F = i3;
        Q();
        this.R.setVisibility(0);
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = (QQCircleDitto$StItemInfo) this.E;
        z(qQCircleDitto$StItemInfo);
        QLog.d("QCirclePYMKRecommendItemViewHolder", 4, "[setData] style:", Integer.valueOf(i16));
        if (i16 == 50002) {
            H(qQCircleDitto$StItemInfo);
        }
        E(qQCircleDitto$StItemInfo);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements QFSFollowView.d {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            a.this.C(608, 3);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            int i16;
            if (i3 > 0) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            a.this.C(608, i16);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }
}
