package tencent.im.msg;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_body$RichText extends MessageMicro<nt_im_msg_body$RichText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"attr", "elems", "not_online_file", "ptt", "tmp_ptt", "trans_211_tmp_msg"}, new Object[]{null, null, null, null, null, null}, nt_im_msg_body$RichText.class);
    public nt_im_msg_body$Attr attr = new MessageMicro<nt_im_msg_body$Attr>() { // from class: tencent.im.msg.nt_im_msg_body$Attr
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 82}, new String[]{"code_page", "time", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "color", "size", QQWinkConstants.TAB_EFFECT, "char_set", "pitch_and_family", "font_name", "reserve_data"}, new Object[]{-1, 1, 0, 0, 10, 7, 78, 90, "Times New Roman", ByteStringMicro.EMPTY}, nt_im_msg_body$Attr.class);
        public final PBSInt32Field code_page = PBField.initSInt32(-1);
        public final PBUInt32Field time = PBField.initUInt32(1);
        public final PBUInt32Field random = PBField.initUInt32(0);
        public final PBUInt32Field color = PBField.initUInt32(0);
        public final PBUInt32Field size = PBField.initUInt32(10);
        public final PBUInt32Field effect = PBField.initUInt32(7);
        public final PBUInt32Field char_set = PBField.initUInt32(78);
        public final PBUInt32Field pitch_and_family = PBField.initUInt32(90);
        public final PBStringField font_name = PBField.initString("Times New Roman");
        public final PBBytesField reserve_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBRepeatMessageField<nt_im_msg_body$Elem> elems = PBField.initRepeatMessage(nt_im_msg_body$Elem.class);
    public nt_im_msg_body$NotOnlineFile not_online_file = new nt_im_msg_body$NotOnlineFile();
    public nt_im_msg_body$Ptt ptt = new MessageMicro<nt_im_msg_body$Ptt>() { // from class: tencent.im.msg.nt_im_msg_body$Ptt
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_valid;
        public final PBBytesField bytes_down_para;
        public final PBBytesField bytes_file_key;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_file_name;
        public final PBBytesField bytes_file_uuid;
        public final PBBytesField bytes_group_file_key;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField bytes_ptt_url;
        public final PBBytesField bytes_reserve;
        public final PBBytesField bytes_shortcut;
        public final PBBytesField bytes_signature;
        public final PBRepeatField<ByteStringMicro> rpt_bytes_ptt_urls;
        public final PBUInt32Field uint32_download_flag;
        public final PBUInt32Field uint32_file_id;
        public final PBUInt32Field uint32_file_size;
        public final PBUInt32Field uint32_format;
        public final PBUInt32Field uint32_magic_ptt_index;
        public final PBUInt32Field uint32_server_ip;
        public final PBUInt32Field uint32_server_port;
        public final PBUInt32Field uint32_time;
        public final PBUInt32Field uint32_voice_switch;
        public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 232, 242, 250, 256}, new String[]{"uint32_file_type", "uint64_src_uin", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "bytes_reserve", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "bool_valid", "bytes_signature", "bytes_shortcut", "bytes_file_key", "uint32_magic_ptt_index", "uint32_voice_switch", "bytes_ptt_url", "bytes_group_file_key", "uint32_time", "bytes_down_para", "uint32_format", "bytes_pb_reserve", "rpt_bytes_ptt_urls", "uint32_download_flag"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, 0, Boolean.FALSE, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0}, nt_im_msg_body$Ptt.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_file_name = PBField.initBytes(byteStringMicro);
            this.uint32_file_size = PBField.initUInt32(0);
            this.bytes_reserve = PBField.initBytes(byteStringMicro);
            this.uint32_file_id = PBField.initUInt32(0);
            this.uint32_server_ip = PBField.initUInt32(0);
            this.uint32_server_port = PBField.initUInt32(0);
            this.bool_valid = PBField.initBool(false);
            this.bytes_signature = PBField.initBytes(byteStringMicro);
            this.bytes_shortcut = PBField.initBytes(byteStringMicro);
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.uint32_magic_ptt_index = PBField.initUInt32(0);
            this.uint32_voice_switch = PBField.initUInt32(0);
            this.bytes_ptt_url = PBField.initBytes(byteStringMicro);
            this.bytes_group_file_key = PBField.initBytes(byteStringMicro);
            this.uint32_time = PBField.initUInt32(0);
            this.bytes_down_para = PBField.initBytes(byteStringMicro);
            this.uint32_format = PBField.initUInt32(0);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
            this.rpt_bytes_ptt_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
            this.uint32_download_flag = PBField.initUInt32(0);
        }
    };
    public nt_im_msg_body$TmpPtt tmp_ptt = new MessageMicro<nt_im_msg_body$TmpPtt>() { // from class: tencent.im.msg.nt_im_msg_body$TmpPtt
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_file_name;
        public final PBBytesField bytes_file_uuid;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField ptt_encode_data;
        public final PBUInt32Field uint32_busi_type;
        public final PBUInt32Field uint32_file_size;
        public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ptttrans_flag;
        public final PBUInt32Field uint32_user_type;
        public final PBUInt64Field uint64_msg_id;
        public final PBUInt32Field uint64_ptt_times;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 72, 80, 242, 250}, new String[]{"uint32_file_type", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "uint64_ptt_times", "uint32_user_type", "uint32_ptttrans_flag", "uint32_busi_type", "uint64_msg_id", "bytes_pb_reserve", "ptt_encode_data"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0L, byteStringMicro, byteStringMicro}, nt_im_msg_body$TmpPtt.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_file_name = PBField.initBytes(byteStringMicro);
            this.uint32_file_size = PBField.initUInt32(0);
            this.uint64_ptt_times = PBField.initUInt32(0);
            this.uint32_user_type = PBField.initUInt32(0);
            this.uint32_ptttrans_flag = PBField.initUInt32(0);
            this.uint32_busi_type = PBField.initUInt32(0);
            this.uint64_msg_id = PBField.initUInt64(0L);
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
            this.ptt_encode_data = PBField.initBytes(byteStringMicro);
        }
    };
    public nt_im_msg_body$Trans211TmpMsg trans_211_tmp_msg = new MessageMicro<nt_im_msg_body$Trans211TmpMsg>() { // from class: tencent.im.msg.nt_im_msg_body$Trans211TmpMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_msg_body", "uint32_c2c_cmd"}, new Object[]{ByteStringMicro.EMPTY, 0}, nt_im_msg_body$Trans211TmpMsg.class);
        public final PBBytesField bytes_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_c2c_cmd = PBField.initUInt32(0);
    };
}
