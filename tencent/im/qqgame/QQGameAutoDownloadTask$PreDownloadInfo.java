package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameAutoDownloadTask$PreDownloadInfo extends MessageMicro<QQGameAutoDownloadTask$PreDownloadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 96}, new String[]{"appid", "icon_url", "url", "package_name", "via", "app_name", "version_code", "download_start_time", "download_end_time", "apk_channel", "appointment_time", "king_card_auth"}, new Object[]{"", "", "", "", "", "", "", 0L, 0L, "", 0L, 0}, QQGameAutoDownloadTask$PreDownloadInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField package_name = PBField.initString("");
    public final PBStringField via = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField version_code = PBField.initString("");
    public final PBInt64Field download_start_time = PBField.initInt64(0);
    public final PBInt64Field download_end_time = PBField.initInt64(0);
    public final PBStringField apk_channel = PBField.initString("");
    public final PBInt64Field appointment_time = PBField.initInt64(0);
    public final PBInt32Field king_card_auth = PBField.initInt32(0);
}
