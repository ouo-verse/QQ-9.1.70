package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class qqshop_report$SQQSHPCliLogReq extends MessageMicro<qqshop_report$SQQSHPCliLogReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"logs"}, new Object[]{null}, qqshop_report$SQQSHPCliLogReq.class);
    public final PBRepeatMessageField<qqshop_report$SQQSHPCliLogInfo> logs = PBField.initRepeatMessage(qqshop_report$SQQSHPCliLogInfo.class);
}
