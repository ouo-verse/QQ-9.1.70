package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ResourceInfo extends MessageMicro<QzoneActivityPB$ResourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 82, 90}, new String[]{"mode", "text", "bg_light", "bg_dark", "text_color_light", "text_color_dark", "jump_url", "display_cfg", "resource_name"}, new Object[]{"", "", "", "", "", "", "", null, ""}, QzoneActivityPB$ResourceInfo.class);
    public final PBStringField mode = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField bg_light = PBField.initString("");
    public final PBStringField bg_dark = PBField.initString("");
    public final PBStringField text_color_light = PBField.initString("");
    public final PBStringField text_color_dark = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public QzoneActivityPB$DisplayCfg display_cfg = new QzoneActivityPB$DisplayCfg();
    public final PBStringField resource_name = PBField.initString("");
}
