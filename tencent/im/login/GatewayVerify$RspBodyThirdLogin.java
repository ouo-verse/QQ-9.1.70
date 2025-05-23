package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RspBodyThirdLogin extends MessageMicro<GatewayVerify$RspBodyThirdLogin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 96, 106, 162, 170, 178, 186, 194}, new String[]{"uint32_service_type", "uint64_qq_uin", "uint32_register_flag", "str_register_token", "msg_rsp_google", "msg_rsp_facebook", "msg_rsp_phone", "msg_rsp_apple", "msg_rsp_wechat"}, new Object[]{0, 0L, 0, "", null, null, null, null, null}, GatewayVerify$RspBodyThirdLogin.class);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_register_flag = PBField.initUInt32(0);
    public final PBStringField str_register_token = PBField.initString("");
    public GatewayVerify$RspBodyGoogle msg_rsp_google = new MessageMicro<GatewayVerify$RspBodyGoogle>() { // from class: tencent.im.login.GatewayVerify$RspBodyGoogle
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, GatewayVerify$RspBodyGoogle.class);
        public final PBStringField str_user_profile = PBField.initString("");
    };
    public GatewayVerify$RspBodyFaceBook msg_rsp_facebook = new MessageMicro<GatewayVerify$RspBodyFaceBook>() { // from class: tencent.im.login.GatewayVerify$RspBodyFaceBook
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, GatewayVerify$RspBodyFaceBook.class);
        public final PBStringField str_user_profile = PBField.initString("");
    };
    public GatewayVerify$RspPhoneLogin msg_rsp_phone = new MessageMicro<GatewayVerify$RspPhoneLogin>() { // from class: tencent.im.login.GatewayVerify$RspPhoneLogin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, GatewayVerify$RspPhoneLogin.class);
        public final PBStringField str_user_profile = PBField.initString("");
    };
    public GatewayVerify$RspBodyApple msg_rsp_apple = new MessageMicro<GatewayVerify$RspBodyApple>() { // from class: tencent.im.login.GatewayVerify$RspBodyApple
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GatewayVerify$RspBodyApple.class);
    };
    public GatewayVerify$RspWechat msg_rsp_wechat = new MessageMicro<GatewayVerify$RspWechat>() { // from class: tencent.im.login.GatewayVerify$RspWechat
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"str_profile"}, new Object[]{""}, GatewayVerify$RspWechat.class);
        public final PBStringField str_profile = PBField.initString("");
    };
}
