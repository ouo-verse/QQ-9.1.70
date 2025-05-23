package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_head$Head extends MessageMicro<im_msg_head$Head> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66, 74, 82}, new String[]{"uint32_head_type", "msg_cs_head", "msg_s2c_head", "msg_httpconn_head", "uint32_paint_flag", "msg_login_sig", "msg_delta_head", "msg_c2c_head", "msg_sconn_head", "msg_inst_ctrl"}, new Object[]{0, null, null, null, 0, null, null, null, null, null}, im_msg_head$Head.class);
    public final PBUInt32Field uint32_head_type = PBField.initUInt32(0);
    public im_msg_head$CSHead msg_cs_head = new MessageMicro<im_msg_head$CSHead>() { // from class: tencent.im.msg.im_msg_head$CSHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 85, 88, 101, 104, 117, 120, 133, 136, 149, 152, 160, 168, 176, 184, 192}, new String[]{"uint64_uin", "uint32_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pubno", "uint32_localid", "uint32_timezone", "uint32_client_ip", "uint32_client_port", "uint32_conn_ip", "uint32_conn_port", "uint32_interface_ip", "uint32_interface_port", "uint32_actual_ip", "uint32_flag", "uint32_timestamp", "uint32_subcmd", "uint32_result", "uint32_app_id", "uint32_instance_id", "uint64_session_id", "uint32_idc_id"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0}, im_msg_head$CSHead.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_command = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);
        public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);
        public final PBUInt32Field uint32_localid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_timezone = PBField.initUInt32(0);
        public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBFixed32Field uint32_conn_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_conn_port = PBField.initUInt32(0);
        public final PBFixed32Field uint32_interface_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
        public final PBFixed32Field uint32_actual_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBFixed32Field uint32_timestamp = PBField.initFixed32(0);
        public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
    };
    public im_msg_head$S2CHead msg_s2c_head = new MessageMicro<im_msg_head$S2CHead>() { // from class: tencent.im.msg.im_msg_head$S2CHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48, 56}, new String[]{"uint32_sub_msgtype", "uint32_msg_type", "uint64_from_uin", "uint32_msg_id", "uint32_relay_ip", "uint32_relay_port", "uint64_to_uin"}, new Object[]{0, 0, 0L, 0, 0, 0, 0L}, im_msg_head$S2CHead.class);
        public final PBUInt32Field uint32_sub_msgtype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
        public final PBFixed32Field uint32_relay_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_relay_port = PBField.initUInt32(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    };
    public im_msg_head$HttpConnHead msg_httpconn_head = new im_msg_head$HttpConnHead();
    public final PBUInt32Field uint32_paint_flag = PBField.initUInt32(0);
    public im_msg_head$LoginSig msg_login_sig = new im_msg_head$LoginSig();
    public im_msg_head$DeltaHead msg_delta_head = new MessageMicro<im_msg_head$DeltaHead>() { // from class: tencent.im.msg.im_msg_head$DeltaHead
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_ack_cookie;
        public final PBBytesField bytes_cookie;
        public final PBUInt32Field uint32_flags;
        public final PBUInt32Field uint32_result;
        public final PBUInt64Field uint64_total_len = PBField.initUInt64(0);
        public final PBUInt64Field uint64_offset = PBField.initUInt64(0);
        public final PBUInt64Field uint64_ack_offset = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56}, new String[]{"uint64_total_len", "uint64_offset", "uint64_ack_offset", "bytes_cookie", "bytes_ack_cookie", "uint32_result", "uint32_flags"}, new Object[]{0L, 0L, 0L, byteStringMicro, byteStringMicro, 0, 0}, im_msg_head$DeltaHead.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_cookie = PBField.initBytes(byteStringMicro);
            this.bytes_ack_cookie = PBField.initBytes(byteStringMicro);
            this.uint32_result = PBField.initUInt32(0);
            this.uint32_flags = PBField.initUInt32(0);
        }
    };
    public im_msg_head$C2CHead msg_c2c_head = new MessageMicro<im_msg_head$C2CHead>() { // from class: tencent.im.msg.im_msg_head$C2CHead
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_auth_buf;
        public final PBBytesField bytes_auth_pic_sig;
        public final PBBytesField bytes_auth_sig;
        public final PBStringField string_phone_number;
        public final PBUInt32Field uint32_client_time;
        public final PBUInt32Field uint32_rand;
        public final PBUInt32Field uint32_server_time;
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_cc_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cc_cmd = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 72, 80, 90}, new String[]{"uint64_to_uin", "uint64_from_uin", "uint32_cc_type", "uint32_cc_cmd", "bytes_auth_pic_sig", "bytes_auth_sig", "bytes_auth_buf", "uint32_server_time", "uint32_client_time", "uint32_rand", "string_phone_number"}, new Object[]{0L, 0L, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, ""}, im_msg_head$C2CHead.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_auth_pic_sig = PBField.initBytes(byteStringMicro);
            this.bytes_auth_sig = PBField.initBytes(byteStringMicro);
            this.bytes_auth_buf = PBField.initBytes(byteStringMicro);
            this.uint32_server_time = PBField.initUInt32(0);
            this.uint32_client_time = PBField.initUInt32(0);
            this.uint32_rand = PBField.initUInt32(0);
            this.string_phone_number = PBField.initString("");
        }
    };
    public im_msg_head$SConnHead msg_sconn_head = new MessageMicro<im_msg_head$SConnHead>() { // from class: tencent.im.msg.im_msg_head$SConnHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], im_msg_head$SConnHead.class);
    };
    public im_msg_head$InstCtrl msg_inst_ctrl = new im_msg_head$InstCtrl();
}
