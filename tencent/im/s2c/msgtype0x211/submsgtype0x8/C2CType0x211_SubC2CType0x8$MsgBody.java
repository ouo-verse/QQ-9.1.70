package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$MsgBody extends MessageMicro<C2CType0x211_SubC2CType0x8$MsgBody> {
    public static final int MSG_CCNF_ABI_QUERY_FIELD_NUMBER = 3;
    public static final int MSG_CCNF_FILESEND_REQ_FIELD_NUMBER = 5;
    public static final int MSG_CCNF_FILESTATE_SYNC_FIELD_NUMBER = 6;
    public static final int MSG_CC_NOTIFYLIST_FIELD_NUMBER = 2;
    public static final int MSG_CC_PUSH_JUDGE_RESULT_FIELD_NUMBER = 4;
    public static final int MSG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_cc_notifylist", "msg_ccnf_abi_query", "msg_cc_push_judge_result", "msg_ccnf_filesend_req", "msg_ccnf_filestate_sync"}, new Object[]{1, null, null, null, null, null}, C2CType0x211_SubC2CType0x8$MsgBody.class);
    public final PBEnumField msg_type = PBField.initEnum(1);
    public C2CType0x211_SubC2CType0x8$NotifyList msg_cc_notifylist = new MessageMicro<C2CType0x211_SubC2CType0x8$NotifyList>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$NotifyList
        public static final int NOTIFY_TYPE_FIELD_NUMBER = 1;
        public static final int RPT_MSG_UPDATE_LIST_FIELD_NUMBER = 2;
        public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"notify_type", "rpt_msg_update_list", "uint32_session_id"}, new Object[]{0, null, 0}, C2CType0x211_SubC2CType0x8$NotifyList.class);
        public final PBEnumField notify_type = PBField.initEnum(0);
        public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8$UpdateInfo> rpt_msg_update_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8$UpdateInfo.class);
        public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    };
    public C2CType0x211_SubC2CType0x8$NearFieldAbiQuery msg_ccnf_abi_query = new MessageMicro<C2CType0x211_SubC2CType0x8$NearFieldAbiQuery>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$NearFieldAbiQuery
        public static final int BOOL_NEED_TIPS_FIELD_NUMBER = 3;
        public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
        public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 8;
        public static final int INT32_PEER_IP_FIELD_NUMBER = 6;
        public static final int INT32_PEER_PORT_FIELD_NUMBER = 7;
        public static final int INT32_TIMEOUT_FIELD_NUMBER = 4;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_cookie;
        public final PBBytesField bytes_peer_extra;
        public final PBInt32Field int32_peer_ip;
        public final PBInt32Field int32_peer_port;
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBBoolField bool_need_tips = PBField.initBool(false);
        public final PBInt32Field int32_timeout = PBField.initInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66}, new String[]{"uint64_to_uin", "uint64_from_uin", "bool_need_tips", "int32_timeout", "bytes_cookie", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra"}, new Object[]{0L, 0L, Boolean.FALSE, 0, byteStringMicro, 0, 0, byteStringMicro}, C2CType0x211_SubC2CType0x8$NearFieldAbiQuery.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_cookie = PBField.initBytes(byteStringMicro);
            this.int32_peer_ip = PBField.initInt32(0);
            this.int32_peer_port = PBField.initInt32(0);
            this.bytes_peer_extra = PBField.initBytes(byteStringMicro);
        }
    };
    public C2CType0x211_SubC2CType0x8$PushJudgeResult msg_cc_push_judge_result = new MessageMicro<C2CType0x211_SubC2CType0x8$PushJudgeResult>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$PushJudgeResult
        public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 6;
        public static final int INT32_PEER_IP_FIELD_NUMBER = 4;
        public static final int INT32_PEER_PORT_FIELD_NUMBER = 5;
        public static final int MSG_HEAD_FIELD_NUMBER = 1;
        public static final int MSG_RESULT_FIELD_NUMBER = 3;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"msg_head", "uint64_to_uin", "msg_result", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra"}, new Object[]{null, 0L, null, 0, 0, ByteStringMicro.EMPTY}, C2CType0x211_SubC2CType0x8$PushJudgeResult.class);
        public C2CType0x211_SubC2CType0x8$BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8$BusiRespHead();
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public C2CType0x211_SubC2CType0x8$JudgeResult msg_result = new C2CType0x211_SubC2CType0x8$JudgeResult();
        public final PBInt32Field int32_peer_ip = PBField.initInt32(0);
        public final PBInt32Field int32_peer_port = PBField.initInt32(0);
        public final PBBytesField bytes_peer_extra = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public C2CType0x211_SubC2CType0x8$NearFieldFileSendReq msg_ccnf_filesend_req = new MessageMicro<C2CType0x211_SubC2CType0x8$NearFieldFileSendReq>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$NearFieldFileSendReq
        public static final int INT32_CONN_WIFIAP_TIMEOUT_FIELD_NUMBER = 6;
        public static final int INT32_IP_FIELD_NUMBER = 3;
        public static final int INT32_UDP_PORT_FIELD_NUMBER = 4;
        public static final int RPT_MSG_FILE_LIST_FIELD_NUMBER = 2;
        public static final int STR_SSID_FIELD_NUMBER = 5;
        public static final int STR_WIFIPSW_FIELD_NUMBER = 8;
        public static final int UINT32_FORCE_WIFI_FIELD_NUMBER = 7;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 66}, new String[]{"uint64_to_uin", "rpt_msg_file_list", "int32_ip", "int32_udp_port", "str_ssid", "int32_conn_wifiap_timeout", "uint32_force_wifi", "str_wifipsw"}, new Object[]{0L, null, 0, 0, "", 0, 0, ""}, C2CType0x211_SubC2CType0x8$NearFieldFileSendReq.class);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8$NearFieldFileInfo> rpt_msg_file_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8$NearFieldFileInfo.class);
        public final PBInt32Field int32_ip = PBField.initInt32(0);
        public final PBInt32Field int32_udp_port = PBField.initInt32(0);
        public final PBStringField str_ssid = PBField.initString("");
        public final PBInt32Field int32_conn_wifiap_timeout = PBField.initInt32(0);
        public final PBUInt32Field uint32_force_wifi = PBField.initUInt32(0);
        public final PBStringField str_wifipsw = PBField.initString("");
    };
    public C2CType0x211_SubC2CType0x8$NearFieldFileStateSync msg_ccnf_filestate_sync = new MessageMicro<C2CType0x211_SubC2CType0x8$NearFieldFileStateSync>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$NearFieldFileStateSync
        public static final int ETYPE_FIELD_NUMBER = 1;
        public static final int INT32_ERROR_CODE_FIELD_NUMBER = 4;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 3;
        public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"eType", "uint64_session_id", "uint64_from_uin", "int32_error_code"}, new Object[]{1, 0L, 0L, 0}, C2CType0x211_SubC2CType0x8$NearFieldFileStateSync.class);
        public final PBEnumField eType = PBField.initEnum(1);
        public final PBUInt64Field uint64_session_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBInt32Field int32_error_code = PBField.initInt32(0);
    };
}
