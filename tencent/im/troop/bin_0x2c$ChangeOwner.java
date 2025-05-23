package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x2c$ChangeOwner extends MessageMicro<bin_0x2c$ChangeOwner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"oldOwnerUid", "newOwnerUid"}, new Object[]{0L, 0L}, bin_0x2c$ChangeOwner.class);
    public final PBUInt64Field oldOwnerUid = PBField.initUInt64(0);
    public final PBUInt64Field newOwnerUid = PBField.initUInt64(0);
}
