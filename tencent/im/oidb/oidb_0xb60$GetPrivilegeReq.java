package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xb60$GetPrivilegeReq extends MessageMicro<oidb_0xb60$GetPrivilegeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "app_type"}, new Object[]{0, 3}, oidb_0xb60$GetPrivilegeReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(3);
}
