package xb0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ai extends QCircleBaseShareOperation {
    public ai(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private QCircleEvilReportInfo L() {
        return new QCircleEvilReportInfo.Builder().setEviluind(t().tagId).setBuddyflag("1").setScene("25058").setContentid(new QCircleEvilReportInfo.ContentIdBuilder().setTagName(t().polymerizationName).getContentId()).setAppname("QZONE").setAppid("2400001").setSubapp("wezone_topic").build();
    }

    private QCircleEvilReportInfo M() {
        String b16 = com.tencent.biz.qqcircle.utils.u.b(t().feed.poster.f398463id.get());
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        return new QCircleEvilReportInfo.Builder().setEviluind(b16).setScene("25014").setSubapp("wezone_feed").setContentid(new QCircleEvilReportInfo.ContentIdBuilder().setFeedId(t().feed.f398449id.get()).setCreateTime(String.valueOf(t().feed.createTime.get())).setAccount_Type("1").getContentId()).build();
    }

    private QCircleEvilReportInfo N() {
        int i3 = t().type;
        if (i3 != 0) {
            if (i3 != 4) {
                return null;
            }
            return L();
        }
        return M();
    }

    private void O() {
        H(23, 2, t().extraTypeInfo, "");
        d("report", null);
    }

    private void P() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(23).setSubActionType(2);
        if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
            str = t().extraTypeInfo.mFeed.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        if (t().extraTypeInfo != null) {
            i3 = t().extraTypeInfo.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(m())));
    }

    private void Q() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(11).setSubActionType(8).setThrActionType(0).setExt9(o()).setFeedReportInfo(p()).setPageId(m()).setfPageId(n()));
    }

    private void R() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.share.poster.f398463id.get()).setActionType(6).setSubActionType(5).setThrActionType(2).setExt6(t().polymerizationName));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleTransActivityLifeEvent(0));
            if (t().feed.securityInfo != null && !TextUtils.isEmpty(t().feed.securityInfo.reportPageUrl.get())) {
                com.tencent.biz.qqcircle.launcher.c.g(f(), t().feed.securityInfo.reportPageUrl.get());
            } else {
                QCircleEvilReportInfo N = N();
                if (N != null) {
                    com.tencent.biz.qqcircle.utils.u.a(N);
                }
            }
            if (t().type == 4) {
                R();
                return;
            }
            if (!C(57) && !uq3.c.g6()) {
                if (C(32)) {
                    Q();
                    return;
                } else {
                    P();
                    return;
                }
            }
            O();
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
