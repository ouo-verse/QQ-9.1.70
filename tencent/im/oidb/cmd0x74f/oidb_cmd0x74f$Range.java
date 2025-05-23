package tencent.im.oidb.cmd0x74f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x74f$Range extends MessageMicro<oidb_cmd0x74f$Range> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"string_name", "uint32_days"}, new Object[]{"", 0L}, oidb_cmd0x74f$Range.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBUInt64Field uint32_days = PBField.initUInt64(0);
}
