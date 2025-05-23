package qqcircle;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$ChannelRobotSchemaTransfer extends MessageMicro<QQCircleFeedBase$ChannelRobotSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"entryFeed", a.f36094d}, new Object[]{null, ""}, QQCircleFeedBase$ChannelRobotSchemaTransfer.class);
    public FeedCloudMeta$StFeed entryFeed = new FeedCloudMeta$StFeed();
    public final PBRepeatField<String> taskID = PBField.initRepeat(PBStringField.__repeatHelper__);
}
