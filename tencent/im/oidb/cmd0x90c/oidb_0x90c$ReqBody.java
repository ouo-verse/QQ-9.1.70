package tencent.im.oidb.cmd0x90c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x90c$ReqBody extends MessageMicro<oidb_0x90c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32}, new String[]{"uint64_to", "uint64_labelid", "rpt_photoids"}, new Object[]{0L, 0L, 0L}, oidb_0x90c$ReqBody.class);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0);
    public final PBUInt64Field uint64_labelid = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_photoids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
