package ua0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSFastShareUserInfo;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.requests.QFSDoShareRequest;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$ShareItem;
import feedcloud.FeedCloudWrite$StDoShareRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import uq3.k;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private QCircleExtraTypeInfo f438617a;

    /* renamed from: b, reason: collision with root package name */
    private int f438618b;

    /* renamed from: c, reason: collision with root package name */
    private int f438619c;

    /* renamed from: d, reason: collision with root package name */
    private int f438620d;

    /* renamed from: e, reason: collision with root package name */
    private int f438621e;

    /* renamed from: f, reason: collision with root package name */
    private int f438622f;

    /* renamed from: g, reason: collision with root package name */
    private String f438623g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoShareRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoShareRsp feedCloudWrite$StDoShareRsp) {
            if (z16 && j3 == 0 && feedCloudWrite$StDoShareRsp != null) {
                QLog.d("RHF-QCircleShareReportHelper", 1, "[sendShareSuccessReq] share request success.");
            } else {
                QLog.e("RHF-QCircleShareReportHelper", 1, "[sendShareSuccessReq] handleRsp isSuc:", Boolean.valueOf(z16), ",retCode:", Long.valueOf(j3), ",errMsg:", str);
            }
        }
    }

    d(int i3, int i16) {
        this.f438620d = i3;
        this.f438621e = i16;
    }

    private static void B(QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        if (qCircleExtraTypeInfo != null && qCircleExtraTypeInfo.mFeed != null && forwardInfoEntity != null && !TextUtils.isEmpty(forwardInfoEntity.getForwardUin())) {
            ArrayList arrayList = new ArrayList();
            String forwardUin = forwardInfoEntity.getForwardUin();
            if (forwardUin.contains(",")) {
                for (String str : forwardUin.split(",")) {
                    if (!TextUtils.isEmpty(str)) {
                        FeedCloudWrite$ShareItem feedCloudWrite$ShareItem = new FeedCloudWrite$ShareItem();
                        feedCloudWrite$ShareItem.to_uin.set(str);
                        feedCloudWrite$ShareItem.type.set(g(forwardInfoEntity.getForwardUinType()));
                        arrayList.add(feedCloudWrite$ShareItem);
                    }
                }
            } else {
                FeedCloudWrite$ShareItem feedCloudWrite$ShareItem2 = new FeedCloudWrite$ShareItem();
                feedCloudWrite$ShareItem2.to_uin.set(forwardUin);
                feedCloudWrite$ShareItem2.type.set(g(forwardInfoEntity.getForwardUinType()));
                if (!TextUtils.isEmpty(forwardUin)) {
                    arrayList.add(feedCloudWrite$ShareItem2);
                }
            }
            D(arrayList, qCircleExtraTypeInfo.mFeed.f398449id.get());
        }
    }

    public static void C(String str, String str2, int i3) {
        if (i3 == 10008) {
            QLog.d("RHF-QCircleShareReportHelper", 1, "[saveRecentShare] UIN_TYPE_TEMP_CIRCLE don't need save.");
            return;
        }
        String a16 = cu.a(str, ",");
        String a17 = cu.a(str2, ",");
        if (!TextUtils.isEmpty(a16) && !a16.contains(",") && !TextUtils.isEmpty(a17) && !a17.contains(",")) {
            String transferShareInfoToString = QFSFastShareUserInfo.transferShareInfoToString(new QFSFastShareUserInfo(a17, a16, i3));
            if (!TextUtils.isEmpty(transferShareInfoToString)) {
                k.a().p(QFSFastShareUserInfo.SP_KEY_FAST_SHARE_USER_INFO, transferShareInfoToString);
                return;
            }
            return;
        }
        QLog.e("RHF-QCircleShareReportHelper", 1, "ForwardEntranceActivity [saveRecentShare] lastUin or lastUinName is error. lastUin = " + a16 + ", lastUinName =" + a17 + ", lastUinType =" + i3 + ", uin =" + str + ", name =" + str2);
    }

    public static void D(List<FeedCloudWrite$ShareItem> list, String str) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            VSNetworkHelper.getInstance().sendRequest(new QFSDoShareRequest(list, str), new a());
        }
    }

    public static d a(int i3, int i16) {
        return new d(i3, i16);
    }

    private int b(int i3) {
        if (i3 == 0 || i3 != 1) {
            return 1;
        }
        return 2;
    }

    private static QCircleExtraTypeInfo c(QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo qCircleForwardExtraTypeInfo) {
        if (qCircleForwardExtraTypeInfo == null) {
            return null;
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.mPlayScene = qCircleForwardExtraTypeInfo.mPlayScene;
        qCircleExtraTypeInfo.mDataPosition = qCircleForwardExtraTypeInfo.mDataPosition;
        qCircleExtraTypeInfo.mFeed = qCircleForwardExtraTypeInfo.feed;
        qCircleExtraTypeInfo.pageType = qCircleForwardExtraTypeInfo.pageType;
        qCircleExtraTypeInfo.sourceType = qCircleForwardExtraTypeInfo.sourceType;
        qCircleExtraTypeInfo.mCurrentPersonalUin = qCircleForwardExtraTypeInfo.mCurrentPersonalUin;
        qCircleExtraTypeInfo.mGlobalViewModelKey = qCircleForwardExtraTypeInfo.mGlobalViewModelKey;
        qCircleExtraTypeInfo.title = qCircleForwardExtraTypeInfo.title;
        Map<String, Object> map = qCircleForwardExtraTypeInfo.mExtMap;
        if (map != null) {
            qCircleExtraTypeInfo.mReportExtraMap.putAll(map);
        }
        return qCircleExtraTypeInfo;
    }

    public static QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo d(QCircleShareInfo qCircleShareInfo) {
        if (qCircleShareInfo == null) {
            return null;
        }
        QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo qCircleForwardExtraTypeInfo = new QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo();
        Map<String, Object> map = qCircleShareInfo.mDTReportExtMapOnSendSuccess;
        qCircleForwardExtraTypeInfo.mExtMap = map;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = qCircleShareInfo.extraTypeInfo;
        qCircleForwardExtraTypeInfo.feed = qCircleShareInfo.feed;
        if (qCircleExtraTypeInfo == null) {
            return qCircleForwardExtraTypeInfo;
        }
        if (map == null) {
            qCircleForwardExtraTypeInfo.mExtMap = new ConcurrentHashMap();
        }
        qCircleForwardExtraTypeInfo.mExtMap.putAll(qCircleExtraTypeInfo.mReportExtraMap);
        qCircleForwardExtraTypeInfo.mPlayScene = qCircleExtraTypeInfo.mPlayScene;
        qCircleForwardExtraTypeInfo.mDataPosition = qCircleExtraTypeInfo.mDataPosition;
        qCircleForwardExtraTypeInfo.pageType = qCircleExtraTypeInfo.pageType;
        qCircleForwardExtraTypeInfo.sourceType = qCircleExtraTypeInfo.sourceType;
        qCircleForwardExtraTypeInfo.mCurrentPersonalUin = qCircleExtraTypeInfo.mCurrentPersonalUin;
        qCircleForwardExtraTypeInfo.mGlobalViewModelKey = qCircleExtraTypeInfo.mGlobalViewModelKey;
        qCircleForwardExtraTypeInfo.title = qCircleExtraTypeInfo.title;
        return qCircleForwardExtraTypeInfo;
    }

    private String e() {
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.f438617a;
        if (qCircleExtraTypeInfo == null) {
            return "";
        }
        return c.g(qCircleExtraTypeInfo.mReportExtraMap);
    }

    public static String f(int i3) {
        if (i3 == 1) {
            return "groupid:";
        }
        if (i3 == 10014) {
            return "channel:";
        }
        if (i3 == 10008) {
            return "follow_uin:";
        }
        return "uin:";
    }

    public static int g(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 10014) {
            return 2;
        }
        return 0;
    }

    private void h() {
        if (this.f438620d == 57) {
            u();
        } else {
            t();
        }
    }

    private void i(QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        if (forwardInfoEntity != null) {
            this.f438622f = b(forwardInfoEntity.getForwardUinType());
            this.f438623g = forwardInfoEntity.getForwardUin();
        }
        this.f438617a = qCircleExtraTypeInfo;
    }

    private FeedCloudMeta$StFeed j() {
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.f438617a;
        if (qCircleExtraTypeInfo == null) {
            return null;
        }
        return qCircleExtraTypeInfo.mFeed;
    }

    private int k() {
        Integer valueOf;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.f438617a;
        if (qCircleExtraTypeInfo == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(qCircleExtraTypeInfo.mDataPosition);
        }
        return valueOf.intValue();
    }

    private String l() {
        FeedCloudMeta$StFeed j3 = j();
        if (j3 == null) {
            return null;
        }
        return j3.poster.f398463id.get();
    }

    private int m() {
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.f438617a;
        if (qCircleExtraTypeInfo == null) {
            return 0;
        }
        return qCircleExtraTypeInfo.mPlayScene;
    }

    public static void s(String str, @NonNull QCircleForwardInfoReportBean qCircleForwardInfoReportBean) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        List<HostForwardUtils.ForwardInfoEntity> multiShareEntityList = qCircleForwardInfoReportBean.getMultiShareEntityList();
        QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra = qCircleForwardInfoReportBean.getReportExtra();
        int pageId = qCircleForwardInfoReportBean.getPageId();
        int parentPageId = qCircleForwardInfoReportBean.getParentPageId();
        QCircleExtraTypeInfo c16 = c(reportExtra);
        int i3 = 0;
        for (HostForwardUtils.ForwardInfoEntity forwardInfoEntity : multiShareEntityList) {
            if (forwardInfoEntity != null) {
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(forwardInfoEntity.getForwardUin());
                if (sb7.length() > 0) {
                    sb7.append(",");
                }
                sb7.append(f(forwardInfoEntity.getForwardUinType()));
                sb7.append(forwardInfoEntity.getForwardUin());
                if (!TextUtils.isEmpty(forwardInfoEntity.getForwardName())) {
                    if (sb6.length() > 0) {
                        sb6.append(",");
                    }
                    sb6.append(forwardInfoEntity.getForwardName());
                }
                i3 = forwardInfoEntity.getForwardUinType();
                if (!TextUtils.isEmpty(forwardInfoEntity.getForwardUin())) {
                    FeedCloudWrite$ShareItem feedCloudWrite$ShareItem = new FeedCloudWrite$ShareItem();
                    feedCloudWrite$ShareItem.to_uin.set(forwardInfoEntity.getForwardUin());
                    feedCloudWrite$ShareItem.type.set(g(forwardInfoEntity.getForwardUinType()));
                    arrayList.add(feedCloudWrite$ShareItem);
                }
                v(str, pageId, parentPageId, c16, forwardInfoEntity);
            }
        }
        QCircleForwardInfoReportBean qCircleForwardInfoReportBean2 = new QCircleForwardInfoReportBean();
        qCircleForwardInfoReportBean2.setReportExtra(qCircleForwardInfoReportBean.getReportExtra());
        HostForwardUtils.ForwardInfoEntity forwardInfoEntity2 = new HostForwardUtils.ForwardInfoEntity();
        forwardInfoEntity2.setForwardUin(sb5.toString());
        String sb8 = sb6.toString();
        if (TextUtils.isEmpty(sb8) && qCircleForwardInfoReportBean.getForwardEntity() != null) {
            sb8 = qCircleForwardInfoReportBean.getForwardEntity().getForwardName();
        }
        forwardInfoEntity2.setForwardName(sb8);
        forwardInfoEntity2.setForwardUinType(i3);
        qCircleForwardInfoReportBean2.setForwardEntity(forwardInfoEntity2);
        x(qCircleForwardInfoReportBean2, sb7.toString());
        if (c16 != null && (feedCloudMeta$StFeed = c16.mFeed) != null) {
            D(arrayList, feedCloudMeta$StFeed.f398449id.get());
        }
    }

    private void t() {
        FeedCloudMeta$StFeed j3 = j();
        if (j3 == null) {
            QLog.d("RHF-QCircleShareReportHelper", 1, "[reportToLpDc05501] feed should be not null.");
        } else {
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(c.a(j3).setActionType(this.f438618b).setSubActionType(this.f438619c).setToUin(l()).setPageId(this.f438620d).setfPageId(this.f438621e).setExt3(String.valueOf(this.f438622f)).setExt4(String.valueOf(this.f438623g)).setExt5(String.valueOf(1))));
        }
    }

    private void u() {
        FeedCloudMeta$StFeed j3 = j();
        if (j3 == null) {
            QLog.d("RHF-QCircleShareReportHelper", 1, "[reportToLpDc05507] feed should be not null.");
            return;
        }
        String l3 = l();
        int k3 = k();
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(c.c(j3).setActionType(this.f438618b).setSubActionType(this.f438619c).setToUin(l3).setPosition(k3).setPlayScene(m()).setPageId(this.f438620d).setfpageid(this.f438621e).setExt3(String.valueOf(this.f438622f)).setExt4(String.valueOf(this.f438623g)).setExt5(String.valueOf(1)).setExt10(e()).setFirstFeedId(w20.a.j().h())));
    }

    public static void v(String str, int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        if (forwardInfoEntity != null && !TextUtils.isEmpty(forwardInfoEntity.getForwardUin())) {
            if (TextUtils.equals(str, HostForwardUtils.HOST_FORWARD_DIALOG_RECENTLY_FLAG())) {
                a(i3, i16).o(qCircleExtraTypeInfo, forwardInfoEntity);
            } else if (TextUtils.equals(str, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG())) {
                a(i3, i16).r(qCircleExtraTypeInfo, forwardInfoEntity);
            }
        }
    }

    public static void w(String str, @NonNull QCircleForwardInfoReportBean qCircleForwardInfoReportBean) {
        if (!qCircleForwardInfoReportBean.getMultiShareEntityList().isEmpty()) {
            s(str, qCircleForwardInfoReportBean);
            return;
        }
        QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo reportExtra = qCircleForwardInfoReportBean.getReportExtra();
        int pageId = qCircleForwardInfoReportBean.getPageId();
        int parentPageId = qCircleForwardInfoReportBean.getParentPageId();
        QCircleExtraTypeInfo c16 = c(reportExtra);
        HostForwardUtils.ForwardInfoEntity forwardEntity = qCircleForwardInfoReportBean.getForwardEntity();
        v(str, pageId, parentPageId, c16, forwardEntity);
        B(c16, forwardEntity);
        if (!TextUtils.isEmpty(qCircleForwardInfoReportBean.getForwardEntity().getForwardUin())) {
            x(qCircleForwardInfoReportBean, "");
        }
    }

    private static void x(QCircleForwardInfoReportBean qCircleForwardInfoReportBean, String str) {
        String str2;
        String str3;
        String str4;
        if (qCircleForwardInfoReportBean != null && qCircleForwardInfoReportBean.getForwardEntity() != null) {
            String forwardUin = qCircleForwardInfoReportBean.getForwardEntity().getForwardUin();
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (TextUtils.isEmpty(str)) {
                str = forwardUin;
            }
            buildElementParams.put("xsj_target_qq", str);
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SENDVIEW_POP_SEND_BUTTON);
            if (qCircleForwardInfoReportBean.getReportExtra() != null) {
                if (qCircleForwardInfoReportBean.getReportExtra().mExtMap != null) {
                    buildElementParams.putAll(qCircleForwardInfoReportBean.getReportExtra().mExtMap);
                }
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleForwardInfoReportBean.getReportExtra().feed;
                if (feedCloudMeta$StFeed != null) {
                    str2 = feedCloudMeta$StFeed.f398449id.get();
                } else {
                    str2 = "";
                }
                buildElementParams.put("xsj_feed_id", str2);
                buildElementParams.put("xsj_custom_pgid", qCircleForwardInfoReportBean.getReportExtra().mDtCustomPgId);
                if (qCircleForwardInfoReportBean.getReportExtra().isMultiSelect) {
                    str3 = "multiple";
                } else {
                    str3 = "single";
                }
                buildElementParams.put("xsj_single_multiple_choice_type", str3);
                if (qCircleForwardInfoReportBean.getReportExtra().isMutualShare) {
                    str4 = QCircleDaTongConstant.ElementParamValue.NEW_SELECT;
                } else {
                    str4 = QCircleDaTongConstant.ElementParamValue.OLD_SELECT;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, str4);
            }
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
            C(forwardUin, qCircleForwardInfoReportBean.getForwardEntity().getForwardName(), qCircleForwardInfoReportBean.getForwardEntity().getForwardUinType());
        }
    }

    public static void y(String str, int i3, int i16, @NonNull QCircleExtraTypeInfo qCircleExtraTypeInfo, @NonNull HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        if (TextUtils.equals(str, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG())) {
            a(i3, i16).p(qCircleExtraTypeInfo, forwardInfoEntity);
        }
    }

    public static void z(String str, @NonNull QCircleForwardInfoReportBean qCircleForwardInfoReportBean) {
        y(str, qCircleForwardInfoReportBean.getPageId(), qCircleForwardInfoReportBean.getParentPageId(), c(qCircleForwardInfoReportBean.getReportExtra()), qCircleForwardInfoReportBean.getForwardEntity());
    }

    public void A(QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo qCircleForwardExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        this.f438618b = 126;
        this.f438619c = 3;
        i(c(qCircleForwardExtraTypeInfo), forwardInfoEntity);
        u();
    }

    public void n(QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        this.f438618b = 124;
        this.f438619c = 2;
        QLog.d("RHF-QCircleShareReportHelper", 1, "[reportDialogRecentlyClick] ", toString());
        i(qCircleExtraTypeInfo, forwardInfoEntity);
        u();
    }

    public void o(QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        QFSCommentAtHelper.q0(forwardInfoEntity);
        if (qCircleExtraTypeInfo == null) {
            return;
        }
        this.f438618b = 124;
        this.f438619c = 3;
        QLog.d("RHF-QCircleShareReportHelper", 1, "[reportDialogRecentlySend] ", toString());
        i(qCircleExtraTypeInfo, forwardInfoEntity);
        u();
    }

    public void p(QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        this.f438618b = 125;
        this.f438619c = 2;
        QLog.d("RHF-QCircleShareReportHelper", 1, "[reportFriendSwitchClick] ", toString());
        i(qCircleExtraTypeInfo, forwardInfoEntity);
        h();
    }

    public void q(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.f438618b = 125;
        this.f438619c = 1;
        QLog.d("RHF-QCircleShareReportHelper", 1, "[reportFriendSwitchExport] ", toString());
        i(qCircleExtraTypeInfo, null);
        h();
    }

    public void r(QCircleExtraTypeInfo qCircleExtraTypeInfo, HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        QFSCommentAtHelper.q0(forwardInfoEntity);
        if (qCircleExtraTypeInfo == null) {
            return;
        }
        this.f438618b = 125;
        this.f438619c = 3;
        QLog.d("RHF-QCircleShareReportHelper", 1, "[reportFriendSwitchSend] ", toString());
        i(qCircleExtraTypeInfo, forwardInfoEntity);
        u();
    }

    public String toString() {
        return "QCircleRecentlyChatReportHelper{mActionType=" + this.f438618b + ", mSubActionType=" + this.f438619c + ", mPageId=" + this.f438620d + ", mParentPageId=" + this.f438621e + ", mChatType=" + this.f438622f + ", mChatUin='" + this.f438623g + "', mShareBtnType=1}";
    }
}
