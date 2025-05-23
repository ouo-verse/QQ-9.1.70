package tencent.im.oidb.cmd0x5d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d4$RspBody extends MessageMicro<oidb_0x5d4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"seq", "result"}, new Object[]{0, null}, oidb_0x5d4$RspBody.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x5d4$DelResult> result = PBField.initRepeatMessage(oidb_0x5d4$DelResult.class);
}
