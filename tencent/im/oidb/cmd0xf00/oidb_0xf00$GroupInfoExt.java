package tencent.im.oidb.cmd0xf00;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf00$GroupInfoExt extends MessageMicro<oidb_0xf00$GroupInfoExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 112, 152, 192, 200, 216, 224, 232, 240}, new String[]{"uint32_reserver", "uint64_lucky_word_id", "uint32_light_char_num", "bytes_lucky_word", "uint32_star_id", "uint32_essential_msg_switch", "uint32_essential_msg_prilivege", "uint32_invite_robot_switch", "uint32_group_bind_guild_switch", "uint64_group_aio_bind_guild_id", "uint32_full_group_expansion_switch", "uint64_full_group_expansion_seq", "uint32_invite_robot_member_switch", "uint32_invite_robot_member_examine"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0, 0L, 0, 0L, 0, 0}, oidb_0xf00$GroupInfoExt.class);
    public final PBUInt32Field uint32_reserver = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lucky_word_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_light_char_num = PBField.initUInt32(0);
    public final PBBytesField bytes_lucky_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_star_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_essential_msg_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_essential_msg_prilivege = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invite_robot_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_bind_guild_switch = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_aio_bind_guild_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_full_group_expansion_switch = PBField.initUInt32(0);
    public final PBUInt64Field uint64_full_group_expansion_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_invite_robot_member_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invite_robot_member_examine = PBField.initUInt32(0);
}
