package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RspLftInfo extends MessageMicro<GatewayVerify$RspLftInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88}, new String[]{"uint32_lft_forbid_area", "uint32_lft_forbid_reason"}, new Object[]{0, 0}, GatewayVerify$RspLftInfo.class);
    public final PBUInt32Field uint32_lft_forbid_area = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lft_forbid_reason = PBField.initUInt32(0);
}
