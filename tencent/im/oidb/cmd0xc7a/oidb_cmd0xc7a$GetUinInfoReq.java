package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc7a$GetUinInfoReq extends MessageMicro<oidb_cmd0xc7a$GetUinInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uins"}, new Object[]{0L}, oidb_cmd0xc7a$GetUinInfoReq.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
