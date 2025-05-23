package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x345$RspBody extends MessageMicro<cmd0x345$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"uint32_sub_cmd", "uint32_return_code", "msg_subcmd_0x1_rsp_body", "msg_subcmd_0x2_rsp_body", "msg_subcmd_0x3_rsp_body", "msg_subcmd_0x4_rsp_body", "msg_subcmd_0x5_rsp_body", "msg_subcmd_0x6_rsp_body", "msg_subcmd_0x7_rsp_body", "msg_subcmd_0x9_rsp_body", "msg_subcmd_0xa_rsp_body"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null}, cmd0x345$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_return_code = PBField.initUInt32(0);
    public SubCmd0x1RspBody msg_subcmd_0x1_rsp_body = new SubCmd0x1RspBody();
    public SubCmd0x2RspBody msg_subcmd_0x2_rsp_body = new SubCmd0x2RspBody();
    public SubCmd0x3RspBody msg_subcmd_0x3_rsp_body = new SubCmd0x3RspBody();
    public SubCmd0x4RspBody msg_subcmd_0x4_rsp_body = new SubCmd0x4RspBody();
    public SubCmd0x5RspBody msg_subcmd_0x5_rsp_body = new SubCmd0x5RspBody();
    public SubCmd0x6RspBody msg_subcmd_0x6_rsp_body = new SubCmd0x6RspBody();
    public SubCmd0x7RspBody msg_subcmd_0x7_rsp_body = new SubCmd0x7RspBody();
    public SubCmd0x9RspBody msg_subcmd_0x9_rsp_body = new SubCmd0x9RspBody();
    public SubCmd0xaRspBody msg_subcmd_0xa_rsp_body = new SubCmd0xaRspBody();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FileAttr extends MessageMicro<FileAttr> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_sha3;
        public final PBStringField str_file_name;
        public final PBUInt32Field uint32_create_time;
        public final PBUInt32Field uint32_modify_time;
        public final PBUInt32Field uint32_upload_uin;
        public final PBUInt64Field uint64_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
        public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
        public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
        public final PBUInt32Field uint32_trans_from = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104}, new String[]{"uint64_size", "uint32_ttl", "uint32_download_times", "uint32_owner", "uint32_trans_from", "str_file_path", "bytes_md5", "bytes_sha", "bytes_sha3", "str_file_name", "uint32_create_time", "uint32_modify_time", "uint32_upload_uin"}, new Object[]{0L, 0, 0, 0, 0, "", byteStringMicro, byteStringMicro, byteStringMicro, "", 0, 0, 0}, FileAttr.class);
        }

        public FileAttr() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_sha3 = PBField.initBytes(byteStringMicro);
            this.str_file_name = PBField.initString("");
            this.uint32_create_time = PBField.initUInt32(0);
            this.uint32_modify_time = PBField.initUInt32(0);
            this.uint32_upload_uin = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x1RspBody extends MessageMicro<SubCmd0x1RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 64, 72, 82, 90}, new String[]{"str_file_id", "str_check_sum", "str_host", "uint32_port", "str_file_key", "str_file_name", "str_warn", "uint32_costom_id", "uint32_https_port", "str_https_domain", "str_dns"}, new Object[]{"", "", "", 80, "", "", "", 0, Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), "", ""}, SubCmd0x1RspBody.class);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_check_sum = PBField.initString("");
        public final PBStringField str_host = PBField.initString("");
        public final PBUInt32Field uint32_port = PBField.initUInt32(80);
        public final PBStringField str_file_key = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
        public final PBStringField str_warn = PBField.initString("");
        public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_https_port = PBField.initUInt32(WebSocketImpl.DEFAULT_WSS_PORT);
        public final PBStringField str_https_domain = PBField.initString("");
        public final PBStringField str_dns = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x2RspBody extends MessageMicro<SubCmd0x2RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubCmd0x2RspBody.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x3RspBody extends MessageMicro<SubCmd0x3RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56, 66, 74, 80, 90, 98}, new String[]{"str_host", "uint32_port", "str_check_sum", "str_cookie", "uint32_costom_id", "str_ret_msg", "int32_ret_code", "str_suggest_file_name", "bytes_sha", "uint32_https_port", "str_https_domain", "str_dns"}, new Object[]{"", 80, "", "", 0, "", 0, "", ByteStringMicro.EMPTY, Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), "", ""}, SubCmd0x3RspBody.class);
        public final PBStringField str_host = PBField.initString("");
        public final PBUInt32Field uint32_port = PBField.initUInt32(80);
        public final PBStringField str_check_sum = PBField.initString("");
        public final PBStringField str_cookie = PBField.initString("");
        public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_suggest_file_name = PBField.initString("");
        public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_https_port = PBField.initUInt32(WebSocketImpl.DEFAULT_WSS_PORT);
        public final PBStringField str_https_domain = PBField.initString("");
        public final PBStringField str_dns = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x4RspBody extends MessageMicro<SubCmd0x4RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_max_transfer_file_count", "uint64_max_transfer_single_file_size", "uint32_max_transfer_file_queue_num", "uint32_max_download_file_num"}, new Object[]{0, 0L, 0, 0}, SubCmd0x4RspBody.class);
        public final PBUInt32Field uint32_max_transfer_file_count = PBField.initUInt32(0);
        public final PBUInt64Field uint64_max_transfer_single_file_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_max_transfer_file_queue_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_max_download_file_num = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x5RspBody extends MessageMicro<SubCmd0x5RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_ret_msg", "str_file_id"}, new Object[]{"", ""}, SubCmd0x5RspBody.class);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_file_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x6RspBody extends MessageMicro<SubCmd0x6RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_ret_msg", "str_file_id"}, new Object[]{"", ""}, SubCmd0x6RspBody.class);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_file_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x7RspBody extends MessageMicro<SubCmd0x7RspBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cookie;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_thri_sha;
        public final PBStringField str_https_domain;
        public final PBStringField str_ret_msg;
        public final PBUInt32Field uint32_https_port;
        public final PBStringField str_server_ip = PBField.initString("");
        public final PBFixed32Field uint32_server_port = PBField.initFixed32(0);
        public final PBStringField str_dns = PBField.initString("");
        public final PBStringField str_url = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 26, 34, 42, 50, 58, 66, 74, 80, 90}, new String[]{"str_server_ip", "uint32_server_port", "str_dns", "str_url", "bytes_sha", "bytes_thri_sha", "bytes_md5", "bytes_cookie", "str_ret_msg", "uint32_https_port", "str_https_domain"}, new Object[]{"", 0, "", "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, "", Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), ""}, SubCmd0x7RspBody.class);
        }

        public SubCmd0x7RspBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_thri_sha = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_cookie = PBField.initBytes(byteStringMicro);
            this.str_ret_msg = PBField.initString("");
            this.uint32_https_port = PBField.initUInt32(WebSocketImpl.DEFAULT_WSS_PORT);
            this.str_https_domain = PBField.initString("");
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x9RspBody extends MessageMicro<SubCmd0x9RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_begin", "uint32_total_file_num", "uint32_file_num", "rpt_msg_file_list"}, new Object[]{0, 0, 0, null}, SubCmd0x9RspBody.class);
        public final PBUInt32Field uint32_begin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
        public final PBRepeatMessageField<FileAttr> rpt_msg_file_list = PBField.initRepeatMessage(FileAttr.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0xaRspBody extends MessageMicro<SubCmd0xaRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint64_uin", "uint64_disscus_uin", "str_file_id", "str_session_info", "str_ret_msg"}, new Object[]{0L, 0L, "", "", ""}, SubCmd0xaRspBody.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_session_info = PBField.initString("");
        public final PBStringField str_ret_msg = PBField.initString("");
    }
}
