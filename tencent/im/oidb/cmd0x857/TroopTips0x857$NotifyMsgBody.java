package tencent.im.oidb.cmd0x857;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.state.data.SquareJSConst;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$NotifyMsgBody extends MessageMicro<TroopTips0x857$NotifyMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 114, 122, 130, 138, 146, 154, 162, 168, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 296, 306, 312, 322, 338, 346, 370, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN}, new String[]{"opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_group_code", "opt_msg_graytips", "opt_msg_messagebox", "opt_msg_floatedtips", "opt_msg_toptips", "opt_msg_redtips", "opt_msg_group_notify", "opt_msg_recall", "opt_msg_theme_notify", "uint32_service_type", "opt_msg_objmsg_update", "opt_msg_werewolf_push", "opt_stcm_game_state", "apllo_msg_push", "opt_msg_goldtips", "opt_msg_screen_share", "opt_msg_miniapp_notify", "opt_uint64_sender_uin", "opt_msg_luckybag_notify", "opt_msg_troopformtips_push", "opt_msg_media_push", "opt_recv_msg_set_changed_notify", "opt_general_gray_tip", "opt_msg_video_push", "opt_lbs_share_change_plus_info", "opt_msg_sing_push", "opt_msg_group_info_change", "opt_group_announce_tbc_info", "opt_qq_vedio_game_push_info", "opt_qq_group_digest_msg", "opt_study_room_member_msg", "opt_qq_live_notify", "opt_group_async_notidy", "opt_uint64_group_cur_msg_seq", "opt_group_digest_msg_summary", "opt_uint64_sysdb_msg_id", "opt_revert_graytips_traceless", "opt_msg_security_notify", "opt_group_member_info_change_notify", "opt_top_banner_notify", "opt_group_robot_change_notify"}, new Object[]{1, 0L, 0L, 0L, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null}, TroopTips0x857$NotifyMsgBody.class);
    public final PBEnumField opt_enum_type = PBField.initEnum(1);
    public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public TroopTips0x857$AIOGrayTipsInfo opt_msg_graytips = new MessageMicro<TroopTips0x857$AIOGrayTipsInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$AIOGrayTipsInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField opt_bytes_brief;
        public final PBBytesField opt_bytes_content;
        public final PBUInt32Field opt_uint32_remind;
        public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
        public final PBUInt32Field uint32_reliao_admin_opt;
        public final PBUInt32Field uint32_robot_group_opt;
        public final PBUInt64Field uint64_receiver_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56}, new String[]{"opt_uint32_show_lastest", "opt_bytes_content", "opt_uint32_remind", "opt_bytes_brief", "uint64_receiver_uin", "uint32_reliao_admin_opt", "uint32_robot_group_opt"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0L, 0, 0}, TroopTips0x857$AIOGrayTipsInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.opt_bytes_content = PBField.initBytes(byteStringMicro);
            this.opt_uint32_remind = PBField.initUInt32(0);
            this.opt_bytes_brief = PBField.initBytes(byteStringMicro);
            this.uint64_receiver_uin = PBField.initUInt64(0L);
            this.uint32_reliao_admin_opt = PBField.initUInt32(0);
            this.uint32_robot_group_opt = PBField.initUInt32(0);
        }
    };
    public TroopTips0x857$MessageBoxInfo opt_msg_messagebox = new MessageMicro<TroopTips0x857$MessageBoxInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$MessageBoxInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField opt_bytes_button;
        public final PBBytesField opt_bytes_content;
        public final PBBytesField opt_bytes_title;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"opt_bytes_content", "opt_bytes_title", "opt_bytes_button"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, TroopTips0x857$MessageBoxInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.opt_bytes_content = PBField.initBytes(byteStringMicro);
            this.opt_bytes_title = PBField.initBytes(byteStringMicro);
            this.opt_bytes_button = PBField.initBytes(byteStringMicro);
        }
    };
    public TroopTips0x857$FloatedTipsInfo opt_msg_floatedtips = new MessageMicro<TroopTips0x857$FloatedTipsInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$FloatedTipsInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"opt_bytes_content"}, new Object[]{ByteStringMicro.EMPTY}, TroopTips0x857$FloatedTipsInfo.class);
        public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public TroopTips0x857$AIOTopTipsInfo opt_msg_toptips = new MessageMicro<TroopTips0x857$AIOTopTipsInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$AIOTopTipsInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField opt_bytes_content;
        public final PBBytesField opt_bytes_data;
        public final PBBytesField opt_bytes_data_a;
        public final PBBytesField opt_bytes_data_i;
        public final PBBytesField opt_bytes_data_p;
        public final PBBytesField opt_bytes_url;
        public final PBEnumField opt_enum_action;
        public final PBUInt32Field opt_uint32_icon;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66}, new String[]{"opt_bytes_content", "opt_uint32_icon", "opt_enum_action", "opt_bytes_url", "opt_bytes_data", "opt_bytes_data_i", "opt_bytes_data_a", "opt_bytes_data_p"}, new Object[]{byteStringMicro, 0, 1, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, TroopTips0x857$AIOTopTipsInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.opt_bytes_content = PBField.initBytes(byteStringMicro);
            this.opt_uint32_icon = PBField.initUInt32(0);
            this.opt_enum_action = PBField.initEnum(1);
            this.opt_bytes_url = PBField.initBytes(byteStringMicro);
            this.opt_bytes_data = PBField.initBytes(byteStringMicro);
            this.opt_bytes_data_i = PBField.initBytes(byteStringMicro);
            this.opt_bytes_data_a = PBField.initBytes(byteStringMicro);
            this.opt_bytes_data_p = PBField.initBytes(byteStringMicro);
        }
    };
    public TroopTips0x857$RedGrayTipsInfo opt_msg_redtips = new MessageMicro<TroopTips0x857$RedGrayTipsInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$RedGrayTipsInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_authkey;
        public final PBBytesField bytes_broadcast_rich_content;
        public final PBBytesField bytes_idiom;
        public final PBBytesField bytes_idiom_alpha;
        public final PBBytesField bytes_jumpurl;
        public final PBBytesField bytes_pc_body;
        public final PBBytesField bytes_poem_rule;
        public final PBBytesField bytes_receiver_rich_content;
        public final PBBytesField bytes_sender_rich_content;
        public final PBSInt32Field sint32_msgtype;
        public final PBUInt32Field uint32_hide_flag;
        public final PBUInt32Field uint32_icon;
        public final PBUInt32Field uint32_idiom_seq;
        public final PBUInt32Field uint32_lucky_flag;
        public final PBUInt32Field uint32_random;
        public final PBUInt32Field uint32_subchannel;
        public final PBUInt32Field uint32_time;
        public final PBUInt64Field uint64_lucky_uin;
        public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 122, 130, 136, 146, 154, 160, 170}, new String[]{"opt_uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey", "sint32_msgtype", "uint32_lucky_flag", "uint32_hide_flag", "bytes_pc_body", "uint32_icon", "uint64_lucky_uin", "uint32_time", "uint32_random", "bytes_broadcast_rich_content", "bytes_idiom", "uint32_idiom_seq", "bytes_idiom_alpha", "bytes_jumpurl", "uint32_subchannel", "bytes_poem_rule"}, new Object[]{0, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0L, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro}, TroopTips0x857$RedGrayTipsInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sender_rich_content = PBField.initBytes(byteStringMicro);
            this.bytes_receiver_rich_content = PBField.initBytes(byteStringMicro);
            this.bytes_authkey = PBField.initBytes(byteStringMicro);
            this.sint32_msgtype = PBField.initSInt32(0);
            this.uint32_lucky_flag = PBField.initUInt32(0);
            this.uint32_hide_flag = PBField.initUInt32(0);
            this.bytes_pc_body = PBField.initBytes(byteStringMicro);
            this.uint32_icon = PBField.initUInt32(0);
            this.uint64_lucky_uin = PBField.initUInt64(0L);
            this.uint32_time = PBField.initUInt32(0);
            this.uint32_random = PBField.initUInt32(0);
            this.bytes_broadcast_rich_content = PBField.initBytes(byteStringMicro);
            this.bytes_idiom = PBField.initBytes(byteStringMicro);
            this.uint32_idiom_seq = PBField.initUInt32(0);
            this.bytes_idiom_alpha = PBField.initBytes(byteStringMicro);
            this.bytes_jumpurl = PBField.initBytes(byteStringMicro);
            this.uint32_subchannel = PBField.initUInt32(0);
            this.bytes_poem_rule = PBField.initBytes(byteStringMicro);
        }
    };
    public TroopTips0x857$GroupNotifyInfo opt_msg_group_notify = new TroopTips0x857$GroupNotifyInfo();
    public TroopTips0x857$MessageRecallReminder opt_msg_recall = new MessageMicro<TroopTips0x857$MessageRecallReminder>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$MessageRecallReminder
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_nickname;
        public final PBBytesField bytes_userdef;
        public WithDrawWordingInfo msg_wording_info;
        public final PBBytesField str_reminder_content;
        public final PBUInt32Field uint32_group_type;
        public final PBUInt32Field uint32_op_type;
        public final PBRepeatMessageField<MessageMeta> uint32_recalled_msg_list;
        public final PBUInt64Field uint64_admin_uin;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class MessageMeta extends MessageMicro<MessageMeta> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint32_seq", "uint32_time", "uint32_msg_random", "uint32_msg_type", "uint32_msg_flag", "uint64_author_uin", "uint32_is_anony_msg"}, new Object[]{0, 0, 0, 0, 0, 0L, 0}, MessageMeta.class);
            public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
            public final PBUInt32Field uint32_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_flag = PBField.initUInt32(0);
            public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_is_anony_msg = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class WithDrawWordingInfo extends MessageMicro<WithDrawWordingInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_item_id", "string_item_name"}, new Object[]{0, ""}, WithDrawWordingInfo.class);
            public final PBInt32Field int32_item_id = PBField.initInt32(0);
            public final PBStringField string_item_name = PBField.initString("");
        }

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64, 74}, new String[]{"uint64_uin", "bytes_nickname", "uint32_recalled_msg_list", "str_reminder_content", "bytes_userdef", "uint32_group_type", "uint32_op_type", "uint64_admin_uin", "msg_wording_info"}, new Object[]{0L, byteStringMicro, null, byteStringMicro, byteStringMicro, 0, 0, 0L, null}, TroopTips0x857$MessageRecallReminder.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nickname = PBField.initBytes(byteStringMicro);
            this.uint32_recalled_msg_list = PBField.initRepeatMessage(MessageMeta.class);
            this.str_reminder_content = PBField.initBytes(byteStringMicro);
            this.bytes_userdef = PBField.initBytes(byteStringMicro);
            this.uint32_group_type = PBField.initUInt32(0);
            this.uint32_op_type = PBField.initUInt32(0);
            this.uint64_admin_uin = PBField.initUInt64(0L);
            this.msg_wording_info = new WithDrawWordingInfo();
        }
    };
    public TroopTips0x857$ThemeStateNotify opt_msg_theme_notify = new MessageMicro<TroopTips0x857$ThemeStateNotify>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$ThemeStateNotify
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_feeds_id;
        public final PBBytesField bytes_theme_name;
        public final PBUInt32Field uint32_state = PBField.initUInt32(0);
        public final PBUInt64Field uint64_action_uin;
        public final PBUInt64Field uint64_create_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_state", "bytes_feeds_id", "bytes_theme_name", "uint64_action_uin", "uint64_create_uin"}, new Object[]{0, byteStringMicro, byteStringMicro, 0L, 0L}, TroopTips0x857$ThemeStateNotify.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
            this.bytes_theme_name = PBField.initBytes(byteStringMicro);
            this.uint64_action_uin = PBField.initUInt64(0L);
            this.uint64_create_uin = PBField.initUInt64(0L);
        }
    };
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public TroopTips0x857$NotifyObjmsgUpdate opt_msg_objmsg_update = new TroopTips0x857$NotifyObjmsgUpdate();
    public TroopTips0x857$WereWolfPush opt_msg_werewolf_push = new TroopTips0x857$WereWolfPush();
    public TroopTips0x857$STCMGameMessage opt_stcm_game_state = new MessageMicro<TroopTips0x857$STCMGameMessage>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$STCMGameMessage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uint32_msg_cmd", "msg_comm", "msg_0x01", "msg_0x02", "msg_0x03", "msg_0x04", "msg_0x05", "msg_0x06"}, new Object[]{0, null, null, null, null, null, null, null}, TroopTips0x857$STCMGameMessage.class);
        public final PBUInt32Field uint32_msg_cmd = PBField.initUInt32(0);
        public STMsgComm msg_comm = new STMsgComm();
        public STGameJoinRoom msg_0x01 = new STGameJoinRoom();
        public STGameQuitRoom msg_0x02 = new STGameQuitRoom();
        public STGameStart msg_0x03 = new STGameStart();
        public STGameOver msg_0x04 = new STGameOver();
        public STGameInvalid msg_0x05 = new STGameInvalid();
        public STGameCancel msg_0x06 = new STGameCancel();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STGameCancel extends MessageMicro<STGameCancel> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], STGameCancel.class);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STGameInvalid extends MessageMicro<STGameInvalid> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], STGameInvalid.class);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STGameJoinRoom extends MessageMicro<STGameJoinRoom> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_room_vol", "rpt_uint32_uin_list"}, new Object[]{0, 0}, STGameJoinRoom.class);
            public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
            public final PBRepeatField<Integer> rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STGameOver extends MessageMicro<STGameOver> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_winner_info", "uint32_over_type"}, new Object[]{null, 0}, STGameOver.class);
            public final PBRepeatMessageField<STScoreInfo> rpt_msg_winner_info = PBField.initRepeatMessage(STScoreInfo.class);
            public final PBUInt32Field uint32_over_type = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STGameQuitRoom extends MessageMicro<STGameQuitRoom> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_room_vol", "rpt_uint32_uin_list"}, new Object[]{0, 0}, STGameQuitRoom.class);
            public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
            public final PBRepeatField<Integer> rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STGameStart extends MessageMicro<STGameStart> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], STGameStart.class);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STMsgComm extends MessageMicro<STMsgComm> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_game_id", "str_room_id", "uint64_time_stamp"}, new Object[]{0, "", 0L}, STMsgComm.class);
            public final PBUInt32Field uint32_game_id = PBField.initUInt32(0);
            public final PBStringField str_room_id = PBField.initString("");
            public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class STScoreInfo extends MessageMicro<STScoreInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_winner", "str_wording"}, new Object[]{0, ""}, STScoreInfo.class);
            public final PBUInt32Field uint32_winner = PBField.initUInt32(0);
            public final PBStringField str_wording = PBField.initString("");
        }
    };
    public TroopTips0x857$STPushMsgElem apllo_msg_push = new MessageMicro<TroopTips0x857$STPushMsgElem>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$STPushMsgElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"type", "pm1"}, new Object[]{0, null}, TroopTips0x857$STPushMsgElem.class);
        public final PBUInt32Field type = PBField.initUInt32(0);

        /* renamed from: pm1, reason: collision with root package name */
        public STPushMsgElem0x1 f435980pm1 = new STPushMsgElem0x1();

        /* loaded from: classes29.dex */
        public static final class STPushMsgElem0x1 extends MessageMicro<STPushMsgElem0x1> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66, 72}, new String[]{"actionId", "actionType", "sendUin", "rcvUin", "aioType", "sessionId", "wordType", "diyWords", SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{0, 0, 0, 0, 0, "", 0, "", 0}, STPushMsgElem0x1.class);
            public final PBInt32Field actionId = PBField.initInt32(0);
            public final PBInt32Field actionType = PBField.initInt32(0);
            public final PBUInt32Field sendUin = PBField.initUInt32(0);
            public final PBUInt32Field rcvUin = PBField.initUInt32(0);
            public final PBInt32Field aioType = PBField.initInt32(0);
            public final PBStringField sessionId = PBField.initString("");
            public final PBInt32Field wordType = PBField.initInt32(0);
            public final PBStringField diyWords = PBField.initString("");
            public final PBRepeatField<Integer> uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        }
    };
    public TroopTips0x857$GoldMsgTipsElem opt_msg_goldtips = new TroopTips0x857$GoldMsgTipsElem();
    public TroopTips0x857$ScreenShareMark opt_msg_screen_share = new MessageMicro<TroopTips0x857$ScreenShareMark>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$ScreenShareMark
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_msg_operation", "uint64_msg_create_time", "rpt_msg_elem_array"}, new Object[]{0, 0L, null}, TroopTips0x857$ScreenShareMark.class);
        public final PBUInt32Field uint32_msg_operation = PBField.initUInt32(0);
        public final PBUInt64Field uint64_msg_create_time = PBField.initUInt64(0);
        public final PBRepeatMessageField<MarkElemInfo> rpt_msg_elem_array = PBField.initRepeatMessage(MarkElemInfo.class);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class MarkElemInfo extends MessageMicro<MarkElemInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 80, 90, 98, 106, 114}, new String[]{"uint32_mark_operation", "uint32_mark_info_id", "uint32_mark_shape", "uint64_mark_time", "uint64_screenshare_start_time", "uint32_mark_creator_uin", "msg_mark_background_rect", "msg_mark_rect", "msg_mark_color", "uint32_line_width", "msg_start_point", "msg_end_point", "msg_path_mark", "msg_text_mark"}, new Object[]{0, 0, 0, 0L, 0L, 0L, null, null, null, 0, null, null, null, null}, MarkElemInfo.class);
            public final PBUInt32Field uint32_mark_operation = PBField.initUInt32(0);
            public final PBUInt32Field uint32_mark_info_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_mark_shape = PBField.initUInt32(0);
            public final PBUInt64Field uint64_mark_time = PBField.initUInt64(0);
            public final PBUInt64Field uint64_screenshare_start_time = PBField.initUInt64(0);
            public final PBUInt64Field uint32_mark_creator_uin = PBField.initUInt64(0);
            public MarkRectangle msg_mark_background_rect = new MarkRectangle();
            public MarkRectangle msg_mark_rect = new MarkRectangle();
            public RGBAColor msg_mark_color = new RGBAColor();
            public final PBUInt32Field uint32_line_width = PBField.initUInt32(0);
            public MarkPoint msg_start_point = new MarkPoint();
            public MarkPoint msg_end_point = new MarkPoint();
            public PathMark msg_path_mark = new PathMark();
            public TextMark msg_text_mark = new TextMark();
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class MarkPoint extends MessageMicro<MarkPoint> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_coordinate_x", "uint32_coordinate_y"}, new Object[]{0, 0}, MarkPoint.class);
            public final PBUInt32Field uint32_coordinate_x = PBField.initUInt32(0);
            public final PBUInt32Field uint32_coordinate_y = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class MarkRectangle extends MessageMicro<MarkRectangle> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"msg_left_bottom_point", "uint32_width", "uint32_height"}, new Object[]{null, 0, 0}, MarkRectangle.class);
            public MarkPoint msg_left_bottom_point = new MarkPoint();
            public final PBUInt32Field uint32_width = PBField.initUInt32(0);
            public final PBUInt32Field uint32_height = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class PathMark extends MessageMicro<PathMark> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"rpt_msg_move_points", "uint32_path_id", "uint32_path_totle_content_count", "uint32_path_content_id"}, new Object[]{null, 0, 0, 0}, PathMark.class);
            public final PBRepeatMessageField<MarkPoint> rpt_msg_move_points = PBField.initRepeatMessage(MarkPoint.class);
            public final PBUInt32Field uint32_path_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_path_totle_content_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_path_content_id = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class RGBAColor extends MessageMicro<RGBAColor> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 37}, new String[]{"uint32_red", "uint32_green", "uint32_blue", "float_alpha"}, new Object[]{0, 0, 0, Float.valueOf(0.0f)}, RGBAColor.class);
            public final PBUInt32Field uint32_red = PBField.initUInt32(0);
            public final PBUInt32Field uint32_green = PBField.initUInt32(0);
            public final PBUInt32Field uint32_blue = PBField.initUInt32(0);
            public final PBFloatField float_alpha = PBField.initFloat(0.0f);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class TextMark extends MessageMicro<TextMark> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 32, 40, 48}, new String[]{"uint32_text_font_size", "string_text_content", "uint32_text_id", "uint32_text_totle_content_count", "uint32_text_content_id"}, new Object[]{0, "", 0, 0, 0}, TextMark.class);
            public final PBUInt32Field uint32_text_font_size = PBField.initUInt32(0);
            public final PBStringField string_text_content = PBField.initString("");
            public final PBUInt32Field uint32_text_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_text_totle_content_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_text_content_id = PBField.initUInt32(0);
        }
    };
    public TroopTips0x857$MiniAppNotify opt_msg_miniapp_notify = new TroopTips0x857$MiniAppNotify();
    public final PBUInt64Field opt_uint64_sender_uin = PBField.initUInt64(0);
    public TroopTips0x857$LuckyBagNotify opt_msg_luckybag_notify = new MessageMicro<TroopTips0x857$LuckyBagNotify>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$LuckyBagNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg_tips"}, new Object[]{ByteStringMicro.EMPTY}, TroopTips0x857$LuckyBagNotify.class);
        public final PBBytesField bytes_msg_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public TroopTips0x857$TroopFormGrayTipsInfo opt_msg_troopformtips_push = new TroopTips0x857$TroopFormGrayTipsInfo();
    public TroopTips0x857$MediaChangePushInfo opt_msg_media_push = new TroopTips0x857$MediaChangePushInfo();
    public TroopTips0x857$RecvMsgSetChangedNotify opt_recv_msg_set_changed_notify = new MessageMicro<TroopTips0x857$RecvMsgSetChangedNotify>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$RecvMsgSetChangedNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_sub_type"}, new Object[]{0}, TroopTips0x857$RecvMsgSetChangedNotify.class);
        public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    };
    public TroopTips0x857$GeneralGrayTipInfo opt_general_gray_tip = new MessageMicro<TroopTips0x857$GeneralGrayTipInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$GeneralGrayTipInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_content;
        public final PBBytesField bytes_pb_reserv;
        public final PBUInt64Field uint64_tips_seq_id;
        public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0);
        public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0);
        public final PBRepeatMessageField<TroopTips0x857$TemplParam> rpt_msg_templ_param = PBField.initRepeatMessage(TroopTips0x857$TemplParam.class);

        static {
            String[] strArr = {MessageForUniteGrayTip.KEY_UINT64_BUSI_TYPE, MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, "uint32_ctrl_flag", "uint32_c2c_type", "uint32_service_type", MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID, "rpt_msg_templ_param", MessageForUniteGrayTip.KEY_BYTES_CONTENT, MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID, "bytes_pb_reserv"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 80, 802}, strArr, new Object[]{0L, 0L, 0, 0, 0, 0L, null, byteStringMicro, 0L, byteStringMicro}, TroopTips0x857$GeneralGrayTipInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_content = PBField.initBytes(byteStringMicro);
            this.uint64_tips_seq_id = PBField.initUInt64(0L);
            this.bytes_pb_reserv = PBField.initBytes(byteStringMicro);
        }
    };
    public TroopTips0x857$VideoChangePushInfo opt_msg_video_push = new TroopTips0x857$VideoChangePushInfo();
    public TroopTips0x857$LbsShareChangePushInfo opt_lbs_share_change_plus_info = new TroopTips0x857$LbsShareChangePushInfo();
    public TroopTips0x857$SingChangePushInfo opt_msg_sing_push = new TroopTips0x857$SingChangePushInfo();
    public TroopTips0x857$GroupInfoChange opt_msg_group_info_change = new TroopTips0x857$GroupInfoChange();
    public TroopTips0x857$GroupAnnounceTBCInfo opt_group_announce_tbc_info = new MessageMicro<TroopTips0x857$GroupAnnounceTBCInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$GroupAnnounceTBCInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"feeds_id", "group_id", "action"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0}, TroopTips0x857$GroupAnnounceTBCInfo.class);
        public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBUInt32Field action = PBField.initUInt32(0);
    };
    public TroopTips0x857$QQVedioGamePushInfo opt_qq_vedio_game_push_info = new MessageMicro<TroopTips0x857$QQVedioGamePushInfo>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$QQVedioGamePushInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_ext_info;
        public final PBBytesField bytes_version_ctrl;
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint32_msg_type", "uint64_group_code", "uint64_oper_uin", "bytes_version_ctrl", "bytes_ext_info"}, new Object[]{0, 0L, 0L, byteStringMicro, byteStringMicro}, TroopTips0x857$QQVedioGamePushInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_version_ctrl = PBField.initBytes(byteStringMicro);
            this.bytes_ext_info = PBField.initBytes(byteStringMicro);
        }
    };
    public TroopTips0x857$QQGroupDigestMsg opt_qq_group_digest_msg = new TroopTips0x857$QQGroupDigestMsg();
    public TroopTips0x857$StudyRoomMemberChangePush opt_study_room_member_msg = new MessageMicro<TroopTips0x857$StudyRoomMemberChangePush>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$StudyRoomMemberChangePush
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"member_count"}, new Object[]{0}, TroopTips0x857$StudyRoomMemberChangePush.class);
        public final PBUInt32Field member_count = PBField.initUInt32(0);
    };
    public TroopTips0x857$QQVaLiveNotifyMsg opt_qq_live_notify = new TroopTips0x857$QQVaLiveNotifyMsg();
    public TroopTips0x857$GroupAsyncNotify opt_group_async_notidy = new MessageMicro<TroopTips0x857$GroupAsyncNotify>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$GroupAsyncNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_msg_type", "uint64_msg_seq"}, new Object[]{0, 0L}, TroopTips0x857$GroupAsyncNotify.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    };
    public final PBUInt64Field opt_uint64_group_cur_msg_seq = PBField.initUInt64(0);
    public TroopTips0x857$QQGroupDigestMsgSummary opt_group_digest_msg_summary = new TroopTips0x857$QQGroupDigestMsgSummary();
    public final PBUInt64Field opt_uint64_sysdb_msg_id = PBField.initUInt64(0);
    public TroopTips0x857$RevertGrayTipsMsgTraceless opt_revert_graytips_traceless = new MessageMicro<TroopTips0x857$RevertGrayTipsMsgTraceless>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$RevertGrayTipsMsgTraceless
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_from", "uint64_to", "group_code", MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID}, new Object[]{0L, 0L, 0L, 0L, 0L}, TroopTips0x857$RevertGrayTipsMsgTraceless.class);
        public final PBUInt64Field uint64_from = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to = PBField.initUInt64(0);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0);
    };
    public TroopTips0x857$MsgSecurityNotify opt_msg_security_notify = new MessageMicro<TroopTips0x857$MsgSecurityNotify>() { // from class: tencent.im.oidb.cmd0x857.TroopTips0x857$MsgSecurityNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{ShortVideoConstants.FROM_UIN, "msg_seq", "msg_random", "beat_type", "fold_msg"}, new Object[]{0L, 0, 0, 0, null}, TroopTips0x857$MsgSecurityNotify.class);
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBUInt32Field msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field msg_random = PBField.initUInt32(0);
        public final PBUInt32Field beat_type = PBField.initUInt32(0);
        public FoldingMsg fold_msg = new FoldingMsg();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class FoldingMsg extends MessageMicro<FoldingMsg> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField grey_prompt;
            public final PBBytesField toast;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"grey_prompt", "toast"}, new Object[]{byteStringMicro, byteStringMicro}, FoldingMsg.class);
            }

            public FoldingMsg() {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.grey_prompt = PBField.initBytes(byteStringMicro);
                this.toast = PBField.initBytes(byteStringMicro);
            }
        }
    };
    public TroopTips0x857$GroupMemberInfoChangeNotify opt_group_member_info_change_notify = new TroopTips0x857$GroupMemberInfoChangeNotify();
    public TroopTips0x857$TopBannerNotify opt_top_banner_notify = new TroopTips0x857$TopBannerNotify();
    public TroopTips0x857$GroupRobotChangeNotify opt_group_robot_change_notify = new TroopTips0x857$GroupRobotChangeNotify();
}
