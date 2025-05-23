package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StImage;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StNoticePicInfo extends MessageMicro<QQCircleFeedBase$StNoticePicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"picInfo", "actionType", "schemaUrl"}, new Object[]{null, 0, ""}, QQCircleFeedBase$StNoticePicInfo.class);
    public FeedCloudMeta$StImage picInfo = new FeedCloudMeta$StImage();
    public final PBUInt32Field actionType = PBField.initUInt32(0);
    public final PBStringField schemaUrl = PBField.initString("");
}
