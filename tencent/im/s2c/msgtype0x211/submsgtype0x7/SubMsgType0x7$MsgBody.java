package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x7$MsgBody extends MessageMicro<SubMsgType0x7$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106}, new String[]{"uint32_sub_cmd", "msg_header", "rpt_msg_subcmd_0x1_ftn_notify", "rpt_msg_subcmd_0x2_nfc_notify", "rpt_msg_subcmd_0x3_filecontrol", "msg_subcmd_0x4_generic", "rpt_msg_subcmd_0x5_molo_notify", "rpt_msg_subcmd_0x8_rnfc_notify", "rpt_msg_subcmd_0x9_ftn_thumb_notify", "rpt_msg_subcmd_0xa_nfc_thumb_notify", "rpt_msg_subcmd_0xb_mpfile_notify", "msg_subcmd_0xc_progress_req", "msg_subcmd_0xd_progress_rsp"}, new Object[]{0, null, null, null, null, null, null, null, null, null, null, null, null}, SubMsgType0x7$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public MsgHeader msg_header = new MsgHeader();
    public final PBRepeatMessageField<FTNNotify> rpt_msg_subcmd_0x1_ftn_notify = PBField.initRepeatMessage(FTNNotify.class);
    public final PBRepeatMessageField<NFCNotify> rpt_msg_subcmd_0x2_nfc_notify = PBField.initRepeatMessage(NFCNotify.class);
    public final PBRepeatMessageField<FileControl> rpt_msg_subcmd_0x3_filecontrol = PBField.initRepeatMessage(FileControl.class);
    public GenericSubCmd msg_subcmd_0x4_generic = new GenericSubCmd();
    public final PBRepeatMessageField<MoloNotify> rpt_msg_subcmd_0x5_molo_notify = PBField.initRepeatMessage(MoloNotify.class);
    public final PBRepeatMessageField<RNFCNotify> rpt_msg_subcmd_0x8_rnfc_notify = PBField.initRepeatMessage(RNFCNotify.class);
    public final PBRepeatMessageField<FTNNotify> rpt_msg_subcmd_0x9_ftn_thumb_notify = PBField.initRepeatMessage(FTNNotify.class);
    public final PBRepeatMessageField<NFCNotify> rpt_msg_subcmd_0xa_nfc_thumb_notify = PBField.initRepeatMessage(NFCNotify.class);
    public final PBRepeatMessageField<MpFileNotify> rpt_msg_subcmd_0xb_mpfile_notify = PBField.initRepeatMessage(MpFileNotify.class);
    public ProgressReq msg_subcmd_0xc_progress_req = new ProgressReq();
    public ProgressRsp msg_subcmd_0xd_progress_rsp = new ProgressRsp();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ActionInfo extends MessageMicro<ActionInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_service_name", "bytes_buf"}, new Object[]{"", ByteStringMicro.EMPTY}, ActionInfo.class);
        public final PBStringField str_service_name = PBField.initString("");
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FTNNotify extends MessageMicro<FTNNotify> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_originfile_md5;
        public ActionInfo msg_ActionInfo;
        public final PBStringField str_file_key;
        public final PBUInt32Field uint32_batchID;
        public final PBUInt32Field uint32_group_curindex;
        public final PBUInt32Field uint32_group_id;
        public final PBUInt32Field uint32_group_size;
        public final PBUInt32Field uint32_groupflag;
        public final PBUInt32Field uint32_originfiletype;
        public final PBUInt64Field uint64_file_len;
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBStringField str_file_name = PBField.initString("");
        public final PBStringField str_file_index = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 88, 162, 168, 176}, new String[]{"uint64_sessionid", "str_file_name", "str_file_index", "bytes_file_md5", "str_file_key", "uint64_file_len", "bytes_originfile_md5", "uint32_originfiletype", "uint32_group_id", "uint32_group_size", "uint32_group_curindex", "msg_ActionInfo", "uint32_batchID", "uint32_groupflag"}, new Object[]{0L, "", "", byteStringMicro, "", 0L, byteStringMicro, 0, 0, 0, 0, null, 0, 0}, FTNNotify.class);
        }

        public FTNNotify() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.str_file_key = PBField.initString("");
            this.uint64_file_len = PBField.initUInt64(0L);
            this.bytes_originfile_md5 = PBField.initBytes(byteStringMicro);
            this.uint32_originfiletype = PBField.initUInt32(0);
            this.uint32_group_id = PBField.initUInt32(0);
            this.uint32_group_size = PBField.initUInt32(0);
            this.uint32_group_curindex = PBField.initUInt32(0);
            this.msg_ActionInfo = new ActionInfo();
            this.uint32_batchID = PBField.initUInt32(0);
            this.uint32_groupflag = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FileControl extends MessageMicro<FileControl> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72}, new String[]{"uint64_sessionid", "uint32_operate", "uint32_seq", "uint32_code", "str_msg", "uint32_group_id", "uint32_group_curindex", "uint32_batchID", "bool_file_assist"}, new Object[]{0L, 0, 0, 0, "", 0, 0, 0, Boolean.FALSE}, FileControl.class);
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_operate = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_code = PBField.initUInt32(0);
        public final PBStringField str_msg = PBField.initString("");
        public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_curindex = PBField.initUInt32(0);
        public final PBUInt32Field uint32_batchID = PBField.initUInt32(0);
        public final PBBoolField bool_file_assist = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GenericSubCmd extends MessageMicro<GenericSubCmd> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint64_sessionid", "uint32_size", "uint32_index", "uint32_type", "bytes_buf", "uint32_support_auth"}, new Object[]{0L, 0, 0, 0, ByteStringMicro.EMPTY, 0}, GenericSubCmd.class);
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_size = PBField.initUInt32(0);
        public final PBUInt32Field uint32_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_support_auth = PBField.initUInt32(0);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class QQDataTextMsg extends MessageMicro<QQDataTextMsg> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_item"}, new Object[]{null}, QQDataTextMsg.class);
            public final PBRepeatMessageField<MsgItem> rpt_msg_item = PBField.initRepeatMessage(MsgItem.class);

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class MsgItem extends MessageMicro<MsgItem> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "bytes_text"}, new Object[]{0, ByteStringMicro.EMPTY}, MsgItem.class);
                public final PBUInt32Field uint32_type = PBField.initUInt32(0);
                public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class WifiPhotoNoPush extends MessageMicro<WifiPhotoNoPush> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_json"}, new Object[]{ByteStringMicro.EMPTY}, WifiPhotoNoPush.class);
            public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class WifiPhotoWithPush extends MessageMicro<WifiPhotoWithPush> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_json"}, new Object[]{ByteStringMicro.EMPTY}, WifiPhotoWithPush.class);
            public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MoloNotify extends MessageMicro<MoloNotify> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"bytes_buf", "uint32_group_id", "uint32_group_size", "uint32_group_curindex"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0}, MoloNotify.class);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_curindex = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MpFileNotify extends MessageMicro<MpFileNotify> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 32, 40, 48, 58}, new String[]{"uint64_sessionid", "uint32_operate", "fixed32_ip", "uint32_port", "uint32_type", "uint32_power", "bytes_json"}, new Object[]{0L, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY}, MpFileNotify.class);
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_operate = PBField.initUInt32(0);
        public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_power = PBField.initUInt32(0);
        public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MsgHeader extends MessageMicro<MsgHeader> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"uint32_src_app_id", "uint32_src_inst_id", "uint32_dst_app_id", "uint32_dst_inst_id", "uint64_dst_uin", "uint64_src_uin", "uint32_src_uin_type", "uint32_dst_uin_type", "uint32_src_ter_type", "uint32_dst_ter_type"}, new Object[]{0, 0, 0, 0, 0L, 0L, 0, 0, 0, 0}, MsgHeader.class);
        public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_src_inst_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dst_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dst_inst_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_src_uin_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dst_uin_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_src_ter_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dst_ter_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class NFCNotify extends MessageMicro<NFCNotify> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_file_assist;
        public final PBBytesField bytes_file_md5;
        public final PBBytesField bytes_originfile_md5;
        public final PBBytesField bytes_tokenkey;
        public final PBBytesField bytes_url_notify;
        public final PBFixed32Field fixed32_ip;
        public ActionInfo msg_ActionInfo;
        public final PBUInt32Field uint32_batchID;
        public final PBUInt32Field uint32_group_curindex;
        public final PBUInt32Field uint32_group_id;
        public final PBUInt32Field uint32_group_size;
        public final PBUInt32Field uint32_groupflag;
        public final PBUInt32Field uint32_originfiletype;
        public final PBUInt32Field uint32_port;
        public final PBUInt64Field uint64_file_len;
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBStringField str_file_name = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 37, 40, 50, 58, 64, 74, 80, 88, 96, 104, 162, 168, 176, 184}, new String[]{"uint64_sessionid", "str_file_name", "bytes_file_md5", "fixed32_ip", "uint32_port", "bytes_url_notify", "bytes_tokenkey", "uint64_file_len", "bytes_originfile_md5", "uint32_originfiletype", "uint32_group_id", "uint32_group_size", "uint32_group_curindex", "msg_ActionInfo", "uint32_batchID", "uint32_groupflag", "bool_file_assist"}, new Object[]{0L, "", byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, 0, null, 0, 0, Boolean.FALSE}, NFCNotify.class);
        }

        public NFCNotify() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
            this.fixed32_ip = PBField.initFixed32(0);
            this.uint32_port = PBField.initUInt32(0);
            this.bytes_url_notify = PBField.initBytes(byteStringMicro);
            this.bytes_tokenkey = PBField.initBytes(byteStringMicro);
            this.uint64_file_len = PBField.initUInt64(0L);
            this.bytes_originfile_md5 = PBField.initBytes(byteStringMicro);
            this.uint32_originfiletype = PBField.initUInt32(0);
            this.uint32_group_id = PBField.initUInt32(0);
            this.uint32_group_size = PBField.initUInt32(0);
            this.uint32_group_curindex = PBField.initUInt32(0);
            this.msg_ActionInfo = new ActionInfo();
            this.uint32_batchID = PBField.initUInt32(0);
            this.uint32_groupflag = PBField.initUInt32(0);
            this.bool_file_assist = PBField.initBool(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ProgressReq extends MessageMicro<ProgressReq> {
        public static final int ProgressReq_Falg_All = 65535;
        public static final int ProgressReq_Falg_AllSession = 16;
        public static final int ProgressReq_Falg_FileName = 2;
        public static final int ProgressReq_Falg_FileSize = 1;
        public static final int ProgressReq_Falg_Time = 4;
        public static final int ProgressReq_Falg_UpdateSession = 32;
        public static final int ProgressReq_QueryInfo = 1;
        public static final int ProgressReq_QueryList = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_cmd", "uint64_cookie", "uint32_infoflag", "rpt_uint64_sessionid"}, new Object[]{0, 0L, 0, 0L}, ProgressReq.class);
        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
        public final PBUInt64Field uint64_cookie = PBField.initUInt64(0);
        public final PBUInt32Field uint32_infoflag = PBField.initUInt32(0);
        public final PBRepeatField<Long> rpt_uint64_sessionid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ProgressRsp extends MessageMicro<ProgressRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_cmd", "uint64_cookie", "uint32_package_count", "uint32_package_index", "rpt_msg_progressinfo"}, new Object[]{0, 0L, 0, 0, null}, ProgressRsp.class);
        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
        public final PBUInt64Field uint64_cookie = PBField.initUInt64(0);
        public final PBUInt32Field uint32_package_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_package_index = PBField.initUInt32(0);
        public final PBRepeatMessageField<ProgressInfo> rpt_msg_progressinfo = PBField.initRepeatMessage(ProgressInfo.class);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ProgressInfo extends MessageMicro<ProgressInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint64_sessionid", "uint64_progress", "uint32_status", "uint64_filesize", "str_filename", "uint64_time"}, new Object[]{0L, 0L, 0, 0L, "", 0L}, ProgressInfo.class);
            public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
            public final PBUInt64Field uint64_progress = PBField.initUInt64(0);
            public final PBUInt32Field uint32_status = PBField.initUInt32(0);
            public final PBUInt64Field uint64_filesize = PBField.initUInt64(0);
            public final PBStringField str_filename = PBField.initString("");
            public final PBUInt64Field uint64_time = PBField.initUInt64(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RNFCNotify extends MessageMicro<RNFCNotify> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 29, 32, 40, 48}, new String[]{"uint64_sessionid", "bytes_token", "fixed32_ip", "uint32_port", "uint64_svrTaskId", "bool_file_assist"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0, 0L, Boolean.FALSE}, RNFCNotify.class);
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_port = PBField.initUInt32(0);
        public final PBUInt64Field uint64_svrTaskId = PBField.initUInt64(0);
        public final PBBoolField bool_file_assist = PBField.initBool(false);
    }
}
