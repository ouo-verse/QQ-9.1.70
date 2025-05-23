package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StPrePullCacheFeed;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StGetPrePullInfoReqV2 extends MessageMicro<QQCircleFeedBase$StGetPrePullInfoReqV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"prePullMD", "entranceMod", "redTouchCacheFeeds", "normalCacheFeeds"}, new Object[]{null, 0, null, null}, QQCircleFeedBase$StGetPrePullInfoReqV2.class);
    public QQCircleFeedBase$PrePullMetaData prePullMD = new QQCircleFeedBase$PrePullMetaData();
    public final PBEnumField entranceMod = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudMeta$StPrePullCacheFeed> redTouchCacheFeeds = PBField.initRepeatMessage(FeedCloudMeta$StPrePullCacheFeed.class);
    public final PBRepeatMessageField<FeedCloudMeta$StPrePullCacheFeed> normalCacheFeeds = PBField.initRepeatMessage(FeedCloudMeta$StPrePullCacheFeed.class);
}
