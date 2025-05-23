package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$RspBody extends MessageMicro<TroopTips0x857$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint64_group_code", "rpt_uint64_memberuins"}, new Object[]{0L, 0L}, TroopTips0x857$RspBody.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_memberuins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
