package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$LoginInfo extends MessageMicro<oidb_0x8dd$LoginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_login_day", "uint32_login_date"}, new Object[]{0, 0}, oidb_0x8dd$LoginInfo.class);
    public final PBUInt32Field uint32_login_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_date = PBField.initUInt32(0);
}
