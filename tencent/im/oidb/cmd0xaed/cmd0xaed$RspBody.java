package tencent.im.oidb.cmd0xaed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xaed$RspBody extends MessageMicro<cmd0xaed$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_succ_qim_uins"}, new Object[]{0L}, cmd0xaed$RspBody.class);
    public final PBRepeatField<Long> rpt_uint64_succ_qim_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
