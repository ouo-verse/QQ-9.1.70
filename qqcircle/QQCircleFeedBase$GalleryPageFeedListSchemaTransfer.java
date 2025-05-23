package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$GalleryPageFeedListSchemaTransfer extends MessageMicro<QQCircleFeedBase$GalleryPageFeedListSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"entryFeeds"}, new Object[]{null}, QQCircleFeedBase$GalleryPageFeedListSchemaTransfer.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> entryFeeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
