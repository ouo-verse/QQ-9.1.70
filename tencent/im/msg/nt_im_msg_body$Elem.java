package tencent.im.msg;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_body$Elem extends MessageMicro<nt_im_msg_body$Elem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, 306, 314, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 338, 346, f.CTRL_INDEX, 362, 370, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, 386, 394, 402, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC}, new String[]{"text", PreDetect.FACE_DETECT, "online_image", "not_online_image", "trans_elem_info", "market_face", "elem_flags", "custom_face", "elem_flags2", "fun_face", "secret_file", "rich_msg", AbstractImageDownloader.TAG_GROUP, "pub_group", "market_trans", "extra_info", "shake_window", "pub_account", "video_file", "tips_info", "anon_group_msg", "qq_live_old", "life_online", "qqwallet_msg", "crm_elem", "conference_tips_info", "redbag_info", "low_version_tips", "bankcode_ctrl_info", "near_by_msg", "custom_elem", "location_info", "pub_acc_info", "small_emoji", "fsj_msg_elem", "ark_app", "general_flags", "hc_flash_pic", "deliver_gift_msg", "bitapp_msg", "open_qq_data", "apollo_msg", "group_pub_acc_info", "bless_msg", "src_msg", "lola_msg", "group_business_msg", "msg_workflow_notify", "pat_elem", "group_post_elem", "light_app", "eim_info", "common_elem"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteStringMicro.EMPTY, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, nt_im_msg_body$Elem.class);
    public nt_im_msg_body$Text text = new MessageMicro<nt_im_msg_body$Text>() { // from class: tencent.im.msg.nt_im_msg_body$Text
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField attr_6_buf;
        public final PBBytesField attr_7_buf;
        public final PBBytesField buf;
        public final PBBytesField bytes_pb_reserve;
        public final PBStringField link;
        public final PBBytesField str;

        static {
            String[] strArr = {"str", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "attr_6_buf", "attr_7_buf", "buf", "bytes_pb_reserve"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 90, 98}, strArr, new Object[]{byteStringMicro, "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$Text.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str = PBField.initBytes(byteStringMicro);
            this.link = PBField.initString("");
            this.attr_6_buf = PBField.initBytes(byteStringMicro);
            this.attr_7_buf = PBField.initBytes(byteStringMicro);
            this.buf = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };

    /* renamed from: face, reason: collision with root package name */
    public nt_im_msg_body$Face f435955face = new MessageMicro<nt_im_msg_body$Face>() { // from class: tencent.im.msg.nt_im_msg_body$Face
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField buf;
        public final PBUInt32Field index = PBField.initUInt32(0);
        public final PBBytesField old;

        static {
            String[] strArr = {"index", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "buf"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 90}, strArr, new Object[]{0, byteStringMicro, byteStringMicro}, nt_im_msg_body$Face.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.old = PBField.initBytes(byteStringMicro);
            this.buf = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$OnlineImage online_image = new MessageMicro<nt_im_msg_body$OnlineImage>() { // from class: tencent.im.msg.nt_im_msg_body$OnlineImage
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField file_path;
        public final PBBytesField guid;
        public final PBBytesField old_ver_send_file;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"guid", "file_path", "old_ver_send_file"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$OnlineImage.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.guid = PBField.initBytes(byteStringMicro);
            this.file_path = PBField.initBytes(byteStringMicro);
            this.old_ver_send_file = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$NotOnlineImage not_online_image = new nt_im_msg_body$NotOnlineImage();
    public nt_im_msg_body$TransElem trans_elem_info = new MessageMicro<nt_im_msg_body$TransElem>() { // from class: tencent.im.msg.nt_im_msg_body$TransElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"elem_type", "elem_value"}, new Object[]{0, ByteStringMicro.EMPTY}, nt_im_msg_body$TransElem.class);
        public final PBUInt32Field elem_type = PBField.initUInt32(0);
        public final PBBytesField elem_value = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nt_im_msg_body$MarketFace market_face = new MessageMicro<nt_im_msg_body$MarketFace>() { // from class: tencent.im.msg.nt_im_msg_body$MarketFace
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_face_id;
        public final PBBytesField bytes_face_name;
        public final PBBytesField bytes_key;
        public final PBBytesField bytes_mobileparam;
        public final PBBytesField bytes_param;
        public final PBBytesField bytes_pb_reserve;
        public final PBUInt32Field uint32_face_info;
        public final PBUInt32Field uint32_image_height;
        public final PBUInt32Field uint32_image_width;
        public final PBUInt32Field uint32_item_type;
        public final PBUInt32Field uint32_media_type;
        public final PBUInt32Field uint32_sub_type;
        public final PBUInt32Field uint32_tab_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106}, new String[]{"bytes_face_name", "uint32_item_type", "uint32_face_info", "bytes_face_id", "uint32_tab_id", "uint32_sub_type", "bytes_key", "bytes_param", "uint32_media_type", "uint32_image_width", "uint32_image_height", "bytes_mobileparam", "bytes_pb_reserve"}, new Object[]{byteStringMicro, 0, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro}, nt_im_msg_body$MarketFace.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_face_name = PBField.initBytes(byteStringMicro);
            this.uint32_item_type = PBField.initUInt32(0);
            this.uint32_face_info = PBField.initUInt32(0);
            this.bytes_face_id = PBField.initBytes(byteStringMicro);
            this.uint32_tab_id = PBField.initUInt32(0);
            this.uint32_sub_type = PBField.initUInt32(0);
            this.bytes_key = PBField.initBytes(byteStringMicro);
            this.bytes_param = PBField.initBytes(byteStringMicro);
            this.uint32_media_type = PBField.initUInt32(0);
            this.uint32_image_width = PBField.initUInt32(0);
            this.uint32_image_height = PBField.initUInt32(0);
            this.bytes_mobileparam = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$ElemFlags elem_flags = new MessageMicro<nt_im_msg_body$ElemFlags>() { // from class: tencent.im.msg.nt_im_msg_body$ElemFlags
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_business_data;
        public final PBBytesField bytes_flags1;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_flags1", "bytes_business_data"}, new Object[]{byteStringMicro, byteStringMicro}, nt_im_msg_body$ElemFlags.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_flags1 = PBField.initBytes(byteStringMicro);
            this.bytes_business_data = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$CustomFace custom_face = new MessageMicro<nt_im_msg_body$CustomFace>() { // from class: tencent.im.msg.nt_im_msg_body$CustomFace
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field biz_type;
        public final PBBytesField bytes_buffer;
        public final PBBytesField bytes_flag;
        public final PBBytesField bytes_guid;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_old_data;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_signature;
        public final PBUInt32Field image_type;
        public final PBUInt32Field index;
        public final PBUInt32Field repeat_image;
        public final PBUInt32Field repeat_index;
        public final PBStringField str_400_url;
        public final PBStringField str_big_url;
        public final PBStringField str_file_path;
        public final PBStringField str_orig_url;
        public final PBStringField str_shortcut;
        public final PBStringField str_thumb_url;
        public final PBUInt32Field uint32_400_height;
        public final PBUInt32Field uint32_400_width;
        public final PBUInt32Field uint32_download_len;
        public final PBUInt32Field uint32_file_id;
        public final PBUInt32Field uint32_file_type;
        public final PBUInt32Field uint32_height;
        public final PBUInt32Field uint32_origin;
        public final PBUInt32Field uint32_server_ip;
        public final PBUInt32Field uint32_server_port;
        public final PBUInt32Field uint32_show_len;
        public final PBUInt32Field uint32_size;
        public final PBUInt32Field uint32_source;
        public final PBUInt32Field uint32_thumb_height;
        public final PBUInt32Field uint32_thumb_width;
        public final PBUInt32Field uint32_useful;
        public final PBUInt32Field uint32_width;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 264, 274}, new String[]{"bytes_guid", "str_file_path", "str_shortcut", "bytes_buffer", "bytes_flag", "bytes_old_data", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "uint32_file_type", "bytes_signature", "uint32_useful", "bytes_md5", "str_thumb_url", "str_big_url", "str_orig_url", "biz_type", "repeat_index", "repeat_image", "image_type", "index", "uint32_width", "uint32_height", "uint32_source", "uint32_size", "uint32_origin", "uint32_thumb_width", "uint32_thumb_height", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve"}, new Object[]{byteStringMicro, "", "", byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, byteStringMicro}, nt_im_msg_body$CustomFace.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_guid = PBField.initBytes(byteStringMicro);
            this.str_file_path = PBField.initString("");
            this.str_shortcut = PBField.initString("");
            this.bytes_buffer = PBField.initBytes(byteStringMicro);
            this.bytes_flag = PBField.initBytes(byteStringMicro);
            this.bytes_old_data = PBField.initBytes(byteStringMicro);
            this.uint32_file_id = PBField.initUInt32(0);
            this.uint32_server_ip = PBField.initUInt32(0);
            this.uint32_server_port = PBField.initUInt32(0);
            this.uint32_file_type = PBField.initUInt32(0);
            this.bytes_signature = PBField.initBytes(byteStringMicro);
            this.uint32_useful = PBField.initUInt32(0);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.str_thumb_url = PBField.initString("");
            this.str_big_url = PBField.initString("");
            this.str_orig_url = PBField.initString("");
            this.biz_type = PBField.initUInt32(0);
            this.repeat_index = PBField.initUInt32(0);
            this.repeat_image = PBField.initUInt32(0);
            this.image_type = PBField.initUInt32(0);
            this.index = PBField.initUInt32(0);
            this.uint32_width = PBField.initUInt32(0);
            this.uint32_height = PBField.initUInt32(0);
            this.uint32_source = PBField.initUInt32(0);
            this.uint32_size = PBField.initUInt32(0);
            this.uint32_origin = PBField.initUInt32(0);
            this.uint32_thumb_width = PBField.initUInt32(0);
            this.uint32_thumb_height = PBField.initUInt32(0);
            this.uint32_show_len = PBField.initUInt32(0);
            this.uint32_download_len = PBField.initUInt32(0);
            this.str_400_url = PBField.initString("");
            this.uint32_400_width = PBField.initUInt32(0);
            this.uint32_400_height = PBField.initUInt32(0);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$ElemFlags2 elem_flags2 = new nt_im_msg_body$ElemFlags2();
    public nt_im_msg_body$FunFace fun_face = new MessageMicro<nt_im_msg_body$FunFace>() { // from class: tencent.im.msg.nt_im_msg_body$FunFace
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_turntable", "msg_bomb"}, new Object[]{null, null}, nt_im_msg_body$FunFace.class);
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
    public nt_im_msg_body$SecretFileMsg secret_file = new MessageMicro<nt_im_msg_body$SecretFileMsg>() { // from class: tencent.im.msg.nt_im_msg_body$SecretFileMsg
        public static final int TYPE_C2C = 0;
        public static final int TYPE_DISCU = 4;
        public static final int TYPE_GROUP = 2;
        public static final int TYPE_NEARBA = 3;
        public static final int TYPE_WPA = 5;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_encrypt_key;
        public final PBBytesField bytes_file_key;
        public nt_im_msg_body$ElemFlags2 elem_flags2;
        public nt_im_msg_body$NotOnlineImage not_online_image;
        public final PBStringField str_fromphonenum;
        public final PBUInt32Field uint32_encrypt_prehead_length;
        public final PBUInt32Field uint32_encrypt_type;
        public final PBUInt32Field uint32_left_time;
        public final PBUInt32Field uint32_opertype;
        public final PBUInt32Field uint32_read_times;
        public final PBUInt32Field uint32_status;
        public final PBUInt32Field uint32_ttl;
        public final PBUInt32Field uint32_type;
        public final PBUInt64Field uint64_from_uin;
        public final PBUInt64Field uint64_to_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 122}, new String[]{"bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image", "elem_flags2", "uint32_opertype", "str_fromphonenum"}, new Object[]{byteStringMicro, 0L, 0L, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, null, null, 0, ""}, nt_im_msg_body$SecretFileMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.uint64_from_uin = PBField.initUInt64(0L);
            this.uint64_to_uin = PBField.initUInt64(0L);
            this.uint32_status = PBField.initUInt32(0);
            this.uint32_ttl = PBField.initUInt32(0);
            this.uint32_type = PBField.initUInt32(0);
            this.uint32_encrypt_prehead_length = PBField.initUInt32(0);
            this.uint32_encrypt_type = PBField.initUInt32(0);
            this.bytes_encrypt_key = PBField.initBytes(byteStringMicro);
            this.uint32_read_times = PBField.initUInt32(0);
            this.uint32_left_time = PBField.initUInt32(0);
            this.not_online_image = new nt_im_msg_body$NotOnlineImage();
            this.elem_flags2 = new nt_im_msg_body$ElemFlags2();
            this.uint32_opertype = PBField.initUInt32(0);
            this.str_fromphonenum = PBField.initString("");
        }
    };
    public nt_im_msg_body$RichMsg rich_msg = new MessageMicro<nt_im_msg_body$RichMsg>() { // from class: tencent.im.msg.nt_im_msg_body$RichMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_msg_resid;
        public final PBBytesField bytes_template_1;
        public final PBUInt32Field uint32_flags;
        public final PBUInt32Field uint32_rand;
        public final PBUInt32Field uint32_seq;
        public final PBUInt32Field uint32_service_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"bytes_template_1", "uint32_service_id", "bytes_msg_resid", "uint32_rand", "uint32_seq", "uint32_flags"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0, 0, 0}, nt_im_msg_body$RichMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_template_1 = PBField.initBytes(byteStringMicro);
            this.uint32_service_id = PBField.initUInt32(0);
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
            this.uint32_rand = PBField.initUInt32(0);
            this.uint32_seq = PBField.initUInt32(0);
            this.uint32_flags = PBField.initUInt32(0);
        }
    };
    public nt_im_msg_body$GroupFile group_file = new MessageMicro<nt_im_msg_body$GroupFile>() { // from class: tencent.im.msg.nt_im_msg_body$GroupFile
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_batch_id;
        public final PBBytesField bytes_batch_item_id;
        public final PBBytesField bytes_file_id;
        public final PBBytesField bytes_file_key;
        public final PBBytesField bytes_filename;
        public final PBBytesField bytes_mark;
        public final PBBytesField bytes_pb_reserve;
        public final PBUInt32Field uint32_feed_msg_time;
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_sequence;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 66, 72, 82}, new String[]{"bytes_filename", "uint64_file_size", "bytes_file_id", "bytes_batch_id", "bytes_file_key", "bytes_mark", "uint64_sequence", "bytes_batch_item_id", "uint32_feed_msg_time", "bytes_pb_reserve"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro}, nt_im_msg_body$GroupFile.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_filename = PBField.initBytes(byteStringMicro);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.bytes_file_id = PBField.initBytes(byteStringMicro);
            this.bytes_batch_id = PBField.initBytes(byteStringMicro);
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.bytes_mark = PBField.initBytes(byteStringMicro);
            this.uint64_sequence = PBField.initUInt64(0L);
            this.bytes_batch_item_id = PBField.initBytes(byteStringMicro);
            this.uint32_feed_msg_time = PBField.initUInt32(0);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$PubGroup pub_group = new nt_im_msg_body$PubGroup();
    public nt_im_msg_body$MarketTrans market_trans = new MessageMicro<nt_im_msg_body$MarketTrans>() { // from class: tencent.im.msg.nt_im_msg_body$MarketTrans
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_msg_resid;
        public final PBBytesField bytes_xml;
        public final PBInt32Field int32_flag = PBField.initInt32(0);
        public final PBUInt32Field uint32_ability;
        public final PBUInt32Field uint32_min_ability;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"int32_flag", "bytes_xml", "bytes_msg_resid", "uint32_ability", "uint32_min_ability"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0}, nt_im_msg_body$MarketTrans.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_xml = PBField.initBytes(byteStringMicro);
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
            this.uint32_ability = PBField.initUInt32(0);
            this.uint32_min_ability = PBField.initUInt32(0);
        }
    };
    public nt_im_msg_body$ExtraInfo extra_info = new nt_im_msg_body$ExtraInfo();
    public nt_im_msg_body$ShakeWindow shake_window = new MessageMicro<nt_im_msg_body$ShakeWindow>() { // from class: tencent.im.msg.nt_im_msg_body$ShakeWindow
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_type", "uint32_reserve", "uint64_uin"}, new Object[]{0, 0, 0L}, nt_im_msg_body$ShakeWindow.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_reserve = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
    public nt_im_msg_body$PubAccount pub_account = new MessageMicro<nt_im_msg_body$PubAccount>() { // from class: tencent.im.msg.nt_im_msg_body$PubAccount
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_buf", "uint64_pub_account_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, nt_im_msg_body$PubAccount.class);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_pub_account_uin = PBField.initUInt64(0);
    };
    public nt_im_msg_body$VideoFile video_file = new MessageMicro<nt_im_msg_body$VideoFile>() { // from class: tencent.im.msg.nt_im_msg_body$VideoFile
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_support_progressive;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_file_name;
        public final PBBytesField bytes_file_uuid;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_source;
        public final PBBytesField bytes_thumb_file_md5;
        public final PBRepeatField<ByteStringMicro> rpt_bytes_thumb_file_urls;
        public final PBRepeatField<ByteStringMicro> rpt_bytes_video_file_urls;
        public final PBUInt32Field uint32_busi_type;
        public final PBUInt32Field uint32_file_format;
        public final PBUInt32Field uint32_file_height;
        public final PBUInt32Field uint32_file_size;
        public final PBUInt32Field uint32_file_time;
        public final PBUInt32Field uint32_file_width;
        public final PBUInt32Field uint32_from_chat_type;
        public final PBUInt32Field uint32_sub_busi_type;
        public final PBUInt32Field uint32_thumb_download_flag;
        public final PBUInt32Field uint32_thumb_file_size;
        public final PBUInt32Field uint32_thumb_height;
        public final PBUInt32Field uint32_thumb_width;
        public final PBUInt32Field uint32_to_chat_type;
        public final PBUInt32Field uint32_video_attr;
        public final PBUInt32Field uint32_video_download_flag;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 152, 162, 170, 176, 184, 194}, new String[]{"bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_file_md5", "bytes_source", "uint32_thumb_file_size", "uint32_busi_type", "uint32_from_chat_type", "uint32_to_chat_type", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "uint32_sub_busi_type", "uint32_video_attr", "rpt_bytes_thumb_file_urls", "rpt_bytes_video_file_urls", "uint32_thumb_download_flag", "uint32_video_download_flag", "bytes_pb_reserve"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, Boolean.FALSE, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, nt_im_msg_body$VideoFile.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_file_name = PBField.initBytes(byteStringMicro);
            this.uint32_file_format = PBField.initUInt32(0);
            this.uint32_file_time = PBField.initUInt32(0);
            this.uint32_file_size = PBField.initUInt32(0);
            this.uint32_thumb_width = PBField.initUInt32(0);
            this.uint32_thumb_height = PBField.initUInt32(0);
            this.bytes_thumb_file_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_source = PBField.initBytes(byteStringMicro);
            this.uint32_thumb_file_size = PBField.initUInt32(0);
            this.uint32_busi_type = PBField.initUInt32(0);
            this.uint32_from_chat_type = PBField.initUInt32(0);
            this.uint32_to_chat_type = PBField.initUInt32(0);
            this.bool_support_progressive = PBField.initBool(false);
            this.uint32_file_width = PBField.initUInt32(0);
            this.uint32_file_height = PBField.initUInt32(0);
            this.uint32_sub_busi_type = PBField.initUInt32(0);
            this.uint32_video_attr = PBField.initUInt32(0);
            PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
            this.rpt_bytes_thumb_file_urls = PBField.initRepeat(pBBytesField);
            this.rpt_bytes_video_file_urls = PBField.initRepeat(pBBytesField);
            this.uint32_thumb_download_flag = PBField.initUInt32(0);
            this.uint32_video_download_flag = PBField.initUInt32(0);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$TipsInfo tips_info = new MessageMicro<nt_im_msg_body$TipsInfo>() { // from class: tencent.im.msg.nt_im_msg_body$TipsInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"text"}, new Object[]{""}, nt_im_msg_body$TipsInfo.class);
        public final PBStringField text = PBField.initString("");
    };
    public nt_im_msg_body$AnonymousGroupMsg anon_group_msg = new MessageMicro<nt_im_msg_body$AnonymousGroupMsg>() { // from class: tencent.im.msg.nt_im_msg_body$AnonymousGroupMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField str_anon_id;
        public final PBBytesField str_anon_nick;
        public final PBBytesField str_rank_color;
        public final PBUInt32Field uint32_bubble_id;
        public final PBUInt32Field uint32_expire_time;
        public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
        public final PBUInt32Field uint32_head_portrait;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58}, new String[]{"uint32_flags", "str_anon_id", "str_anon_nick", "uint32_head_portrait", "uint32_expire_time", "uint32_bubble_id", "str_rank_color"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro}, nt_im_msg_body$AnonymousGroupMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_anon_id = PBField.initBytes(byteStringMicro);
            this.str_anon_nick = PBField.initBytes(byteStringMicro);
            this.uint32_head_portrait = PBField.initUInt32(0);
            this.uint32_expire_time = PBField.initUInt32(0);
            this.uint32_bubble_id = PBField.initUInt32(0);
            this.str_rank_color = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$QQLiveOld qq_live_old = new MessageMicro<nt_im_msg_body$QQLiveOld>() { // from class: tencent.im.msg.nt_im_msg_body$QQLiveOld
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField str_introduce;
        public final PBBytesField str_param;
        public final PBBytesField str_show_text;
        public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_sub_cmd", "str_show_text", "str_param", "str_introduce"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$QQLiveOld.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_show_text = PBField.initBytes(byteStringMicro);
            this.str_param = PBField.initBytes(byteStringMicro);
            this.str_introduce = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$LifeOnlineAccount life_online = new MessageMicro<nt_im_msg_body$LifeOnlineAccount>() { // from class: tencent.im.msg.nt_im_msg_body$LifeOnlineAccount
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField gdt_cli_data;
        public final PBBytesField gdt_imp_data;
        public final PBBytesField view_id;
        public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_op = PBField.initUInt32(0);
        public final PBUInt32Field uint32_show_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_report = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ack = PBField.initUInt32(0);
        public final PBUInt64Field uint64_bitmap = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74}, new String[]{"uint64_unique_id", "uint32_op", "uint32_show_time", "uint32_report", "uint32_ack", "uint64_bitmap", "gdt_imp_data", "gdt_cli_data", "view_id"}, new Object[]{0L, 0, 0, 0, 0, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$LifeOnlineAccount.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.gdt_imp_data = PBField.initBytes(byteStringMicro);
            this.gdt_cli_data = PBField.initBytes(byteStringMicro);
            this.view_id = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$QQWalletMsg qqwallet_msg = new MessageMicro<nt_im_msg_body$QQWalletMsg>() { // from class: tencent.im.msg.nt_im_msg_body$QQWalletMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"aio_body"}, new Object[]{null}, nt_im_msg_body$QQWalletMsg.class);
        public nt_im_msg_body$QQWalletAioBody aio_body = new MessageMicro<nt_im_msg_body$QQWalletAioBody>() { // from class: tencent.im.msg.nt_im_msg_body$QQWalletAioBody
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_authkey;
            public final PBBytesField bytes_billno;
            public final PBBytesField bytes_name;
            public final PBBytesField bytes_pb_reserve;
            public final PBBytesField bytes_pc_body;
            public final PBSInt32Field sint32_conftype;
            public final PBSInt32Field sint32_envelopeid;
            public final PBSInt32Field sint32_msg_from;
            public final PBSInt32Field sint32_msgtype;
            public final PBSInt32Field sint32_sessiontype;
            public final PBBytesField string_index;
            public final PBUInt32Field uint32_redchannel;
            public final PBRepeatField<Long> uint64_grap_uin;
            public final PBUInt64Field uint64_senduin = PBField.initUInt64(0);
            public nt_im_msg_body$QQWalletAioElem sender = new MessageMicro<nt_im_msg_body$QQWalletAioElem>() { // from class: tencent.im.msg.nt_im_msg_body$QQWalletAioElem
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_actions_priority;
                public final PBBytesField bytes_aio_image_left;
                public final PBBytesField bytes_aio_image_right;
                public final PBBytesField bytes_blackstripe;
                public final PBBytesField bytes_cft_image;
                public final PBBytesField bytes_content;
                public final PBBytesField bytes_iconurl;
                public final PBBytesField bytes_jump_url;
                public final PBBytesField bytes_linkurl;
                public final PBBytesField bytes_native_android;
                public final PBBytesField bytes_native_ios;
                public final PBBytesField bytes_notice;
                public final PBBytesField bytes_pb_reserve;
                public final PBBytesField bytes_subtitle;
                public final PBBytesField bytes_title;
                public final PBUInt32Field uint32_content_bgcolor;
                public final PBUInt32Field uint32_content_color;
                public final PBUInt32Field uint32_subtitle_color;
                public final PBUInt32Field uint32_title_color;
                public final PBUInt32Field uint32_background = PBField.initUInt32(0);
                public final PBUInt32Field uint32_icon = PBField.initUInt32(0);

                static {
                    String[] strArr = {"uint32_background", "uint32_icon", "bytes_title", "bytes_subtitle", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "bytes_linkurl", "bytes_blackstripe", "bytes_notice", "uint32_title_color", "uint32_subtitle_color", "bytes_actions_priority", "bytes_jump_url", "bytes_native_ios", "bytes_native_android", "bytes_iconurl", "uint32_content_color", "uint32_content_bgcolor", "bytes_aio_image_left", "bytes_aio_image_right", "bytes_cft_image", "bytes_pb_reserve"};
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 128, 136, 146, 154, 162, 170}, strArr, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$QQWalletAioElem.class);
                }

                {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    this.bytes_title = PBField.initBytes(byteStringMicro);
                    this.bytes_subtitle = PBField.initBytes(byteStringMicro);
                    this.bytes_content = PBField.initBytes(byteStringMicro);
                    this.bytes_linkurl = PBField.initBytes(byteStringMicro);
                    this.bytes_blackstripe = PBField.initBytes(byteStringMicro);
                    this.bytes_notice = PBField.initBytes(byteStringMicro);
                    this.uint32_title_color = PBField.initUInt32(0);
                    this.uint32_subtitle_color = PBField.initUInt32(0);
                    this.bytes_actions_priority = PBField.initBytes(byteStringMicro);
                    this.bytes_jump_url = PBField.initBytes(byteStringMicro);
                    this.bytes_native_ios = PBField.initBytes(byteStringMicro);
                    this.bytes_native_android = PBField.initBytes(byteStringMicro);
                    this.bytes_iconurl = PBField.initBytes(byteStringMicro);
                    this.uint32_content_color = PBField.initUInt32(0);
                    this.uint32_content_bgcolor = PBField.initUInt32(0);
                    this.bytes_aio_image_left = PBField.initBytes(byteStringMicro);
                    this.bytes_aio_image_right = PBField.initBytes(byteStringMicro);
                    this.bytes_cft_image = PBField.initBytes(byteStringMicro);
                    this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
                }
            };
            public nt_im_msg_body$QQWalletAioElem receiver = new MessageMicro<nt_im_msg_body$QQWalletAioElem>() { // from class: tencent.im.msg.nt_im_msg_body$QQWalletAioElem
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_actions_priority;
                public final PBBytesField bytes_aio_image_left;
                public final PBBytesField bytes_aio_image_right;
                public final PBBytesField bytes_blackstripe;
                public final PBBytesField bytes_cft_image;
                public final PBBytesField bytes_content;
                public final PBBytesField bytes_iconurl;
                public final PBBytesField bytes_jump_url;
                public final PBBytesField bytes_linkurl;
                public final PBBytesField bytes_native_android;
                public final PBBytesField bytes_native_ios;
                public final PBBytesField bytes_notice;
                public final PBBytesField bytes_pb_reserve;
                public final PBBytesField bytes_subtitle;
                public final PBBytesField bytes_title;
                public final PBUInt32Field uint32_content_bgcolor;
                public final PBUInt32Field uint32_content_color;
                public final PBUInt32Field uint32_subtitle_color;
                public final PBUInt32Field uint32_title_color;
                public final PBUInt32Field uint32_background = PBField.initUInt32(0);
                public final PBUInt32Field uint32_icon = PBField.initUInt32(0);

                static {
                    String[] strArr = {"uint32_background", "uint32_icon", "bytes_title", "bytes_subtitle", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "bytes_linkurl", "bytes_blackstripe", "bytes_notice", "uint32_title_color", "uint32_subtitle_color", "bytes_actions_priority", "bytes_jump_url", "bytes_native_ios", "bytes_native_android", "bytes_iconurl", "uint32_content_color", "uint32_content_bgcolor", "bytes_aio_image_left", "bytes_aio_image_right", "bytes_cft_image", "bytes_pb_reserve"};
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 128, 136, 146, 154, 162, 170}, strArr, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$QQWalletAioElem.class);
                }

                {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    this.bytes_title = PBField.initBytes(byteStringMicro);
                    this.bytes_subtitle = PBField.initBytes(byteStringMicro);
                    this.bytes_content = PBField.initBytes(byteStringMicro);
                    this.bytes_linkurl = PBField.initBytes(byteStringMicro);
                    this.bytes_blackstripe = PBField.initBytes(byteStringMicro);
                    this.bytes_notice = PBField.initBytes(byteStringMicro);
                    this.uint32_title_color = PBField.initUInt32(0);
                    this.uint32_subtitle_color = PBField.initUInt32(0);
                    this.bytes_actions_priority = PBField.initBytes(byteStringMicro);
                    this.bytes_jump_url = PBField.initBytes(byteStringMicro);
                    this.bytes_native_ios = PBField.initBytes(byteStringMicro);
                    this.bytes_native_android = PBField.initBytes(byteStringMicro);
                    this.bytes_iconurl = PBField.initBytes(byteStringMicro);
                    this.uint32_content_color = PBField.initUInt32(0);
                    this.uint32_content_bgcolor = PBField.initUInt32(0);
                    this.bytes_aio_image_left = PBField.initBytes(byteStringMicro);
                    this.bytes_aio_image_right = PBField.initBytes(byteStringMicro);
                    this.bytes_cft_image = PBField.initBytes(byteStringMicro);
                    this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
                }
            };
            public final PBSInt32Field sint32_channelid = PBField.initSInt32(0);
            public final PBSInt32Field sint32_templateid = PBField.initSInt32(0);
            public final PBUInt32Field uint32_resend = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_priority = PBField.initUInt32(0);
            public final PBSInt32Field sint32_redtype = PBField.initSInt32(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 114, 120, 128, 138, 146, 152, 160, 170}, new String[]{"uint64_senduin", "sender", "receiver", "sint32_channelid", "sint32_templateid", "uint32_resend", "uint32_msg_priority", "sint32_redtype", "bytes_billno", "bytes_authkey", "sint32_sessiontype", "sint32_msgtype", "sint32_envelopeid", "bytes_name", "sint32_conftype", "sint32_msg_from", "bytes_pc_body", "string_index", "uint32_redchannel", "uint64_grap_uin", "bytes_pb_reserve"}, new Object[]{0L, null, null, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0L, byteStringMicro}, nt_im_msg_body$QQWalletAioBody.class);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.msg.nt_im_msg_body$QQWalletAioElem] */
            /* JADX WARN: Type inference failed for: r0v3, types: [tencent.im.msg.nt_im_msg_body$QQWalletAioElem] */
            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_billno = PBField.initBytes(byteStringMicro);
                this.bytes_authkey = PBField.initBytes(byteStringMicro);
                this.sint32_sessiontype = PBField.initSInt32(0);
                this.sint32_msgtype = PBField.initSInt32(0);
                this.sint32_envelopeid = PBField.initSInt32(0);
                this.bytes_name = PBField.initBytes(byteStringMicro);
                this.sint32_conftype = PBField.initSInt32(0);
                this.sint32_msg_from = PBField.initSInt32(0);
                this.bytes_pc_body = PBField.initBytes(byteStringMicro);
                this.string_index = PBField.initBytes(byteStringMicro);
                this.uint32_redchannel = PBField.initUInt32(0);
                this.uint64_grap_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
                this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
            }
        };
    };
    public nt_im_msg_body$CrmElem crm_elem = new MessageMicro<nt_im_msg_body$CrmElem>() { // from class: tencent.im.msg.nt_im_msg_body$CrmElem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_msg_resid;
        public final PBBytesField crm_buf;
        public final PBUInt32Field uint32_count_flag;
        public final PBUInt32Field uint32_push_flag;
        public final PBUInt32Field uint32_qidian_flag;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"crm_buf", "bytes_msg_resid", "uint32_qidian_flag", "uint32_push_flag", "uint32_count_flag"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0}, nt_im_msg_body$CrmElem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.crm_buf = PBField.initBytes(byteStringMicro);
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
            this.uint32_qidian_flag = PBField.initUInt32(0);
            this.uint32_push_flag = PBField.initUInt32(0);
            this.uint32_count_flag = PBField.initUInt32(0);
        }
    };
    public nt_im_msg_body$ConferenceTipsInfo conference_tips_info = new MessageMicro<nt_im_msg_body$ConferenceTipsInfo>() { // from class: tencent.im.msg.nt_im_msg_body$ConferenceTipsInfo
        public static final int ECONFST_BUDDY_AV = 2;
        public static final int ECONFST_DISCUSS_AV = 1;
        public static final int ECONFST_NONE = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_session_type", "uint64_session_uin", "str_text"}, new Object[]{0, 0L, ""}, nt_im_msg_body$ConferenceTipsInfo.class);
        public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0);
        public final PBStringField str_text = PBField.initString("");
    };
    public nt_im_msg_body$RedBagInfo redbag_info = new MessageMicro<nt_im_msg_body$RedBagInfo>() { // from class: tencent.im.msg.nt_im_msg_body$RedBagInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"redbag_type"}, new Object[]{0}, nt_im_msg_body$RedBagInfo.class);
        public final PBUInt32Field redbag_type = PBField.initUInt32(0);
    };
    public nt_im_msg_body$LowVersionTips low_version_tips = new MessageMicro<nt_im_msg_body$LowVersionTips>() { // from class: tencent.im.msg.nt_im_msg_body$LowVersionTips
        public static final int CF_BuddyChatType = 0;
        public static final int CF_DiscussChatType = 3;
        public static final int CF_GroupChatType = 1;
        public static final int CF_TempChatType = 2;
        public static final int CF_UnknownChatType = -1;
        public static final int EBusinessID_ConfScheduleMsg = 1;
        public static final int EBusinessID_DingDongMsg = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_business_id", "uint32_session_type", "uint64_session_uin", "uint64_sender_uin", "str_text"}, new Object[]{0, 0, 0L, 0L, ""}, nt_im_msg_body$LowVersionTips.class);
        public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBStringField str_text = PBField.initString("");
    };
    public final PBBytesField bankcode_ctrl_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public nt_im_msg_body$NearByMessageType near_by_msg = new MessageMicro<nt_im_msg_body$NearByMessageType>() { // from class: tencent.im.msg.nt_im_msg_body$NearByMessageType
        public static final int ETypeClearingImg = 2;
        public static final int ETypeClearingText = 1;
        public static final int ETypeDefault = 0;
        public static final int ETypeIdentify = 1;
        public static final int ETypeNormal = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_type", "uint32_identify_type"}, new Object[]{0, 0}, nt_im_msg_body$NearByMessageType.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_identify_type = PBField.initUInt32(0);
    };
    public nt_im_msg_body$CustomElem custom_elem = new MessageMicro<nt_im_msg_body$CustomElem>() { // from class: tencent.im.msg.nt_im_msg_body$CustomElem
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
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"bytes_desc", "bytes_data", "enum_type", "bytes_ext", "bytes_sound"}, new Object[]{byteStringMicro, byteStringMicro, 1, byteStringMicro, byteStringMicro}, nt_im_msg_body$CustomElem.class);
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
    public nt_im_msg_body$LocationInfo location_info = new MessageMicro<nt_im_msg_body$LocationInfo>() { // from class: tencent.im.msg.nt_im_msg_body$LocationInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBDoubleField double_longitude = PBField.initDouble(0.0d);
        public final PBDoubleField double_latitude = PBField.initDouble(0.0d);
        public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17, 26}, new String[]{"double_longitude", "double_latitude", "bytes_desc"}, new Object[]{valueOf, valueOf, ByteStringMicro.EMPTY}, nt_im_msg_body$LocationInfo.class);
        }
    };
    public nt_im_msg_body$PubAccInfo pub_acc_info = new MessageMicro<nt_im_msg_body$PubAccInfo>() { // from class: tencent.im.msg.nt_im_msg_body$PubAccInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_is_inter_num", "string_msg_template_id", "string_long_msg_url", "bytes_download_key"}, new Object[]{0, "", "", ByteStringMicro.EMPTY}, nt_im_msg_body$PubAccInfo.class);
        public final PBUInt32Field uint32_is_inter_num = PBField.initUInt32(0);
        public final PBStringField string_msg_template_id = PBField.initString("");
        public final PBStringField string_long_msg_url = PBField.initString("");
        public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nt_im_msg_body$SmallEmoji small_emoji = new MessageMicro<nt_im_msg_body$SmallEmoji>() { // from class: tencent.im.msg.nt_im_msg_body$SmallEmoji
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"packIdSum", NodeProps.CUSTOM_PROP_IMAGE_TYPE}, new Object[]{0, 0}, nt_im_msg_body$SmallEmoji.class);
        public final PBUInt32Field packIdSum = PBField.initUInt32(0);
        public final PBUInt32Field imageType = PBField.initUInt32(0);
    };
    public nt_im_msg_body$FSJMessageElem fsj_msg_elem = new MessageMicro<nt_im_msg_body$FSJMessageElem>() { // from class: tencent.im.msg.nt_im_msg_body$FSJMessageElem
        public static final int ETypeHotChatFlashPic = 1;
        public static final int ETypeNormal = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_msg_type"}, new Object[]{0}, nt_im_msg_body$FSJMessageElem.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    };
    public nt_im_msg_body$ArkAppElem ark_app = new MessageMicro<nt_im_msg_body$ArkAppElem>() { // from class: tencent.im.msg.nt_im_msg_body$ArkAppElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app_name", "min_version", "xml_template", "bytes_data"}, new Object[]{"", "", "", ByteStringMicro.EMPTY}, nt_im_msg_body$ArkAppElem.class);
        public final PBStringField app_name = PBField.initString("");
        public final PBStringField min_version = PBField.initString("");
        public final PBStringField xml_template = PBField.initString("");
        public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nt_im_msg_body$GeneralFlags general_flags = new nt_im_msg_body$GeneralFlags();
    public nt_im_msg_body$CustomFace hc_flash_pic = new MessageMicro<nt_im_msg_body$CustomFace>() { // from class: tencent.im.msg.nt_im_msg_body$CustomFace
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field biz_type;
        public final PBBytesField bytes_buffer;
        public final PBBytesField bytes_flag;
        public final PBBytesField bytes_guid;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_old_data;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_signature;
        public final PBUInt32Field image_type;
        public final PBUInt32Field index;
        public final PBUInt32Field repeat_image;
        public final PBUInt32Field repeat_index;
        public final PBStringField str_400_url;
        public final PBStringField str_big_url;
        public final PBStringField str_file_path;
        public final PBStringField str_orig_url;
        public final PBStringField str_shortcut;
        public final PBStringField str_thumb_url;
        public final PBUInt32Field uint32_400_height;
        public final PBUInt32Field uint32_400_width;
        public final PBUInt32Field uint32_download_len;
        public final PBUInt32Field uint32_file_id;
        public final PBUInt32Field uint32_file_type;
        public final PBUInt32Field uint32_height;
        public final PBUInt32Field uint32_origin;
        public final PBUInt32Field uint32_server_ip;
        public final PBUInt32Field uint32_server_port;
        public final PBUInt32Field uint32_show_len;
        public final PBUInt32Field uint32_size;
        public final PBUInt32Field uint32_source;
        public final PBUInt32Field uint32_thumb_height;
        public final PBUInt32Field uint32_thumb_width;
        public final PBUInt32Field uint32_useful;
        public final PBUInt32Field uint32_width;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 264, 274}, new String[]{"bytes_guid", "str_file_path", "str_shortcut", "bytes_buffer", "bytes_flag", "bytes_old_data", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "uint32_file_type", "bytes_signature", "uint32_useful", "bytes_md5", "str_thumb_url", "str_big_url", "str_orig_url", "biz_type", "repeat_index", "repeat_image", "image_type", "index", "uint32_width", "uint32_height", "uint32_source", "uint32_size", "uint32_origin", "uint32_thumb_width", "uint32_thumb_height", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve"}, new Object[]{byteStringMicro, "", "", byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, byteStringMicro}, nt_im_msg_body$CustomFace.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_guid = PBField.initBytes(byteStringMicro);
            this.str_file_path = PBField.initString("");
            this.str_shortcut = PBField.initString("");
            this.bytes_buffer = PBField.initBytes(byteStringMicro);
            this.bytes_flag = PBField.initBytes(byteStringMicro);
            this.bytes_old_data = PBField.initBytes(byteStringMicro);
            this.uint32_file_id = PBField.initUInt32(0);
            this.uint32_server_ip = PBField.initUInt32(0);
            this.uint32_server_port = PBField.initUInt32(0);
            this.uint32_file_type = PBField.initUInt32(0);
            this.bytes_signature = PBField.initBytes(byteStringMicro);
            this.uint32_useful = PBField.initUInt32(0);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.str_thumb_url = PBField.initString("");
            this.str_big_url = PBField.initString("");
            this.str_orig_url = PBField.initString("");
            this.biz_type = PBField.initUInt32(0);
            this.repeat_index = PBField.initUInt32(0);
            this.repeat_image = PBField.initUInt32(0);
            this.image_type = PBField.initUInt32(0);
            this.index = PBField.initUInt32(0);
            this.uint32_width = PBField.initUInt32(0);
            this.uint32_height = PBField.initUInt32(0);
            this.uint32_source = PBField.initUInt32(0);
            this.uint32_size = PBField.initUInt32(0);
            this.uint32_origin = PBField.initUInt32(0);
            this.uint32_thumb_width = PBField.initUInt32(0);
            this.uint32_thumb_height = PBField.initUInt32(0);
            this.uint32_show_len = PBField.initUInt32(0);
            this.uint32_download_len = PBField.initUInt32(0);
            this.str_400_url = PBField.initString("");
            this.uint32_400_width = PBField.initUInt32(0);
            this.uint32_400_height = PBField.initUInt32(0);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$DeliverGiftMsg deliver_gift_msg = new MessageMicro<nt_im_msg_body$DeliverGiftMsg>() { // from class: tencent.im.msg.nt_im_msg_body$DeliverGiftMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_animation_brief;
        public final PBBytesField bytes_animation_package_url_a;
        public final PBBytesField bytes_animation_package_url_i;
        public final PBBytesField bytes_comefrom_link;
        public final PBBytesField bytes_gray_tip_content;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_receiver_name;
        public final PBBytesField bytes_receiver_pic;
        public final PBBytesField bytes_remind_brief;
        public final PBBytesField bytes_stmessage_comefrom;
        public final PBBytesField bytes_stmessage_gifturl;
        public final PBBytesField bytes_stmessage_message;
        public final PBBytesField bytes_stmessage_subtitle;
        public final PBBytesField bytes_stmessage_title;
        public final PBBytesField bytes_to_all_gift_id;
        public final PBUInt32Field uint32_animation_package_id;
        public final PBUInt32Field uint32_gift_count;
        public final PBUInt32Field uint32_gift_id;
        public final PBUInt32Field uint32_stmessage_exflag;
        public final PBUInt32Field uint32_stmessage_giftpicid;
        public final PBUInt64Field uint64_receiver_uin;
        public final PBUInt64Field uint64_sender_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 56, 66, 72, 80, 90, 98, 106, 112, 122, 128, 138, 146, 154, 162, 170, 178}, new String[]{"bytes_gray_tip_content", "uint32_animation_package_id", "bytes_animation_package_url_a", "bytes_animation_package_url_i", "bytes_remind_brief", "uint32_gift_id", "uint32_gift_count", "bytes_animation_brief", "uint64_sender_uin", "uint64_receiver_uin", "bytes_stmessage_title", "bytes_stmessage_subtitle", "bytes_stmessage_message", "uint32_stmessage_giftpicid", "bytes_stmessage_comefrom", "uint32_stmessage_exflag", "bytes_to_all_gift_id", "bytes_comefrom_link", "bytes_pb_reserve", "bytes_receiver_name", "bytes_receiver_pic", "bytes_stmessage_gifturl"}, new Object[]{byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$DeliverGiftMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_gray_tip_content = PBField.initBytes(byteStringMicro);
            this.uint32_animation_package_id = PBField.initUInt32(0);
            this.bytes_animation_package_url_a = PBField.initBytes(byteStringMicro);
            this.bytes_animation_package_url_i = PBField.initBytes(byteStringMicro);
            this.bytes_remind_brief = PBField.initBytes(byteStringMicro);
            this.uint32_gift_id = PBField.initUInt32(0);
            this.uint32_gift_count = PBField.initUInt32(0);
            this.bytes_animation_brief = PBField.initBytes(byteStringMicro);
            this.uint64_sender_uin = PBField.initUInt64(0L);
            this.uint64_receiver_uin = PBField.initUInt64(0L);
            this.bytes_stmessage_title = PBField.initBytes(byteStringMicro);
            this.bytes_stmessage_subtitle = PBField.initBytes(byteStringMicro);
            this.bytes_stmessage_message = PBField.initBytes(byteStringMicro);
            this.uint32_stmessage_giftpicid = PBField.initUInt32(0);
            this.bytes_stmessage_comefrom = PBField.initBytes(byteStringMicro);
            this.uint32_stmessage_exflag = PBField.initUInt32(0);
            this.bytes_to_all_gift_id = PBField.initBytes(byteStringMicro);
            this.bytes_comefrom_link = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
            this.bytes_receiver_name = PBField.initBytes(byteStringMicro);
            this.bytes_receiver_pic = PBField.initBytes(byteStringMicro);
            this.bytes_stmessage_gifturl = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$BitAppMsg bitapp_msg = new MessageMicro<nt_im_msg_body$BitAppMsg>() { // from class: tencent.im.msg.nt_im_msg_body$BitAppMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_buf"}, new Object[]{ByteStringMicro.EMPTY}, nt_im_msg_body$BitAppMsg.class);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nt_im_msg_body$OpenQQData open_qq_data = new MessageMicro<nt_im_msg_body$OpenQQData>() { // from class: tencent.im.msg.nt_im_msg_body$OpenQQData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_car_qq_data"}, new Object[]{ByteStringMicro.EMPTY}, nt_im_msg_body$OpenQQData.class);
        public final PBBytesField bytes_car_qq_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nt_im_msg_body$ApolloActMsg apollo_msg = new MessageMicro<nt_im_msg_body$ApolloActMsg>() { // from class: tencent.im.msg.nt_im_msg_body$ApolloActMsg
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
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106}, new String[]{"uint32_action_id", "bytes_action_name", "bytes_action_text", "uint32_flag", "uint32_peer_uin", "uint32_sender_ts", "uint32_peer_ts", "int32_sender_status", "int32_peer_status", "diytext_id", "diytext_content", "input_text", "bytes_pb_reserve"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$ApolloActMsg.class);
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
    public nt_im_msg_body$GroupPubAccountInfo group_pub_acc_info = new MessageMicro<nt_im_msg_body$GroupPubAccountInfo>() { // from class: tencent.im.msg.nt_im_msg_body$GroupPubAccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_pub_account"}, new Object[]{0L}, nt_im_msg_body$GroupPubAccountInfo.class);
        public final PBUInt64Field uint64_pub_account = PBField.initUInt64(0);
    };
    public nt_im_msg_body$BlessingMessage bless_msg = new MessageMicro<nt_im_msg_body$BlessingMessage>() { // from class: tencent.im.msg.nt_im_msg_body$BlessingMessage
        public static final int ETypeBlessing = 1;
        public static final int ETypeNormal = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_msg_type", "uint32_ex_flag"}, new Object[]{0, 0}, nt_im_msg_body$BlessingMessage.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ex_flag = PBField.initUInt32(0);
    };
    public nt_im_msg_body$SourceMsg src_msg = new MessageMicro<nt_im_msg_body$SourceMsg>() { // from class: tencent.im.msg.nt_im_msg_body$SourceMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_richMsg;
        public final PBBytesField bytes_src_msg;
        public final PBBytesField bytes_troop_name;
        public final PBUInt64Field uint64_to_uin;
        public final PBRepeatField<Integer> uint32_orig_seqs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBRepeatMessageField<nt_im_msg_body$Elem> elems = PBField.initRepeatMessage(nt_im_msg_body$Elem.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 74, 80, 90}, new String[]{"uint32_orig_seqs", "uint64_sender_uin", "uint32_time", "uint32_flag", "elems", "uint32_type", "bytes_richMsg", "bytes_pb_reserve", "bytes_src_msg", "uint64_to_uin", "bytes_troop_name"}, new Object[]{0, 0L, 0, 0, null, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro}, nt_im_msg_body$SourceMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_richMsg = PBField.initBytes(byteStringMicro);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
            this.bytes_src_msg = PBField.initBytes(byteStringMicro);
            this.uint64_to_uin = PBField.initUInt64(0L);
            this.bytes_troop_name = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$LolaMsg lola_msg = new MessageMicro<nt_im_msg_body$LolaMsg>() { // from class: tencent.im.msg.nt_im_msg_body$LolaMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_download_key;
        public final PBBytesField bytes_encode_content;
        public final PBBytesField bytes_long_msg_url;
        public final PBBytesField bytes_msg_resid;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_msg_resid", "bytes_encode_content", "bytes_long_msg_url", "bytes_download_key"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$LolaMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
            this.bytes_encode_content = PBField.initBytes(byteStringMicro);
            this.bytes_long_msg_url = PBField.initBytes(byteStringMicro);
            this.bytes_download_key = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$GroupBusinessMsg group_business_msg = new MessageMicro<nt_im_msg_body$GroupBusinessMsg>() { // from class: tencent.im.msg.nt_im_msg_body$GroupBusinessMsg
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
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uint32_flags", "bytes_head_url", "bytes_head_clk_url", "bytes_nick", "bytes_nick_color", "bytes_rank", "bytes_rank_color", "bytes_rank_bgcolor"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, nt_im_msg_body$GroupBusinessMsg.class);
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
    public nt_im_msg_body$WorkflowNotifyMsg msg_workflow_notify = new MessageMicro<nt_im_msg_body$WorkflowNotifyMsg>() { // from class: tencent.im.msg.nt_im_msg_body$WorkflowNotifyMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_ext_msg", "uint64_create_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, nt_im_msg_body$WorkflowNotifyMsg.class);
        public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0);
    };
    public nt_im_msg_body$PatsElem pat_elem = new MessageMicro<nt_im_msg_body$PatsElem>() { // from class: tencent.im.msg.nt_im_msg_body$PatsElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_pat_type", "uint32_pat_count"}, new Object[]{0, 0}, nt_im_msg_body$PatsElem.class);
        public final PBUInt32Field uint32_pat_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pat_count = PBField.initUInt32(0);
    };
    public nt_im_msg_body$GroupPostElem group_post_elem = new MessageMicro<nt_im_msg_body$GroupPostElem>() { // from class: tencent.im.msg.nt_im_msg_body$GroupPostElem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_trans_type", "bytes_trans_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, nt_im_msg_body$GroupPostElem.class);
        public final PBUInt32Field uint32_trans_type = PBField.initUInt32(0);
        public final PBBytesField bytes_trans_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public nt_im_msg_body$LightAppElem light_app = new MessageMicro<nt_im_msg_body$LightAppElem>() { // from class: tencent.im.msg.nt_im_msg_body$LightAppElem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_data;
        public final PBBytesField bytes_msg_resid;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_data", "bytes_msg_resid"}, new Object[]{byteStringMicro, byteStringMicro}, nt_im_msg_body$LightAppElem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_data = PBField.initBytes(byteStringMicro);
            this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$EIMInfo eim_info = new MessageMicro<nt_im_msg_body$EIMInfo>() { // from class: tencent.im.msg.nt_im_msg_body$EIMInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_root_id", "uint32_flag"}, new Object[]{0L, 0}, nt_im_msg_body$EIMInfo.class);
        public final PBUInt64Field uint64_root_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    };
    public nt_im_msg_body$CommonElem common_elem = new nt_im_msg_body$CommonElem();
}
