package tencent.im.oidb.cmd0x875;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x875$RspBody extends MessageMicro<oidb_0x875$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_seq", "rpt_msg_interact_list", "uint32_isend"}, new Object[]{0L, null, 0}, oidb_0x875$RspBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x875$UserFollowState> rpt_msg_interact_list = PBField.initRepeatMessage(oidb_0x875$UserFollowState.class);
    public final PBUInt32Field uint32_isend = PBField.initUInt32(0);
}
