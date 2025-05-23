package tencent.im.oidb.cmd0x7ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x7ba$RspBody extends MessageMicro<oidb_0x7ba$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 96}, new String[]{"rpt_info", "uint32_next_index", "uint32_complete"}, new Object[]{null, 0, 0}, oidb_0x7ba$RspBody.class);
    public final PBRepeatMessageField<oidb_0x7ba$PraiseInfo> rpt_info = PBField.initRepeatMessage(oidb_0x7ba$PraiseInfo.class);
    public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_complete = PBField.initUInt32(0);
}
