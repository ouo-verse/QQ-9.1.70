package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$VipInfoNotify extends MessageMicro<SubMsgType0x6f$VipInfoNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 74}, new String[]{"uint64_uin", "uint32_vip_level", "uint32_vip_identify", "uint32_ext", "str_ext", "uint32_red_flag", "uint32_disable_red_envelope", "uint32_redpack_id", "str_redpack_name"}, new Object[]{0L, 0, 0, 0, "", 0, 0, 0, ""}, SubMsgType0x6f$VipInfoNotify.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_vip_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_identify = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext = PBField.initUInt32(0);
    public final PBStringField str_ext = PBField.initString("");
    public final PBUInt32Field uint32_red_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_disable_red_envelope = PBField.initUInt32(0);
    public final PBUInt32Field uint32_redpack_id = PBField.initUInt32(0);
    public final PBStringField str_redpack_name = PBField.initString("");
}
