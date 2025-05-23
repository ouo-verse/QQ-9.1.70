package tencent.im.login;

import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RspBody extends MessageMicro<GatewayVerify$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 74, 82, 162, 242, 322, 402, 482, P2VGlobalConfig.WATER_MARKER_WIDTH, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 642, 650, 690, 698, 706}, new String[]{"uint64_seq", "msg_rsp_common_info", "msg_rsp_third_login", "msg_rsp_self_phone", "msg_rsp_connect_login", "msg_rsp_bind_phone_login", "msg_rsp_lft_info", "msg_rsp_tips_info", "msg_rsp_cmd_4", "msg_rsp_cmd_9", "msg_rsp_cmd_17", "msg_rsp_cmd_18", "msg_rsp_cmd_23", "msg_rsp_cmd_24", "msg_rsp_cmd_25"}, new Object[]{0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, GatewayVerify$RspBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public GatewayVerify$RspCommonInfo msg_rsp_common_info = new MessageMicro<GatewayVerify$RspCommonInfo>() { // from class: tencent.im.login.GatewayVerify$RspCommonInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 96}, new String[]{"uint32_need_verify_scenes", "msg_rsp_nt", "uint32_a1_seq"}, new Object[]{0, null, 0}, GatewayVerify$RspCommonInfo.class);
        public final PBUInt32Field uint32_need_verify_scenes = PBField.initUInt32(0);
        public GatewayVerify$RspNT msg_rsp_nt = new MessageMicro<GatewayVerify$RspNT>() { // from class: tencent.im.login.GatewayVerify$RspNT
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_uid", "bytes_ua2"}, new Object[]{"", ByteStringMicro.EMPTY}, GatewayVerify$RspNT.class);
            public final PBStringField str_uid = PBField.initString("");
            public final PBBytesField bytes_ua2 = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        public final PBUInt32Field uint32_a1_seq = PBField.initUInt32(0);
    };
    public GatewayVerify$RspBodyThirdLogin msg_rsp_third_login = new GatewayVerify$RspBodyThirdLogin();
    public GatewayVerify$RspBodySelfPhone msg_rsp_self_phone = new GatewayVerify$RspBodySelfPhone();
    public GatewayVerify$RspConnectLogin msg_rsp_connect_login = new MessageMicro<GatewayVerify$RspConnectLogin>() { // from class: tencent.im.login.GatewayVerify$RspConnectLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GatewayVerify$RspConnectLogin.class);
    };
    public GatewayVerify$RspBindPhoneLogin msg_rsp_bind_phone_login = new MessageMicro<GatewayVerify$RspBindPhoneLogin>() { // from class: tencent.im.login.GatewayVerify$RspBindPhoneLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GatewayVerify$RspBindPhoneLogin.class);
    };
    public GatewayVerify$RspLftInfo msg_rsp_lft_info = new GatewayVerify$RspLftInfo();
    public GatewayVerify$RspTipsInfo msg_rsp_tips_info = new GatewayVerify$RspTipsInfo();
    public GatewayVerify$RspCmd4 msg_rsp_cmd_4 = new MessageMicro<GatewayVerify$RspCmd4>() { // from class: tencent.im.login.GatewayVerify$RspCmd4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GatewayVerify$RspCmd4.class);
    };
    public GatewayVerify$RspCmd9 msg_rsp_cmd_9 = new MessageMicro<GatewayVerify$RspCmd9>() { // from class: tencent.im.login.GatewayVerify$RspCmd9
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_rsp_phone_sms_extend_login"}, new Object[]{null}, GatewayVerify$RspCmd9.class);
        public GatewayVerify$RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new GatewayVerify$RspPhoneSmsExtendLogin();
    };
    public GatewayVerify$RspCmd17 msg_rsp_cmd_17 = new MessageMicro<GatewayVerify$RspCmd17>() { // from class: tencent.im.login.GatewayVerify$RspCmd17
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GatewayVerify$RspCmd17.class);
    };
    public GatewayVerify$RspCmd18 msg_rsp_cmd_18 = new GatewayVerify$RspCmd18();
    public GatewayVerify$RspCmd23 msg_rsp_cmd_23 = new MessageMicro<GatewayVerify$RspCmd23>() { // from class: tencent.im.login.GatewayVerify$RspCmd23
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_rsp_time_wechat"}, new Object[]{null}, GatewayVerify$RspCmd23.class);
        public GatewayVerify$RspTimWeChat msg_rsp_time_wechat = new MessageMicro<GatewayVerify$RspTimWeChat>() { // from class: tencent.im.login.GatewayVerify$RspTimWeChat
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"str_wechat_register_token"}, new Object[]{""}, GatewayVerify$RspTimWeChat.class);
            public final PBStringField str_wechat_register_token = PBField.initString("");
        };
    };
    public GatewayVerify$RspCmd24 msg_rsp_cmd_24 = new MessageMicro<GatewayVerify$RspCmd24>() { // from class: tencent.im.login.GatewayVerify$RspCmd24
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_salt_list"}, new Object[]{null}, GatewayVerify$RspCmd24.class);
        public final PBRepeatMessageField<GatewayVerify$RandSalt> rpt_salt_list = PBField.initRepeatMessage(GatewayVerify$RandSalt.class);
    };
    public GatewayVerify$RspCmd25 msg_rsp_cmd_25 = new GatewayVerify$RspCmd25();
}
