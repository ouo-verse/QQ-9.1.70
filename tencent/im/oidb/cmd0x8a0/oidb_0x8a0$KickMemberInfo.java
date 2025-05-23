package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8a0$KickMemberInfo extends MessageMicro<oidb_0x8a0$KickMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"opt_uint32_operate", "opt_uint64_member_uin", "opt_uint32_flag", "opt_bytes_msg"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, oidb_0x8a0$KickMemberInfo.class);
    public final PBUInt32Field opt_uint32_operate = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_member_uin = PBField.initUInt64(0);
    public final PBUInt32Field opt_uint32_flag = PBField.initUInt32(0);
    public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
