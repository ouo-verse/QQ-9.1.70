package tencent.im.oidb.cmd0x72d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x72d$ReqBody extends MessageMicro<cmd0x72d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_groupcode"}, new Object[]{0L}, cmd0x72d$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_groupcode = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
