package tencent.im.oidb.cmd0xb14;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb14$ReqBody extends MessageMicro<oidb_0xb14$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"type", "group_id", "uins"}, new Object[]{0, 0L, 0L}, oidb_0xb14$ReqBody.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
