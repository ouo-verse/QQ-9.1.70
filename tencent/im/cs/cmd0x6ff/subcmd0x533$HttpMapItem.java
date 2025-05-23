package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$HttpMapItem extends MessageMicro<subcmd0x533$HttpMapItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"string_key", "string_value", "rpt_string_key_list"}, new Object[]{"", "", ""}, subcmd0x533$HttpMapItem.class);
    public final PBStringField string_key = PBField.initString("");
    public final PBStringField string_value = PBField.initString("");
    public final PBRepeatField<String> rpt_string_key_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
