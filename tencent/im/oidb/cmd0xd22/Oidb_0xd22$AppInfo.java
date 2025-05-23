package tencent.im.oidb.cmd0xd22;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd22$AppInfo extends MessageMicro<Oidb_0xd22$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "organization_id"}, new Object[]{0, 0}, Oidb_0xd22$AppInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field organization_id = PBField.initUInt32(0);
}
