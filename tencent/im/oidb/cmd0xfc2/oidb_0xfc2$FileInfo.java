package tencent.im.oidb.cmd0xfc2;

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
public final class oidb_0xfc2$FileInfo extends MessageMicro<oidb_0xfc2$FileInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_sha;
    public final PBInt64Field int64_save_time;
    public final PBInt64Field int64_upload_time;
    public final PBUInt32Field uint32_danger_level;
    public final PBStringField str_fileid = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt64Field uint64_size = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 64}, new String[]{"str_fileid", "str_name", "uint64_size", "bytes_sha", "bytes_md5", "uint32_danger_level", "int64_upload_time", "int64_save_time"}, new Object[]{"", "", 0L, byteStringMicro, byteStringMicro, 0, 0L, 0L}, oidb_0xfc2$FileInfo.class);
    }

    public oidb_0xfc2$FileInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sha = PBField.initBytes(byteStringMicro);
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_danger_level = PBField.initUInt32(0);
        this.int64_upload_time = PBField.initInt64(0L);
        this.int64_save_time = PBField.initInt64(0L);
    }
}
