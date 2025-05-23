package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqCmd24 extends MessageMicro<GatewayVerify$ReqCmd24> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_country_code", "str_mobile_phone", "waterprof_wall_info"}, new Object[]{0, "", null}, GatewayVerify$ReqCmd24.class);
    public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
    public final PBStringField str_mobile_phone = PBField.initString("");
    public GatewayVerify$WaterprofWallInfo waterprof_wall_info = new GatewayVerify$WaterprofWallInfo();
}
