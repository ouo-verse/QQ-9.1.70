package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqCmd4 extends MessageMicro<GatewayVerify$ReqCmd4> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_country_code", "str_new_device_check_sig", "str_new_device_check_uin_token"}, new Object[]{0, "", ""}, GatewayVerify$ReqCmd4.class);
    public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
    public final PBStringField str_new_device_check_sig = PBField.initString("");
    public final PBStringField str_new_device_check_uin_token = PBField.initString("");
}
