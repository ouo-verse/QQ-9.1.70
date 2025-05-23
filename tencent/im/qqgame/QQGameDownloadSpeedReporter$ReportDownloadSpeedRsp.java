package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameDownloadSpeedReporter$ReportDownloadSpeedRsp extends MessageMicro<QQGameDownloadSpeedReporter$ReportDownloadSpeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{48}, new String[]{"next_duration"}, new Object[]{0L}, QQGameDownloadSpeedReporter$ReportDownloadSpeedRsp.class);
    public final PBInt64Field next_duration = PBField.initInt64(0);
}
