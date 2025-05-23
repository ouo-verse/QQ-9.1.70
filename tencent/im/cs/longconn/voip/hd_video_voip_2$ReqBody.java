package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_voip_2$ReqBody extends MessageMicro<hd_video_voip_2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 410}, new String[]{"msg_voip_head", "msg_phone_bind_req_body", "msg_phone_callback_req_body", "msg_phone_cancel_callback_req_body", "msg_phone_speed_test_req_body", "msg_phone_multi_chat_create_req_body", "msg_phone_multi_chat_invite_req_body", "msg_phone_multi_chat_query_req_body", "msg_phone_multi_chat_kick_req_body", "msg_phone_multi_chat_cancel_req_body", "msg_phone_h5_check_req_body", "msg_bm", "msg_get_call_type_req_body"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null}, hd_video_voip_2$ReqBody.class);
    public hd_video_voip_2$VoipHead msg_voip_head = new hd_video_voip_2$VoipHead();
    public hd_video_voip_2$CmdPhoneBindReqBody msg_phone_bind_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneBindReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneBindReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field uint32_from_flag = PBField.initUInt32(0);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public hd_video_voip_2$TelInfo msg_to_tel = new hd_video_voip_2$TelInfo();
        public final PBUInt32Field uint32_call_policy = PBField.initUInt32(0);
        public hd_video_voip_2$SpeedTestInfo msg_speed_test_info = new MessageMicro<hd_video_voip_2$SpeedTestInfo>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$SpeedTestInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint32_total_pkg", "uint32_real_recv_pkg", "uint32_delay", "uint32_jitter", "uint32_loss_continue", "uint32_estimate_bandwidth"}, new Object[]{0, 0, 0, 0, 0, 0}, hd_video_voip_2$SpeedTestInfo.class);
            public final PBUInt32Field uint32_total_pkg = PBField.initUInt32(0);
            public final PBUInt32Field uint32_real_recv_pkg = PBField.initUInt32(0);
            public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
            public final PBUInt32Field uint32_jitter = PBField.initUInt32(0);
            public final PBUInt32Field uint32_loss_continue = PBField.initUInt32(0);
            public final PBUInt32Field uint32_estimate_bandwidth = PBField.initUInt32(0);
        };
        public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0);
        public final PBBytesField bytes_prvt_session = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<ByteStringMicro> bytes_last_call_id = PBField.initRepeat(PBBytesField.__repeatHelper__);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 58, 66}, new String[]{"uint32_from_flag", "msg_from_tel", "msg_to_tel", "uint32_call_policy", "msg_speed_test_info", "uint64_prvt_id", "bytes_prvt_session", "bytes_last_call_id"}, new Object[]{0, null, null, 0, null, 0L, byteStringMicro, byteStringMicro}, hd_video_voip_2$CmdPhoneBindReqBody.class);
        }
    };
    public hd_video_voip_2$CmdPhoneCallBackReqBody msg_phone_callback_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneCallBackReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneCallBackReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public hd_video_voip_2$TelInfo msg_to_tel = new hd_video_voip_2$TelInfo();
        public final PBUInt64Field uint64_balance = PBField.initUInt64(0);
        public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0);
        public final PBBytesField bytes_prvt_session = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<ByteStringMicro> bytes_last_call_id = PBField.initRepeat(PBBytesField.__repeatHelper__);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58}, new String[]{"msg_from_tel", "msg_to_tel", "uint64_balance", "uint32_cost_type", "uint64_prvt_id", "bytes_prvt_session", "bytes_last_call_id"}, new Object[]{null, null, 0L, 0, 0L, byteStringMicro, byteStringMicro}, hd_video_voip_2$CmdPhoneCallBackReqBody.class);
        }
    };
    public hd_video_voip_2$CmdPhoneCancelCallBackReqBody msg_phone_cancel_callback_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneCancelCallBackReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneCancelCallBackReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_from_tel", "msg_to_tel", "bytes_call_id"}, new Object[]{null, null, ByteStringMicro.EMPTY}, hd_video_voip_2$CmdPhoneCancelCallBackReqBody.class);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public hd_video_voip_2$TelInfo msg_to_tel = new hd_video_voip_2$TelInfo();
        public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$CmdPhoneSpeedTestReq msg_phone_speed_test_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneSpeedTestReq>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneSpeedTestReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21}, new String[]{"uint64_self_uin", "fixed32_self_client_ip"}, new Object[]{0L, 0}, hd_video_voip_2$CmdPhoneSpeedTestReq.class);
        public final PBUInt64Field uint64_self_uin = PBField.initUInt64(0);
        public final PBFixed32Field fixed32_self_client_ip = PBField.initFixed32(0);
    };
    public hd_video_voip_2$CmdPhoneMultiChatCreateReqBody msg_phone_multi_chat_create_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatCreateReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatCreateReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_from_tel", "msg_to_tel", "uint64_balance"}, new Object[]{null, null, 0L}, hd_video_voip_2$CmdPhoneMultiChatCreateReqBody.class);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_to_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
        public final PBUInt64Field uint64_balance = PBField.initUInt64(0);
    };
    public hd_video_voip_2$CmdPhoneMultiChatInviteReqBody msg_phone_multi_chat_invite_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatInviteReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatInviteReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_from_tel", "bytes_conf_id", "msg_invite_tel"}, new Object[]{null, ByteStringMicro.EMPTY, null}, hd_video_voip_2$CmdPhoneMultiChatInviteReqBody.class);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_invite_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
    };
    public hd_video_voip_2$CmdPhoneMultiChatQueryReqBody msg_phone_multi_chat_query_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatQueryReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatQueryReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_from_tel", "bytes_conf_id"}, new Object[]{null, ByteStringMicro.EMPTY}, hd_video_voip_2$CmdPhoneMultiChatQueryReqBody.class);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$CmdPhoneMultiChatKickReqBody msg_phone_multi_chat_kick_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatKickReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatKickReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_from_tel", "bytes_conf_id", "msg_kick_tel"}, new Object[]{null, ByteStringMicro.EMPTY, null}, hd_video_voip_2$CmdPhoneMultiChatKickReqBody.class);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_kick_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
    };
    public hd_video_voip_2$CmdPhoneMultiChatCancelReqBody msg_phone_multi_chat_cancel_req_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatCancelReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatCancelReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_from_tel", "bytes_conf_id"}, new Object[]{null, ByteStringMicro.EMPTY}, hd_video_voip_2$CmdPhoneMultiChatCancelReqBody.class);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$PhoneH5CheckReqBody msg_phone_h5_check_req_body = new MessageMicro<hd_video_voip_2$PhoneH5CheckReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$PhoneH5CheckReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_seq", "msg_from_tel", "msg_to_tel", "uint64_prvt_id"}, new Object[]{0L, null, null, 0L}, hd_video_voip_2$PhoneH5CheckReqBody.class);
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public hd_video_voip_2$TelInfo msg_to_tel = new hd_video_voip_2$TelInfo();
        public final PBUInt64Field uint64_prvt_id = PBField.initUInt64(0);
    };
    public hd_video_voip_2$BalanceAccount msg_bm = new MessageMicro<hd_video_voip_2$BalanceAccount>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$BalanceAccount
        public static final int AT_MULTI = 2;
        public static final int AT_PAIR = 1;
        public static final int AT_TEAM = 3;
        public static final int AT_UNKNOW = 0;
        public static final int FROM_TYPE_LT = 1;
        public static final int FROM_TYPE_QQ = 2;
        public static final int FROM_TYPE_UNKNOW = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_from_app", "uint64_id", "uint32_account_type", "bytes_balance_cookie"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, hd_video_voip_2$BalanceAccount.class);
        public final PBUInt32Field uint32_from_app = PBField.initUInt32(0);
        public final PBUInt64Field uint64_id = PBField.initUInt64(0);
        public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
        public final PBBytesField bytes_balance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$CmdGetCallTypeReqBody msg_get_call_type_req_body = new MessageMicro<hd_video_voip_2$CmdGetCallTypeReqBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdGetCallTypeReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_from_flag", "msg_from_tel", "msg_to_tel", "uint32_call_policy"}, new Object[]{0, null, null, 0}, hd_video_voip_2$CmdGetCallTypeReqBody.class);
        public final PBUInt32Field uint32_from_flag = PBField.initUInt32(0);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public hd_video_voip_2$TelInfo msg_to_tel = new hd_video_voip_2$TelInfo();
        public final PBUInt32Field uint32_call_policy = PBField.initUInt32(0);
    };
}
