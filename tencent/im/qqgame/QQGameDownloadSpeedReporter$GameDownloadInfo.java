package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameDownloadSpeedReporter$GameDownloadInfo extends MessageMicro<QQGameDownloadSpeedReporter$GameDownloadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"appid", "total_downloaded", "wifi_downloaded", "mobile_downloaded", "p2p_downloaded", "duration", "user_current_time"}, new Object[]{"", 0L, 0L, 0L, 0L, 0L, 0L}, QQGameDownloadSpeedReporter$GameDownloadInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt64Field total_downloaded = PBField.initInt64(0);
    public final PBInt64Field wifi_downloaded = PBField.initInt64(0);
    public final PBInt64Field mobile_downloaded = PBField.initInt64(0);
    public final PBInt64Field p2p_downloaded = PBField.initInt64(0);
    public final PBInt64Field duration = PBField.initInt64(0);
    public final PBInt64Field user_current_time = PBField.initInt64(0);
}
