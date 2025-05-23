package tencent.im.cs.longconn;

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

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video$VideoHead extends MessageMicro<hd_video$VideoHead> {
    public static final int CMD_ACCEPT_INVITE_REQ = 1001;
    public static final int CMD_ACCEPT_INVITE_RSP = 1002;
    public static final int CMD_CREATE_ROOM_REQ = 1;
    public static final int CMD_CREATE_ROOM_RSP = 2;
    public static final int CMD_IGNORE_INVITE_REQ = 8;
    public static final int CMD_IGNORE_INVITE_RSP = 9;
    public static final int CMD_INVITE_REACHED_REQ = 18;
    public static final int CMD_INVITE_USERS_REQ = 4;
    public static final int CMD_INVITE_USERS_RSP = 5;
    public static final int CMD_LOGOUT_REQ = 1003;
    public static final int CMD_LOGOUT_RSP = 1004;
    public static final int CMD_QUERY_INFO_REQ = 12;
    public static final int CMD_QUERY_INFO_RSP = 13;
    public static final int CMD_REFUSE_INVITE_REQ = 6;
    public static final int CMD_REFUSE_INVITE_RSP = 7;
    public static final int CMD_S2C_BUSINESS_CHANGE_REQ = 11;
    public static final int CMD_S2C_INVITE_REQ = 3;
    public static final int CMD_S2C_INVITE_RSP = 21;
    public static final int CMD_S2C_IOS_PUSH_NOTIFY_LOGOUT_REQ = 26;
    public static final int CMD_S2C_IOS_VOIP_PUSHNOTIFY_REQ = 20;
    public static final int CMD_S2C_NOTIFY_HAVE_ROOM_REQ = 19;
    public static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_ACCEPT_REQ = 22;
    public static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_LOGOUT_REQ = 23;
    public static final int CMD_S2C_ROOM_DESTROY_REQ = 14;
    public static final int CMD_S2C_USER_STAT_NOTIFY_REQ = 10;
    public static final int CMD_SDK_INFO_REPORT_REQ = 24;
    public static final int CMD_SDK_INFO_REPORT_RSP = 25;
    public static final int CMD_SDK_STAT_REPORT_REQ = 16;
    public static final int CMD_SDK_STAT_REPORT_RSP = 17;
    public static final int CMD_TERM_ACT_NOTIFY_REQ = 15;
    public static final int CMD_UPDATE_INVITE_REQ = 1005;
    public static final int CMD_UPDATE_INVITE_RSP = 1006;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ipv6;
    public final PBBytesField bytes_mobile_imsi;
    public final PBInt32Field int32_sub_service_type;
    public hd_video_comm$AccountExtInfo msg_account_ext_info;
    public final PBUInt64Field uint64_server_timestamp;
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
    public final PBStringField str_from_nation = PBField.initString("");
    public final PBStringField str_from_mobile = PBField.initString("");
    public final PBStringField str_to_nation = PBField.initString("");
    public final PBStringField str_to_mobile = PBField.initString("");
    public hd_video$UXError msg_ux_error = new MessageMicro<hd_video$UXError>() { // from class: tencent.im.cs.longconn.hd_video$UXError
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_error_no", "string_error_info"}, new Object[]{0, ""}, hd_video$UXError.class);
        public final PBInt32Field int32_error_no = PBField.initInt32(0);
        public final PBStringField string_error_info = PBField.initString("");
    };
    public final PBBoolField bool_need_push = PBField.initBool(false);
    public hd_video$AppRouteInfo msg_route_info = new MessageMicro<hd_video$AppRouteInfo>() { // from class: tencent.im.cs.longconn.hd_video$AppRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"msg_source_ipinfo", "uint32_app_id", "uint32_instanceId", "bool_is_qcall"}, new Object[]{null, 0, 0, Boolean.FALSE}, hd_video$AppRouteInfo.class);
        public hd_video_comm$NetAddr msg_source_ipinfo = new hd_video_comm$NetAddr();
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_instanceId = PBField.initUInt32(0);
        public final PBBoolField bool_is_qcall = PBField.initBool(false);
    };
    public final PBUInt32Field uint32_need_push_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<hd_video_comm$TransBuffer> rpt_msg_trans_buffer_list = PBField.initRepeatMessage(hd_video_comm$TransBuffer.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 74, 80, 90, 96, 106, 112, 120, 130, 138, 176, 186, 192, 202}, new String[]{"uint64_room_id", "uint64_uin", "uint32_seq", "enum_body_type", "uint32_error_no", "str_from_nation", "str_from_mobile", "str_to_mobile", "msg_ux_error", "bool_need_push", "msg_route_info", "uint32_need_push_type", "str_to_nation", "uint64_group_id", "uint32_call_type", "rpt_msg_trans_buffer_list", "bytes_mobile_imsi", "int32_sub_service_type", "bytes_client_ipv6", "uint64_server_timestamp", "msg_account_ext_info"}, new Object[]{0L, 0L, 0, 1, 0, "", "", "", null, Boolean.FALSE, null, 0, "", 0L, 0, null, byteStringMicro, 0, byteStringMicro, 0L, null}, hd_video$VideoHead.class);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [tencent.im.cs.longconn.hd_video$UXError] */
    /* JADX WARN: Type inference failed for: r3v8, types: [tencent.im.cs.longconn.hd_video$AppRouteInfo] */
    public hd_video$VideoHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_mobile_imsi = PBField.initBytes(byteStringMicro);
        this.int32_sub_service_type = PBField.initInt32(0);
        this.bytes_client_ipv6 = PBField.initBytes(byteStringMicro);
        this.uint64_server_timestamp = PBField.initUInt64(0L);
        this.msg_account_ext_info = new hd_video_comm$AccountExtInfo();
    }
}
