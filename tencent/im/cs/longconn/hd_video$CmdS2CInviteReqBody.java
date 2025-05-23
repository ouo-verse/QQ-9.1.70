package tencent.im.cs.longconn;

import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video$CmdS2CInviteReqBody extends MessageMicro<hd_video$CmdS2CInviteReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField alert_str;
    public final PBEnumField alert_type;
    public final PBBoolField bool_chat_with_anyone;
    public final PBBoolField bool_terminal_switch_flag;
    public final PBBytesField bytes_ext_content;
    public final PBBytesField bytes_from_display_name;
    public final PBBytesField bytes_sign;
    public final PBBytesField bytes_sync_set_ipv6;
    public final PBEnumField enum_business_type;
    public final PBEnumField enum_termtype;
    public final PBFixed32Field fixed32_client_seq;
    public final PBFixed32Field fixed32_sync_set_ip;
    public final PBFixed32Field fixed32_sync_set_port;
    public final PBFixed32Field fixed32_timestamp;
    public hd_video_comm$CryptInfo msg_crypt_info;
    public hd_video_comm$AccountExtInfo msg_from_user;
    public hd_video_comm$ClientConnectInterfaceRetryParam msg_itf_retry_info;
    public hd_video_comm$PstnAudioProto msg_local_audio_proto;
    public hd_video$LoginSig msg_login_sig;
    public hd_video_comm$NetAddr msg_punch_addr;
    public final PBRepeatMessageField<hd_video_comm$NetAddr> msg_punch_addr_others;
    public hd_video$InviteTempSessionData msg_temp_session;
    public final PBRepeatMessageField<hd_video_comm$ExtContent> rpt_msg_ext_contents;
    public final PBRepeatMessageField<hd_video_comm$NetAddr> rpt_msg_interface_list;
    public final PBRepeatMessageField<hd_video_comm$SipServerInfo> rpt_msg_sip_server_list;
    public final PBRepeatMessageField<hd_video_comm$AccountExtInfo> rpt_msg_user_list;
    public final PBRepeatField<Long> rpt_uint64_uin_list;
    public final PBStringField str_interesting_chat_buf;
    public final PBStringField str_ticket;
    public final PBUInt32Field uint32_business_flag;
    public final PBUInt32Field uint32_client_ver;
    public final PBUInt32Field uint32_ext_content_type;
    public final PBUInt32Field uint32_from_app_id;
    public final PBUInt32Field uint32_from_binded_id_type;
    public final PBUInt32Field uint32_from_instance_id;
    public final PBUInt32Field uint32_from_network_type;
    public final PBUInt32Field uint32_invite_scene;
    public final PBUInt32Field uint32_itf_net_type;
    public final PBUInt32Field uint32_new_business_flag;
    public final PBUInt32Field uint32_punch_key;
    public final PBUInt32Field uint32_recovery_room_flag;
    public final PBUInt32Field uint32_to_network_type;
    public final PBUInt32Field uint32_watch_video_flag;
    public final PBUInt64Field uint64_business_id;
    public final PBUInt64Field uint64_dial_no;
    public final PBUInt64Field uint64_from_binded_id;
    public final PBUInt64Field uint64_from_uin;
    public final PBUInt64Field uint64_old_room_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 53, 61, 64, 72, 80, 90, 98, 104, 114, 120, 128, 136, 144, 154, 160, 168, 176, 186, 194, 200, 208, 216, 224, 234, 242, 250, 256, 266, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN, 290, 301, 309, 312, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 336, a.CTRL_INDEX, f.CTRL_INDEX, 362, 368, 376, 386}, new String[]{"bytes_sign", "rpt_msg_interface_list", "enum_business_type", "uint64_business_id", "uint32_business_flag", "fixed32_client_seq", "fixed32_timestamp", "rpt_uint64_uin_list", "uint64_from_uin", "uint64_dial_no", "str_ticket", "msg_punch_addr", "uint32_punch_key", "msg_temp_session", "enum_termtype", "uint32_client_ver", "uint32_new_business_flag", "uint32_from_app_id", "msg_login_sig", "bool_terminal_switch_flag", "uint64_old_room_id", "bool_chat_with_anyone", "str_interesting_chat_buf", "rpt_msg_sip_server_list", "uint64_from_binded_id", "uint32_from_binded_id_type", "uint32_from_network_type", "uint32_to_network_type", "msg_local_audio_proto", "bytes_from_display_name", "msg_crypt_info", "uint32_ext_content_type", "bytes_ext_content", "rpt_msg_ext_contents", "uint32_from_instance_id", "msg_punch_addr_others", "fixed32_sync_set_ip", "fixed32_sync_set_port", "uint32_recovery_room_flag", "bytes_sync_set_ipv6", "msg_itf_retry_info", "uint32_itf_net_type", "uint32_watch_video_flag", "rpt_msg_user_list", "msg_from_user", "uint32_invite_scene", "alert_type", "alert_str"}, new Object[]{byteStringMicro, null, 1, 0L, 0, 0, 0, 0L, 0L, 0L, "", null, 0, null, 1, 0, 0, 0, null, bool, 0L, bool, "", null, 0L, 0, 0, 0, null, byteStringMicro, null, 0, byteStringMicro, null, 0, null, 0, 0, 0, byteStringMicro, null, 0, 0, null, null, 0, 0, ""}, hd_video$CmdS2CInviteReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [tencent.im.cs.longconn.hd_video$LoginSig] */
    public hd_video$CmdS2CInviteReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sign = PBField.initBytes(byteStringMicro);
        this.rpt_msg_interface_list = PBField.initRepeatMessage(hd_video_comm$NetAddr.class);
        this.enum_business_type = PBField.initEnum(1);
        this.uint64_business_id = PBField.initUInt64(0L);
        this.uint32_business_flag = PBField.initUInt32(0);
        this.fixed32_client_seq = PBField.initFixed32(0);
        this.fixed32_timestamp = PBField.initFixed32(0);
        this.rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.uint64_from_uin = PBField.initUInt64(0L);
        this.uint64_dial_no = PBField.initUInt64(0L);
        this.str_ticket = PBField.initString("");
        this.msg_punch_addr = new hd_video_comm$NetAddr();
        this.uint32_punch_key = PBField.initUInt32(0);
        this.msg_temp_session = new hd_video$InviteTempSessionData();
        this.enum_termtype = PBField.initEnum(1);
        this.uint32_client_ver = PBField.initUInt32(0);
        this.uint32_new_business_flag = PBField.initUInt32(0);
        this.uint32_from_app_id = PBField.initUInt32(0);
        this.msg_login_sig = new MessageMicro<hd_video$LoginSig>() { // from class: tencent.im.cs.longconn.hd_video$LoginSig
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "bytes_sig"}, new Object[]{0, ByteStringMicro.EMPTY}, hd_video$LoginSig.class);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.bool_terminal_switch_flag = PBField.initBool(false);
        this.uint64_old_room_id = PBField.initUInt64(0L);
        this.bool_chat_with_anyone = PBField.initBool(false);
        this.str_interesting_chat_buf = PBField.initString("");
        this.rpt_msg_sip_server_list = PBField.initRepeatMessage(hd_video_comm$SipServerInfo.class);
        this.uint64_from_binded_id = PBField.initUInt64(0L);
        this.uint32_from_binded_id_type = PBField.initUInt32(0);
        this.uint32_from_network_type = PBField.initUInt32(0);
        this.uint32_to_network_type = PBField.initUInt32(0);
        this.msg_local_audio_proto = new hd_video_comm$PstnAudioProto();
        this.bytes_from_display_name = PBField.initBytes(byteStringMicro);
        this.msg_crypt_info = new hd_video_comm$CryptInfo();
        this.uint32_ext_content_type = PBField.initUInt32(0);
        this.bytes_ext_content = PBField.initBytes(byteStringMicro);
        this.rpt_msg_ext_contents = PBField.initRepeatMessage(hd_video_comm$ExtContent.class);
        this.uint32_from_instance_id = PBField.initUInt32(0);
        this.msg_punch_addr_others = PBField.initRepeatMessage(hd_video_comm$NetAddr.class);
        this.fixed32_sync_set_ip = PBField.initFixed32(0);
        this.fixed32_sync_set_port = PBField.initFixed32(0);
        this.uint32_recovery_room_flag = PBField.initUInt32(0);
        this.bytes_sync_set_ipv6 = PBField.initBytes(byteStringMicro);
        this.msg_itf_retry_info = new hd_video_comm$ClientConnectInterfaceRetryParam();
        this.uint32_itf_net_type = PBField.initUInt32(0);
        this.uint32_watch_video_flag = PBField.initUInt32(0);
        this.rpt_msg_user_list = PBField.initRepeatMessage(hd_video_comm$AccountExtInfo.class);
        this.msg_from_user = new hd_video_comm$AccountExtInfo();
        this.uint32_invite_scene = PBField.initUInt32(0);
        this.alert_type = PBField.initEnum(0);
        this.alert_str = PBField.initString("");
    }
}
