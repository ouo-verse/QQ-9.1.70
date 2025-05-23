package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCirclePendant$UserPendantInfo extends MessageMicro<QQCirclePendant$UserPendantInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField hold = PBField.initBool(false);
    public final PBBoolField expired = PBField.initBool(false);
    public final PBUInt64Field startTime = PBField.initUInt64(0);
    public final PBUInt64Field endTime = PBField.initUInt64(0);
    public QQCirclePendant$PendantInfo pendantInfo = new QQCirclePendant$PendantInfo();
    public QQCirclePendant$PendantTaskInfo taskInfo = new MessageMicro<QQCirclePendant$PendantTaskInfo>() { // from class: qqcircle.QQCirclePendant$PendantTaskInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"startTime", "endTime", "url"}, new Object[]{0L, 0L, ""}, QQCirclePendant$PendantTaskInfo.class);
        public final PBUInt64Field startTime = PBField.initUInt64(0);
        public final PBUInt64Field endTime = PBField.initUInt64(0);
        public final PBStringField url = PBField.initString("");
    };
    public final PBInt32Field Pop = PBField.initInt32(0);
    public final PBStringField tips = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 66}, new String[]{"hold", "expired", "startTime", "endTime", "pendantInfo", "taskInfo", "Pop", "tips"}, new Object[]{bool, bool, 0L, 0L, null, null, 0, ""}, QQCirclePendant$UserPendantInfo.class);
    }
}
