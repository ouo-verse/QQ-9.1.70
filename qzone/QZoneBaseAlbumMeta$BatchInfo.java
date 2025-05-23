package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseAlbumMeta$BatchInfo extends MessageMicro<QZoneBaseAlbumMeta$BatchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{JobDbManager.COL_UP_BATCH_ID, "desc", "show_time", QCircleAlphaUserReporter.KEY_USER, "lbs", "medias", "upload_number"}, new Object[]{0L, "", "", null, null, null, 0L}, QZoneBaseAlbumMeta$BatchInfo.class);
    public final PBUInt64Field batch_id = PBField.initUInt64(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField show_time = PBField.initString("");
    public QZoneBaseMeta$StUser user = new QZoneBaseMeta$StUser();
    public QZoneBaseMeta$StLBS lbs = new QZoneBaseMeta$StLBS();
    public final PBRepeatMessageField<QZoneBaseMeta$StMedia> medias = PBField.initRepeatMessage(QZoneBaseMeta$StMedia.class);
    public final PBUInt64Field upload_number = PBField.initUInt64(0);
}
