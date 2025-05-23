package xf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneEmptyItemView;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneEmptyItemView> {
    private boolean d(BusinessFeedData businessFeedData) {
        return businessFeedData.isFriendPlayingFeed() || businessFeedData.isFriendPlayingFeedV2() || businessFeedData.isFriendPlayingRecomm();
    }

    @Override // nf.a
    public Class<QZoneEmptyItemView> a() {
        return QZoneEmptyItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_HIDE;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        if (businessFeedData.shouldHide) {
            QLog.i("QZoneHideFeedDetector", 1, "data should hide because of error");
            return true;
        }
        boolean isRegisterAnniversaryFeed = businessFeedData.isRegisterAnniversaryFeed();
        boolean isTodayInHistoryFeed = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        boolean d16 = d(businessFeedData);
        boolean z16 = businessFeedData.isPYMKFeed() && (!((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).getPYMKSetting() || StudyModeManager.t());
        boolean z17 = isRegisterAnniversaryFeed || isTodayInHistoryFeed || d16 || z16;
        if (z17) {
            QLog.i("QZoneHideFeedDetector", 1, "isRegisterAnniversaryFeed: " + isRegisterAnniversaryFeed + ", isTodayInHistoryFeed: " + isTodayInHistoryFeed + ", isFriendPlayingFeed: " + d16 + ", isPYMKAndHide: " + z16);
        }
        return z17;
    }
}
