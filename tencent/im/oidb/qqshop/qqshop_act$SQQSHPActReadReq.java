package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class qqshop_act$SQQSHPActReadReq extends MessageMicro<qqshop_act$SQQSHPActReadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"act_id"}, new Object[]{0}, qqshop_act$SQQSHPActReadReq.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
}
