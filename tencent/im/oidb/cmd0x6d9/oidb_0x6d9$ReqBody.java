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
public final class oidb_0x6d9$ReqBody extends MessageMicro<oidb_0x6d9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42}, new String[]{"trans_file_req", "copy_from_req", "copy_to_req", "feeds_info_req"}, new Object[]{null, null, null, null}, oidb_0x6d9$ReqBody.class);
    public oidb_0x6d9$TransFileReqBody trans_file_req = new oidb_0x6d9$TransFileReqBody();
    public oidb_0x6d9$CopyFromReqBody copy_from_req = new MessageMicro<oidb_0x6d9$CopyFromReqBody>() { // from class: tencent.im.oidb.cmd0x6d9.oidb_0x6d9$CopyFromReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_dst_folder_id;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_src_file_path;
        public final PBBytesField bytes_src_parent_folder;
        public final PBStringField str_file_name;
        public final PBStringField str_local_path;
        public final PBUInt32Field uint32_dst_bus_id;
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_src_uin;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 64, 74, 82, 88, 98}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_bus_id", "bytes_dst_folder_id", "uint64_file_size", "str_local_path", "str_file_name", "uint64_src_uin", "bytes_md5"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0L, "", "", 0L, byteStringMicro}, oidb_0x6d9$CopyFromReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parent_folder = PBField.initBytes(byteStringMicro);
            this.bytes_src_file_path = PBField.initBytes(byteStringMicro);
            this.uint32_dst_bus_id = PBField.initUInt32(0);
            this.bytes_dst_folder_id = PBField.initBytes(byteStringMicro);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_local_path = PBField.initString("");
            this.str_file_name = PBField.initString("");
            this.uint64_src_uin = PBField.initUInt64(0L);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0x6d9$CopyToReqBody copy_to_req = new oidb_0x6d9$CopyToReqBody();
    public oidb_0x6d9$FeedsReqBody feeds_info_req = new oidb_0x6d9$FeedsReqBody();
}
