package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x345$ReqBody extends MessageMicro<cmd0x345$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"uint32_sub_cmd", "msg_subcmd_0x1_req_body", "msg_subcmd_0x2_req_body", "msg_subcmd_0x3_req_body", "msg_subcmd_0x4_req_body", "msg_subcmd_0x5_req_body", "msg_subcmd_0x6_req_body", "msg_subcmd_0x7_req_body", "msg_subcmd_0x9_req_body", "msg_subcmd_0xa_req_body"}, new Object[]{0, null, null, null, null, null, null, null, null, null}, cmd0x345$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public SubCmd0x1ReqBody msg_subcmd_0x1_req_body = new SubCmd0x1ReqBody();
    public SubCmd0x2ReqBody msg_subcmd_0x2_req_body = new SubCmd0x2ReqBody();
    public SubCmd0x3ReqBody msg_subcmd_0x3_req_body = new SubCmd0x3ReqBody();
    public SubCmd0x4ReqBody msg_subcmd_0x4_req_body = new SubCmd0x4ReqBody();
    public SubCmd0x5ReqBody msg_subcmd_0x5_req_body = new SubCmd0x5ReqBody();
    public SubCmd0x6ReqBody msg_subcmd_0x6_req_body = new SubCmd0x6ReqBody();
    public SubCmd0x7ReqBody msg_subcmd_0x7_req_body = new SubCmd0x7ReqBody();
    public SubCmd0x9ReqBody msg_subcmd_0x9_req_body = new SubCmd0x9ReqBody();
    public SubCmd0xaReqBody msg_subcmd_0xa_req_body = new SubCmd0xaReqBody();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x1ReqBody extends MessageMicro<SubCmd0x1ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64}, new String[]{"str_md5", "str_sha", "str_file_name", "uint64_file_size", "uint32_upload_type", "uint32_disscus_uin", "uint32_sender_uin", "uint32_costom_id"}, new Object[]{"", "", "", 0L, 0, 0, 0, 0}, SubCmd0x1ReqBody.class);
        public final PBStringField str_md5 = PBField.initString("");
        public final PBStringField str_sha = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x2ReqBody extends MessageMicro<SubCmd0x2ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66, 74, 80, 88, 96, 104, 112, 122}, new String[]{"uint32_disscus_uin", "uint32_sender_uin", "str_file_name", "uint64_file_size", "str_file_id", "str_batch_id", "str_batch_item_id", "str_client_key", "str_file_key", "uint32_mark", "uint64_time", "uint64_sequence", "uint32_busid", "uint32_random", "bytes_pb_bytes_reserve"}, new Object[]{0, 0, "", 0L, "", "", "", "", "", 0, 0L, 0L, 0, 0, ByteStringMicro.EMPTY}, SubCmd0x2ReqBody.class);
        public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
        public final PBStringField str_file_name = PBField.initString("");
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_batch_id = PBField.initString("");
        public final PBStringField str_batch_item_id = PBField.initString("");
        public final PBStringField str_client_key = PBField.initString("");
        public final PBStringField str_file_key = PBField.initString("");
        public final PBUInt32Field uint32_mark = PBField.initUInt32(0);
        public final PBUInt64Field uint64_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_sequence = PBField.initUInt64(0);
        public final PBUInt32Field uint32_busid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_random = PBField.initUInt32(0);
        public final PBBytesField bytes_pb_bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x3ReqBody extends MessageMicro<SubCmd0x3ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"uint32_uin", "str_file_id", "uint32_disscus_uin", "uint32_costom_id", "uint64_uin", "uint64_disscus_uin"}, new Object[]{0, "", 0, 0, 0L, 0L}, SubCmd0x3ReqBody.class);
        public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x4ReqBody extends MessageMicro<SubCmd0x4ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubCmd0x4ReqBody.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x5ReqBody extends MessageMicro<SubCmd0x5ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_src_file_path;
        public final PBBytesField bytes_src_parent_folder;
        public final PBStringField str_file_name;
        public final PBUInt32Field uint32_dst_uin;
        public final PBUInt32Field uint32_from_uin;
        public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_file_size;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66}, new String[]{"uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_uin", "uint64_file_size", "uint32_from_uin", "str_file_name", "bytes_md5"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0L, 0, "", byteStringMicro}, SubCmd0x5ReqBody.class);
        }

        public SubCmd0x5ReqBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parent_folder = PBField.initBytes(byteStringMicro);
            this.bytes_src_file_path = PBField.initBytes(byteStringMicro);
            this.uint32_dst_uin = PBField.initUInt32(0);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.uint32_from_uin = PBField.initUInt32(0);
            this.str_file_name = PBField.initString("");
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x6ReqBody extends MessageMicro<SubCmd0x6ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_sig;
        public final PBBytesField bytes_uuid;
        public final PBStringField str_dst_phone_number;
        public final PBStringField str_file_name;
        public final PBStringField str_src_file_path;
        public final PBStringField str_src_parent_folder;
        public final PBUInt32Field uint32_client_type;
        public final PBUInt64Field uint64_app_id;
        public final PBUInt64Field uint64_dst_uin;
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_talk_type;
        public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58, 66, 74, 80, 88, 98, 106, 112}, new String[]{"uint32_dst_bus_id", "uint64_src_uin", "bytes_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "str_src_file_path", "str_src_parent_folder", "uint32_client_type", "uint64_app_id", "str_dst_phone_number", "bytes_sig", "uint64_talk_type"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, 0L, 0L, "", "", "", 0, 0L, "", byteStringMicro, 0L}, SubCmd0x6ReqBody.class);
        }

        public SubCmd0x6ReqBody() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.uint64_dst_uin = PBField.initUInt64(0L);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_file_name = PBField.initString("");
            this.str_src_file_path = PBField.initString("");
            this.str_src_parent_folder = PBField.initString("");
            this.uint32_client_type = PBField.initUInt32(0);
            this.uint64_app_id = PBField.initUInt64(0L);
            this.str_dst_phone_number = PBField.initString("");
            this.bytes_sig = PBField.initBytes(byteStringMicro);
            this.uint64_talk_type = PBField.initUInt64(0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x7ReqBody extends MessageMicro<SubCmd0x7ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_disscus_uin", "str_file_path"}, new Object[]{0L, ""}, SubCmd0x7ReqBody.class);
        public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0);
        public final PBStringField str_file_path = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0x9ReqBody extends MessageMicro<SubCmd0x9ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_disscus_uin", "uint32_begin", "uint32_file_num"}, new Object[]{0L, 0, 0}, SubCmd0x9ReqBody.class);
        public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_begin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubCmd0xaReqBody extends MessageMicro<SubCmd0xaReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_uin", "uint64_disscus_uin", "str_file_id", "str_session_info"}, new Object[]{0L, 0L, "", ""}, SubCmd0xaReqBody.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_session_info = PBField.initString("");
    }
}
