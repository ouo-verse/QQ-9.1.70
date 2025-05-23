package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8f7$RspBody extends MessageMicro<oidb_cmd0x8f7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ret_msg;
    public final PBBytesField bytes_workflow_id;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public oidb_cmd0x8f7$ApplyDelRspBody msg_del_rsp_body;
    public oidb_cmd0x8f7$ApplyDownAbsRsp msg_downabs_rsp_body;
    public oidb_cmd0x8f7$ApplyDownloadRspBody msg_download_rsp_body;
    public oidb_cmd0x8f7$SourceID msg_source_id;
    public oidb_cmd0x8f7$ApplyUploadRspBody msg_upload_rsp_body;
    public final PBUInt32Field uint32_subcmd;
    public final PBUInt64Field uint64_appid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 90, 98, 106, 114}, new String[]{"int32_ret_code", "bytes_ret_msg", "uint32_subcmd", "msg_source_id", "bytes_workflow_id", "uint64_appid", "msg_upload_rsp_body", "msg_download_rsp_body", "msg_downabs_rsp_body", "msg_del_rsp_body"}, new Object[]{0, byteStringMicro, 0, null, byteStringMicro, 0L, null, null, null, null}, oidb_cmd0x8f7$RspBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyUploadRspBody] */
    /* JADX WARN: Type inference failed for: r0v7, types: [tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDownloadRspBody] */
    /* JADX WARN: Type inference failed for: r0v8, types: [tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDownAbsRsp] */
    /* JADX WARN: Type inference failed for: r0v9, types: [tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDelRspBody] */
    public oidb_cmd0x8f7$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_ret_msg = PBField.initBytes(byteStringMicro);
        this.uint32_subcmd = PBField.initUInt32(0);
        this.msg_source_id = new oidb_cmd0x8f7$SourceID();
        this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
        this.uint64_appid = PBField.initUInt64(0L);
        this.msg_upload_rsp_body = new MessageMicro<oidb_cmd0x8f7$ApplyUploadRspBody>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyUploadRspBody
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField bool_file_exist = PBField.initBool(false);
            public final PBBytesField bytes_check_key;
            public final PBBytesField bytes_conflict_key;
            public final PBBytesField bytes_random_sha;
            public final PBBytesField bytes_server_name;
            public final PBBytesField bytes_uuid;
            public final PBUInt32Field uint32_expired_time;
            public final PBUInt32Field uint32_server_port;
            public final PBUInt32Field uint32_uploadip;
            public final PBUInt32Field uint32_version;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 64, 72, 80}, new String[]{"bool_file_exist", "bytes_uuid", "bytes_check_key", "bytes_server_name", "uint32_server_port", "bytes_random_sha", "bytes_conflict_key", "uint32_expired_time", "uint32_version", "uint32_uploadip"}, new Object[]{Boolean.FALSE, byteStringMicro2, byteStringMicro2, byteStringMicro2, 0, ByteStringMicro.copyFromUtf8(""), byteStringMicro2, 0, 0, 0}, oidb_cmd0x8f7$ApplyUploadRspBody.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_uuid = PBField.initBytes(byteStringMicro2);
                this.bytes_check_key = PBField.initBytes(byteStringMicro2);
                this.bytes_server_name = PBField.initBytes(byteStringMicro2);
                this.uint32_server_port = PBField.initUInt32(0);
                this.bytes_random_sha = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
                this.bytes_conflict_key = PBField.initBytes(byteStringMicro2);
                this.uint32_expired_time = PBField.initUInt32(0);
                this.uint32_version = PBField.initUInt32(0);
                this.uint32_uploadip = PBField.initUInt32(0);
            }
        };
        this.msg_download_rsp_body = new MessageMicro<oidb_cmd0x8f7$ApplyDownloadRspBody>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDownloadRspBody
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_cookie_name;
            public final PBBytesField bytes_cookie_val;
            public final PBBytesField bytes_server_name;
            public final PBBytesField bytes_url;
            public final PBUInt32Field uint32_download_port;
            public final PBUInt32Field uint32_version;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"bytes_server_name", "bytes_url", "uint32_download_port", "bytes_cookie_name", "bytes_cookie_val", "uint32_version"}, new Object[]{byteStringMicro2, byteStringMicro2, 0, byteStringMicro2, byteStringMicro2, 0}, oidb_cmd0x8f7$ApplyDownloadRspBody.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_server_name = PBField.initBytes(byteStringMicro2);
                this.bytes_url = PBField.initBytes(byteStringMicro2);
                this.uint32_download_port = PBField.initUInt32(0);
                this.bytes_cookie_name = PBField.initBytes(byteStringMicro2);
                this.bytes_cookie_val = PBField.initBytes(byteStringMicro2);
                this.uint32_version = PBField.initUInt32(0);
            }
        };
        this.msg_downabs_rsp_body = new MessageMicro<oidb_cmd0x8f7$ApplyDownAbsRsp>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDownAbsRsp
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_cookie;
            public final PBBytesField bytes_download_dns;
            public final PBBytesField bytes_download_key;
            public final PBBytesField bytes_file_sha;
            public final PBUInt32Field uint32_download_ip = PBField.initUInt32(0);
            public final PBUInt32Field uint32_download_port;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"uint32_download_ip", "bytes_download_dns", "uint32_download_port", "bytes_file_sha", "bytes_download_key", "bytes_cookie"}, new Object[]{0, byteStringMicro2, 0, byteStringMicro2, byteStringMicro2, byteStringMicro2}, oidb_cmd0x8f7$ApplyDownAbsRsp.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_download_dns = PBField.initBytes(byteStringMicro2);
                this.uint32_download_port = PBField.initUInt32(0);
                this.bytes_file_sha = PBField.initBytes(byteStringMicro2);
                this.bytes_download_key = PBField.initBytes(byteStringMicro2);
                this.bytes_cookie = PBField.initBytes(byteStringMicro2);
            }
        };
        this.msg_del_rsp_body = new MessageMicro<oidb_cmd0x8f7$ApplyDelRspBody>() { // from class: tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7$ApplyDelRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0x8f7$ApplyDelRspBody.class);
        };
    }
}
