package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video$RspBody extends MessageMicro<hd_video$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"msg_video_head", "msg_failed_body", "msg_create_room_body", "msg_invite_body", "msg_accept_body", "msg_refuse_body", "msg_ignore_body", "msg_logout_body", "msg_query_info_body", "msg_sdk_stat_body", "msg_update_body", "msg_sdk_info_body"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null}, hd_video$RspBody.class);
    public hd_video$VideoHead msg_video_head = new hd_video$VideoHead();
    public hd_video_comm$CmdFailedRspBody msg_failed_body = new MessageMicro<hd_video_comm$CmdFailedRspBody>() { // from class: tencent.im.cs.longconn.hd_video_comm$CmdFailedRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_error_code", "str_error_info"}, new Object[]{0, ""}, hd_video_comm$CmdFailedRspBody.class);
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
        public final PBStringField str_error_info = PBField.initString("");
    };
    public hd_video$CmdCreateRoomRspBody msg_create_room_body = new MessageMicro<hd_video$CmdCreateRoomRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdCreateRoomRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 50, 58, 66, 74, 80, 88, 98, 104, 112, 122, 130}, new String[]{"uint64_dial_no", "str_ticket", "bytes_sign", "uint64_business_id", "rpt_msg_interface_list", "msg_temp_session", "msg_crypt_info", "msg_itf_retry_info", "uint32_itf_net_type", "uint32_watch_video_flag", "msg_account_ext_info", "uint32_invite_scene", "alert_type", "alert_str", "peer_msg_account_ext_info"}, new Object[]{0L, "", ByteStringMicro.EMPTY, 0L, null, null, null, null, 0, 0, null, 0, 0, "", null}, hd_video$CmdCreateRoomRspBody.class);
        public final PBUInt64Field uint64_dial_no = PBField.initUInt64(0);
        public final PBStringField str_ticket = PBField.initString("");
        public final PBBytesField bytes_sign = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_business_id = PBField.initUInt64(0);
        public final PBRepeatMessageField<hd_video_comm$NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(hd_video_comm$NetAddr.class);
        public hd_video$InviteTempSessionData msg_temp_session = new hd_video$InviteTempSessionData();
        public hd_video_comm$CryptInfo msg_crypt_info = new hd_video_comm$CryptInfo();
        public hd_video_comm$ClientConnectInterfaceRetryParam msg_itf_retry_info = new hd_video_comm$ClientConnectInterfaceRetryParam();
        public final PBUInt32Field uint32_itf_net_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_watch_video_flag = PBField.initUInt32(0);
        public hd_video_comm$AccountExtInfo msg_account_ext_info = new hd_video_comm$AccountExtInfo();
        public final PBUInt32Field uint32_invite_scene = PBField.initUInt32(0);
        public final PBEnumField alert_type = PBField.initEnum(0);
        public final PBStringField alert_str = PBField.initString("");
        public final PBRepeatMessageField<hd_video_comm$AccountExtInfo> peer_msg_account_ext_info = PBField.initRepeatMessage(hd_video_comm$AccountExtInfo.class);
    };
    public hd_video$CmdInviteUsersRspBody msg_invite_body = new MessageMicro<hd_video$CmdInviteUsersRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdInviteUsersRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 45, 53, 58}, new String[]{"msg_punch_addr", "uint32_punch_key", "uint64_otheruin", "msg_punch_addr_others", "fixed32_sync_set_ip", "fixed32_sync_set_port", "bytes_sync_set_ipv6"}, new Object[]{null, 0, 0L, null, 0, 0, ByteStringMicro.EMPTY}, hd_video$CmdInviteUsersRspBody.class);
        public hd_video_comm$NetAddr msg_punch_addr = new hd_video_comm$NetAddr();
        public final PBUInt32Field uint32_punch_key = PBField.initUInt32(0);
        public final PBUInt64Field uint64_otheruin = PBField.initUInt64(0);
        public final PBRepeatMessageField<hd_video_comm$NetAddr> msg_punch_addr_others = PBField.initRepeatMessage(hd_video_comm$NetAddr.class);
        public final PBFixed32Field fixed32_sync_set_ip = PBField.initFixed32(0);
        public final PBFixed32Field fixed32_sync_set_port = PBField.initFixed32(0);
        public final PBBytesField bytes_sync_set_ipv6 = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video$CmdAcceptInviteRspBody msg_accept_body = new MessageMicro<hd_video$CmdAcceptInviteRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdAcceptInviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], hd_video$CmdAcceptInviteRspBody.class);
    };
    public hd_video$CmdRefuseInviteRspBody msg_refuse_body = new MessageMicro<hd_video$CmdRefuseInviteRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdRefuseInviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], hd_video$CmdRefuseInviteRspBody.class);
    };
    public hd_video$CmdIgnoreInviteRspBody msg_ignore_body = new MessageMicro<hd_video$CmdIgnoreInviteRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdIgnoreInviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], hd_video$CmdIgnoreInviteRspBody.class);
    };
    public hd_video$CmdLogoutRspBody msg_logout_body = new MessageMicro<hd_video$CmdLogoutRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdLogoutRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], hd_video$CmdLogoutRspBody.class);
    };
    public hd_video$CmdQueryInfoRspBody msg_query_info_body = new MessageMicro<hd_video$CmdQueryInfoRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdQueryInfoRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 53, 58, 66, 72, 82, 90, 96, 104, 112}, new String[]{"uint64_dial_no", "str_ticket", "enum_business_type", "uint64_business_id", "uint32_business_flag", "fixed32_client_seq", "bytes_sign", "rpt_msg_interface_list", "rpt_uint64_userlist", "msg_crypt_info", "msg_itf_retry_info", "uint32_itf_net_type", "uint32_watch_video_flag", "uint32_invite_scene"}, new Object[]{0L, "", 1, 0L, 0, 0, ByteStringMicro.EMPTY, null, 0L, null, null, 0, 0, 0}, hd_video$CmdQueryInfoRspBody.class);
        public final PBUInt64Field uint64_dial_no = PBField.initUInt64(0);
        public final PBStringField str_ticket = PBField.initString("");
        public final PBEnumField enum_business_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_business_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
        public final PBFixed32Field fixed32_client_seq = PBField.initFixed32(0);
        public final PBBytesField bytes_sign = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<hd_video_comm$NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(hd_video_comm$NetAddr.class);
        public final PBRepeatField<Long> rpt_uint64_userlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public hd_video_comm$CryptInfo msg_crypt_info = new hd_video_comm$CryptInfo();
        public hd_video_comm$ClientConnectInterfaceRetryParam msg_itf_retry_info = new hd_video_comm$ClientConnectInterfaceRetryParam();
        public final PBUInt32Field uint32_itf_net_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_watch_video_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_invite_scene = PBField.initUInt32(0);
    };
    public hd_video$CmdSDKReportRspBody msg_sdk_stat_body = new MessageMicro<hd_video$CmdSDKReportRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdSDKReportRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], hd_video$CmdSDKReportRspBody.class);
    };
    public hd_video$CmdUpdateInviteRspBody msg_update_body = new MessageMicro<hd_video$CmdUpdateInviteRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdUpdateInviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_result"}, new Object[]{0}, hd_video$CmdUpdateInviteRspBody.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    };
    public hd_video$CmdSdkInfoReportRspBody msg_sdk_info_body = new MessageMicro<hd_video$CmdSdkInfoReportRspBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdSdkInfoReportRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], hd_video$CmdSdkInfoReportRspBody.class);
    };
}
