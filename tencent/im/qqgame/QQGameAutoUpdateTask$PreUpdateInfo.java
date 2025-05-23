package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameAutoUpdateTask$PreUpdateInfo extends MessageMicro<QQGameAutoUpdateTask$PreUpdateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{"appid", "apk_url", "version_code", "pkg_name", "app_name", "apk_channel", "icon"}, new Object[]{"", "", 0, "", "", "", ""}, QQGameAutoUpdateTask$PreUpdateInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField apk_url = PBField.initString("");
    public final PBInt32Field version_code = PBField.initInt32(0);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField apk_channel = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
