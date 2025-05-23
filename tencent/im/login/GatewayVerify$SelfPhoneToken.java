package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GatewayVerify$SelfPhoneToken extends MessageMicro<GatewayVerify$SelfPhoneToken> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88}, new String[]{"str_token", "int32_channel_id"}, new Object[]{"", 0}, GatewayVerify$SelfPhoneToken.class);
    public final PBStringField str_token = PBField.initString("");
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
}
