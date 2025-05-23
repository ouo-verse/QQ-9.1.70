package xb0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ah extends QCircleBaseShareOperation {
    public ah(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private String L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        long j3;
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        String str2 = feedCloudMeta$StFeed.f398449id.get();
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        String str3 = "";
        if (feedCloudMeta$StUser == null) {
            str = "";
        } else {
            str = feedCloudMeta$StUser.f398463id.get();
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = feedCloudMeta$StFeed.poster;
        if (feedCloudMeta$StUser2 != null) {
            str3 = feedCloudMeta$StUser2.nick.get();
        }
        FeedCloudMeta$StLive feedCloudMeta$StLive = feedCloudMeta$StFeed.live;
        if (feedCloudMeta$StLive != null && (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) != null) {
            j3 = feedCloudMeta$RoomInfoData.roomId.get();
        } else {
            j3 = 0;
        }
        return "mqqapi://ecommerce/open?target=52&page_name=qplus_promotion_setting&target_uin=" + str + "&target_nick=" + str3 + "&feed_id=" + str2 + "&room_id=" + j3 + "&source_from=1&channel=2&src_type=internal&version=1";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        List<FeedCloudCommon$Entry> list;
        if (t() != null && f() != null && t().feed != null && t().feed.poster != null) {
            if (t().feed.urlInfo == null) {
                list = null;
            } else {
                list = t().feed.urlInfo.get();
            }
            String d16 = bh.d(list, "promotion_data");
            if (TextUtils.isEmpty(d16)) {
                d16 = L(t().feed);
            }
            QLog.d("QCirclePromotionOperation", 1, "promotion url=" + d16);
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(d16, null);
            d(QCircleDaTongConstant.ElementParamValue.XSJ_PROMOTION, null);
            return;
        }
        J("QCirclePromotionOperation");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
