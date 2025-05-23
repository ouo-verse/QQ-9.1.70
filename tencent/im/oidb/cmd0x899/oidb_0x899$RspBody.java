package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x899$RspBody extends MessageMicro<oidb_0x899$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_group_code", "uint64_start_uin", "uint32_identify_flag", "rpt_memberlist", "str_errorinfo"}, new Object[]{0L, 0L, 0, null, ByteStringMicro.EMPTY}, oidb_0x899$RspBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_start_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_identify_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x899$memberlist> rpt_memberlist = PBField.initRepeatMessage(oidb_0x899$memberlist.class);
    public final PBBytesField str_errorinfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
