package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$QueryPhotoListReq extends MessageMicro<QZonePhotoDegrade$QueryPhotoListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"status", "time_period", "count", "cookie"}, new Object[]{0, null, 0, ""}, QZonePhotoDegrade$QueryPhotoListReq.class);
    public final PBEnumField status = PBField.initEnum(0);
    public QZonePhotoDegrade$TimePeriod time_period = new QZonePhotoDegrade$TimePeriod();
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField cookie = PBField.initString("");
}
