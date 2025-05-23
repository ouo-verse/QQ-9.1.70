package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cd$RspBody extends MessageMicro<cmd0x7cd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_stamp", "uint32_over", "uint32_next", "rpt_msg_appoints_info"}, new Object[]{0, 0, 0, null}, cmd0x7cd$RspBody.class);
    public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x7cd$AppointBrife> rpt_msg_appoints_info = PBField.initRepeatMessage(cmd0x7cd$AppointBrife.class);
}
