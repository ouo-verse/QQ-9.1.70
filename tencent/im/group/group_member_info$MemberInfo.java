package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$MemberInfo extends MessageMicro<group_member_info$MemberInfo> {
    public static final int CONCERN_TYPE_CONCERN = 1;
    public static final int CONCERN_TYPE_GENERAL = 0;
    public static final int CONCERN_TYPE_HATE = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_allow_mod_card;
    public final PBBoolField bool_is_concerned;
    public final PBBoolField bool_is_friend;
    public final PBBoolField bool_is_super_qq;
    public final PBBoolField bool_is_super_vip;
    public final PBBoolField bool_is_vip;
    public final PBBoolField bool_is_year_vip;
    public final PBBoolField bool_location_shared;
    public final PBBytesField bytes_group_honor;
    public final PBBytesField bytes_job;
    public final PBBytesField bytes_phone_num;
    public final PBBytesField bytes_special_title;
    public final PBUInt32Field medal_id;
    public group_member_info$FlowersEntry msg_flower_entry;
    public group_member_info$MemberGameInfo msg_game_info;
    public group_member_info$TeamEntry msg_team_entry;
    public group_member_info$RspGroupCardGetStory qqstory_infocard;
    public final PBRepeatMessageField<group_member_info$CustomEntry> rpt_msg_custom_enties;
    public final PBRepeatMessageField<group_member_info$GBarInfo> rpt_msg_gbar_concerned;
    public final PBBytesField str_card;
    public final PBBytesField str_errmsg;
    public final PBBytesField str_gbar_title;
    public final PBBytesField str_gbar_url;
    public final PBBytesField str_lev;
    public final PBBytesField str_location;
    public final PBBytesField str_nick;
    public final PBBytesField str_remark;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_concern_type;
    public final PBUInt32Field uint32_credit;
    public final PBUInt32Field uint32_gbar_cnt;
    public final PBUInt32Field uint32_group_honor_bit;
    public final PBUInt32Field uint32_level;
    public final PBUInt32Field uint32_role;
    public final PBUInt32Field uint32_sex;
    public final PBUInt32Field uint32_special_title_expire_time;
    public final PBUInt32Field uint32_vip_lev;
    public final PBUInt64Field uint64_distance;
    public final PBUInt64Field uint64_join;
    public final PBUInt64Field uint64_last_speak;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 72, 82, 90, 96, 106, 112, 120, 130, 138, 146, 154, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 296, 306, 312, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 336}, new String[]{"uint64_uin", "uint32_result", "str_errmsg", "bool_is_friend", "str_remark", "bool_is_concerned", "uint32_credit", "str_card", "uint32_sex", "str_location", "str_nick", "uint32_age", "str_lev", "uint64_join", "uint64_last_speak", "rpt_msg_custom_enties", "rpt_msg_gbar_concerned", "str_gbar_title", "str_gbar_url", "uint32_gbar_cnt", "bool_is_allow_mod_card", "bool_is_vip", "bool_is_year_vip", "bool_is_super_vip", "bool_is_super_qq", "uint32_vip_lev", "uint32_role", "bool_location_shared", "uint64_distance", "uint32_concern_type", "bytes_special_title", "uint32_special_title_expire_time", "msg_flower_entry", "msg_team_entry", "bytes_phone_num", "bytes_job", "medal_id", "qqstory_infocard", "uint32_level", "msg_game_info", "bytes_group_honor", "uint32_group_honor_bit"}, new Object[]{0L, 0, byteStringMicro, bool, byteStringMicro, bool, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0L, 0L, null, null, byteStringMicro, byteStringMicro, 0, bool, bool, bool, bool, bool, 0, 0, bool, 0L, 0, byteStringMicro, 0, null, null, byteStringMicro, byteStringMicro, 0, null, 0, null, byteStringMicro, 0}, group_member_info$MemberInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.group.group_member_info$FlowersEntry] */
    public group_member_info$MemberInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_errmsg = PBField.initBytes(byteStringMicro);
        this.bool_is_friend = PBField.initBool(false);
        this.str_remark = PBField.initBytes(byteStringMicro);
        this.bool_is_concerned = PBField.initBool(false);
        this.uint32_credit = PBField.initUInt32(0);
        this.str_card = PBField.initBytes(byteStringMicro);
        this.uint32_sex = PBField.initUInt32(0);
        this.str_location = PBField.initBytes(byteStringMicro);
        this.str_nick = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.str_lev = PBField.initBytes(byteStringMicro);
        this.uint64_join = PBField.initUInt64(0L);
        this.uint64_last_speak = PBField.initUInt64(0L);
        this.rpt_msg_custom_enties = PBField.initRepeatMessage(group_member_info$CustomEntry.class);
        this.rpt_msg_gbar_concerned = PBField.initRepeatMessage(group_member_info$GBarInfo.class);
        this.str_gbar_title = PBField.initBytes(byteStringMicro);
        this.str_gbar_url = PBField.initBytes(byteStringMicro);
        this.uint32_gbar_cnt = PBField.initUInt32(0);
        this.bool_is_allow_mod_card = PBField.initBool(false);
        this.bool_is_vip = PBField.initBool(false);
        this.bool_is_year_vip = PBField.initBool(false);
        this.bool_is_super_vip = PBField.initBool(false);
        this.bool_is_super_qq = PBField.initBool(false);
        this.uint32_vip_lev = PBField.initUInt32(0);
        this.uint32_role = PBField.initUInt32(0);
        this.bool_location_shared = PBField.initBool(false);
        this.uint64_distance = PBField.initUInt64(0L);
        this.uint32_concern_type = PBField.initUInt32(0);
        this.bytes_special_title = PBField.initBytes(byteStringMicro);
        this.uint32_special_title_expire_time = PBField.initUInt32(0);
        this.msg_flower_entry = new MessageMicro<group_member_info$FlowersEntry>() { // from class: tencent.im.group.group_member_info$FlowersEntry
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_flower_count"}, new Object[]{0L}, group_member_info$FlowersEntry.class);
            public final PBUInt64Field uint64_flower_count = PBField.initUInt64(0);
        };
        this.msg_team_entry = new group_member_info$TeamEntry();
        this.bytes_phone_num = PBField.initBytes(byteStringMicro);
        this.bytes_job = PBField.initBytes(byteStringMicro);
        this.medal_id = PBField.initUInt32(0);
        this.qqstory_infocard = new group_member_info$RspGroupCardGetStory();
        this.uint32_level = PBField.initUInt32(0);
        this.msg_game_info = new group_member_info$MemberGameInfo();
        this.bytes_group_honor = PBField.initBytes(byteStringMicro);
        this.uint32_group_honor_bit = PBField.initUInt32(0);
    }
}
