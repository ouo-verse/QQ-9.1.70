package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$ApplyUploadReq extends MessageMicro<oidb_0xfc2$ApplyUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_sha;
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBEnumField uint32_content_type = PBField.initEnum(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58}, new String[]{"uint64_file_size", "str_file_name", "str_local_filepath", "uint32_danger_level", "uint32_content_type", "bytes_md5", "bytes_sha"}, new Object[]{0L, "", "", 0, 0, byteStringMicro, byteStringMicro}, oidb_0xfc2$ApplyUploadReq.class);
    }

    public oidb_0xfc2$ApplyUploadReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_sha = PBField.initBytes(byteStringMicro);
    }
}
