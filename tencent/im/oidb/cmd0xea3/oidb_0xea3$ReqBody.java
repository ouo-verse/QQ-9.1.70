package tencent.im.oidb.cmd0xea3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xea3$ReqBody extends MessageMicro<oidb_0xea3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "msg_seq"}, new Object[]{0L, 0L}, oidb_0xea3$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBRepeatField<Long> msg_seq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
