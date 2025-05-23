package tencent.im.oidb.cmd0xeb5;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb5$Label extends MessageMicro<oidb_0xeb5$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"string_name", LayoutAttrDefine.BG_Color, "text_color"}, new Object[]{"", "", ""}, oidb_0xeb5$Label.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBStringField bg_color = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
}
