package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqBody extends MessageMicro<GatewayVerify$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 42, 74, 82, 162, 242, 322, 402, 410, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 610, 618, 626}, new String[]{"uint64_seq", "msg_req_client_info", "msg_req_common_info", "msg_req_third_login", "msg_req_self_phone", "msg_req_connect_login", "msg_req_bind_phone_login", "msg_req_mask_qq_login", "msg_req_cmd_4", "msg_req_cmd_9", "msg_req_cmd_17", "msg_req_cmd_18", "msg_req_cmd_23", "msg_req_cmd_24", "msg_req_cmd_25"}, new Object[]{0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, GatewayVerify$ReqBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public GatewayVerify$ReqCommonInfo msg_req_common_info = new GatewayVerify$ReqCommonInfo();
    public GatewayVerify$ReqClientInfo msg_req_client_info = new MessageMicro<GatewayVerify$ReqClientInfo>() { // from class: tencent.im.login.GatewayVerify$ReqClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_client_qua", "uint32_client_platform", "str_qimei36"}, new Object[]{"", 0, ""}, GatewayVerify$ReqClientInfo.class);
        public final PBStringField str_client_qua = PBField.initString("");
        public final PBUInt32Field uint32_client_platform = PBField.initUInt32(0);
        public final PBStringField str_qimei36 = PBField.initString("");
    };
    public GatewayVerify$ReqBodyThirdLogin msg_req_third_login = new GatewayVerify$ReqBodyThirdLogin();
    public GatewayVerify$ReqBodySelfPhone msg_req_self_phone = new GatewayVerify$ReqBodySelfPhone();
    public GatewayVerify$ReqConnectLogin msg_req_connect_login = new GatewayVerify$ReqConnectLogin();
    public GatewayVerify$ReqBindPhoneLogin msg_req_bind_phone_login = new GatewayVerify$ReqBindPhoneLogin();
    public GatewayVerify$ReqMaskQQLogin msg_req_mask_qq_login = new GatewayVerify$ReqMaskQQLogin();
    public GatewayVerify$ReqCmd4 msg_req_cmd_4 = new GatewayVerify$ReqCmd4();
    public GatewayVerify$ReqCmd9 msg_req_cmd_9 = new MessageMicro<GatewayVerify$ReqCmd9>() { // from class: tencent.im.login.GatewayVerify$ReqCmd9
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GatewayVerify$ReqCmd9.class);
    };
    public GatewayVerify$ReqCmd17 msg_req_cmd_17 = new GatewayVerify$ReqCmd17();
    public GatewayVerify$ReqCmd18 msg_req_cmd_18 = new MessageMicro<GatewayVerify$ReqCmd18>() { // from class: tencent.im.login.GatewayVerify$ReqCmd18
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_sms_token"}, new Object[]{""}, GatewayVerify$ReqCmd18.class);
        public final PBStringField str_sms_token = PBField.initString("");
    };
    public GatewayVerify$ReqCmd23 msg_req_cmd_23 = new GatewayVerify$ReqCmd23();
    public GatewayVerify$ReqCmd24 msg_req_cmd_24 = new GatewayVerify$ReqCmd24();
    public GatewayVerify$ReqCmd25 msg_req_cmd_25 = new MessageMicro<GatewayVerify$ReqCmd25>() { // from class: tencent.im.login.GatewayVerify$ReqCmd25
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_a1_list"}, new Object[]{null}, GatewayVerify$ReqCmd25.class);
        public final PBRepeatMessageField<GatewayVerify$A1Sig> rpt_a1_list = PBField.initRepeatMessage(GatewayVerify$A1Sig.class);
    };
}
