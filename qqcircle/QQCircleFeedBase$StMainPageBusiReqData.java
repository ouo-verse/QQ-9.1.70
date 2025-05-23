package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMainPageBusiReqData extends MessageMicro<QQCircleFeedBase$StMainPageBusiReqData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"reqType", "entrySchema", "filter_feeds"}, new Object[]{0, "", null}, QQCircleFeedBase$StMainPageBusiReqData.class);
    public final PBUInt32Field reqType = PBField.initUInt32(0);
    public final PBStringField entrySchema = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> filter_feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
