package tencent.im.oidb.cmd0x971;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x971$ReqBody extends MessageMicro<oidb_0x971$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rule_id"}, new Object[]{0}, oidb_0x971$ReqBody.class);
    public final PBRepeatField<Integer> rule_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
