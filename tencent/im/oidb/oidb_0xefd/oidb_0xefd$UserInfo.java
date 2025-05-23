package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xefd$UserInfo extends MessageMicro<oidb_0xefd$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"app_id", "open_id", "wns_id", "is_majia_number", "user_type"}, new Object[]{"", "", "", 0, 0}, oidb_0xefd$UserInfo.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField wns_id = PBField.initString("");
    public final PBUInt32Field is_majia_number = PBField.initUInt32(0);
    public final PBUInt32Field user_type = PBField.initUInt32(0);
}
