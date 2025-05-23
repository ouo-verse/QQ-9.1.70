package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb69$AppInfo extends MessageMicro<oidb_0xb69$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"appid", "app_name", "switch_on", "order", "app_permission"}, new Object[]{0L, "", 0, 0, null}, oidb_0xb69$AppInfo.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt32Field switch_on = PBField.initUInt32(0);
    public final PBUInt32Field order = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xb69$AppPermission> app_permission = PBField.initRepeatMessage(oidb_0xb69$AppPermission.class);
}
