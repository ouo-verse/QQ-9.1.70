package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class GatewayVerify$ReqBindPhoneLogin extends MessageMicro<GatewayVerify$ReqBindPhoneLogin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_pic_verify_info"}, new Object[]{null}, GatewayVerify$ReqBindPhoneLogin.class);
    public GatewayVerify$PicVerifyInfo msg_pic_verify_info = new GatewayVerify$PicVerifyInfo();
}
