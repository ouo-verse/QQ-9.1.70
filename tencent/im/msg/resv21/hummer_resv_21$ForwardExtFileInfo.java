package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_resv_21$ForwardExtFileInfo extends MessageMicro<hummer_resv_21$ForwardExtFileInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_sha1;
    public final PBBytesField bytes_file_uuid;
    public final PBInt64Field int64_dead_time;
    public final PBStringField str_file_name;
    public final PBStringField str_fileidcrc;
    public final PBUInt32Field uint32_bus_id;
    public final PBUInt32Field uint32_img_height;
    public final PBUInt32Field uint32_img_width;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_video_duration;
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 72, 80, 88, 96, 104, 114}, new String[]{"uint32_file_type", "uint64_sender_uin", "uint64_receiver_uin", "bytes_file_uuid", "str_file_name", "uint64_file_size", "bytes_file_sha1", "bytes_file_md5", "int64_dead_time", "uint32_img_width", "uint32_img_height", "uint64_video_duration", "uint32_bus_id", "str_fileidcrc"}, new Object[]{0, 0L, 0L, byteStringMicro, "", 0L, byteStringMicro, byteStringMicro, 0L, 0, 0, 0L, 0, ""}, hummer_resv_21$ForwardExtFileInfo.class);
    }

    public hummer_resv_21$ForwardExtFileInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
        this.str_file_name = PBField.initString("");
        this.uint64_file_size = PBField.initUInt64(0L);
        this.bytes_file_sha1 = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.int64_dead_time = PBField.initInt64(0L);
        this.uint32_img_width = PBField.initUInt32(0);
        this.uint32_img_height = PBField.initUInt32(0);
        this.uint64_video_duration = PBField.initUInt64(0L);
        this.uint32_bus_id = PBField.initUInt32(0);
        this.str_fileidcrc = PBField.initString("");
    }
}
