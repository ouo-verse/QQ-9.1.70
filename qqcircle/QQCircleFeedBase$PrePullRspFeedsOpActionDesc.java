package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StPrePullCacheFeed;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$PrePullRspFeedsOpActionDesc extends MessageMicro<QQCircleFeedBase$PrePullRspFeedsOpActionDesc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opActionDesc", "feeds"}, new Object[]{0, null}, QQCircleFeedBase$PrePullRspFeedsOpActionDesc.class);
    public final PBEnumField opActionDesc = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudMeta$StPrePullCacheFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StPrePullCacheFeed.class);
}
