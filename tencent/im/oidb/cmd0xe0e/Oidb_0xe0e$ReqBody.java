package tencent.im.oidb.cmd0xe0e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xe0e$ReqBody extends MessageMicro<Oidb_0xe0e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_id", "disabled", "disabled_appids"}, new Object[]{0L, 0, 0L}, Oidb_0xe0e$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBRepeatField<Long> disabled_appids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
