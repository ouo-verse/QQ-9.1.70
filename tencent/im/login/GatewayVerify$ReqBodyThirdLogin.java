package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqBodyThirdLogin extends MessageMicro<GatewayVerify$ReqBodyThirdLogin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 162, 170, 178, 186, 194}, new String[]{"uint32_service_type", "uin_account_type", "msg_req_google", "msg_req_facebook", "msg_req_phone", "msg_req_apple", "msg_req_wechat"}, new Object[]{0, 0, null, null, null, null, null}, GatewayVerify$ReqBodyThirdLogin.class);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt32Field uin_account_type = PBField.initUInt32(0);
    public GatewayVerify$ReqBodyGoogle msg_req_google = new MessageMicro<GatewayVerify$ReqBodyGoogle>() { // from class: tencent.im.login.GatewayVerify$ReqBodyGoogle
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_appid", "str_id_token"}, new Object[]{"", ""}, GatewayVerify$ReqBodyGoogle.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_id_token = PBField.initString("");
    };
    public GatewayVerify$ReqBodyFaceBook msg_req_facebook = new MessageMicro<GatewayVerify$ReqBodyFaceBook>() { // from class: tencent.im.login.GatewayVerify$ReqBodyFaceBook
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_appid", "str_access_token"}, new Object[]{"", ""}, GatewayVerify$ReqBodyFaceBook.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_access_token = PBField.initString("");
    };
    public GatewayVerify$ReqPhoneLogin msg_req_phone = new MessageMicro<GatewayVerify$ReqPhoneLogin>() { // from class: tencent.im.login.GatewayVerify$ReqPhoneLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_country_code", "str_phone_num"}, new Object[]{"", ""}, GatewayVerify$ReqPhoneLogin.class);
        public final PBStringField str_country_code = PBField.initString("");
        public final PBStringField str_phone_num = PBField.initString("");
    };
    public GatewayVerify$ReqBodyApple msg_req_apple = new MessageMicro<GatewayVerify$ReqBodyApple>() { // from class: tencent.im.login.GatewayVerify$ReqBodyApple
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114, 242, 250}, new String[]{"str_appid", "str_user_id", "str_identity_token", "str_authorization_code", "str_nick_name", "str_gender"}, new Object[]{"", "", "", "", "", ""}, GatewayVerify$ReqBodyApple.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_user_id = PBField.initString("");
        public final PBStringField str_identity_token = PBField.initString("");
        public final PBStringField str_authorization_code = PBField.initString("");
        public final PBStringField str_nick_name = PBField.initString("");
        public final PBStringField str_gender = PBField.initString("");
    };
    public GatewayVerify$ReqWechat msg_req_wechat = new GatewayVerify$ReqWechat();
}
