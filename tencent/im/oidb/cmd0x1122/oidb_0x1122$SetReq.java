package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1122$SetReq extends MessageMicro<oidb_0x1122$SetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_perms", "domain"}, new Object[]{null, 0}, oidb_0x1122$SetReq.class);
    public final PBRepeatMessageField<oidb_0x1122$UserPermission> user_perms = PBField.initRepeatMessage(oidb_0x1122$UserPermission.class);
    public final PBUInt32Field domain = PBField.initUInt32(0);
}
