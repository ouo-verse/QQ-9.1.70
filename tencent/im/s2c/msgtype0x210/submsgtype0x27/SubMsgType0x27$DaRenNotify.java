package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$DaRenNotify extends MessageMicro<SubMsgType0x27$DaRenNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_uin", "uint32_login_days", "uint32_days", "uint32_is_yestoday_login", "uint32_is_today_login"}, new Object[]{0L, 0, 0, 0, 0}, SubMsgType0x27$DaRenNotify.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_login_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_yestoday_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_today_login = PBField.initUInt32(0);
}
