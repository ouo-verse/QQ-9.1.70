package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class qqshop_report$SQQSHPCliLogRsp extends MessageMicro<qqshop_report$SQQSHPCliLogRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "ret_msg"}, new Object[]{0, ""}, qqshop_report$SQQSHPCliLogRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
}
