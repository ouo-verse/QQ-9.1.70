package tencent.im.oidb.cmd0xd6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd6b$RspBody extends MessageMicro<Oidb_0xd6b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 90, 96}, new String[]{"cmd_version", "rpt_msg_mutualmark_data", "rpt_uint64_unfinished_uins"}, new Object[]{"", null, 0L}, Oidb_0xd6b$RspBody.class);
    public final PBStringField cmd_version = PBField.initString("");
    public final PBRepeatMessageField<Oidb_0xd6b$MutualMarkData> rpt_msg_mutualmark_data = PBField.initRepeatMessage(Oidb_0xd6b$MutualMarkData.class);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
