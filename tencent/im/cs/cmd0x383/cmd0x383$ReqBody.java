package tencent.im.cs.cmd0x383;

import com.heytap.databaseengine.type.SportMode;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.i2.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x383$ReqBody extends MessageMicro<cmd0x383$ReqBody> {
    public static final int APP_ID_ANDROID_CLIENT = 3;
    public static final int APP_ID_ANPING_SVR = 100;
    public static final int APP_ID_DISCUSS_SVR = 13;
    public static final int APP_ID_FEEDS_TRANS_SVR = 17;
    public static final int APP_ID_GJ_UNKNOWN_SVR = 101;
    public static final int APP_ID_GROUPACTIVE_SVR = 16;
    public static final int APP_ID_GROUPCARD_SVR = 15;
    public static final int APP_ID_GROUPSPACE_SVR = 11;
    public static final int APP_ID_IOS_CLIENT = 2;
    public static final int APP_ID_IPAD_CLIENT = 5;
    public static final int APP_ID_NEW_GROUP_EVENT = 40;
    public static final int APP_ID_OFFlINE_SVR = 12;
    public static final int APP_ID_PC_CLIENT = 1;
    public static final int APP_ID_PC_CLIENT_WEB = 4;
    public static final int APP_ID_WEIYUN_SVR = 14;
    public static final int APP_ID_WINPHONE_CLIENT = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, y.CTRL_INDEX, 898, SportMode.HORSE_RIDING, 914, 922, 930, b.CTRL_INDEX, 954}, new String[]{"uint64_groupcode", "uint32_app_id", "msg_upload_req_body", "msg_resend_req_body", "msg_download_req_body", "msg_del_file_req_body", "msg_rename_req_body", "msg_trans_file_req_body", "msg_link_file_req_body", "msg_feed_msg_v2_req_body", "msg_get_space_req_body", "msg_check_audit_flag_req_body", "msg_copy_from_req_body", "msg_copy_to_req_body", "msg_get_file_list_req_body", "msg_create_folder_req_body", "msg_get_file_count_req_body", "msg_get_file_info_req_body", "msg_get_file_list_v2_req_body", "msg_file_search_req_body"}, new Object[]{0L, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, cmd0x383$ReqBody.class);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public cmd0x383$ApplyUploadReqBody msg_upload_req_body = new MessageMicro<cmd0x383$ApplyUploadReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyUploadReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_sha3;
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
        public final PBStringField str_local_path = PBField.initString("");
        public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 66, 74}, new String[]{"uint32_bus_id", "uint32_oper_type", "str_file_path", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5"}, new Object[]{0, 0, "", "", "", 0L, byteStringMicro, byteStringMicro, byteStringMicro}, cmd0x383$ApplyUploadReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_sha3 = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
        }
    };
    public cmd0x383$ApplyResendReqBody msg_resend_req_body = new MessageMicro<cmd0x383$ApplyResendReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyResendReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_bus_id", "str_file_path", "bytes_sha"}, new Object[]{0, "", ByteStringMicro.EMPTY}, cmd0x383$ApplyResendReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
        public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0x383$ApplyDownloadReqBody msg_download_req_body = new MessageMicro<cmd0x383$ApplyDownloadReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyDownloadReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
        public final PBBoolField bool_thumbnail_req = PBField.initBool(false);
        public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
        public final PBBoolField bool_preview_req = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uint32_bus_id", "str_file_path", "bool_thumbnail_req", "uint32_url_type", "bool_preview_req"}, new Object[]{0, "", bool, 0, bool}, cmd0x383$ApplyDownloadReqBody.class);
        }
    };
    public cmd0x383$ApplyDelFileReqBody msg_del_file_req_body = new MessageMicro<cmd0x383$ApplyDelFileReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyDelFileReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_bus_id", "str_file_path"}, new Object[]{0, ""}, cmd0x383$ApplyDelFileReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
    };
    public cmd0x383$ApplyRenameReqBody msg_rename_req_body = new MessageMicro<cmd0x383$ApplyRenameReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyRenameReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_bus_id", "str_file_path", "str_file_name"}, new Object[]{0, "", ""}, cmd0x383$ApplyRenameReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
    };
    public cmd0x383$ApplyTransFileReqBody msg_trans_file_req_body = new MessageMicro<cmd0x383$ApplyTransFileReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyTransFileReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_bus_id", "str_file_path"}, new Object[]{0, ""}, cmd0x383$ApplyTransFileReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
    };
    public cmd0x383$ApplyLinkFileReqBody msg_link_file_req_body = new MessageMicro<cmd0x383$ApplyLinkFileReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyLinkFileReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_src_bus_id", "str_src_file_path", "uint32_dst_bus_id"}, new Object[]{0, "", 0}, cmd0x383$ApplyLinkFileReqBody.class);
        public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
        public final PBStringField str_src_file_path = PBField.initString("");
        public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyFeedMsgV2ReqBody msg_feed_msg_v2_req_body = new MessageMicro<cmd0x383$ApplyFeedMsgV2ReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyFeedMsgV2ReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_client_ip;
        public final PBBytesField bytes_imei;
        public final PBBytesField bytes_session_key;
        public final PBUInt32Field uint32_client_port;
        public final PBBoolField bool_first_pkg_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path1 = PBField.initString("");
        public final PBStringField str_file_path2 = PBField.initString("");
        public final PBStringField str_file_path3 = PBField.initString("");
        public final PBUInt32Field uint32_msg_random1 = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_random2 = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_random3 = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pt_appid = PBField.initUInt32(0);
        public final PBInt32Field int32_key_type = PBField.initInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 88, 96, 104, 240, 248, 258, 266, 272, FilterEnum.MIC_PTU_BAIXI}, new String[]{"bool_first_pkg_flag", "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "uint32_msg_random1", "uint32_msg_random2", "uint32_msg_random3", "uint32_pt_appid", "int32_key_type", "bytes_session_key", "bytes_client_ip", "uint32_client_port", "bytes_imei"}, new Object[]{Boolean.FALSE, 0, 0, 0, "", "", "", 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro}, cmd0x383$ApplyFeedMsgV2ReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_session_key = PBField.initBytes(byteStringMicro);
            this.bytes_client_ip = PBField.initBytes(byteStringMicro);
            this.uint32_client_port = PBField.initUInt32(0);
            this.bytes_imei = PBField.initBytes(byteStringMicro);
        }
    };
    public cmd0x383$ApplyGetSpaceReqBody msg_get_space_req_body = new MessageMicro<cmd0x383$ApplyGetSpaceReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetSpaceReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x383$ApplyGetSpaceReqBody.class);
    };
    public cmd0x383$ApplyCheckAuditFlagReqBody msg_check_audit_flag_req_body = new MessageMicro<cmd0x383$ApplyCheckAuditFlagReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCheckAuditFlagReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_bus_id", "str_file_path"}, new Object[]{0, ""}, cmd0x383$ApplyCheckAuditFlagReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
    };
    public cmd0x383$ApplyCopyFromReqBody msg_copy_from_req_body = new MessageMicro<cmd0x383$ApplyCopyFromReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCopyFromReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_src_file_path;
        public final PBBytesField bytes_src_parent_folder;
        public final PBStringField str_file_name;
        public final PBStringField str_local_path;
        public final PBUInt32Field uint32_dst_bus_id;
        public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_file_size;
        public final PBUInt64Field uint64_src_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 64, 82}, new String[]{"uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_bus_id", "uint64_file_size", "str_local_path", "str_file_name", "uint64_src_uin", "bytes_md5"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0L, "", "", 0L, byteStringMicro}, cmd0x383$ApplyCopyFromReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_src_parent_folder = PBField.initBytes(byteStringMicro);
            this.bytes_src_file_path = PBField.initBytes(byteStringMicro);
            this.uint32_dst_bus_id = PBField.initUInt32(0);
            this.uint64_file_size = PBField.initUInt64(0L);
            this.str_local_path = PBField.initString("");
            this.str_file_name = PBField.initString("");
            this.uint64_src_uin = PBField.initUInt64(0L);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
        }
    };
    public cmd0x383$ApplyCopyToReqBody msg_copy_to_req_body = new MessageMicro<cmd0x383$ApplyCopyToReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCopyToReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_src_bus_id", "str_src_file_path", "uint32_dst_bus_id", "uint64_dst_uin"}, new Object[]{0, "", 0, 0L}, cmd0x383$ApplyCopyToReqBody.class);
        public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
        public final PBStringField str_src_file_path = PBField.initString("");
        public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    };
    public cmd0x383$ApplyGetFileListReqBody msg_get_file_list_req_body = new MessageMicro<cmd0x383$ApplyGetFileListReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListReqBody
        public static final int REQ_FROM_ANPING_SVR = 21;
        public static final int REQ_FROM_MB_FILE_LIST = 3;
        public static final int REQ_FROM_MB_GROUP_CARD = 2;
        public static final int REQ_FROM_PC_CLIENT_INNERWEB = 11;
        public static final int REQ_FROM_PC_CLIENT_INNERWEB_PAGE = 12;
        public static final int REQ_FROM_PC_GROUP_CARD = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_start_index", "uint32_file_count", "uint32_req_from", "str_parent_folder_path"}, new Object[]{0, 0, 0, ""}, cmd0x383$ApplyGetFileListReqBody.class);
        public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
        public final PBStringField str_parent_folder_path = PBField.initString("");
    };
    public cmd0x383$ApplyCreateFolderReqBody msg_create_folder_req_body = new MessageMicro<cmd0x383$ApplyCreateFolderReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCreateFolderReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_bus_id", "str_folder_name", "str_parent_folder_path"}, new Object[]{0, "", ""}, cmd0x383$ApplyCreateFolderReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_folder_name = PBField.initString("");
        public final PBStringField str_parent_folder_path = PBField.initString("");
    };
    public cmd0x383$ApplyGetFileCountReqBody msg_get_file_count_req_body = new MessageMicro<cmd0x383$ApplyGetFileCountReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileCountReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_bus_id"}, new Object[]{0}, cmd0x383$ApplyGetFileCountReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyGetFileInfoReqBody msg_get_file_info_req_body = new MessageMicro<cmd0x383$ApplyGetFileInfoReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileInfoReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_bus_id", "str_file_path", "uint32_field_flag"}, new Object[]{0, "", 16777215}, cmd0x383$ApplyGetFileInfoReqBody.class);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
        public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
    };
    public cmd0x383$ApplyGetFileListV2ReqBody msg_get_file_list_v2_req_body = new MessageMicro<cmd0x383$ApplyGetFileListV2ReqBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListV2ReqBody
        public static final int REQ_FROM_MB_FILE_LIST_BY_FILETYPE = 2;
        public static final int REQ_FROM_MB_FILE_LIST_BY_TIMESTAMP = 1;
        public static final int REQ_FROM_MB_FILE_LIST_BY_UPLOADER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"msg_start_timestamp", "uint32_file_count", "msg_max_timestamp", "uint32_all_file_count", "uint32_req_from"}, new Object[]{null, 0, null, 0, 0}, cmd0x383$ApplyGetFileListV2ReqBody.class);
        public cmd0x383$FileTimestamp msg_start_timestamp = new cmd0x383$FileTimestamp();
        public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
        public cmd0x383$FileTimestamp msg_max_timestamp = new cmd0x383$FileTimestamp();
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyFileSearchReqBody msg_file_search_req_body = new cmd0x383$ApplyFileSearchReqBody();
}
