package tencent.im.msg;

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
public final class obj_msg$MsgContentInfo extends MessageMicro<obj_msg$MsgContentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_Content_info_id", "msg_file"}, new Object[]{ByteStringMicro.EMPTY, null}, obj_msg$MsgContentInfo.class);
    public final PBBytesField bytes_Content_info_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public MsgFile msg_file = new MsgFile();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MsgFile extends MessageMicro<MsgFile> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_ext;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_file_path;
        public final PBBytesField bytes_file_sha1;
        public final PBInt64Field int64_dead_time;
        public final PBStringField str_file_name;
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_file_size;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58, 66}, new String[]{"uint32_bus_id", "bytes_file_path", "uint64_file_size", "str_file_name", "int64_dead_time", "bytes_file_sha1", "bytes_ext", "bytes_file_md5"}, new Object[]{0, byteStringMicro, 0L, "", 0L, byteStringMicro, byteStringMicro, byteStringMicro}, MsgFile.class);
        }

        public MsgFile() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_path = PBField.initBytes(byteStringMicro);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_file_name = PBField.initString("");
            this.int64_dead_time = PBField.initInt64(0L);
            this.bytes_file_sha1 = PBField.initBytes(byteStringMicro);
            this.bytes_ext = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        }
    }
}
