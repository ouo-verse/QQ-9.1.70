package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$NotOnlineFile extends MessageMicro<im_msg_body$NotOnlineFile> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_file_uuid;
    public final PBBytesField bytes_note;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField bytes_sig;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_file_urls;
    public final PBStringField str_fileidcrc_media;
    public final PBUInt32Field uint32_abs_file_type;
    public final PBUInt32Field uint32_client_type;
    public final PBUInt32Field uint32_danger_evel;
    public final PBUInt32Field uint32_download_flag;
    public final PBUInt32Field uint32_expire_time;
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_life_time;
    public final PBUInt32Field uint32_micro_cloud;
    public final PBUInt32Field uint32_reserved;
    public final PBUInt32Field uint32_subcmd;
    public final PBUInt32Field uint32_upload_time;
    public final PBUInt64Field uint64_file_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 90, 96, 400, 408, 416, 424, 432, 440, 450, 458}, new String[]{"uint32_file_type", "bytes_sig", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint64_file_size", "bytes_note", "uint32_reserved", "uint32_subcmd", "uint32_micro_cloud", "rpt_bytes_file_urls", "uint32_download_flag", "uint32_danger_evel", "uint32_life_time", "uint32_upload_time", "uint32_abs_file_type", "uint32_client_type", "uint32_expire_time", "bytes_pb_reserve", "str_fileidcrc_media"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, ""}, im_msg_body$NotOnlineFile.class);
    }

    public im_msg_body$NotOnlineFile() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sig = PBField.initBytes(byteStringMicro);
        this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.bytes_note = PBField.initBytes(byteStringMicro);
        this.uint32_reserved = PBField.initUInt32(0);
        this.uint32_subcmd = PBField.initUInt32(0);
        this.uint32_micro_cloud = PBField.initUInt32(0);
        this.rpt_bytes_file_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.uint32_download_flag = PBField.initUInt32(0);
        this.uint32_danger_evel = PBField.initUInt32(0);
        this.uint32_life_time = PBField.initUInt32(0);
        this.uint32_upload_time = PBField.initUInt32(0);
        this.uint32_abs_file_type = PBField.initUInt32(0);
        this.uint32_client_type = PBField.initUInt32(0);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        this.str_fileidcrc_media = PBField.initString("");
    }
}
