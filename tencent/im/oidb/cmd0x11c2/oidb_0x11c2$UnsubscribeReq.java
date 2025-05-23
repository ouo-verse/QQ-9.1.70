package tencent.im.oidb.cmd0x11c2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x11c2$UnsubscribeReq extends MessageMicro<oidb_0x11c2$UnsubscribeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"subscription_id", "guild_id"}, new Object[]{"", 0L}, oidb_0x11c2$UnsubscribeReq.class);
    public final PBStringField subscription_id = PBField.initString("");
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
}
