package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_voip_2$RspBody extends MessageMicro<hd_video_voip_2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 418}, new String[]{"msg_voip_head", "msg_failed_body", "msg_phone_bind_rsp_body", "msg_phone_callback_rsp_body", "msg_phone_cancel_callback_rsp_body", "msg_phone_speed_test_rsp_body", "msg_phone_multi_chat_create_rsp_body", "msg_phone_multi_chat_invite_rsp_body", "msg_phone_multi_chat_query_rsp_body", "msg_phone_multi_chat_kick_rsp_body", "msg_phone_multi_chat_cancel_rsp_body", "msg_phone_h5_check_rsp_body", "msg_get_call_type_rsp_body"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null}, hd_video_voip_2$RspBody.class);
    public hd_video_voip_2$VoipHead msg_voip_head = new hd_video_voip_2$VoipHead();
    public hd_video_voip_2$CmdFailedRspBody msg_failed_body = new MessageMicro<hd_video_voip_2$CmdFailedRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdFailedRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_error_code", "bytes_error_info"}, new Object[]{0, ByteStringMicro.EMPTY}, hd_video_voip_2$CmdFailedRspBody.class);
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
        public final PBBytesField bytes_error_info = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$CmdPhoneBindRspBody msg_phone_bind_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneBindRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneBindRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_call_id;
        public final PBBytesField bytes_call_phone;
        public final PBBytesField bytes_call_prompt;
        public final PBUInt32Field uint32_ability;
        public final PBUInt32Field uint32_call_phone_type;
        public final PBUInt32Field uint32_cb_line_count;
        public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_call_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 64}, new String[]{"uint32_call_type", "uint64_call_id", "bytes_call_id", "bytes_call_prompt", "bytes_call_phone", "uint32_ability", "uint32_call_phone_type", "uint32_cb_line_count"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0}, hd_video_voip_2$CmdPhoneBindRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_call_id = PBField.initBytes(byteStringMicro);
            this.bytes_call_prompt = PBField.initBytes(byteStringMicro);
            this.bytes_call_phone = PBField.initBytes(byteStringMicro);
            this.uint32_ability = PBField.initUInt32(0);
            this.uint32_call_phone_type = PBField.initUInt32(0);
            this.uint32_cb_line_count = PBField.initUInt32(0);
        }
    };
    public hd_video_voip_2$CmdPhoneCallBackRspBody msg_phone_callback_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneCallBackRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneCallBackRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_call_id;
        public final PBBytesField bytes_call_phone;
        public final PBBytesField bytes_call_prompt;
        public final PBUInt32Field uint32_call_phone_type;
        public final PBUInt32Field uint32_cb_line_count;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"bytes_call_id", "bytes_call_prompt", "bytes_call_phone", "uint32_call_phone_type", "uint32_cb_line_count"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, hd_video_voip_2$CmdPhoneCallBackRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_call_id = PBField.initBytes(byteStringMicro);
            this.bytes_call_prompt = PBField.initBytes(byteStringMicro);
            this.bytes_call_phone = PBField.initBytes(byteStringMicro);
            this.uint32_call_phone_type = PBField.initUInt32(0);
            this.uint32_cb_line_count = PBField.initUInt32(0);
        }
    };
    public hd_video_voip_2$CmdPhoneCancelCallBackRspBody msg_phone_cancel_callback_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneCancelCallBackRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneCancelCallBackRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_call_id"}, new Object[]{ByteStringMicro.EMPTY}, hd_video_voip_2$CmdPhoneCancelCallBackRspBody.class);
        public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$CmdPhoneSpeedTestRsp msg_phone_speed_test_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneSpeedTestRsp>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneSpeedTestRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82}, new String[]{"uint32_result", "uint32_test_type", "uint32_pkglen", "uint32_pkgnum_per_second", "uint32_sendpkg_keep_time", "uint32_ping_interval_time", "uint32_ping_cnt", "uint32_ping_packet_size", "uint32_server_interval", "rpt_msg_ipspeed_info_list"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, null}, hd_video_voip_2$CmdPhoneSpeedTestRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt32Field uint32_test_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pkglen = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pkgnum_per_second = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sendpkg_keep_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ping_interval_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ping_cnt = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ping_packet_size = PBField.initUInt32(0);
        public final PBUInt32Field uint32_server_interval = PBField.initUInt32(0);
        public final PBRepeatMessageField<IPSpeedSvrInfo> rpt_msg_ipspeed_info_list = PBField.initRepeatMessage(IPSpeedSvrInfo.class);

        /* loaded from: classes29.dex */
        public static final class IPSpeedSvrInfo extends MessageMicro<IPSpeedSvrInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16}, new String[]{"fixed32_server_ip", "uint32_server_port"}, new Object[]{0, 0}, IPSpeedSvrInfo.class);
            public final PBFixed32Field fixed32_server_ip = PBField.initFixed32(0);
            public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
        }
    };
    public hd_video_voip_2$CmdPhoneMultiChatCreateRspBody msg_phone_multi_chat_create_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatCreateRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatCreateRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_call_phone;
        public final PBBytesField bytes_call_prompt;
        public final PBBytesField bytes_conf_id;
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_not_support_to_tel;
        public final PBUInt32Field uint32_call_phone_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"bytes_conf_id", "msg_not_support_to_tel", "bytes_call_prompt", "bytes_call_phone", "uint32_call_phone_type"}, new Object[]{byteStringMicro, null, byteStringMicro, byteStringMicro, 0}, hd_video_voip_2$CmdPhoneMultiChatCreateRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_conf_id = PBField.initBytes(byteStringMicro);
            this.msg_not_support_to_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
            this.bytes_call_prompt = PBField.initBytes(byteStringMicro);
            this.bytes_call_phone = PBField.initBytes(byteStringMicro);
            this.uint32_call_phone_type = PBField.initUInt32(0);
        }
    };
    public hd_video_voip_2$CmdPhoneMultiChatInviteRspBody msg_phone_multi_chat_invite_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatInviteRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatInviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_conf_id", "msg_invite_fail_tel", "msg_invite_succ_tel"}, new Object[]{ByteStringMicro.EMPTY, null, null}, hd_video_voip_2$CmdPhoneMultiChatInviteRspBody.class);
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_invite_fail_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_invite_succ_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
    };
    public hd_video_voip_2$CmdPhoneMultiChatQueryRspBody msg_phone_multi_chat_query_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatQueryRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatQueryRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_conf_id", "msg_chating_tel"}, new Object[]{ByteStringMicro.EMPTY, null}, hd_video_voip_2$CmdPhoneMultiChatQueryRspBody.class);
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_chating_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
    };
    public hd_video_voip_2$CmdPhoneMultiChatKickRspBody msg_phone_multi_chat_kick_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatKickRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatKickRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_conf_id", "msg_kick_fail_tel", "msg_kick_succ_tel"}, new Object[]{ByteStringMicro.EMPTY, null, null}, hd_video_voip_2$CmdPhoneMultiChatKickRspBody.class);
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_kick_fail_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
        public final PBRepeatMessageField<hd_video_voip_2$TelInfo> msg_kick_succ_tel = PBField.initRepeatMessage(hd_video_voip_2$TelInfo.class);
    };
    public hd_video_voip_2$CmdPhoneMultiChatCancelRspBody msg_phone_multi_chat_cancel_rsp_body = new MessageMicro<hd_video_voip_2$CmdPhoneMultiChatCancelRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdPhoneMultiChatCancelRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_conf_id"}, new Object[]{ByteStringMicro.EMPTY}, hd_video_voip_2$CmdPhoneMultiChatCancelRspBody.class);
        public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public hd_video_voip_2$PhoneH5CheckRspBody msg_phone_h5_check_rsp_body = new MessageMicro<hd_video_voip_2$PhoneH5CheckRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$PhoneH5CheckRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint64_seq", "msg_from_tel", "msg_to_tel", "uint32_error_no", "uint64_balance"}, new Object[]{0L, null, null, 0, 0L}, hd_video_voip_2$PhoneH5CheckRspBody.class);
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
        public hd_video_voip_2$TelInfo msg_from_tel = new hd_video_voip_2$TelInfo();
        public hd_video_voip_2$TelInfo msg_to_tel = new hd_video_voip_2$TelInfo();
        public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
        public final PBUInt64Field uint64_balance = PBField.initUInt64(0);
    };
    public hd_video_voip_2$CmdGetCallTypeRspBody msg_get_call_type_rsp_body = new MessageMicro<hd_video_voip_2$CmdGetCallTypeRspBody>() { // from class: tencent.im.cs.longconn.voip.hd_video_voip_2$CmdGetCallTypeRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_call_id;
        public final PBBytesField bytes_call_phone;
        public final PBUInt32Field uint32_call_ability;
        public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_tiny_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_call_type", "uint64_tiny_id", "bytes_call_id", "bytes_call_phone", "uint32_call_ability"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, 0}, hd_video_voip_2$CmdGetCallTypeRspBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_call_id = PBField.initBytes(byteStringMicro);
            this.bytes_call_phone = PBField.initBytes(byteStringMicro);
            this.uint32_call_ability = PBField.initUInt32(0);
        }
    };
}
