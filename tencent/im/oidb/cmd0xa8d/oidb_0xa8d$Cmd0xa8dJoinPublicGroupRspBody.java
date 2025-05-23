package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xa8d$Cmd0xa8dJoinPublicGroupRspBody extends MessageMicro<oidb_0xa8d$Cmd0xa8dJoinPublicGroupRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74}, new String[]{"uint64_GroupCode", "uint32_SpeakInterval", "uint32_GroupFlagEx", "uint32_StartSpeakInterval", "uint32_GroupClassEx", "uint32_GroupClass", "uint32_MaxMember", "uint32_SpecialClass", "bytes_GroupName"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY}, oidb_0xa8d$Cmd0xa8dJoinPublicGroupRspBody.class);
    public final PBUInt64Field uint64_GroupCode = PBField.initUInt64(0);
    public final PBUInt32Field uint32_SpeakInterval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_GroupFlagEx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_StartSpeakInterval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_GroupClassEx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_GroupClass = PBField.initUInt32(0);
    public final PBUInt32Field uint32_MaxMember = PBField.initUInt32(0);
    public final PBUInt32Field uint32_SpecialClass = PBField.initUInt32(0);
    public final PBBytesField bytes_GroupName = PBField.initBytes(ByteStringMicro.EMPTY);
}
