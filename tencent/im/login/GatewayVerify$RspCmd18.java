package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RspCmd18 extends MessageMicro<GatewayVerify$RspCmd18> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"msg_rsp_phone_sms_extend_login", "str_sms_token", "msg_rsp_phone_sms_aux_verify_login"}, new Object[]{null, "", null}, GatewayVerify$RspCmd18.class);
    public GatewayVerify$RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new GatewayVerify$RspPhoneSmsExtendLogin();
    public final PBStringField str_sms_token = PBField.initString("");
    public GatewayVerify$RspPhoneSmsAuxVerifyLogin msg_rsp_phone_sms_aux_verify_login = new MessageMicro<GatewayVerify$RspPhoneSmsAuxVerifyLogin>() { // from class: tencent.im.login.GatewayVerify$RspPhoneSmsAuxVerifyLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"bind_login_uin_info", "str_aux_verify_url"}, new Object[]{null, ""}, GatewayVerify$RspPhoneSmsAuxVerifyLogin.class);
        public GatewayVerify$UinInfo bind_login_uin_info = new GatewayVerify$UinInfo();
        public final PBStringField str_aux_verify_url = PBField.initString("");
    };
}
