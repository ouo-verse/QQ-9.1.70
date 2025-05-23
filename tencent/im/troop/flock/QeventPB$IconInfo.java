package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QeventPB$IconInfo extends MessageMicro<QeventPB$IconInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"icon_url_40", "icon_url_100", "icon_url_140", "icon_url_640", "icon_url"}, new Object[]{"", "", "", "", ""}, QeventPB$IconInfo.class);
    public final PBStringField icon_url_40 = PBField.initString("");
    public final PBStringField icon_url_100 = PBField.initString("");
    public final PBStringField icon_url_140 = PBField.initString("");
    public final PBStringField icon_url_640 = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
}
