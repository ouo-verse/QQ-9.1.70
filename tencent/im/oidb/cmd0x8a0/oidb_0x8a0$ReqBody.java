package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8a0$ReqBody extends MessageMicro<oidb_0x8a0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"opt_uint64_group_code", "rpt_msg_kick_list", "rpt_kick_list", "uint32_kick_flag", "bytes_kick_msg"}, new Object[]{0L, null, 0L, 0, ByteStringMicro.EMPTY}, oidb_0x8a0$ReqBody.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x8a0$KickMemberInfo> rpt_msg_kick_list = PBField.initRepeatMessage(oidb_0x8a0$KickMemberInfo.class);
    public final PBRepeatField<Long> rpt_kick_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_kick_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_kick_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
