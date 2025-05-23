package tencent.im.cs.cmd0x346;

import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ReqBody extends MessageMicro<cmd0x346$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 808, 816, 1600, 720002, 720010, 720018, 799994}, new String[]{"uint32_cmd", "uint32_seq", "msg_recv_list_query_req", "msg_send_list_query_req", "msg_renew_file_req", "msg_recall_file_req", "msg_apply_upload_req", "msg_apply_upload_hit_req", "msg_apply_forward_file_req", "msg_upload_succ_req", "msg_delete_file_req", "msg_download_succ_req", "msg_apply_download_abs_req", "msg_apply_download_req", "msg_apply_list_download_req", "msg_file_query_req", "msg_apply_copy_from_req", "msg_apply_upload_req_v2", "msg_apply_upload_req_v3", "msg_apply_upload_hit_req_v2", "msg_apply_upload_hit_req_v3", "uint32_business_id", "uint32_client_type", "uint32_flag_support_mediaplatform", "msg_apply_copy_to_req", "msg_apply_clean_traffic_req", "msg_apply_get_traffic_req", "msg_extension_req"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, null, null, null, null}, cmd0x346$ReqBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public cmd0x346$RecvListQueryReq msg_recv_list_query_req = new MessageMicro<cmd0x346$RecvListQueryReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$RecvListQueryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_begin_index", "uint32_req_count", "uint32_filter_filetype"}, new Object[]{0L, 0, 0, 0}, cmd0x346$RecvListQueryReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_filter_filetype = PBField.initUInt32(0);
    };
    public cmd0x346$SendListQueryReq msg_send_list_query_req = new MessageMicro<cmd0x346$SendListQueryReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$SendListQueryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_begin_index", "uint32_req_count", "uint32_filter_filetype"}, new Object[]{0L, 0, 0, 0}, cmd0x346$SendListQueryReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_filter_filetype = PBField.initUInt32(0);
    };
    public cmd0x346$RenewFileReq msg_renew_file_req = new MessageMicro<cmd0x346$RenewFileReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$RenewFileReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_uin", "bytes_uuid", "uint32_add_ttl"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, cmd0x346$RenewFileReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_add_ttl = PBField.initUInt32(0);
    };
    public cmd0x346$RecallFileReq msg_recall_file_req = new cmd0x346$RecallFileReq();
    public cmd0x346$ApplyUploadReq msg_apply_upload_req = new cmd0x346$ApplyUploadReq();
    public cmd0x346$ApplyUploadHitReq msg_apply_upload_hit_req = new MessageMicro<cmd0x346$ApplyUploadHitReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 322, 402, 482, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 640}, new String[]{"uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "str_local_filepath", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0L, "", ByteStringMicro.EMPTY, "", 0, 0L}, cmd0x346$ApplyUploadHitReq.class);
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBStringField str_file_name = PBField.initString("");
        public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_local_filepath = PBField.initString("");
        public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
        public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
    };
    public cmd0x346$ApplyForwardFileReq msg_apply_forward_file_req = new cmd0x346$ApplyForwardFileReq();
    public cmd0x346$UploadSuccReq msg_upload_succ_req = new cmd0x346$UploadSuccReq();
    public cmd0x346$DeleteFileReq msg_delete_file_req = new cmd0x346$DeleteFileReq();
    public cmd0x346$DownloadSuccReq msg_download_succ_req = new cmd0x346$DownloadSuccReq();
    public cmd0x346$ApplyDownloadAbsReq msg_apply_download_abs_req = new cmd0x346$ApplyDownloadAbsReq();
    public cmd0x346$ApplyDownloadReq msg_apply_download_req = new cmd0x346$ApplyDownloadReq();
    public cmd0x346$ApplyListDownloadReq msg_apply_list_download_req = new MessageMicro<cmd0x346$ApplyListDownloadReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyListDownloadReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240}, new String[]{"uint64_uin", "uint32_begin_index", "uint32_req_count"}, new Object[]{0L, 0, 0}, cmd0x346$ApplyListDownloadReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    };
    public cmd0x346$FileQueryReq msg_file_query_req = new cmd0x346$FileQueryReq();
    public cmd0x346$ApplyCopyFromReq msg_apply_copy_from_req = new MessageMicro<cmd0x346$ApplyCopyFromReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyCopyFromReq
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_src_parentfolder;
        public final PBBytesField bytes_src_uuid;
        public final PBStringField str_file_name;
        public final PBUInt32Field uint32_danger_level;
        public final PBUInt64Field uint64_dst_uin;
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_total_space;
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_src_group = PBField.initUInt64(0);
        public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 322, 402, 482, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 640, QVipServiceAccountFolderProcessor.CMD, 800, x.CTRL_INDEX}, new String[]{"uint64_src_uin", "uint64_src_group", "uint32_src_svcid", "bytes_src_parentfolder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, "", 0, 0L}, cmd0x346$ApplyCopyFromReq.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parentfolder = PBField.initBytes(byteStringMicro);
            this.bytes_src_uuid = PBField.initBytes(byteStringMicro);
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.uint64_dst_uin = PBField.initUInt64(0L);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_file_name = PBField.initString("");
            this.uint32_danger_level = PBField.initUInt32(0);
            this.uint64_total_space = PBField.initUInt64(0L);
        }
    };
    public cmd0x346$ApplyUploadReqV2 msg_apply_upload_req_v2 = new cmd0x346$ApplyUploadReqV2();
    public cmd0x346$ApplyUploadReqV3 msg_apply_upload_req_v3 = new cmd0x346$ApplyUploadReqV3();
    public cmd0x346$ApplyUploadHitReqV2 msg_apply_upload_hit_req_v2 = new cmd0x346$ApplyUploadHitReqV2();
    public cmd0x346$ApplyUploadHitReqV3 msg_apply_upload_hit_req_v3 = new MessageMicro<cmd0x346$ApplyUploadHitReqV3>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadHitReqV3
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_10m_md5;
        public final PBBytesField bytes_sha;
        public final PBStringField str_local_filepath;
        public final PBUInt32Field uint32_danger_level;
        public final PBUInt64Field uint64_total_space;
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
        public final PBStringField str_file_name = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 240, 322, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, 720}, new String[]{"uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space"}, new Object[]{0L, 0L, 0L, "", byteStringMicro, byteStringMicro, "", 0, 0L}, cmd0x346$ApplyUploadHitReqV3.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_10m_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.str_local_filepath = PBField.initString("");
            this.uint32_danger_level = PBField.initUInt32(0);
            this.uint64_total_space = PBField.initUInt64(0L);
        }
    };
    public cmd0x346$ApplyCopyToReq msg_apply_copy_to_req = new cmd0x346$ApplyCopyToReq();
    public cmd0x346$ApplyCleanTrafficReq msg_apply_clean_traffic_req = new MessageMicro<cmd0x346$ApplyCleanTrafficReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyCleanTrafficReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x346$ApplyCleanTrafficReq.class);
    };
    public cmd0x346$ApplyGetTrafficReq msg_apply_get_traffic_req = new MessageMicro<cmd0x346$ApplyGetTrafficReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$ApplyGetTrafficReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x346$ApplyGetTrafficReq.class);
    };
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_mediaplatform = PBField.initUInt32(0);
    public cmd0x346$ExtensionReq msg_extension_req = new cmd0x346$ExtensionReq();
}
