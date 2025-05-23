package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d9$CopyToReqBody extends MessageMicro<oidb_0x6d9$CopyToReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tim_cloud_extension_info;
    public final PBBytesField bytes_tim_cloud_pdir_key;
    public final PBBytesField bytes_tim_cloud_ppdir_key;
    public final PBUInt32Field uint32_tim_file_exist_option;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
    public final PBStringField str_src_file_id = PBField.initString("");
    public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBStringField str_new_file_name = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 322, 802, 810, 818, 824}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "str_src_file_id", "uint32_dst_bus_id", "uint64_dst_uin", "str_new_file_name", "bytes_tim_cloud_pdir_key", "bytes_tim_cloud_ppdir_key", "bytes_tim_cloud_extension_info", "uint32_tim_file_exist_option"}, new Object[]{0L, 0, 0, "", 0, 0L, "", byteStringMicro, byteStringMicro, byteStringMicro, 0}, oidb_0x6d9$CopyToReqBody.class);
    }

    public oidb_0x6d9$CopyToReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_tim_cloud_pdir_key = PBField.initBytes(byteStringMicro);
        this.bytes_tim_cloud_ppdir_key = PBField.initBytes(byteStringMicro);
        this.bytes_tim_cloud_extension_info = PBField.initBytes(byteStringMicro);
        this.uint32_tim_file_exist_option = PBField.initUInt32(0);
    }
}
