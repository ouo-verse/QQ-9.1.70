package tencent.im.oidb.cmd0xd6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.mutualmark.mutualmark$MutualMark;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd6b$MutualMarkData extends MessageMicro<Oidb_0xd6b$MutualMarkData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90, 96}, new String[]{"uint64_frd_uin", "uint32_result", "uint32_is_gray_for_chat_move", "mutualmark_info", "wear_id"}, new Object[]{0L, 0, 0, null, 0L}, Oidb_0xd6b$MutualMarkData.class);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_gray_for_chat_move = PBField.initUInt32(0);
    public final PBRepeatMessageField<mutualmark$MutualMark> mutualmark_info = PBField.initRepeatMessage(mutualmark$MutualMark.class);
    public final PBRepeatField<Long> wear_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
