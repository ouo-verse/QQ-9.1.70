package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$UserAuthResult extends MessageMicro<oidb_0xd55$UserAuthResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"openid", "uin", "result"}, new Object[]{"", 0L, 0}, oidb_0xd55$UserAuthResult.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field result = PBField.initInt32(0);
}
