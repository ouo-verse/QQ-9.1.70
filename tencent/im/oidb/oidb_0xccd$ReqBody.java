package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xccd$ReqBody extends MessageMicro<oidb_0xccd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int64_uin", "uint32_appids", "platform"}, new Object[]{0L, 0, 0}, oidb_0xccd$ReqBody.class);
    public final PBUInt64Field int64_uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> uint32_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field platform = PBField.initUInt32(0);
}
