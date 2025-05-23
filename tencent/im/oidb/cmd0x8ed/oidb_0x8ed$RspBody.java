package tencent.im.oidb.cmd0x8ed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8ed$RspBody extends MessageMicro<oidb_0x8ed$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_room_id", "uint64_judge_uin", "uint64_owner_uin", "rpt_uint64_uin"}, new Object[]{0L, 0L, 0L, 0L}, oidb_0x8ed$RspBody.class);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
