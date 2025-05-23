package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xec4$Praise extends MessageMicro<oidb_0xec4$Praise> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint64_time", "str_from_nick"}, new Object[]{0L, 0L, 0L, ""}, oidb_0xec4$Praise.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBStringField str_from_nick = PBField.initString("");
}
