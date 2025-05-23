package tencent.im.oidb.inner.cmd0xca05;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca05$RspBody extends MessageMicro<cmd0xca05$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_res", "rpt_result", "uint32_timestamp"}, new Object[]{0, null, 0}, cmd0xca05$RspBody.class);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xca05$Result> rpt_result = PBField.initRepeatMessage(cmd0xca05$Result.class);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}
