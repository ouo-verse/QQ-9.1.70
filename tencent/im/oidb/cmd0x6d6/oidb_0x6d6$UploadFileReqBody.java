package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$UploadFileReqBody extends MessageMicro<oidb_0x6d6$UploadFileReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_support_multi_upload;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_sha;
    public final PBBytesField bytes_sha3;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 120}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "uint32_entrance", "str_parent_folder_id", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5", "bool_support_multi_upload"}, new Object[]{0L, 0, 0, 0, "", "", "", 0L, byteStringMicro, byteStringMicro, byteStringMicro, Boolean.FALSE}, oidb_0x6d6$UploadFileReqBody.class);
    }

    public oidb_0x6d6$UploadFileReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sha = PBField.initBytes(byteStringMicro);
        this.bytes_sha3 = PBField.initBytes(byteStringMicro);
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.bool_support_multi_upload = PBField.initBool(false);
    }
}
