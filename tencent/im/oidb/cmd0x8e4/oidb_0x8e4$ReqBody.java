package tencent.im.oidb.cmd0x8e4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e4$ReqBody extends MessageMicro<oidb_0x8e4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"string_invite_id", "uint32_accept_invite", "uint32_play_way", "uint64_kick_uin", "uint32_max_member_num", "uint32_ready_state", "uint32_zone_id"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0L, 0, 0, 0}, oidb_0x8e4$ReqBody.class);
    public final PBBytesField string_invite_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_accept_invite = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_way = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kick_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_max_member_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ready_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zone_id = PBField.initUInt32(0);
}
