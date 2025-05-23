package tencent.im.msg;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$Elem extends MessageMicro<im_msg_body$Elem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, 306, 314, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 338, 346, f.CTRL_INDEX, 362, 370, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, 386, 394, 402, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC}, new String[]{"text", PreDetect.FACE_DETECT, "online_image", "not_online_image", "trans_elem_info", "market_face", "elem_flags", "custom_face", "elem_flags2", "fun_face", "secret_file", "rich_msg", AbstractImageDownloader.TAG_GROUP, "pub_group", "market_trans", "extra_info", "shake_window", "pub_account", "video_file", "tips_info", "anon_group_msg", "qq_live_old", "life_online", "qqwallet_msg", "crm_elem", "conference_tips_info", "redbag_info", "low_version_tips", "bankcode_ctrl_info", "near_by_msg", "custom_elem", "location_info", "pub_acc_info", "small_emoji", "fsj_msg_elem", "ark_app", "general_flags", "hc_flash_pic", "deliver_gift_msg", "bitapp_msg", "open_qq_data", "apollo_msg", "group_pub_acc_info", "bless_msg", "src_msg", "lola_msg", "group_business_msg", "msg_workflow_notify", "pat_elem", "group_post_elem", "light_app", "eim_info", "common_elem"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteStringMicro.EMPTY, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, im_msg_body$Elem.class);
    public im_msg_body$Text text = new im_msg_body$Text();

    /* renamed from: face, reason: collision with root package name */
    public im_msg_body$Face f435954face = new im_msg_body$Face();
    public im_msg_body$OnlineImage online_image = new MessageMicro<im_msg_body$OnlineImage>() { // from class: tencent.im.msg.im_msg_body$OnlineImage
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField file_path;
        public final PBBytesField guid;
        public final PBBytesField old_ver_send_file;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"guid", "file_path", "old_ver_send_file"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$OnlineImage.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.guid = PBField.initBytes(byteStringMicro);
            this.file_path = PBField.initBytes(byteStringMicro);
            this.old_ver_send_file = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$NotOnlineImage not_online_image = new im_msg_body$NotOnlineImage();
    public im_msg_body$TransElem trans_elem_info = new im_msg_body$TransElem();
    public im_msg_body$MarketFace market_face = new im_msg_body$MarketFace();
    public im_msg_body$ElemFlags elem_flags = new MessageMicro<im_msg_body$ElemFlags>() { // from class: tencent.im.msg.im_msg_body$ElemFlags
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_business_data;
        public final PBBytesField bytes_flags1;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_flags1", "bytes_business_data"}, new Object[]{byteStringMicro, byteStringMicro}, im_msg_body$ElemFlags.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_flags1 = PBField.initBytes(byteStringMicro);
            this.bytes_business_data = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$CustomFace custom_face = new im_msg_body$CustomFace();
    public im_msg_body$ElemFlags2 elem_flags2 = new im_msg_body$ElemFlags2();
    public im_msg_body$FunFace fun_face = new MessageMicro<im_msg_body$FunFace>() { // from class: tencent.im.msg.im_msg_body$FunFace
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_turntable", "msg_bomb"}, new Object[]{null, null}, im_msg_body$FunFace.class);
        public Turntable msg_turntable = new Turntable();
        public Bomb msg_bomb = new Bomb();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Bomb extends MessageMicro<Bomb> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"bool_burst"}, new Object[]{Boolean.FALSE}, Bomb.class);
            public final PBBoolField bool_burst = PBField.initBool(false);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Turntable extends MessageMicro<Turntable> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"rpt_uint64_uin_list", "uint64_hit_uin", "str_hit_uin_nick"}, new Object[]{0L, 0L, ""}, Turntable.class);
            public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
            public final PBUInt64Field uint64_hit_uin = PBField.initUInt64(0);
            public final PBStringField str_hit_uin_nick = PBField.initString("");
        }
    };
    public im_msg_body$SecretFileMsg secret_file = new im_msg_body$SecretFileMsg();
    public im_msg_body$RichMsg rich_msg = new im_msg_body$RichMsg();
    public im_msg_body$GroupFile group_file = new im_msg_body$GroupFile();
    public im_msg_body$PubGroup pub_group = new im_msg_body$PubGroup();
    public im_msg_body$MarketTrans market_trans = new im_msg_body$MarketTrans();
    public im_msg_body$ExtraInfo extra_info = new im_msg_body$ExtraInfo();
    public im_msg_body$ShakeWindow shake_window = new im_msg_body$ShakeWindow();
    public im_msg_body$PubAccount pub_account = new MessageMicro<im_msg_body$PubAccount>() { // from class: tencent.im.msg.im_msg_body$PubAccount
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_buf", "uint64_pub_account_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, im_msg_body$PubAccount.class);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_pub_account_uin = PBField.initUInt64(0);
    };
    public im_msg_body$VideoFile video_file = new im_msg_body$VideoFile();
    public im_msg_body$TipsInfo tips_info = new im_msg_body$TipsInfo();
    public im_msg_body$AnonymousGroupMsg anon_group_msg = new im_msg_body$AnonymousGroupMsg();
    public im_msg_body$QQLiveOld qq_live_old = new MessageMicro<im_msg_body$QQLiveOld>() { // from class: tencent.im.msg.im_msg_body$QQLiveOld
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField str_introduce;
        public final PBBytesField str_param;
        public final PBBytesField str_show_text;
        public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_sub_cmd", "str_show_text", "str_param", "str_introduce"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$QQLiveOld.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_show_text = PBField.initBytes(byteStringMicro);
            this.str_param = PBField.initBytes(byteStringMicro);
            this.str_introduce = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$LifeOnlineAccount life_online = new im_msg_body$LifeOnlineAccount();
    public im_msg_body$QQWalletMsg qqwallet_msg = new im_msg_body$QQWalletMsg();
    public im_msg_body$CrmElem crm_elem = new im_msg_body$CrmElem();
    public im_msg_body$ConferenceTipsInfo conference_tips_info = new MessageMicro<im_msg_body$ConferenceTipsInfo>() { // from class: tencent.im.msg.im_msg_body$ConferenceTipsInfo
        public static final int ECONFST_BUDDY_AV = 2;
        public static final int ECONFST_DISCUSS_AV = 1;
        public static final int ECONFST_NONE = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_session_type", "uint64_session_uin", "str_text"}, new Object[]{0, 0L, ""}, im_msg_body$ConferenceTipsInfo.class);
        public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0);
        public final PBStringField str_text = PBField.initString("");
    };
    public im_msg_body$RedBagInfo redbag_info = new MessageMicro<im_msg_body$RedBagInfo>() { // from class: tencent.im.msg.im_msg_body$RedBagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"redbag_type"}, new Object[]{0}, im_msg_body$RedBagInfo.class);
        public final PBUInt32Field redbag_type = PBField.initUInt32(0);
    };
    public im_msg_body$LowVersionTips low_version_tips = new MessageMicro<im_msg_body$LowVersionTips>() { // from class: tencent.im.msg.im_msg_body$LowVersionTips
        public static final int CF_BuddyChatType = 0;
        public static final int CF_DiscussChatType = 3;
        public static final int CF_GroupChatType = 1;
        public static final int CF_TempChatType = 2;
        public static final int CF_UnknownChatType = -1;
        public static final int EBusinessID_ConfScheduleMsg = 1;
        public static final int EBusinessID_DingDongMsg = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_business_id", "uint32_session_type", "uint64_session_uin", "uint64_sender_uin", "str_text"}, new Object[]{0, 0, 0L, 0L, ""}, im_msg_body$LowVersionTips.class);
        public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBStringField str_text = PBField.initString("");
    };
    public final PBBytesField bankcode_ctrl_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg_body$NearByMessageType near_by_msg = new im_msg_body$NearByMessageType();
    public im_msg_body$CustomElem custom_elem = new MessageMicro<im_msg_body$CustomElem>() { // from class: tencent.im.msg.im_msg_body$CustomElem
        public static final int DataType_Bin = 2;
        public static final int DataType_Text = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_data;
        public final PBBytesField bytes_desc;
        public final PBBytesField bytes_ext;
        public final PBBytesField bytes_sound;
        public final PBEnumField enum_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"bytes_desc", "bytes_data", "enum_type", "bytes_ext", "bytes_sound"}, new Object[]{byteStringMicro, byteStringMicro, 1, byteStringMicro, byteStringMicro}, im_msg_body$CustomElem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_desc = PBField.initBytes(byteStringMicro);
            this.bytes_data = PBField.initBytes(byteStringMicro);
            this.enum_type = PBField.initEnum(1);
            this.bytes_ext = PBField.initBytes(byteStringMicro);
            this.bytes_sound = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$LocationInfo location_info = new MessageMicro<im_msg_body$LocationInfo>() { // from class: tencent.im.msg.im_msg_body$LocationInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBDoubleField double_longitude = PBField.initDouble(0.0d);
        public final PBDoubleField double_latitude = PBField.initDouble(0.0d);
        public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17, 26}, new String[]{"double_longitude", "double_latitude", "bytes_desc"}, new Object[]{valueOf, valueOf, ByteStringMicro.EMPTY}, im_msg_body$LocationInfo.class);
        }
    };
    public im_msg_body$PubAccInfo pub_acc_info = new im_msg_body$PubAccInfo();
    public im_msg_body$SmallEmoji small_emoji = new im_msg_body$SmallEmoji();
    public im_msg_body$FSJMessageElem fsj_msg_elem = new MessageMicro<im_msg_body$FSJMessageElem>() { // from class: tencent.im.msg.im_msg_body$FSJMessageElem
        public static final int ETypeHotChatFlashPic = 1;
        public static final int ETypeNormal = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_msg_type"}, new Object[]{0}, im_msg_body$FSJMessageElem.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    };
    public im_msg_body$ArkAppElem ark_app = new im_msg_body$ArkAppElem();
    public im_msg_body$GeneralFlags general_flags = new im_msg_body$GeneralFlags();
    public im_msg_body$CustomFace hc_flash_pic = new im_msg_body$CustomFace();
    public im_msg_body$DeliverGiftMsg deliver_gift_msg = new im_msg_body$DeliverGiftMsg();
    public im_msg_body$BitAppMsg bitapp_msg = new MessageMicro<im_msg_body$BitAppMsg>() { // from class: tencent.im.msg.im_msg_body$BitAppMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_buf"}, new Object[]{ByteStringMicro.EMPTY}, im_msg_body$BitAppMsg.class);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public im_msg_body$OpenQQData open_qq_data = new MessageMicro<im_msg_body$OpenQQData>() { // from class: tencent.im.msg.im_msg_body$OpenQQData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_car_qq_data"}, new Object[]{ByteStringMicro.EMPTY}, im_msg_body$OpenQQData.class);
        public final PBBytesField bytes_car_qq_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public im_msg_body$ApolloActMsg apollo_msg = new MessageMicro<im_msg_body$ApolloActMsg>() { // from class: tencent.im.msg.im_msg_body$ApolloActMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_action_name;
        public final PBBytesField bytes_action_text;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField diytext_content;
        public final PBUInt32Field diytext_id;
        public final PBBytesField input_text;
        public final PBInt32Field int32_peer_status;
        public final PBInt32Field int32_sender_status;
        public final PBUInt32Field uint32_action_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag;
        public final PBUInt32Field uint32_peer_ts;
        public final PBUInt32Field uint32_peer_uin;
        public final PBUInt32Field uint32_sender_ts;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106}, new String[]{"uint32_action_id", "bytes_action_name", "bytes_action_text", "uint32_flag", "uint32_peer_uin", "uint32_sender_ts", "uint32_peer_ts", "int32_sender_status", "int32_peer_status", "diytext_id", "diytext_content", "input_text", "bytes_pb_reserve"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$ApolloActMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_action_name = PBField.initBytes(byteStringMicro);
            this.bytes_action_text = PBField.initBytes(byteStringMicro);
            this.uint32_flag = PBField.initUInt32(0);
            this.uint32_peer_uin = PBField.initUInt32(0);
            this.uint32_sender_ts = PBField.initUInt32(0);
            this.uint32_peer_ts = PBField.initUInt32(0);
            this.int32_sender_status = PBField.initInt32(0);
            this.int32_peer_status = PBField.initInt32(0);
            this.diytext_id = PBField.initUInt32(0);
            this.diytext_content = PBField.initBytes(byteStringMicro);
            this.input_text = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$GroupPubAccountInfo group_pub_acc_info = new im_msg_body$GroupPubAccountInfo();
    public im_msg_body$BlessingMessage bless_msg = new im_msg_body$BlessingMessage();
    public im_msg_body$SourceMsg src_msg = new im_msg_body$SourceMsg();
    public im_msg_body$LolaMsg lola_msg = new MessageMicro<im_msg_body$LolaMsg>() { // from class: tencent.im.msg.im_msg_body$LolaMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_download_key;
        public final PBBytesField bytes_encode_content;
        public final PBBytesField bytes_long_msg_url;
        public final PBBytesField bytes_msg_resid;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_msg_resid", "bytes_encode_content", "bytes_long_msg_url", "bytes_download_key"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$LolaMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
            this.bytes_encode_content = PBField.initBytes(byteStringMicro);
            this.bytes_long_msg_url = PBField.initBytes(byteStringMicro);
            this.bytes_download_key = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$GroupBusinessMsg group_business_msg = new MessageMicro<im_msg_body$GroupBusinessMsg>() { // from class: tencent.im.msg.im_msg_body$GroupBusinessMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_head_clk_url;
        public final PBBytesField bytes_head_url;
        public final PBBytesField bytes_nick;
        public final PBBytesField bytes_nick_color;
        public final PBBytesField bytes_rank;
        public final PBBytesField bytes_rank_bgcolor;
        public final PBBytesField bytes_rank_color;
        public final PBUInt32Field uint32_flags = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uint32_flags", "bytes_head_url", "bytes_head_clk_url", "bytes_nick", "bytes_nick_color", "bytes_rank", "bytes_rank_color", "bytes_rank_bgcolor"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$GroupBusinessMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_head_url = PBField.initBytes(byteStringMicro);
            this.bytes_head_clk_url = PBField.initBytes(byteStringMicro);
            this.bytes_nick = PBField.initBytes(byteStringMicro);
            this.bytes_nick_color = PBField.initBytes(byteStringMicro);
            this.bytes_rank = PBField.initBytes(byteStringMicro);
            this.bytes_rank_color = PBField.initBytes(byteStringMicro);
            this.bytes_rank_bgcolor = PBField.initBytes(byteStringMicro);
        }
    };
    public im_msg_body$WorkflowNotifyMsg msg_workflow_notify = new MessageMicro<im_msg_body$WorkflowNotifyMsg>() { // from class: tencent.im.msg.im_msg_body$WorkflowNotifyMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_ext_msg", "uint64_create_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, im_msg_body$WorkflowNotifyMsg.class);
        public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0);
    };
    public im_msg_body$PatsElem pat_elem = new MessageMicro<im_msg_body$PatsElem>() { // from class: tencent.im.msg.im_msg_body$PatsElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_pat_type", "uint32_pat_count"}, new Object[]{0, 0}, im_msg_body$PatsElem.class);
        public final PBUInt32Field uint32_pat_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pat_count = PBField.initUInt32(0);
    };
    public im_msg_body$GroupPostElem group_post_elem = new MessageMicro<im_msg_body$GroupPostElem>() { // from class: tencent.im.msg.im_msg_body$GroupPostElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_trans_type", "bytes_trans_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, im_msg_body$GroupPostElem.class);
        public final PBUInt32Field uint32_trans_type = PBField.initUInt32(0);
        public final PBBytesField bytes_trans_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public im_msg_body$LightAppElem light_app = new im_msg_body$LightAppElem();
    public im_msg_body$EIMInfo eim_info = new MessageMicro<im_msg_body$EIMInfo>() { // from class: tencent.im.msg.im_msg_body$EIMInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_root_id", "uint32_flag"}, new Object[]{0L, 0}, im_msg_body$EIMInfo.class);
        public final PBUInt64Field uint64_root_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    };
    public im_msg_body$CommonElem common_elem = new im_msg_body$CommonElem();
}
