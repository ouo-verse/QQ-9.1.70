package tencent.im.oidb.cmd0xe72;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe72$RspBody extends MessageMicro<oidb_0xe72$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_no_verify", "uint32_high_risk_group"}, new Object[]{0, 0}, oidb_0xe72$RspBody.class);
    public final PBUInt32Field uint32_no_verify = PBField.initUInt32(0);
    public final PBUInt32Field uint32_high_risk_group = PBField.initUInt32(0);
}
