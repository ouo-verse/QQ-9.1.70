package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$TagPageSchemaTransfer extends MessageMicro<QQCircleFeedBase$TagPageSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"startTime", "endTime", "tagName"}, new Object[]{0L, 0L, ""}, QQCircleFeedBase$TagPageSchemaTransfer.class);
    public final PBInt64Field startTime = PBField.initInt64(0);
    public final PBInt64Field endTime = PBField.initInt64(0);
    public final PBStringField tagName = PBField.initString("");
}
