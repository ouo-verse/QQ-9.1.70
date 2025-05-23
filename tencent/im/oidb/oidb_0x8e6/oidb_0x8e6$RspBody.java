package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e6$RspBody extends MessageMicro<oidb_0x8e6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uint32_level", "uint32_can_vote_free_user_count", "uint32_can_vote_free_count", "uint32_remain_total", "int32_consume_total", "rpt_vote_result"}, new Object[]{0, 0, 0, 0, 0, null}, oidb_0x8e6$RspBody.class);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_vote_free_user_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_vote_free_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remain_total = PBField.initUInt32(0);
    public final PBInt32Field int32_consume_total = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0x8e6$VoteResult> rpt_vote_result = PBField.initRepeatMessage(oidb_0x8e6$VoteResult.class);
}
