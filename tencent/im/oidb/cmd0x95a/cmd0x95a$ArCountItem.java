package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x95a$ArCountItem extends MessageMicro<cmd0x95a$ArCountItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_count_type", "uint32_count_value", "str_count_name"}, new Object[]{0, 0, ""}, cmd0x95a$ArCountItem.class);
    public final PBUInt32Field uint32_count_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count_value = PBField.initUInt32(0);
    public final PBStringField str_count_name = PBField.initString("");
}
