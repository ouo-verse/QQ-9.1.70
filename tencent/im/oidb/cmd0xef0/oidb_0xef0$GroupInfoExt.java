package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef0$GroupInfoExt extends MessageMicro<oidb_0xef0$GroupInfoExt> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_bind_guild_id;
    public final PBBytesField bytes_group_exclude_guild_ids;
    public final PBBytesField bytes_group_ext_flame_data;
    public final PBBytesField bytes_group_owner_id;
    public final PBBytesField bytes_lucky_word;
    public final PBUInt32Field uint32_blacklist_expire_time;
    public final PBUInt32Field uint32_company_id;
    public final PBUInt32Field uint32_essential_msg_prilivege;
    public final PBUInt32Field uint32_essential_msg_switch;
    public final PBUInt32Field uint32_full_group_expansion_switch;
    public final PBUInt32Field uint32_group_bind_guild_switch;
    public final PBUInt32Field uint32_has_group_custom_portrait;
    public final PBUInt32Field uint32_invite_robot_member_examine;
    public final PBUInt32Field uint32_invite_robot_member_switch;
    public final PBUInt32Field uint32_invite_robot_switch;
    public final PBUInt32Field uint32_is_limit_group_rtc;
    public final PBUInt32Field uint32_qmusic_medal_switch;
    public final PBUInt32Field uint32_show_play_together_switch;
    public final PBUInt32Field uint32_star_id;
    public final PBUInt32Field uint32_todo_seq;
    public final PBUInt64Field uint64_bind_guild_id;
    public final PBUInt64Field uint64_full_group_expansion_seq;
    public final PBUInt64Field uint64_gang_up_id;
    public final PBUInt64Field uint64_group_aio_bind_guild_id;
    public final PBUInt64Field uint64_group_flag_pro_1;
    public final PBUInt64Field uint64_msg_event_seq;
    public final PBUInt64Field uint64_viewed_msg_disappear_time;
    public final PBUInt32Field uint32_group_info_ext_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lucky_word_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_light_char_num = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112, 120, 128, 136, 144, 152, 160, 170, 176, 186, 192, 200, 210, 216, 224, 232, 240}, new String[]{"uint32_group_info_ext_seq", "uint64_lucky_word_id", "uint32_light_char_num", "bytes_lucky_word", "uint32_star_id", "uint32_essential_msg_switch", "uint32_todo_seq", "uint32_blacklist_expire_time", "uint32_is_limit_group_rtc", "uint32_company_id", "uint32_has_group_custom_portrait", "uint64_bind_guild_id", "bytes_group_owner_id", "uint32_essential_msg_prilivege", "uint64_msg_event_seq", "uint64_gang_up_id", "uint32_qmusic_medal_switch", "uint32_show_play_together_switch", "uint32_invite_robot_switch", "uint64_group_flag_pro_1", "bytes_group_bind_guild_id", "uint64_viewed_msg_disappear_time", "bytes_group_ext_flame_data", "uint32_group_bind_guild_switch", "uint64_group_aio_bind_guild_id", "bytes_group_exclude_guild_ids", "uint32_full_group_expansion_switch", "uint64_full_group_expansion_seq", "uint32_invite_robot_member_switch", "uint32_invite_robot_member_examine"}, new Object[]{0, 0L, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0L, byteStringMicro, 0, 0L, 0L, 0, 0, 0, 0L, byteStringMicro, 0L, byteStringMicro, 0, 0L, byteStringMicro, 0, 0L, 0, 0}, oidb_0xef0$GroupInfoExt.class);
    }

    public oidb_0xef0$GroupInfoExt() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_lucky_word = PBField.initBytes(byteStringMicro);
        this.uint32_star_id = PBField.initUInt32(0);
        this.uint32_essential_msg_switch = PBField.initUInt32(0);
        this.uint32_todo_seq = PBField.initUInt32(0);
        this.uint32_blacklist_expire_time = PBField.initUInt32(0);
        this.uint32_is_limit_group_rtc = PBField.initUInt32(0);
        this.uint32_company_id = PBField.initUInt32(0);
        this.uint32_has_group_custom_portrait = PBField.initUInt32(0);
        this.uint64_bind_guild_id = PBField.initUInt64(0L);
        this.bytes_group_owner_id = PBField.initBytes(byteStringMicro);
        this.uint32_essential_msg_prilivege = PBField.initUInt32(0);
        this.uint64_msg_event_seq = PBField.initUInt64(0L);
        this.uint64_gang_up_id = PBField.initUInt64(0L);
        this.uint32_qmusic_medal_switch = PBField.initUInt32(0);
        this.uint32_show_play_together_switch = PBField.initUInt32(0);
        this.uint32_invite_robot_switch = PBField.initUInt32(0);
        this.uint64_group_flag_pro_1 = PBField.initUInt64(0L);
        this.bytes_group_bind_guild_id = PBField.initBytes(byteStringMicro);
        this.uint64_viewed_msg_disappear_time = PBField.initUInt64(0L);
        this.bytes_group_ext_flame_data = PBField.initBytes(byteStringMicro);
        this.uint32_group_bind_guild_switch = PBField.initUInt32(0);
        this.uint64_group_aio_bind_guild_id = PBField.initUInt64(0L);
        this.bytes_group_exclude_guild_ids = PBField.initBytes(byteStringMicro);
        this.uint32_full_group_expansion_switch = PBField.initUInt32(0);
        this.uint64_full_group_expansion_seq = PBField.initUInt64(0L);
        this.uint32_invite_robot_member_switch = PBField.initUInt32(0);
        this.uint32_invite_robot_member_examine = PBField.initUInt32(0);
    }
}
