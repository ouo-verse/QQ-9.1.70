package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class qqshop_act$SQQSHPActReq extends MessageMicro<qqshop_act$SQQSHPActReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"act_id", "usr_info"}, new Object[]{0, null}, qqshop_act$SQQSHPActReq.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public qqshop_act$SQQSHPUsrInfo usr_info = new MessageMicro<qqshop_act$SQQSHPUsrInfo>() { // from class: tencent.im.oidb.qqshop.qqshop_act$SQQSHPUsrInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"carriertype", "src", "src_idx", "net_type"}, new Object[]{0, 0, 0, 0}, qqshop_act$SQQSHPUsrInfo.class);
        public final PBUInt32Field carriertype = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBUInt32Field src_idx = PBField.initUInt32(0);
        public final PBUInt32Field net_type = PBField.initUInt32(0);
    };
}
