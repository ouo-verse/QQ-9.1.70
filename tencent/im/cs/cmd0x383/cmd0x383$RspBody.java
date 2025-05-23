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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListRspBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x383$RspBody extends MessageMicro<cmd0x383$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, y.CTRL_INDEX, 898, SportMode.HORSE_RIDING, 914, 922, 930, b.CTRL_INDEX, 954}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "msg_upload_rsp_body", "msg_resend_rsp_body", "msg_download_rsp_body", "msg_del_file_rsp_body", "msg_rename_rsp_body", "msg_trans_file_rsp_body", "msg_link_file_rsp_body", "msg_feed_msg_v2_rsp_body", "msg_get_space_rsp_body", "msg_check_audit_flag_rsp_body", "msg_copy_from_rsp_body", "msg_copy_to_rsp_body", "msg_get_file_list_rsp_body", "msg_create_folder_rsp_body", "msg_get_file_count_rsp_body", "msg_get_file_info_rsp_body", "msg_get_file_list_v2_rsp_body", "msg_file_search_rsp_body"}, new Object[]{0, "", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, cmd0x383$RspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public cmd0x383$ApplyUploadRspBody msg_upload_rsp_body = new MessageMicro<cmd0x383$ApplyUploadRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyUploadRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_file_exist;
        public final PBBoolField bool_safe_check_flag;
        public final PBBytesField bytes_check_key;
        public final PBBytesField bytes_file_key;
        public final PBUInt32Field uint32_im_fail_reason;
        public final PBUInt32Field uint32_safe_check_res;
        public final PBStringField str_upload_ip = PBField.initString("");
        public final PBStringField str_server_dns = PBField.initString("");
        public final PBStringField str_file_path = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 88, 96, 104}, new String[]{"str_upload_ip", "str_server_dns", "str_file_path", "bytes_file_key", "bytes_check_key", "bool_file_exist", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_im_fail_reason"}, new Object[]{"", "", "", byteStringMicro, byteStringMicro, bool, bool, 0, 0}, cmd0x383$ApplyUploadRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.bytes_check_key = PBField.initBytes(byteStringMicro);
            this.bool_file_exist = PBField.initBool(false);
            this.bool_safe_check_flag = PBField.initBool(false);
            this.uint32_safe_check_res = PBField.initUInt32(0);
            this.uint32_im_fail_reason = PBField.initUInt32(0);
        }
    };
    public cmd0x383$ApplyResendRspBody msg_resend_rsp_body = new MessageMicro<cmd0x383$ApplyResendRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyResendRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_check_key;
        public final PBBytesField bytes_file_key;
        public final PBStringField str_upload_ip = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_upload_ip", "bytes_file_key", "bytes_check_key"}, new Object[]{"", byteStringMicro, byteStringMicro}, cmd0x383$ApplyResendRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_key = PBField.initBytes(byteStringMicro);
            this.bytes_check_key = PBField.initBytes(byteStringMicro);
        }
    };
    public cmd0x383$ApplyDownloadRspBody msg_download_rsp_body = new MessageMicro<cmd0x383$ApplyDownloadRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyDownloadRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_safe_check_flag;
        public final PBBytesField bytes_cookie_val;
        public final PBBytesField bytes_download_url;
        public final PBBytesField bytes_md5;
        public final PBBytesField bytes_sha;
        public final PBBytesField bytes_sha3;
        public final PBStringField str_msg;
        public final PBStringField str_save_file_name;
        public final PBUInt32Field uint32_preview_port;
        public final PBUInt32Field uint32_safe_check_res;
        public final PBStringField str_download_ip = PBField.initString("");
        public final PBStringField str_download_dns = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 88, 96, 104, 114}, new String[]{"str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_preview_port", "str_msg"}, new Object[]{"", "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, "", Boolean.FALSE, 0, 0, ""}, cmd0x383$ApplyDownloadRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_download_url = PBField.initBytes(byteStringMicro);
            this.bytes_sha = PBField.initBytes(byteStringMicro);
            this.bytes_sha3 = PBField.initBytes(byteStringMicro);
            this.bytes_md5 = PBField.initBytes(byteStringMicro);
            this.bytes_cookie_val = PBField.initBytes(byteStringMicro);
            this.str_save_file_name = PBField.initString("");
            this.bool_safe_check_flag = PBField.initBool(false);
            this.uint32_safe_check_res = PBField.initUInt32(0);
            this.uint32_preview_port = PBField.initUInt32(0);
            this.str_msg = PBField.initString("");
        }
    };
    public cmd0x383$ApplyDelFileRspBody msg_del_file_rsp_body = new MessageMicro<cmd0x383$ApplyDelFileRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyDelFileRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x383$ApplyDelFileRspBody.class);
    };
    public cmd0x383$ApplyRenameRspBody msg_rename_rsp_body = new MessageMicro<cmd0x383$ApplyRenameRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyRenameRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88, 96}, new String[]{"bool_safe_check_flag", "uint32_safe_check_res"}, new Object[]{Boolean.FALSE, 0}, cmd0x383$ApplyRenameRspBody.class);
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyTransFileRspBody msg_trans_file_rsp_body = new MessageMicro<cmd0x383$ApplyTransFileRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyTransFileRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_save_file_path"}, new Object[]{""}, cmd0x383$ApplyTransFileRspBody.class);
        public final PBStringField str_save_file_path = PBField.initString("");
    };
    public cmd0x383$ApplyLinkFileRspBody msg_link_file_rsp_body = new MessageMicro<cmd0x383$ApplyLinkFileRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyLinkFileRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96}, new String[]{"str_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res"}, new Object[]{"", Boolean.FALSE, 0}, cmd0x383$ApplyLinkFileRspBody.class);
        public final PBStringField str_save_file_path = PBField.initString("");
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyFeedMsgV2RspBody msg_feed_msg_v2_rsp_body = new MessageMicro<cmd0x383$ApplyFeedMsgV2RspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyFeedMsgV2RspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 88}, new String[]{"uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "bool_safe_check_flag"}, new Object[]{0, 0, 0, "", "", "", Boolean.FALSE}, cmd0x383$ApplyFeedMsgV2RspBody.class);
        public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_path1 = PBField.initString("");
        public final PBStringField str_file_path2 = PBField.initString("");
        public final PBStringField str_file_path3 = PBField.initString("");
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    };
    public cmd0x383$ApplyGetSpaceRspBody msg_get_space_rsp_body = new MessageMicro<cmd0x383$ApplyGetSpaceRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetSpaceRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_total_space", "uint64_used_space"}, new Object[]{0L, 0L}, cmd0x383$ApplyGetSpaceRspBody.class);
        public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
        public final PBUInt64Field uint64_used_space = PBField.initUInt64(0);
    };
    public cmd0x383$ApplyCheckAuditFlagRspBody msg_check_audit_flag_rsp_body = new MessageMicro<cmd0x383$ApplyCheckAuditFlagRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCheckAuditFlagRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_audit_flag"}, new Object[]{0}, cmd0x383$ApplyCheckAuditFlagRspBody.class);
        public final PBUInt32Field uint32_audit_flag = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyCopyFromRspBody msg_copy_from_rsp_body = new MessageMicro<cmd0x383$ApplyCopyFromRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCopyFromRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96}, new String[]{"bytes_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res"}, new Object[]{ByteStringMicro.EMPTY, Boolean.FALSE, 0}, cmd0x383$ApplyCopyFromRspBody.class);
        public final PBBytesField bytes_save_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyCopyToRspBody msg_copy_to_rsp_body = new MessageMicro<cmd0x383$ApplyCopyToRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCopyToRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96}, new String[]{"str_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res"}, new Object[]{"", Boolean.FALSE, 0}, cmd0x383$ApplyCopyToRspBody.class);
        public final PBStringField str_save_file_path = PBField.initString("");
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyGetFileListRspBody msg_get_file_list_rsp_body = new MessageMicro<cmd0x383$ApplyGetFileListRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56}, new String[]{"uint32_file_count", "uint32_all_file_count", "bool_is_end", "rpt_msg_file_info_list", "uint32_folder_count", "rpt_msg_folder_info_list", "uint32_filter_code"}, new Object[]{0, 0, Boolean.FALSE, null, 0, null, 0}, cmd0x383$ApplyGetFileListRspBody.class);
        public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
        public final PBBoolField bool_is_end = PBField.initBool(false);
        public final PBRepeatMessageField<FileInfo> rpt_msg_file_info_list = PBField.initRepeatMessage(FileInfo.class);
        public final PBUInt32Field uint32_folder_count = PBField.initUInt32(0);
        public final PBRepeatMessageField<FolderInfo> rpt_msg_folder_info_list = PBField.initRepeatMessage(FolderInfo.class);
        public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class FileInfo extends MessageMicro<FileInfo> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_md5;
            public final PBBytesField bytes_sha;
            public final PBBytesField bytes_sha3;
            public final PBStringField str_local_path;
            public final PBStringField str_uploader_name;
            public final PBStringField str_file_path = PBField.initString("");
            public final PBStringField str_file_name = PBField.initString("");
            public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
            public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_upload_uin = PBField.initUInt32(0);
            public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0);
            public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106, 114, 202}, new String[]{"str_file_path", "str_file_name", "uint64_file_size", "uint32_bus_id", "uint32_upload_uin", "uint64_uploaded_size", "uint32_upload_time", "uint32_dead_time", "uint32_modify_time", "uint32_download_times", "bytes_sha", "bytes_sha3", "bytes_md5", "str_local_path", "str_uploader_name"}, new Object[]{"", "", 0L, 0, 0, 0L, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, "", ""}, FileInfo.class);
            }

            public FileInfo() {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_sha = PBField.initBytes(byteStringMicro);
                this.bytes_sha3 = PBField.initBytes(byteStringMicro);
                this.bytes_md5 = PBField.initBytes(byteStringMicro);
                this.str_local_path = PBField.initString("");
                this.str_uploader_name = PBField.initString("");
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class FolderInfo extends MessageMicro<FolderInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"str_folder_path", "str_folder_name", "uint32_create_time", "uint64_create_uin"}, new Object[]{"", "", 0, 0L}, FolderInfo.class);
            public final PBStringField str_folder_path = PBField.initString("");
            public final PBStringField str_folder_name = PBField.initString("");
            public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
            public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0);
        }
    };
    public cmd0x383$ApplyCreateFolderRspBody msg_create_folder_rsp_body = new MessageMicro<cmd0x383$ApplyCreateFolderRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyCreateFolderRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96}, new String[]{"str_folder_path", "bool_safe_check_flag", "uint32_safe_check_res"}, new Object[]{"", Boolean.FALSE, 0}, cmd0x383$ApplyCreateFolderRspBody.class);
        public final PBStringField str_folder_path = PBField.initString("");
        public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyGetFileCountRspBody msg_get_file_count_rsp_body = new MessageMicro<cmd0x383$ApplyGetFileCountRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileCountRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_all_file_count"}, new Object[]{0}, cmd0x383$ApplyGetFileCountRspBody.class);
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyGetFileInfoRspBody msg_get_file_info_rsp_body = new MessageMicro<cmd0x383$ApplyGetFileInfoRspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileInfoRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"fileInfo"}, new Object[]{null}, cmd0x383$ApplyGetFileInfoRspBody.class);
        public cmd0x383$ApplyGetFileListRspBody.FileInfo fileInfo = new cmd0x383$ApplyGetFileListRspBody.FileInfo();
    };
    public cmd0x383$ApplyGetFileListV2RspBody msg_get_file_list_v2_rsp_body = new MessageMicro<cmd0x383$ApplyGetFileListV2RspBody>() { // from class: tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListV2RspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"bool_is_end", "rpt_msg_file_info_list", "msg_max_timestamp", "uint32_all_file_count", "uint32_filter_code"}, new Object[]{Boolean.FALSE, null, null, 0, 0}, cmd0x383$ApplyGetFileListV2RspBody.class);
        public final PBBoolField bool_is_end = PBField.initBool(false);
        public final PBRepeatMessageField<cmd0x383$ApplyGetFileListRspBody.FileInfo> rpt_msg_file_info_list = PBField.initRepeatMessage(cmd0x383$ApplyGetFileListRspBody.FileInfo.class);
        public cmd0x383$FileTimestamp msg_max_timestamp = new cmd0x383$FileTimestamp();
        public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
    };
    public cmd0x383$ApplyFileSearchRspBody msg_file_search_rsp_body = new cmd0x383$ApplyFileSearchRspBody();
}
