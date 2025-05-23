package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x2c$ResetAdmin extends MessageMicro<bin_0x2c$ResetAdmin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"memberUid", "uinFlag"}, new Object[]{0L, 0L}, bin_0x2c$ResetAdmin.class);
    public final PBUInt64Field memberUid = PBField.initUInt64(0);
    public final PBUInt64Field uinFlag = PBField.initUInt64(0);
}
