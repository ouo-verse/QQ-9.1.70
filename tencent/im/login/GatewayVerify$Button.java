package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$Button extends MessageMicro<GatewayVerify$Button> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_text", "uint32_action", "str_jump_url"}, new Object[]{"", 0, ""}, GatewayVerify$Button.class);
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    public final PBStringField str_jump_url = PBField.initString("");
}
