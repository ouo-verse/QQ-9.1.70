package tencent.im.oidb.cmd0x62c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x62c$ReqBody extends MessageMicro<oidb_cmd0x62c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{"uint64_tinyid"}, new Object[]{0L}, oidb_cmd0x62c$ReqBody.class);
    public final PBRepeatField<Long> uint64_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
