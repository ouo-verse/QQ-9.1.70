package xb0;

import android.content.DialogInterface;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$ProfileCardCover;
import feedcloud.FeedCloudRead$SingleProfileCardInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\u0011"}, d2 = {"Lxb0/am;", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation;", "", "title", "", "N", "eventId", "M", "G", "", "y", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;", "builder", "<init>", "(Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;)V", "u", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class am extends QCircleBaseShareOperation {
    public am(@Nullable QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private final void M(String eventId) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        PBStringField pBStringField;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SELF_CARD_POP);
        QCircleShareInfo t16 = t();
        if (t16 != null && (feedCloudMeta$StFeed = t16.feed) != null) {
            PBStringField pBStringField2 = feedCloudMeta$StFeed.f398449id;
            String str2 = null;
            if (pBStringField2 != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            params.put("xsj_feed_id", str);
            FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
            if (feedCloudMeta$StUser != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
                str2 = pBStringField.get();
            }
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        }
        QCircleReportBean q16 = q();
        if (q16 != null) {
            params.put("xsj_custom_pgid", q16.getDtPageId());
        }
        VideoReport.reportEvent(eventId, params);
    }

    private final void N(String title) {
        boolean z16;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(f(), 230, (String) null, title, (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1910643s), new DialogInterface.OnClickListener() { // from class: xb0.al
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    am.O(am.this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026    }, null\n            )");
            createCustomDialog.show();
            yb0.r h16 = yb0.r.h();
            QCircleShareInfo t16 = t();
            if (t16 != null && (feedCloudMeta$StFeed = t16.feed) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            h16.C(str);
            M("ev_xsj_abnormal_imp");
            return;
        }
        QLog.e("QCircleSetQQProfileCoverOperation", 1, "[showTipsDialog] title is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(am this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.M("ev_xsj_abnormal_clck");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        Object obj;
        FeedCloudRead$ProfileCardCover feedCloudRead$ProfileCardCover;
        Unit unit;
        FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo;
        Unit unit2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        PBBoolField pBBoolField;
        String str2;
        PBRepeatMessageField<FeedCloudRead$SingleProfileCardInfo> pBRepeatMessageField;
        List<FeedCloudRead$SingleProfileCardInfo> list;
        Object firstOrNull;
        e30.b bVar;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3;
        PBStringField pBStringField;
        yb0.r h16 = yb0.r.h();
        QCircleShareInfo t16 = t();
        if (t16 != null && (feedCloudMeta$StFeed3 = t16.feed) != null && (pBStringField = feedCloudMeta$StFeed3.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        h16.C(str);
        QCircleShareInfo t17 = t();
        if (t17 != null) {
            feedCloudMeta$StFeed = t17.feed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (QCirclePluginUtil.isPrivateFeed(feedCloudMeta$StFeed)) {
            QLog.d("QCircleSetQQProfileCoverOperation", 1, "[realOperate] is private feed");
            QCircleToast.j(QCircleToast.f91644d, "\u7531\u4e8e\u4f5c\u8005\u6743\u9650\u8bbe\u7f6e\uff0c\u65e0\u6cd5\u8bbe\u4e3a\u5c01\u9762", 0);
            return;
        }
        QCircleShareInfo t18 = t();
        if (t18 != null && (bVar = t18.feedBlockData) != null) {
            obj = bVar.b("share_panel_profile_card_cover");
        } else {
            obj = null;
        }
        if (obj instanceof FeedCloudRead$ProfileCardCover) {
            feedCloudRead$ProfileCardCover = (FeedCloudRead$ProfileCardCover) obj;
        } else {
            feedCloudRead$ProfileCardCover = null;
        }
        if (feedCloudRead$ProfileCardCover != null) {
            if (!feedCloudRead$ProfileCardCover.show_entry.get()) {
                QCircleToast.j(QCircleToast.f91644d, "\u7531\u4e8e\u4f5c\u8005\u6743\u9650\u8bbe\u7f6e\uff0c\u65e0\u6cd5\u8bbe\u4e3a\u5c01\u9762", 0);
                return;
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QCircleToast.j(QCircleToast.f91644d, "\u6b63\u5728\u52a0\u8f7d\uff0c\u8bf7\u518d\u8bd5\u4e00\u6b21", 0);
            return;
        }
        if (feedCloudRead$ProfileCardCover != null && (pBRepeatMessageField = feedCloudRead$ProfileCardCover.single_profile_card_infos) != null && (list = pBRepeatMessageField.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            feedCloudRead$SingleProfileCardInfo = (FeedCloudRead$SingleProfileCardInfo) firstOrNull;
        } else {
            feedCloudRead$SingleProfileCardInfo = null;
        }
        if (feedCloudRead$SingleProfileCardInfo != null && (pBBoolField = feedCloudRead$SingleProfileCardInfo.allow_modify) != null && !pBBoolField.get()) {
            PBStringField pBStringField2 = feedCloudRead$SingleProfileCardInfo.tips_word;
            if (pBStringField2 != null) {
                str2 = pBStringField2.get();
            } else {
                str2 = null;
            }
            N(str2);
            d(QCircleDaTongConstant.ElementParamValue.SET_QQ_PROFILE_COVER, null);
            return;
        }
        QCircleShareInfo t19 = t();
        if (t19 != null && (feedCloudMeta$StFeed2 = t19.feed) != null) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setFeed(feedCloudMeta$StFeed2);
            qCircleInitBean.setLaunchFrom("sharepanel");
            if (feedCloudRead$SingleProfileCardInfo != null) {
                qCircleInitBean.setBusiInfoData(feedCloudRead$SingleProfileCardInfo.toByteArray());
            }
            QLog.d("QCircleSetQQProfileCoverOperation", 1, "[realOperate] launch cover feed select page, feedId:" + feedCloudMeta$StFeed2.f398449id.get());
            com.tencent.biz.qqcircle.launcher.c.c0(f(), qCircleInitBean);
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            QLog.e("QCircleSetQQProfileCoverOperation", 1, "[realOperate] feed is null");
        }
        d(QCircleDaTongConstant.ElementParamValue.SET_QQ_PROFILE_COVER, null);
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
