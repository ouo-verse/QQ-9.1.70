package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RspCmd25 extends MessageMicro<GatewayVerify$RspCmd25> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_bind_uin_info", "str_unbind_wording"}, new Object[]{null, ""}, GatewayVerify$RspCmd25.class);
    public final PBRepeatMessageField<GatewayVerify$UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(GatewayVerify$UinInfo.class);
    public final PBStringField str_unbind_wording = PBField.initString("");
}
