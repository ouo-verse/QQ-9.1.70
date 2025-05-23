package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class GatewayVerify$ReqBodySelfPhoneLogin extends MessageMicro<GatewayVerify$ReqBodySelfPhoneLogin> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_phone_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField bool_support_auxinfo_check = PBField.initBool(false);
    public final PBBoolField bool_support_unbind_phone = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 96}, new String[]{"bytes_phone_token", "bool_support_auxinfo_check", "bool_support_unbind_phone"}, new Object[]{ByteStringMicro.EMPTY, bool, bool}, GatewayVerify$ReqBodySelfPhoneLogin.class);
    }
}
