package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$GetMultiConfInfoReq extends MessageMicro<cmd0x58b$GetMultiConfInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_conf_uin", "msg_conf_base_info", "msg_conf_mem_info", "uint32_interemark_timestamp"}, new Object[]{0L, null, null, 0}, cmd0x58b$GetMultiConfInfoReq.class);
    public final PBRepeatField<Long> uint64_conf_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public cmd0x58b$ConfBaseInfo msg_conf_base_info = new cmd0x58b$ConfBaseInfo();
    public cmd0x58b$ConfMemberInfo msg_conf_mem_info = new cmd0x58b$ConfMemberInfo();
    public final PBUInt32Field uint32_interemark_timestamp = PBField.initUInt32(0);
}
