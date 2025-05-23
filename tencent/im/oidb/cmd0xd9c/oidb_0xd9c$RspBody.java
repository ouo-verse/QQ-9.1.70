package tencent.im.oidb.cmd0xd9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd9c$RspBody extends MessageMicro<oidb_0xd9c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_next", "rpt_friend_list"}, new Object[]{0, null}, oidb_0xd9c$RspBody.class);
    public final PBUInt32Field uint32_next = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xd9c$OneFrdInfo> rpt_friend_list = PBField.initRepeatMessage(oidb_0xd9c$OneFrdInfo.class);
}
