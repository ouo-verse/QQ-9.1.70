package tencent.im.group_pro_proto.msgpush;

import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;
import tencent.im.group_pro_proto.group_pro.comm.common$MsgSeq;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$EventBody extends MessageMicro<servtype$EventBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 138, 146, 170, 178, 186, 194, 202, 314, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, f.CTRL_INDEX, 370, 386, 506}, new String[]{"msg_read_notify", "msg_comm_gray_tips", "msg_create_guild", "msg_destroy_guild", "msg_join_guild", "msg_kick_off_guild", "msg_quit_guild", "msg_change_guild_info", "msg_create_chan", "msg_destroy_chan", "msg_change_chan_info", "msg_set_admin", "msg_set_msg_recv_type", "msg_update_msg", "msg_set_top", "msg_switch_channel", "msg_update_category", "msg_update_voice_block_list", "msg_set_mute", "msg_live_status_change_room", "msg_switch_live_room", "msg_events", "msg_scheduler", "msg_app_channel", "feed_event", "weak_msg_app_channel", "read_feed_notify", "question_channel_system_msg"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, servtype$EventBody.class);
    public servtype$ReadNotify msg_read_notify = new servtype$ReadNotify();
    public servtype$CommGrayTips msg_comm_gray_tips = new servtype$CommGrayTips();
    public servtype$CreateGuild msg_create_guild = new MessageMicro<servtype$CreateGuild>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$CreateGuild
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_operator_id", "uint64_guild_id"}, new Object[]{0L, 0L}, servtype$CreateGuild.class);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
    };
    public servtype$DestroyGuild msg_destroy_guild = new MessageMicro<servtype$DestroyGuild>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$DestroyGuild
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_operator_id", "uint64_guild_id"}, new Object[]{0L, 0L}, servtype$DestroyGuild.class);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
    };
    public servtype$JoinGuild msg_join_guild = new MessageMicro<servtype$JoinGuild>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$JoinGuild
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 32, 40}, new String[]{"uint64_member_id", "uint32_member_type", "uint64_member_tinyid"}, new Object[]{0L, 0, 0L}, servtype$JoinGuild.class);
        public final PBUInt64Field uint64_member_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_member_tinyid = PBField.initUInt64(0);
    };
    public servtype$KickOffGuild msg_kick_off_guild = new MessageMicro<servtype$KickOffGuild>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$KickOffGuild
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 32, 40}, new String[]{"uint64_member_id", "uint32_set_black", "uint64_member_tinyid"}, new Object[]{0L, 0, 0L}, servtype$KickOffGuild.class);
        public final PBUInt64Field uint64_member_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_set_black = PBField.initUInt32(0);
        public final PBUInt64Field uint64_member_tinyid = PBField.initUInt64(0);
    };
    public servtype$QuitGuild msg_quit_guild = new MessageMicro<servtype$QuitGuild>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$QuitGuild
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], servtype$QuitGuild.class);
    };
    public servtype$ChangeGuildInfo msg_change_guild_info = new MessageMicro<servtype$ChangeGuildInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$ChangeGuildInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58}, new String[]{"uint64_guild_id", "uint64_operator_id", "msg_info_seq", "msg_face_seq", "uint32_update_type", "msg_guild_info_filter", "msg_guild_info"}, new Object[]{0L, 0L, null, null, 0, null, null}, servtype$ChangeGuildInfo.class);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public common$MsgSeq msg_info_seq = new common$MsgSeq();
        public common$MsgSeq msg_face_seq = new common$MsgSeq();
        public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
        public servtype$GuildInfoFilter msg_guild_info_filter = new MessageMicro<servtype$GuildInfoFilter>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$GuildInfoFilter
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 40016, 40024, 40032}, new String[]{"uint32_guild_code", "uint32_owner_id", "uint32_create_time", "uint32_member_max_num", "uint32_member_num", "uint32_guild_type", "uint32_guild_name", "uint32_robot_list", "uint32_admin_list", "uint32_robot_max_num", "uint32_admin_max_num", "uint32_profile", "uint32_face_seq", "uint32_guild_status", "uint32_channel_num", "uint32_member_change_seq", "uint32_guild_info_change_seq", "uint32_channel_change_seq"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, servtype$GuildInfoFilter.class);
            public final PBUInt32Field uint32_guild_code = PBField.initUInt32(0);
            public final PBUInt32Field uint32_owner_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guild_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guild_name = PBField.initUInt32(0);
            public final PBUInt32Field uint32_robot_list = PBField.initUInt32(0);
            public final PBUInt32Field uint32_admin_list = PBField.initUInt32(0);
            public final PBUInt32Field uint32_robot_max_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_admin_max_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_profile = PBField.initUInt32(0);
            public final PBUInt32Field uint32_face_seq = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guild_status = PBField.initUInt32(0);
            public final PBUInt32Field uint32_channel_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_member_change_seq = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guild_info_change_seq = PBField.initUInt32(0);
            public final PBUInt32Field uint32_channel_change_seq = PBField.initUInt32(0);
        };
        public servtype$GuildInfo msg_guild_info = new MessageMicro<servtype$GuildInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$GuildInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_guild_name;
            public final PBBytesField bytes_profile;
            public common$MsgSeq msg_channel_change_seq;
            public common$MsgSeq msg_guild_info_change_seq;
            public servtype$GroupProStatus msg_guild_status;
            public common$MsgSeq msg_member_change_seq;
            public final PBRepeatField<Long> rpt_admin_list;
            public final PBRepeatField<Long> rpt_robot_list;
            public final PBUInt32Field uint32_admin_max_num;
            public final PBUInt32Field uint32_channel_num;
            public final PBUInt32Field uint32_robot_max_num;
            public final PBUInt64Field uint64_face_seq;
            public final PBUInt64Field uint64_guild_code = PBField.initUInt64(0);
            public final PBUInt64Field uint64_owner_id = PBField.initUInt64(0);
            public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
            public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guild_type = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 96, 106, 112, 122, 128, 40018, 40026, 40034}, new String[]{"uint64_guild_code", "uint64_owner_id", "uint64_create_time", "uint32_member_max_num", "uint32_member_num", "uint32_guild_type", "bytes_guild_name", "rpt_robot_list", "rpt_admin_list", "uint32_robot_max_num", "uint32_admin_max_num", "bytes_profile", "uint64_face_seq", "msg_guild_status", "uint32_channel_num", "msg_member_change_seq", "msg_guild_info_change_seq", "msg_channel_change_seq"}, new Object[]{0L, 0L, 0L, 0, 0, 0, byteStringMicro, 0L, 0L, 0, 0, byteStringMicro, 0L, null, 0, null, null, null}, servtype$GuildInfo.class);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.group_pro_proto.msgpush.servtype$GroupProStatus] */
            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_guild_name = PBField.initBytes(byteStringMicro);
                PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
                this.rpt_robot_list = PBField.initRepeat(pBUInt64Field);
                this.rpt_admin_list = PBField.initRepeat(pBUInt64Field);
                this.uint32_robot_max_num = PBField.initUInt32(0);
                this.uint32_admin_max_num = PBField.initUInt32(0);
                this.bytes_profile = PBField.initBytes(byteStringMicro);
                this.uint64_face_seq = PBField.initUInt64(0L);
                this.msg_guild_status = new MessageMicro<servtype$GroupProStatus>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$GroupProStatus
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_is_enable", "uint32_is_banned", "uint32_is_frozen"}, new Object[]{0, 0, 0}, servtype$GroupProStatus.class);
                    public final PBUInt32Field uint32_is_enable = PBField.initUInt32(0);
                    public final PBUInt32Field uint32_is_banned = PBField.initUInt32(0);
                    public final PBUInt32Field uint32_is_frozen = PBField.initUInt32(0);
                };
                this.uint32_channel_num = PBField.initUInt32(0);
                this.msg_member_change_seq = new common$MsgSeq();
                this.msg_guild_info_change_seq = new common$MsgSeq();
                this.msg_channel_change_seq = new common$MsgSeq();
            }
        };
    };
    public servtype$CreateChan msg_create_chan = new MessageMicro<servtype$CreateChan>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$CreateChan
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 34}, new String[]{"uint64_guild_id", "uint64_operator_id", "rpt_create_id"}, new Object[]{0L, 0L, null}, servtype$CreateChan.class);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public final PBRepeatMessageField<servtype$ChannelID> rpt_create_id = PBField.initRepeatMessage(servtype$ChannelID.class);
    };
    public servtype$DestroyChan msg_destroy_chan = new MessageMicro<servtype$DestroyChan>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$DestroyChan
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 34}, new String[]{"uint64_guild_id", "uint64_operator_id", "rpt_delete_id"}, new Object[]{0L, 0L, null}, servtype$DestroyChan.class);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public final PBRepeatMessageField<servtype$ChannelID> rpt_delete_id = PBField.initRepeatMessage(servtype$ChannelID.class);
    };
    public servtype$ChangeChanInfo msg_change_chan_info = new MessageMicro<servtype$ChangeChanInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$ChangeChanInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 58}, new String[]{"uint64_guild_id", "uint64_chan_id", "uint64_operator_id", "msg_info_seq", "uint32_update_type", "msg_chan_info_filter", "msg_chan_info"}, new Object[]{0L, 0L, 0L, null, 0, null, null}, servtype$ChangeChanInfo.class);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_chan_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public common$MsgSeq msg_info_seq = new common$MsgSeq();
        public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
        public servtype$ChanInfoFilter msg_chan_info_filter = new MessageMicro<servtype$ChanInfoFilter>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$ChanInfoFilter
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 40, 48, 56, 64, 88, 96, 114, 122, 128}, new String[]{"uint32_channel_name", "uint32_creator_id", "uint32_create_time", "uint32_guild_id", "uint32_msg_notify_type", "uint32_channel_type", "uint32_speak_permission", "uint32_last_msg_seq", "uint32_last_cnt_msg_seq", "msg_voice_channel_info_filter", "msg_live_channel_info_filter", "uint32_banned_speak"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0}, servtype$ChanInfoFilter.class);
            public final PBUInt32Field uint32_channel_name = PBField.initUInt32(0);
            public final PBUInt32Field uint32_creator_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guild_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_notify_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_speak_permission = PBField.initUInt32(0);
            public final PBUInt32Field uint32_last_msg_seq = PBField.initUInt32(0);
            public final PBUInt32Field uint32_last_cnt_msg_seq = PBField.initUInt32(0);
            public servtype$VoiceChannelInfoFilter msg_voice_channel_info_filter = new MessageMicro<servtype$VoiceChannelInfoFilter>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$VoiceChannelInfoFilter
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_member_max_num"}, new Object[]{0}, servtype$VoiceChannelInfoFilter.class);
                public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
            };
            public servtype$LiveChannelInfoFilter msg_live_channel_info_filter = new MessageMicro<servtype$LiveChannelInfoFilter>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$LiveChannelInfoFilter
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_is_need_room_id", "uint32_is_need_anchor_uin", "uint32_is_need_name"}, new Object[]{0, 0, 0}, servtype$LiveChannelInfoFilter.class);
                public final PBUInt32Field uint32_is_need_room_id = PBField.initUInt32(0);
                public final PBUInt32Field uint32_is_need_anchor_uin = PBField.initUInt32(0);
                public final PBUInt32Field uint32_is_need_name = PBField.initUInt32(0);
            };
            public final PBUInt32Field uint32_banned_speak = PBField.initUInt32(0);
        };
        public servtype$ChannelInfo msg_chan_info = new MessageMicro<servtype$ChannelInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$ChannelInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 90, 98, 114, 122, 128}, new String[]{"uint64_channel_id", "bytes_channel_name", "uint64_creator_id", "uint64_create_time", "uint64_guild_id", "uint32_msg_notify_type", "uint32_channel_type", "uint32_speak_permission", "last_msg_seq", "last_cnt_msg_seq", "msg_voice_channel_info", "msg_live_channel_info", "uint32_banned_speak"}, new Object[]{0L, ByteStringMicro.EMPTY, 0L, 0L, 0L, 0, 0, 0, null, null, null, null, 0}, servtype$ChannelInfo.class);
            public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
            public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field uint64_creator_id = PBField.initUInt64(0);
            public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
            public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
            public final PBUInt32Field uint32_msg_notify_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_speak_permission = PBField.initUInt32(0);
            public common$MsgSeq last_msg_seq = new common$MsgSeq();
            public common$MsgSeq last_cnt_msg_seq = new common$MsgSeq();
            public servtype$VoiceChannelInfo msg_voice_channel_info = new MessageMicro<servtype$VoiceChannelInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$VoiceChannelInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_member_max_num"}, new Object[]{0}, servtype$VoiceChannelInfo.class);
                public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
            };
            public servtype$LiveChannelInfo msg_live_channel_info = new MessageMicro<servtype$LiveChannelInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$LiveChannelInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_room_id", "uint64_anchor_uin", "bytes_name"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, servtype$LiveChannelInfo.class);
                public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
                public final PBUInt64Field uint64_anchor_uin = PBField.initUInt64(0);
                public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
            };
            public final PBUInt32Field uint32_banned_speak = PBField.initUInt32(0);
        };
    };
    public servtype$SetAdmin msg_set_admin = new MessageMicro<servtype$SetAdmin>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SetAdmin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_guild_id", "uint64_chan_id", "uint64_operator_id", "uint64_admin_id", "uint64_admin_tinyid", "uint32_operate_type"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0}, servtype$SetAdmin.class);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_chan_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_admin_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_admin_tinyid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_operate_type = PBField.initUInt32(0);
    };
    public servtype$SetMsgRecvType msg_set_msg_recv_type = new MessageMicro<servtype$SetMsgRecvType>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SetMsgRecvType
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_guild_id", "uint64_chan_id", "int64_operator_id", "uint32_msg_notify_type"}, new Object[]{0L, 0L, 0L, 0}, servtype$SetMsgRecvType.class);
        public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_chan_id = PBField.initUInt64(0);
        public final PBUInt64Field int64_operator_id = PBField.initUInt64(0);
        public final PBEnumField uint32_msg_notify_type = PBField.initEnum(0);
    };
    public servtype$UpdateMsg msg_update_msg = new servtype$UpdateMsg();
    public servtype$SetTop msg_set_top = new MessageMicro<servtype$SetTop>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SetTop
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_action"}, new Object[]{0}, servtype$SetTop.class);
        public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    };
    public servtype$SwitchVoiceChannel msg_switch_channel = new MessageMicro<servtype$SwitchVoiceChannel>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SwitchVoiceChannel
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"member_id", "enter_detail", "leave_detail"}, new Object[]{0L, null, null}, servtype$SwitchVoiceChannel.class);
        public final PBUInt64Field member_id = PBField.initUInt64(0);
        public servtype$SwitchDetail enter_detail = new MessageMicro<servtype$SwitchDetail>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SwitchDetail
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"guild_id", "channel_id", "platform"}, new Object[]{0L, 0L, 0}, servtype$SwitchDetail.class);
            public final PBUInt64Field guild_id = PBField.initUInt64(0);
            public final PBUInt64Field channel_id = PBField.initUInt64(0);
            public final PBUInt32Field platform = PBField.initUInt32(0);
        };
        public servtype$SwitchDetail leave_detail = new MessageMicro<servtype$SwitchDetail>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SwitchDetail
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"guild_id", "channel_id", "platform"}, new Object[]{0L, 0L, 0}, servtype$SwitchDetail.class);
            public final PBUInt64Field guild_id = PBField.initUInt64(0);
            public final PBUInt64Field channel_id = PBField.initUInt64(0);
            public final PBUInt32Field platform = PBField.initUInt32(0);
        };
    };
    public servtype$UpdateCategory msg_update_category = new MessageMicro<servtype$UpdateCategory>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$UpdateCategory
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_category_info", "msg_no_classify_category_info"}, new Object[]{null, null}, servtype$UpdateCategory.class);
        public final PBRepeatMessageField<servtype$CategoryInfo> rpt_msg_category_info = PBField.initRepeatMessage(servtype$CategoryInfo.class);
        public servtype$CategoryInfo msg_no_classify_category_info = new MessageMicro<servtype$CategoryInfo>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$CategoryInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_category_index", "rpt_msg_channel_info", "bytes_category_name", "uint64_category_id"}, new Object[]{0, null, ByteStringMicro.EMPTY, 0L}, servtype$CategoryInfo.class);
            public final PBUInt32Field uint32_category_index = PBField.initUInt32(0);
            public final PBRepeatMessageField<servtype$CategoryChannelInfo> rpt_msg_channel_info = PBField.initRepeatMessage(servtype$CategoryChannelInfo.class);
            public final PBBytesField bytes_category_name = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field uint64_category_id = PBField.initUInt64(0);
        };
    };
    public servtype$UpdateVoiceBlockList msg_update_voice_block_list = new MessageMicro<servtype$UpdateVoiceBlockList>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$UpdateVoiceBlockList
        public static final int ADD = 1;
        public static final int DEL = 2;
        public static final int INVALID = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_action", "uint64_object_tinyid"}, new Object[]{0, 0L}, servtype$UpdateVoiceBlockList.class);
        public final PBUInt32Field uint32_action = PBField.initUInt32(0);
        public final PBUInt64Field uint64_object_tinyid = PBField.initUInt64(0);
    };
    public servtype$SetMute msg_set_mute = new MessageMicro<servtype$SetMute>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SetMute
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"action", "tinyID"}, new Object[]{0, 0L}, servtype$SetMute.class);
        public final PBUInt32Field action = PBField.initUInt32(0);
        public final PBUInt64Field tinyID = PBField.initUInt64(0);
    };
    public servtype$LiveRoomStatusChangeMsg msg_live_status_change_room = new MessageMicro<servtype$LiveRoomStatusChangeMsg>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$LiveRoomStatusChangeMsg
        public static final int CLOSE = 2;
        public static final int INVALID = 0;
        public static final int OPEN = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"guild_id", "channel_id", AudienceReportConst.ROOM_ID, "anchor_tinyid", "action"}, new Object[]{0L, 0L, 0L, 0L, 0}, servtype$LiveRoomStatusChangeMsg.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBUInt64Field anchor_tinyid = PBField.initUInt64(0);
        public final PBEnumField action = PBField.initEnum(0);
    };
    public servtype$SwitchLiveRoom msg_switch_live_room = new MessageMicro<servtype$SwitchLiveRoom>() { // from class: tencent.im.group_pro_proto.msgpush.servtype$SwitchLiveRoom
        public static final int INVALID = 0;
        public static final int JOIN = 1;
        public static final int QUIT = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"guild_id", "channel_id", AudienceReportConst.ROOM_ID, "tinyid", "action"}, new Object[]{0L, 0L, 0L, 0L, 0}, servtype$SwitchLiveRoom.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBUInt64Field tinyid = PBField.initUInt64(0);
        public final PBEnumField action = PBField.initEnum(0);
    };
    public final PBRepeatMessageField<servtype$MsgEvent> msg_events = PBField.initRepeatMessage(servtype$MsgEvent.class);
    public servtype$SchedulerMsg msg_scheduler = new servtype$SchedulerMsg();
    public servtype$AppChannelMsg msg_app_channel = new servtype$AppChannelMsg();
    public servtype$FeedEvent feed_event = new servtype$FeedEvent();
    public servtype$AppChannelMsg weak_msg_app_channel = new servtype$AppChannelMsg();
    public servtype$ReadFeedNotify read_feed_notify = new servtype$ReadFeedNotify();
    public servtype$QuestionChannelSystemMsg question_channel_system_msg = new servtype$QuestionChannelSystemMsg();
}
