package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$RspBody extends MessageMicro<cmd0x346$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 400, 720002, 720010, 720018, 799994}, new String[]{"uint32_cmd", "uint32_seq", "msg_recv_list_query_rsp", "msg_send_list_query_rsp", "msg_renew_file_rsp", "msg_recall_file_rsp", "msg_apply_upload_rsp", "msg_apply_upload_hit_rsp", "msg_apply_forward_file_rsp", "msg_upload_succ_rsp", "msg_delete_file_rsp", "msg_download_succ_rsp", "msg_apply_download_abs_rsp", "msg_apply_download_rsp", "msg_apply_list_download_rsp", "msg_file_query_rsp", "msg_apply_copy_from_rsp", "msg_apply_upload_rsp_v2", "msg_apply_upload_rsp_v3", "msg_apply_upload_hit_rsp_v2", "msg_apply_upload_hit_rsp_v3", "uint32_flag_use_media_platform", "msg_apply_copy_to_rsp", "msg_apply_clean_traffic_rsp", "msg_apply_get_traffic_rsp", "msg_extension_rsp"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null}, cmd0x346$RspBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public cmd0x346$RecvListQueryRsp msg_recv_list_query_rsp = new cmd0x346$RecvListQueryRsp();
    public cmd0x346$SendListQueryRsp msg_send_list_query_rsp = new cmd0x346$SendListQueryRsp();
    public cmd0x346$RenewFileRsp msg_renew_file_rsp = new MessageMicro<cmd0x346$RenewFileRsp>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$RenewFileRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_ret_code", "str_ret_msg"}, new Object[]{0, ""}, cmd0x346$RenewFileRsp.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
    };
    public cmd0x346$RecallFileRsp msg_recall_file_rsp = new cmd0x346$RecallFileRsp();
    public cmd0x346$ApplyUploadRsp msg_apply_upload_rsp = new cmd0x346$ApplyUploadRsp();
    public cmd0x346$ApplyUploadHitRsp msg_apply_upload_hit_rsp = new MessageMicro<cmd0x346$ApplyUploadHitRsp>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_upload_key;
        public final PBBytesField bytes_uuid;
        public final PBStringField str_upload_dns;
        public final PBUInt64Field uint64_total_space;
        public final PBUInt64Field uint64_used_space;
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_upload_ip = PBField.initString("");
        public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
        public final PBStringField str_upload_domain = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242, 320, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, 720, 802}, new String[]{"int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "str_upload_dns"}, new Object[]{0, "", "", 0, "", byteStringMicro, byteStringMicro, 0L, 0L, ""}, cmd0x346$ApplyUploadHitRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_upload_key = PBField.initBytes(byteStringMicro);
            this.uint64_total_space = PBField.initUInt64(0L);
            this.uint64_used_space = PBField.initUInt64(0L);
            this.str_upload_dns = PBField.initString("");
        }
    };
    public cmd0x346$ApplyForwardFileRsp msg_apply_forward_file_rsp = new cmd0x346$ApplyForwardFileRsp();
    public cmd0x346$UploadSuccRsp msg_upload_succ_rsp = new cmd0x346$UploadSuccRsp();
    public cmd0x346$DeleteFileRsp msg_delete_file_rsp = new cmd0x346$DeleteFileRsp();
    public cmd0x346$DownloadSuccRsp msg_download_succ_rsp = new cmd0x346$DownloadSuccRsp();
    public cmd0x346$ApplyDownloadAbsRsp msg_apply_download_abs_rsp = new cmd0x346$ApplyDownloadAbsRsp();
    public cmd0x346$ApplyDownloadRsp msg_apply_download_rsp = new cmd0x346$ApplyDownloadRsp();
    public cmd0x346$ApplyListDownloadRsp msg_apply_list_download_rsp = new MessageMicro<cmd0x346$ApplyListDownloadRsp>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyListDownloadRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 240, 320, 400, 480, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, new String[]{"int32_ret_code", "str_ret_msg", "uint32_total_count", "uint32_begin_index", "uint32_rsp_count", "uint32_is_end", "rpt_msg_file_list"}, new Object[]{0, "", 0, 0, 0, 0, null}, cmd0x346$ApplyListDownloadRsp.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rsp_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
        public final PBRepeatMessageField<cmd0x346$FileInfo> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346$FileInfo.class);
    };
    public cmd0x346$FileQueryRsp msg_file_query_rsp = new cmd0x346$FileQueryRsp();
    public cmd0x346$ApplyCopyFromRsp msg_apply_copy_from_rsp = new MessageMicro<cmd0x346$ApplyCopyFromRsp>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyCopyFromRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242, 320}, new String[]{"int32_ret_code", "str_ret_msg", "bytes_uuid", "uint64_total_space"}, new Object[]{0, "", ByteStringMicro.EMPTY, 0L}, cmd0x346$ApplyCopyFromRsp.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
    };
    public cmd0x346$ApplyUploadRspV2 msg_apply_upload_rsp_v2 = new cmd0x346$ApplyUploadRspV2();
    public cmd0x346$ApplyUploadRspV3 msg_apply_upload_rsp_v3 = new cmd0x346$ApplyUploadRspV3();
    public cmd0x346$ApplyUploadHitRspV2 msg_apply_upload_hit_rsp_v2 = new cmd0x346$ApplyUploadHitRspV2();
    public cmd0x346$ApplyUploadHitRspV3 msg_apply_upload_hit_rsp_v3 = new MessageMicro<cmd0x346$ApplyUploadHitRspV3>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitRspV3
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_upload_key;
        public final PBBytesField bytes_uuid;
        public final PBStringField str_upload_dns;
        public final PBUInt64Field uint64_total_space;
        public final PBUInt64Field uint64_used_space;
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_upload_ip = PBField.initString("");
        public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
        public final PBStringField str_upload_domain = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242, 320, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, 720, 802}, new String[]{"int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "str_upload_dns"}, new Object[]{0, "", "", 0, "", byteStringMicro, byteStringMicro, 0L, 0L, ""}, cmd0x346$ApplyUploadHitRspV3.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_upload_key = PBField.initBytes(byteStringMicro);
            this.uint64_total_space = PBField.initUInt64(0L);
            this.uint64_used_space = PBField.initUInt64(0L);
            this.str_upload_dns = PBField.initString("");
        }
    };
    public final PBUInt32Field uint32_flag_use_media_platform = PBField.initUInt32(0);
    public cmd0x346$ApplyCopyToRsp msg_apply_copy_to_rsp = new cmd0x346$ApplyCopyToRsp();
    public cmd0x346$ApplyCleanTrafficRsp msg_apply_clean_traffic_rsp = new MessageMicro<cmd0x346$ApplyCleanTrafficRsp>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyCleanTrafficRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162}, new String[]{"int32_ret_code", "str_ret_msg"}, new Object[]{0, ""}, cmd0x346$ApplyCleanTrafficRsp.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
    };
    public cmd0x346$ApplyGetTrafficRsp msg_apply_get_traffic_rsp = new MessageMicro<cmd0x346$ApplyGetTrafficRsp>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyGetTrafficRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 240, 320, 400, 480}, new String[]{"int32_ret_code", "str_ret_msg", "uint64_use_file_size", "uint32_use_file_num", "uint64_all_file_size", "uint32_all_file_num"}, new Object[]{0, "", 0L, 0, 0L, 0}, cmd0x346$ApplyGetTrafficRsp.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBUInt64Field uint64_use_file_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_use_file_num = PBField.initUInt32(0);
        public final PBUInt64Field uint64_all_file_size = PBField.initUInt64(0);
        public final PBUInt32Field uint32_all_file_num = PBField.initUInt32(0);
    };
    public cmd0x346$ExtensionRsp msg_extension_rsp = new cmd0x346$ExtensionRsp();
}
