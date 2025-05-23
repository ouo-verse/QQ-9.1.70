package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xde8$RspBody extends MessageMicro<oidb_0xde8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_info", "uint32_is_over"}, new Object[]{null, 0}, oidb_0xde8$RspBody.class);
    public final PBRepeatMessageField<oidb_0xde8$NickInfo> rpt_info = PBField.initRepeatMessage(oidb_0xde8$NickInfo.class);
    public final PBUInt32Field uint32_is_over = PBField.initUInt32(0);
}
