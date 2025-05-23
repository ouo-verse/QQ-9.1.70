package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$VideoFile extends MessageMicro<im_msg_body$VideoFile> {
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
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 152, 162, 170, 176, 184, 194}, new String[]{"bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_file_md5", "bytes_source", "uint32_thumb_file_size", "uint32_busi_type", "uint32_from_chat_type", "uint32_to_chat_type", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "uint32_sub_busi_type", "uint32_video_attr", "rpt_bytes_thumb_file_urls", "rpt_bytes_video_file_urls", "uint32_thumb_download_flag", "uint32_video_download_flag", "bytes_pb_reserve"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, Boolean.FALSE, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, im_msg_body$VideoFile.class);
    }

    public im_msg_body$VideoFile() {
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
}
