package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Smartptt$Slot extends MessageMicro<Smartptt$Slot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_slot_name", "str_slot_value", "str_confirm_status"}, new Object[]{"", "", ""}, Smartptt$Slot.class);
    public final PBStringField str_slot_name = PBField.initString("");
    public final PBStringField str_slot_value = PBField.initString("");
    public final PBStringField str_confirm_status = PBField.initString("");
}
