package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$ForwardBody extends MessageMicro<SubMsgType0x6f$ForwardBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 16002, 16010, 16018, 16026, 16034, 16042, 16058, 16066, 16074, 16082, 16090}, new String[]{"uint32_notify_type", "uint32_op_type", "msg_fanpanzi_notify", "msg_mcard_notification_like", "msg_vip_info_notify", "msg_push_lost_dev_found", "msg_birthday_reminder_push", "msg_push_lost_dev", "msg_babyq_reward_info", "msg_hot_friend_notify", "msg_push_qim_recommend", "msg_mod_qim_friend", "msg_mod_qim_friend_to_qq"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null}, SubMsgType0x6f$ForwardBody.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public SubMsgType0x6f$FanpaiziNotify msg_fanpanzi_notify = new MessageMicro<SubMsgType0x6f$FanpaiziNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$FanpaiziNotify
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_sig;
        public final PBBytesField bytes_tips_content;
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBStringField str_from_nick = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_from_uin", "str_from_nick", "bytes_tips_content", "bytes_sig"}, new Object[]{0L, "", byteStringMicro, byteStringMicro}, SubMsgType0x6f$FanpaiziNotify.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_tips_content = PBField.initBytes(byteStringMicro);
            this.bytes_sig = PBField.initBytes(byteStringMicro);
        }
    };
    public SubMsgType0x6f$MCardNotificationLike msg_mcard_notification_like = new SubMsgType0x6f$MCardNotificationLike();
    public SubMsgType0x6f$VipInfoNotify msg_vip_info_notify = new SubMsgType0x6f$VipInfoNotify();
    public SubMsgType0x6f$PushLostDevFound msg_push_lost_dev_found = new MessageMicro<SubMsgType0x6f$PushLostDevFound>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$PushLostDevFound
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 48}, new String[]{"uint32_msg_type", "uint32_dev_time", "uint64_din"}, new Object[]{0, 0, 0L}, SubMsgType0x6f$PushLostDevFound.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_din = PBField.initUInt64(0);
    };
    public SubMsgType0x6f$BirthdayReminderPush msg_birthday_reminder_push = new MessageMicro<SubMsgType0x6f$BirthdayReminderPush>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$BirthdayReminderPush
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16034}, new String[]{"bytes_reminder_wording"}, new Object[]{ByteStringMicro.EMPTY}, SubMsgType0x6f$BirthdayReminderPush.class);
        public final PBBytesField bytes_reminder_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public SubMsgType0x6f$PushLostDevFound msg_push_lost_dev = new MessageMicro<SubMsgType0x6f$PushLostDevFound>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$PushLostDevFound
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 48}, new String[]{"uint32_msg_type", "uint32_dev_time", "uint64_din"}, new Object[]{0, 0, 0L}, SubMsgType0x6f$PushLostDevFound.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_din = PBField.initUInt64(0);
    };
    public SubMsgType0x6f$RewardInfo msg_babyq_reward_info = new MessageMicro<SubMsgType0x6f$RewardInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$RewardInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cookies;
        public final PBBytesField bytes_icon_url;
        public final PBBytesField bytes_jmp_url;
        public final PBBytesField bytes_jmp_wording;
        public final PBBytesField bytes_name;
        public final PBBytesField bytes_opt_url;
        public final PBBytesField bytes_opt_wording;
        public final PBBytesField bytes_toast_wording;
        public final PBUInt32Field uint32_report_type;
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_face_addon_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 74, 82, 88}, new String[]{"uint32_type", "bytes_name", "bytes_jmp_url", "bytes_cookies", "bytes_jmp_wording", "bytes_opt_wording", "bytes_opt_url", "uint64_face_addon_id", "bytes_icon_url", "bytes_toast_wording", "uint32_report_type"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0}, SubMsgType0x6f$RewardInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_name = PBField.initBytes(byteStringMicro);
            this.bytes_jmp_url = PBField.initBytes(byteStringMicro);
            this.bytes_cookies = PBField.initBytes(byteStringMicro);
            this.bytes_jmp_wording = PBField.initBytes(byteStringMicro);
            this.bytes_opt_wording = PBField.initBytes(byteStringMicro);
            this.bytes_opt_url = PBField.initBytes(byteStringMicro);
            this.uint64_face_addon_id = PBField.initUInt64(0L);
            this.bytes_icon_url = PBField.initBytes(byteStringMicro);
            this.bytes_toast_wording = PBField.initBytes(byteStringMicro);
            this.uint32_report_type = PBField.initUInt32(0);
        }
    };
    public SubMsgType0x6f$HotFriendNotify msg_hot_friend_notify = new MessageMicro<SubMsgType0x6f$HotFriendNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$HotFriendNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104}, new String[]{"uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L}, SubMsgType0x6f$HotFriendNotify.class);
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
    };
    public SubMsgType0x6f$QimRecomendMsg msg_push_qim_recommend = new MessageMicro<SubMsgType0x6f$QimRecomendMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$QimRecomendMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_recomend_list", "uint64_timestamp"}, new Object[]{null, 0L}, SubMsgType0x6f$QimRecomendMsg.class);
        public final PBRepeatMessageField<SubMsgType0x6f$QimRecomendInfo> rpt_msg_recomend_list = PBField.initRepeatMessage(SubMsgType0x6f$QimRecomendInfo.class);
        public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    };
    public SubMsgType0x6f$QimFriendNotify msg_mod_qim_friend = new MessageMicro<SubMsgType0x6f$QimFriendNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$QimFriendNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uint32_op_type", "rpt_uint64_uins", "uint64_fans_unread_count", "uint64_fans_total_count", "uint64_push_time", "rpt_bytes_mobiles"}, new Object[]{0, 0L, 0L, 0L, 0L, ByteStringMicro.EMPTY}, SubMsgType0x6f$QimFriendNotify.class);
        public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
        public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt64Field uint64_fans_unread_count = PBField.initUInt64(0);
        public final PBUInt64Field uint64_fans_total_count = PBField.initUInt64(0);
        public final PBUInt64Field uint64_push_time = PBField.initUInt64(0);
        public final PBRepeatField<ByteStringMicro> rpt_bytes_mobiles = PBField.initRepeat(PBBytesField.__repeatHelper__);
    };
    public SubMsgType0x6f$QimFriendNotifyToQQ msg_mod_qim_friend_to_qq = new SubMsgType0x6f$QimFriendNotifyToQQ();
}
