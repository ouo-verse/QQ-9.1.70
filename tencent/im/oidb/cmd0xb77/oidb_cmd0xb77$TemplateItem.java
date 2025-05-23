package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$TemplateItem extends MessageMicro<oidb_cmd0xb77$TemplateItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"key", "type", "value"}, new Object[]{"", 0, ""}, oidb_cmd0xb77$TemplateItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField value = PBField.initString("");
}
