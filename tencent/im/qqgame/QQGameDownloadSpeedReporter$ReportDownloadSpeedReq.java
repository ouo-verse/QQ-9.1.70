package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameDownloadSpeedReporter$ReportDownloadSpeedReq extends MessageMicro<QQGameDownloadSpeedReporter$ReportDownloadSpeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"game_download_info", "current_rate"}, new Object[]{null, 0L}, QQGameDownloadSpeedReporter$ReportDownloadSpeedReq.class);
    public QQGameDownloadSpeedReporter$GameDownloadInfo game_download_info = new QQGameDownloadSpeedReporter$GameDownloadInfo();
    public final PBInt64Field current_rate = PBField.initInt64(0);
}
