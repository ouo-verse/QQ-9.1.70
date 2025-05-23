package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$NotifyModifyFeedReq extends MessageMicro<QQCircleRankinglist$NotifyModifyFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feed", "fuelValue"}, new Object[]{null, null, 0L}, QQCircleRankinglist$NotifyModifyFeedReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt64Field fuelValue = PBField.initInt64(0);
}
