package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x1122$UserPermission extends MessageMicro<oidb_0x1122$UserPermission> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "perm"}, new Object[]{0L, null}, oidb_0x1122$UserPermission.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public oidb_0x1122$Permission perm = new oidb_0x1122$Permission();
}
