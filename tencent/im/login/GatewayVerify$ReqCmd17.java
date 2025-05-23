package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqCmd17 extends MessageMicro<GatewayVerify$ReqCmd17> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 82, 90}, new String[]{"uint32_country_code", "str_mobile_phone", "bool_support_abolish_switch_of_phone_login", "msg_req_phone_sms_extend_login", "msg_req_phone_sms_aux_verify_login"}, new Object[]{0, "", Boolean.FALSE, null, null}, GatewayVerify$ReqCmd17.class);
    public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
    public final PBStringField str_mobile_phone = PBField.initString("");
    public final PBBoolField bool_support_abolish_switch_of_phone_login = PBField.initBool(false);
    public GatewayVerify$ReqPhoneSmsExtendLogin msg_req_phone_sms_extend_login = new MessageMicro<GatewayVerify$ReqPhoneSmsExtendLogin>() { // from class: tencent.im.login.GatewayVerify$ReqPhoneSmsExtendLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_support_flag"}, new Object[]{0}, GatewayVerify$ReqPhoneSmsExtendLogin.class);
        public final PBUInt32Field uint32_support_flag = PBField.initUInt32(0);
    };
    public GatewayVerify$ReqPhoneSmsAuxVerifyLogin msg_req_phone_sms_aux_verify_login = new MessageMicro<GatewayVerify$ReqPhoneSmsAuxVerifyLogin>() { // from class: tencent.im.login.GatewayVerify$ReqPhoneSmsAuxVerifyLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88}, new String[]{"bool_req_support_aux_verify"}, new Object[]{Boolean.FALSE}, GatewayVerify$ReqPhoneSmsAuxVerifyLogin.class);
        public final PBBoolField bool_req_support_aux_verify = PBField.initBool(false);
    };
}
