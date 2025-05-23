package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8f7$ReqBody extends MessageMicro<oidb_cmd0x8f7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56, 90, 98, 106, 114}, new String[]{"uint32_subcmd", "msg_source_id", "uint32_client_type", "uint32_client_net", "uint32_client_ver", "bytes_workflow_id", "uint64_appid", "msg_upload_req_body", "msg_download_req_body", "msg_downabs_req_body", "msg_del_req_body"}, new Object[]{0, null, 0, 0, 0, ByteStringMicro.EMPTY, 0L, null, null, null, null}, oidb_cmd0x8f7$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public oidb_cmd0x8f7$SourceID msg_source_id = new oidb_cmd0x8f7$SourceID();
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_net = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public oidb_cmd0x8f7$ApplyUploadReqBody msg_upload_req_body = new MessageMicro<oidb_cmd0x8f7$ApplyUploadReqBody>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyUploadReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_name;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBUInt32Field uint32_upload_type;
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_modify_time;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"bytes_file_name", "uint64_file_size", "bytes_sha", "bytes_md5", "uint64_modify_time", "uint32_upload_type"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0L, 0}, oidb_cmd0x8f7$ApplyUploadReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_name = PBField.initBytes(byteStringMicro);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.uint64_modify_time = PBField.initUInt64(0L);
            this.uint32_upload_type = PBField.initUInt32(0);
        }
    };
    public oidb_cmd0x8f7$ApplyDownloadReqBody msg_download_req_body = new MessageMicro<oidb_cmd0x8f7$ApplyDownloadReqBody>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDownloadReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 72}, new String[]{"bytes_uuid", "uint32_url_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_cmd0x8f7$ApplyDownloadReqBody.class);
        public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
    };
    public oidb_cmd0x8f7$ApplyDownAbsReq msg_downabs_req_body = new MessageMicro<oidb_cmd0x8f7$ApplyDownAbsReq>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDownAbsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_uuid"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0x8f7$ApplyDownAbsReq.class);
        public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_cmd0x8f7$ApplyDelReqBody msg_del_req_body = new MessageMicro<oidb_cmd0x8f7$ApplyDelReqBody>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDelReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_bytes_uuid"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0x8f7$ApplyDelReqBody.class);
        public final PBRepeatField<ByteStringMicro> rpt_bytes_uuid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    };
}
