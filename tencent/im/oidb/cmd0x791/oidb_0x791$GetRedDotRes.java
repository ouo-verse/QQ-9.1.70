package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$GetRedDotRes extends MessageMicro<oidb_0x791$GetRedDotRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_uin", "rpt_msg_reddot_info", "uint32_interval"}, new Object[]{0L, null, 0}, oidb_0x791$GetRedDotRes.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x791$RedDotInfo> rpt_msg_reddot_info = PBField.initRepeatMessage(oidb_0x791$RedDotInfo.class);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
}
