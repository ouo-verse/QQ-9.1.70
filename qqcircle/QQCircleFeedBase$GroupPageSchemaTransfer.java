package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$GroupPageSchemaTransfer extends MessageMicro<QQCircleFeedBase$GroupPageSchemaTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"startTime", "endTime", "groupNumber"}, new Object[]{0L, 0L, 0L}, QQCircleFeedBase$GroupPageSchemaTransfer.class);
    public final PBInt64Field startTime = PBField.initInt64(0);
    public final PBInt64Field endTime = PBField.initInt64(0);
    public final PBUInt64Field groupNumber = PBField.initUInt64(0);
}
