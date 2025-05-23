package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class im_msg_body$Ptt extends MessageMicro<im_msg_body$Ptt> {
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
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 232, 242, 250, 256}, new String[]{"uint32_file_type", "uint64_src_uin", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "bytes_reserve", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "bool_valid", "bytes_signature", "bytes_shortcut", "bytes_file_key", "uint32_magic_ptt_index", "uint32_voice_switch", "bytes_ptt_url", "bytes_group_file_key", "uint32_time", "bytes_down_para", "uint32_format", "bytes_pb_reserve", "rpt_bytes_ptt_urls", "uint32_download_flag"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, 0, Boolean.FALSE, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0}, im_msg_body$Ptt.class);
    }

    public im_msg_body$Ptt() {
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
}
