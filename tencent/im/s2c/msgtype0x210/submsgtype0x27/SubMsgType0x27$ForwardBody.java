package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$ForwardBody extends MessageMicro<SubMsgType0x27$ForwardBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 202, 210, 1602, 1610, 1618, 1626, 1634, 1642, 1682, 1690, 1698, 1714, 16002}, new String[]{"uint32_notify_type", "uint32_op_type", "msg_add_group", "msg_del_group", "msg_mod_group_name", "msg_mod_group_sort", "msg_mod_friend_group", "msg_mod_profile", "msg_mod_friend_remark", "msg_mod_long_nick", "msg_mod_custom_face", "msg_mod_group_profile", "msg_mod_group_member_profile", "msg_del_friend", "msg_roam_priv", "msg_grp_msg_roam_flag", "msg_conf_msg_roam_flag", "msg_mod_rich_long_nick", "msg_bin_pkg", "msg_mod_friend_rings", "msg_mod_conf_profile", "msg_mod_friend_flag", "msg_appointment_notify", "msg_daren_notify", "msg_new_comein_user_notify", "msg_push_search_dev", "msg_push_report_dev", "msg_qq_pay_push", "bytes_redpoint_info", "msg_hot_friend_notify", "msg_praise_rank_notify", "msg_campus_notify", "msg_mod_rich_long_nick_ex", "msg_chat_match_info", "msg_frd_custom_online_status_change", "msg_fanpanzi_notify"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteStringMicro.EMPTY, null, null, null, null, null, null, null}, SubMsgType0x27$ForwardBody.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public SubMsgType0x27$AddGroup msg_add_group = new SubMsgType0x27$AddGroup();
    public SubMsgType0x27$DelGroup msg_del_group = new SubMsgType0x27$DelGroup();
    public SubMsgType0x27$ModGroupName msg_mod_group_name = new SubMsgType0x27$ModGroupName();
    public SubMsgType0x27$ModGroupSort msg_mod_group_sort = new SubMsgType0x27$ModGroupSort();
    public SubMsgType0x27$ModFriendGroup msg_mod_friend_group = new MessageMicro<SubMsgType0x27$ModFriendGroup>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModFriendGroup
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_frd_group"}, new Object[]{null}, SubMsgType0x27$ModFriendGroup.class);
        public final PBRepeatMessageField<SubMsgType0x27$FriendGroup> rpt_msg_frd_group = PBField.initRepeatMessage(SubMsgType0x27$FriendGroup.class);
    };
    public SubMsgType0x27$ModProfile msg_mod_profile = new SubMsgType0x27$ModProfile();
    public SubMsgType0x27$ModFriendRemark msg_mod_friend_remark = new SubMsgType0x27$ModFriendRemark();
    public SubMsgType0x27$ModLongNick msg_mod_long_nick = new SubMsgType0x27$ModLongNick();
    public SubMsgType0x27$ModCustomFace msg_mod_custom_face = new SubMsgType0x27$ModCustomFace();
    public SubMsgType0x27$ModGroupProfile msg_mod_group_profile = new MessageMicro<SubMsgType0x27$ModGroupProfile>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModGroupProfile
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_group_uin", "rpt_msg_group_profile_infos", "uint64_group_code", "uint64_cmd_uin"}, new Object[]{0L, null, 0L, 0L}, SubMsgType0x27$ModGroupProfile.class);
        public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<SubMsgType0x27$GroupProfileInfo> rpt_msg_group_profile_infos = PBField.initRepeatMessage(SubMsgType0x27$GroupProfileInfo.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0);
    };
    public SubMsgType0x27$ModGroupMemberProfile msg_mod_group_member_profile = new SubMsgType0x27$ModGroupMemberProfile();
    public SubMsgType0x27$DelFriend msg_del_friend = new SubMsgType0x27$DelFriend();
    public SubMsgType0x27$ModFrdRoamPriv msg_roam_priv = new MessageMicro<SubMsgType0x27$ModFrdRoamPriv>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModFrdRoamPriv
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_roam_priv"}, new Object[]{null}, SubMsgType0x27$ModFrdRoamPriv.class);
        public final PBRepeatMessageField<SubMsgType0x27$OneRoamPriv> rpt_msg_roam_priv = PBField.initRepeatMessage(SubMsgType0x27$OneRoamPriv.class);
    };
    public SubMsgType0x27$GrpMsgRoamFlag msg_grp_msg_roam_flag = new MessageMicro<SubMsgType0x27$GrpMsgRoamFlag>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$GrpMsgRoamFlag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_groupcode", "uint32_flag", "uint64_timestamp"}, new Object[]{0L, 0, 0L}, SubMsgType0x27$GrpMsgRoamFlag.class);
        public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    };
    public SubMsgType0x27$ConfMsgRoamFlag msg_conf_msg_roam_flag = new MessageMicro<SubMsgType0x27$ConfMsgRoamFlag>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ConfMsgRoamFlag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_confid", "uint32_flag", "uint64_timestamp"}, new Object[]{0L, 0, 0L}, SubMsgType0x27$ConfMsgRoamFlag.class);
        public final PBUInt64Field uint64_confid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    };
    public SubMsgType0x27$ModLongNick msg_mod_rich_long_nick = new SubMsgType0x27$ModLongNick();
    public SubMsgType0x27$BinaryMsg msg_bin_pkg = new MessageMicro<SubMsgType0x27$BinaryMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$BinaryMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_op_type", "bytes_op_value"}, new Object[]{0, ByteStringMicro.EMPTY}, SubMsgType0x27$BinaryMsg.class);
        public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
        public final PBBytesField bytes_op_value = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public SubMsgType0x27$ModSnsGeneralInfo msg_mod_friend_rings = new SubMsgType0x27$ModSnsGeneralInfo();
    public SubMsgType0x27$ModConfProfile msg_mod_conf_profile = new MessageMicro<SubMsgType0x27$ModConfProfile>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ModConfProfile
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uin", "uint32_conf_uin", "rpt_msg_profile_infos"}, new Object[]{0L, 0, null}, SubMsgType0x27$ModConfProfile.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_conf_uin = PBField.initUInt32(0);
        public final PBRepeatMessageField<SubMsgType0x27$ProfileInfo> rpt_msg_profile_infos = PBField.initRepeatMessage(SubMsgType0x27$ProfileInfo.class);
    };
    public SubMsgType0x27$SnsUpdateFlag msg_mod_friend_flag = new SubMsgType0x27$SnsUpdateFlag();
    public SubMsgType0x27$AppointmentNotify msg_appointment_notify = new MessageMicro<SubMsgType0x27$AppointmentNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$AppointmentNotify
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_event_info;
        public final PBBytesField bytes_feed_event_info;
        public final PBBytesField bytes_nearby_event_info;
        public final PBBytesField bytes_sig;
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBStringField str_appoint_id = PBField.initString("");
        public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
        public final PBStringField str_tips_content = PBField.initString("");
        public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
        public final PBStringField str_join_wording = PBField.initString("");
        public final PBStringField str_view_wording = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58, 66, 74, 82, 90}, new String[]{"uint64_from_uin", "str_appoint_id", "uint32_notifytype", "str_tips_content", "uint32_unread_count", "str_join_wording", "str_view_wording", "bytes_sig", "bytes_event_info", "bytes_nearby_event_info", "bytes_feed_event_info"}, new Object[]{0L, "", 0, "", 0, "", "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, SubMsgType0x27$AppointmentNotify.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sig = PBField.initBytes(byteStringMicro);
            this.bytes_event_info = PBField.initBytes(byteStringMicro);
            this.bytes_nearby_event_info = PBField.initBytes(byteStringMicro);
            this.bytes_feed_event_info = PBField.initBytes(byteStringMicro);
        }
    };
    public SubMsgType0x27$DaRenNotify msg_daren_notify = new SubMsgType0x27$DaRenNotify();
    public SubMsgType0x27$NewComeinUserNotify msg_new_comein_user_notify = new MessageMicro<SubMsgType0x27$NewComeinUserNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$NewComeinUserNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"uint32_msg_type", "bool_strong_notify", "uint32_push_time", "msg_new_comein_user", "msg_new_group", "msg_new_group_user"}, new Object[]{0, Boolean.FALSE, 0, null, null, null}, SubMsgType0x27$NewComeinUserNotify.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBBoolField bool_strong_notify = PBField.initBool(false);
        public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
        public SubMsgType0x27$NewComeinUser msg_new_comein_user = new MessageMicro<SubMsgType0x27$NewComeinUser>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$NewComeinUser
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_nick;
            public final PBBytesField bytes_remark;
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_uin", "uint32_is_frd", "bytes_remark", "bytes_nick"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro}, SubMsgType0x27$NewComeinUser.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_remark = PBField.initBytes(byteStringMicro);
                this.bytes_nick = PBField.initBytes(byteStringMicro);
            }
        };
        public SubMsgType0x27$NewGroup msg_new_group = new MessageMicro<SubMsgType0x27$NewGroup>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$NewGroup
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_distance;
            public final PBBytesField bytes_group_name;
            public final PBBytesField bytes_owner_nick;
            public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
            public final PBUInt64Field uint64_owner_uin;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"uint64_group_code", "bytes_group_name", "uint64_owner_uin", "bytes_owner_nick", "bytes_distance"}, new Object[]{0L, byteStringMicro, 0L, byteStringMicro, byteStringMicro}, SubMsgType0x27$NewGroup.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_group_name = PBField.initBytes(byteStringMicro);
                this.uint64_owner_uin = PBField.initUInt64(0L);
                this.bytes_owner_nick = PBField.initBytes(byteStringMicro);
                this.bytes_distance = PBField.initBytes(byteStringMicro);
            }
        };
        public SubMsgType0x27$NewGroupUser msg_new_group_user = new MessageMicro<SubMsgType0x27$NewGroupUser>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$NewGroupUser
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_uin", "int32_sex", "int32_age", "str_nick", "bytes_distance"}, new Object[]{0L, 0, 0, "", ByteStringMicro.EMPTY}, SubMsgType0x27$NewGroupUser.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBInt32Field int32_sex = PBField.initInt32(0);
            public final PBInt32Field int32_age = PBField.initInt32(0);
            public final PBStringField str_nick = PBField.initString("");
            public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
        };
    };
    public SubMsgType0x27$PushSearchDev msg_push_search_dev = new MessageMicro<SubMsgType0x27$PushSearchDev>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$PushSearchDev
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50}, new String[]{"uint32_msg_type", "msg_gps_info", "uint32_dev_time", "uint32_push_time", "uint64_din", "str_data"}, new Object[]{0, null, 0, 0, 0L, ""}, SubMsgType0x27$PushSearchDev.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public SubMsgType0x27$GPS msg_gps_info = new MessageMicro<SubMsgType0x27$GPS>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$GPS
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_lat", "int32_lon", "int32_alt", "int32_type"}, new Object[]{900000000, 900000000, -10000000, 0}, SubMsgType0x27$GPS.class);
            public final PBInt32Field int32_lat = PBField.initInt32(900000000);
            public final PBInt32Field int32_lon = PBField.initInt32(900000000);
            public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
            public final PBInt32Field int32_type = PBField.initInt32(0);
        };
        public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_din = PBField.initUInt64(0);
        public final PBStringField str_data = PBField.initString("");
    };
    public SubMsgType0x27$PushReportDev msg_push_report_dev = new MessageMicro<SubMsgType0x27$PushReportDev>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$PushReportDev
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cookie;
        public final PBBytesField bytes_sn;
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_report_max_num;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 34, 40, 50}, new String[]{"uint32_msg_type", "bytes_cookie", "uint32_report_max_num", "bytes_sn"}, new Object[]{0, byteStringMicro, 200, byteStringMicro}, SubMsgType0x27$PushReportDev.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_cookie = PBField.initBytes(byteStringMicro);
            this.uint32_report_max_num = PBField.initUInt32(200);
            this.bytes_sn = PBField.initBytes(byteStringMicro);
        }
    };
    public SubMsgType0x27$QQPayPush msg_qq_pay_push = new MessageMicro<SubMsgType0x27$QQPayPush>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$QQPayPush
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "bool_pay_ok"}, new Object[]{0L, Boolean.FALSE}, SubMsgType0x27$QQPayPush.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBoolField bool_pay_ok = PBField.initBool(false);
    };
    public final PBBytesField bytes_redpoint_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x27$HotFriendNotify msg_hot_friend_notify = new MessageMicro<SubMsgType0x27$HotFriendNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$HotFriendNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136}, new String[]{"uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time", "uint32_qzone_hot_level", "uint32_qzone_hot_days", "uint32_qzone_flag", "uint64_last_qzone_time"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0, 0, 0, 0L}, SubMsgType0x27$HotFriendNotify.class);
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_praise_hot_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_chat_hot_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_praise_hot_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_chat_hot_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_close_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_close_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_last_praise_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_qzone_hot_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_qzone_hot_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_qzone_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_last_qzone_time = PBField.initUInt64(0);
    };
    public SubMsgType0x27$PraiseRankNotify msg_praise_rank_notify = new SubMsgType0x27$PraiseRankNotify();
    public SubMsgType0x27$MQQCampusNotify msg_campus_notify = new SubMsgType0x27$MQQCampusNotify();
    public SubMsgType0x27$ModLongNick msg_mod_rich_long_nick_ex = new SubMsgType0x27$ModLongNick();
    public SubMsgType0x27$ChatMatchInfo msg_chat_match_info = new MessageMicro<SubMsgType0x27$ChatMatchInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$ChatMatchInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_nick;
        public final PBBytesField bytes_sig;
        public final PBBytesField bytes_tips_wording;
        public final PBUInt32Field uint32_c2c_expired_time;
        public final PBUInt32Field uint32_left_chat_time;
        public final PBUInt32Field uint32_match_count;
        public final PBUInt32Field uint32_match_expired_time;
        public final PBUInt64Field uint64_match_uin;
        public final PBUInt64Field uint64_time_stamp;
        public final PBUInt64Field uint64_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64, 72, 82}, new String[]{"bytes_sig", "uint64_uin", "uint64_match_uin", "bytes_tips_wording", "uint32_left_chat_time", "uint64_time_stamp", "uint32_match_expired_time", "uint32_c2c_expired_time", "uint32_match_count", "bytes_nick"}, new Object[]{byteStringMicro, 0L, 0L, byteStringMicro, 0, 0L, 0, 0, 0, byteStringMicro}, SubMsgType0x27$ChatMatchInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sig = PBField.initBytes(byteStringMicro);
            this.uint64_uin = PBField.initUInt64(0L);
            this.uint64_match_uin = PBField.initUInt64(0L);
            this.bytes_tips_wording = PBField.initBytes(byteStringMicro);
            this.uint32_left_chat_time = PBField.initUInt32(0);
            this.uint64_time_stamp = PBField.initUInt64(0L);
            this.uint32_match_expired_time = PBField.initUInt32(0);
            this.uint32_c2c_expired_time = PBField.initUInt32(0);
            this.uint32_match_count = PBField.initUInt32(0);
            this.bytes_nick = PBField.initBytes(byteStringMicro);
        }
    };
    public SubMsgType0x27$FrdCustomOnlineStatusChange msg_frd_custom_online_status_change = new SubMsgType0x27$FrdCustomOnlineStatusChange();
    public SubMsgType0x27$FanpaiziNotify msg_fanpanzi_notify = new MessageMicro<SubMsgType0x27$FanpaiziNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$FanpaiziNotify
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_sig;
        public final PBBytesField bytes_tips_content;
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBStringField str_from_nick = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_from_uin", "str_from_nick", "bytes_tips_content", "bytes_sig"}, new Object[]{0L, "", byteStringMicro, byteStringMicro}, SubMsgType0x27$FanpaiziNotify.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_tips_content = PBField.initBytes(byteStringMicro);
            this.bytes_sig = PBField.initBytes(byteStringMicro);
        }
    };
}
