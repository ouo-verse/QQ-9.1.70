package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x406$GroupFeeMember extends MessageMicro<cmd0x406$GroupFeeMember> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uin", "uint64_paid_time", "string_nick_name"}, new Object[]{0L, 0L, ""}, cmd0x406$GroupFeeMember.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_paid_time = PBField.initUInt64(0);
    public final PBStringField string_nick_name = PBField.initString("");
}
