package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$UserCheckinInfo extends MessageMicro<QZIntimateCheckIn$UserCheckinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{QCircleAlphaUserReporter.KEY_USER, "days", "checkin_data"}, new Object[]{null, 0, ""}, QZIntimateCheckIn$UserCheckinInfo.class);
    public QZoneBaseMeta$StUser user = new QZoneBaseMeta$StUser();
    public final PBUInt32Field days = PBField.initUInt32(0);
    public final PBStringField checkin_data = PBField.initString("");
}
