package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video$MsgBody extends MessageMicro<hd_video$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"msg_video_head", "msg_invite_body", "msg_user_stat_notify_body", "msg_business_change_body", "msg_room_destroy_body", "msg_term_action_body", "msg_invite_reached_body", "msg_have_room_body", "msg_ios_voip_push_body", "msg_pstn_callback_notify_accept", "msg_pstn_callback_notify_logout", "msg_ios_push_notify_logout"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null}, hd_video$MsgBody.class);
    public hd_video$VideoHead msg_video_head = new hd_video$VideoHead();
    public hd_video$CmdS2CInviteReqBody msg_invite_body = new hd_video$CmdS2CInviteReqBody();
    public hd_video$CmdUserStatNotifyReqBody msg_user_stat_notify_body = new MessageMicro<hd_video$CmdUserStatNotifyReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdUserStatNotifyReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uint64_option_uin", "enum_event", "enum_termtype", "uint32_event_reason", "uint32_business_flag", "str_option_uid"}, new Object[]{0L, 1, 1, 0, 0, ""}, hd_video$CmdUserStatNotifyReqBody.class);
        public final PBUInt64Field uint64_option_uin = PBField.initUInt64(0);
        public final PBEnumField enum_event = PBField.initEnum(1);
        public final PBEnumField enum_termtype = PBField.initEnum(1);
        public final PBUInt32Field uint32_event_reason = PBField.initUInt32(0);
        public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
        public final PBStringField str_option_uid = PBField.initString("");
    };
    public hd_video$CmdBusinessChangeReqBody msg_business_change_body = new MessageMicro<hd_video$CmdBusinessChangeReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdBusinessChangeReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"enum_business_type", "uint64_business_id", "uint32_business_flag"}, new Object[]{1, 0L, 0}, hd_video$CmdBusinessChangeReqBody.class);
        public final PBEnumField enum_business_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_business_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
    };
    public hd_video$CmdS2CRoomDestroyReqBody msg_room_destroy_body = new MessageMicro<hd_video$CmdS2CRoomDestroyReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdS2CRoomDestroyReqBody
        public static final int DR_CANCEL = 2;
        public static final int DR_MULTI_TERMINAL_SWITCH = 5;
        public static final int DR_NORMAL = 1;
        public static final int DR_SWITCH_TO_MULTI = 4;
        public static final int DR_TIMEOUT = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"enum_reason"}, new Object[]{1}, hd_video$CmdS2CRoomDestroyReqBody.class);
        public final PBEnumField enum_reason = PBField.initEnum(1);
    };
    public hd_video$CmdTermActNotifyReqBody msg_term_action_body = new MessageMicro<hd_video$CmdTermActNotifyReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdTermActNotifyReqBody
        public static final int AT_RECEIVE = 1;
        public static final int AT_REFUSE = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"enum_action", "uint32_app_id", "enum_termtype", "uint32_business_flag", "uint64_peer_uin", "str_peer_uid"}, new Object[]{1, 0, 1, 0, 0L, ""}, hd_video$CmdTermActNotifyReqBody.class);
        public final PBEnumField enum_action = PBField.initEnum(1);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBEnumField enum_termtype = PBField.initEnum(1);
        public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0);
        public final PBStringField str_peer_uid = PBField.initString("");
    };
    public hd_video$CmdInviteReachedReqBody msg_invite_reached_body = new MessageMicro<hd_video$CmdInviteReachedReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdInviteReachedReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_client_state", "str_utf8_content"}, new Object[]{0, ""}, hd_video$CmdInviteReachedReqBody.class);
        public final PBUInt32Field uint32_client_state = PBField.initUInt32(0);
        public final PBStringField str_utf8_content = PBField.initString("");
    };
    public hd_video$CmdS2CNotifyhaveRoomReqBody msg_have_room_body = new MessageMicro<hd_video$CmdS2CNotifyhaveRoomReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdS2CNotifyhaveRoomReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_userlist"}, new Object[]{null}, hd_video$CmdS2CNotifyhaveRoomReqBody.class);
        public final PBRepeatMessageField<hd_video$PushRoomInfo> rpt_userlist = PBField.initRepeatMessage(hd_video$PushRoomInfo.class);
    };
    public hd_video$CmdS2CIosVoipPushNotifyReqBody msg_ios_voip_push_body = new MessageMicro<hd_video$CmdS2CIosVoipPushNotifyReqBody>() { // from class: tencent.im.cs.longconn.hd_video$CmdS2CIosVoipPushNotifyReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_from_uin", "uint32_from_app_id", "enum_business_type", "uint32_business_flag", "bytes_from_display_name"}, new Object[]{0L, 0, 1, 0, ByteStringMicro.EMPTY}, hd_video$CmdS2CIosVoipPushNotifyReqBody.class);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_from_app_id = PBField.initUInt32(0);
        public final PBEnumField enum_business_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_business_flag = PBField.initUInt32(0);
        public final PBBytesField bytes_from_display_name = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video$CmdPSTNCallbackNotifyAccept msg_pstn_callback_notify_accept = new MessageMicro<hd_video$CmdPSTNCallbackNotifyAccept>() { // from class: tencent.im.cs.longconn.hd_video$CmdPSTNCallbackNotifyAccept
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_call_id", "uint32_accept_time"}, new Object[]{ByteStringMicro.EMPTY, 0}, hd_video$CmdPSTNCallbackNotifyAccept.class);
        public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_accept_time = PBField.initUInt32(0);
    };
    public hd_video$CmdPSTNCallbackNotifyLogout msg_pstn_callback_notify_logout = new MessageMicro<hd_video$CmdPSTNCallbackNotifyLogout>() { // from class: tencent.im.cs.longconn.hd_video$CmdPSTNCallbackNotifyLogout
        public static final int STATUS_DST_NO_ANSWER = 3;
        public static final int STATUS_DST_NO_CONNECT = 5;
        public static final int STATUS_NORMAL = 1;
        public static final int STATUS_SRC_NO_ANSWER = 2;
        public static final int STATUS_SRC_NO_CONNECT = 4;
        public static final int STATUS_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_call_id", "uint32_call_time", "uint32_call_status"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, hd_video$CmdPSTNCallbackNotifyLogout.class);
        public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_call_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_call_status = PBField.initUInt32(0);
    };
    public hd_video$CmdS2CIosPushNotifyLogout msg_ios_push_notify_logout = new MessageMicro<hd_video$CmdS2CIosPushNotifyLogout>() { // from class: tencent.im.cs.longconn.hd_video$CmdS2CIosPushNotifyLogout
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_ios_push_notify_type"}, new Object[]{0}, hd_video$CmdS2CIosPushNotifyLogout.class);
        public final PBUInt32Field uint32_ios_push_notify_type = PBField.initUInt32(0);
    };
}
