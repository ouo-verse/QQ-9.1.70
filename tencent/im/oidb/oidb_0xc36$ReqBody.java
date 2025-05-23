package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc36$ReqBody extends MessageMicro<oidb_0xc36$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_uins"}, new Object[]{0L}, oidb_0xc36$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
