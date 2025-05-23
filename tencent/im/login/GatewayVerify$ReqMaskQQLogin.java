package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqMaskQQLogin extends MessageMicro<GatewayVerify$ReqMaskQQLogin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_encrypt_uin_info"}, new Object[]{ByteStringMicro.EMPTY}, GatewayVerify$ReqMaskQQLogin.class);
    public final PBBytesField bytes_encrypt_uin_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
