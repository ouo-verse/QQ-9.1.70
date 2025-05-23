package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$OfficialAccountSchemaTransfer extends MessageMicro<QQCircleFeedBase$OfficialAccountSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"entryFeed", "recomTransData", "hotPointTransData"}, new Object[]{null, "", ""}, QQCircleFeedBase$OfficialAccountSchemaTransfer.class);
    public FeedCloudMeta$StFeed entryFeed = new FeedCloudMeta$StFeed();
    public final PBStringField recomTransData = PBField.initString("");
    public final PBStringField hotPointTransData = PBField.initString("");
}
