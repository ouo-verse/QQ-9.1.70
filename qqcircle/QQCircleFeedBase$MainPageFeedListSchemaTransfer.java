package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$MainPageFeedListSchemaTransfer extends MessageMicro<QQCircleFeedBase$MainPageFeedListSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"entryFeed", "needPullEntryFeed"}, new Object[]{null, Boolean.FALSE}, QQCircleFeedBase$MainPageFeedListSchemaTransfer.class);
    public FeedCloudMeta$StFeed entryFeed = new FeedCloudMeta$StFeed();
    public final PBBoolField needPullEntryFeed = PBField.initBool(false);
}
