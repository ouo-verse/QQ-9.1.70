package tencent.im.oidb.cmd0x934;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x934$ItemInfo extends MessageMicro<cmd0x934$ItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"title", "icon", "url", "color", "font_color", LayoutAttrDefine.BorderColor}, new Object[]{"", "", "", "", "", ""}, cmd0x934$ItemInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBStringField font_color = PBField.initString("");
    public final PBStringField border_color = PBField.initString("");
}
