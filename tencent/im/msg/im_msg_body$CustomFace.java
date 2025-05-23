package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$CustomFace extends MessageMicro<im_msg_body$CustomFace> {
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
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 264, 274}, new String[]{"bytes_guid", "str_file_path", "str_shortcut", "bytes_buffer", "bytes_flag", "bytes_old_data", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "uint32_file_type", "bytes_signature", "uint32_useful", "bytes_md5", "str_thumb_url", "str_big_url", "str_orig_url", "biz_type", "repeat_index", "repeat_image", "image_type", "index", "uint32_width", "uint32_height", "uint32_source", "uint32_size", "uint32_origin", "uint32_thumb_width", "uint32_thumb_height", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve"}, new Object[]{byteStringMicro, "", "", byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, byteStringMicro}, im_msg_body$CustomFace.class);
    }

    public im_msg_body$CustomFace() {
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
}
