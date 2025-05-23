package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd68$ReqBody extends MessageMicro<oidb_cmd0xd68$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"forward_group_req", "forward_offline_req", "forward_data_wire_req"}, new Object[]{null, null, null}, oidb_cmd0xd68$ReqBody.class);
    public oidb_cmd0xd68$ForwardGroupReqBody forward_group_req = new MessageMicro<oidb_cmd0xd68$ForwardGroupReqBody>() { // from class: tencent.im.oidb.cmd0xd68.oidb_cmd0xd68$ForwardGroupReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_dst_folder_id;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_src_parent_folder;
        public final PBBytesField bytes_src_uuid;
        public final PBStringField cid;
        public final PBStringField str_file_name;
        public final PBStringField str_local_path;
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 66, 74, 82, 90}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_dst_folder_id", "uint64_file_size", "str_local_path", "str_file_name", "bytes_md5", "cid"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, "", "", byteStringMicro, ""}, oidb_cmd0xd68$ForwardGroupReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parent_folder = PBField.initBytes(byteStringMicro);
            this.bytes_src_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_dst_folder_id = PBField.initBytes(byteStringMicro);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_local_path = PBField.initString("");
            this.str_file_name = PBField.initString("");
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.cid = PBField.initString("");
        }
    };
    public oidb_cmd0xd68$ForwardOfflineFileReqBody forward_offline_req = new MessageMicro<oidb_cmd0xd68$ForwardOfflineFileReqBody>() { // from class: tencent.im.oidb.cmd0xd68.oidb_cmd0xd68$ForwardOfflineFileReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_src_parent_folder;
        public final PBBytesField bytes_src_uuid;
        public final PBStringField cid;
        public final PBStringField str_file_name;
        public final PBUInt32Field uint32_client_type;
        public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
        public final PBUInt64Field uint64_dst_uin;
        public final PBUInt64Field uint64_file_size;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 66, 72}, new String[]{"uint32_src_svcid", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "cid", "uint32_client_type"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, "", "", 0}, oidb_cmd0xd68$ForwardOfflineFileReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parent_folder = PBField.initBytes(byteStringMicro);
            this.bytes_src_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.uint64_dst_uin = PBField.initUInt64(0L);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_file_name = PBField.initString("");
            this.cid = PBField.initString("");
            this.uint32_client_type = PBField.initUInt32(0);
        }
    };
    public oidb_cmd0xd68$ForwardDataWireReqBody forward_data_wire_req = new MessageMicro<oidb_cmd0xd68$ForwardDataWireReqBody>() { // from class: tencent.im.oidb.cmd0xd68.oidb_cmd0xd68$ForwardDataWireReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_src_parent_folder;
        public final PBBytesField bytes_src_uuid;
        public final PBStringField cid;
        public final PBStringField str_file_name;
        public final PBUInt32Field uint32_client_type;
        public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
        public final PBUInt64Field uint64_dst_uin;
        public final PBUInt64Field uint64_file_size;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 66, 72}, new String[]{"uint32_src_svcid", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "cid", "uint32_client_type"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, "", "", 0}, oidb_cmd0xd68$ForwardDataWireReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parent_folder = PBField.initBytes(byteStringMicro);
            this.bytes_src_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.uint64_dst_uin = PBField.initUInt64(0L);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_file_name = PBField.initString("");
            this.cid = PBField.initString("");
            this.uint32_client_type = PBField.initUInt32(0);
        }
    };
}
