package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class qqshop_act$SQQSHPActReadRsp extends MessageMicro<qqshop_act$SQQSHPActReadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"code", "act_id"}, new Object[]{0, 0}, qqshop_act$SQQSHPActReadRsp.class);
    public final PBUInt32Field code = PBField.initUInt32(0);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
}
