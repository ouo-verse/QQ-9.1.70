package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$MiniGameSchemaTransfer extends MessageMicro<QQCircleFeedBase$MiniGameSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"entryFeed", "recomTransData"}, new Object[]{null, ""}, QQCircleFeedBase$MiniGameSchemaTransfer.class);
    public FeedCloudMeta$StFeed entryFeed = new FeedCloudMeta$StFeed();
    public final PBStringField recomTransData = PBField.initString("");
}
