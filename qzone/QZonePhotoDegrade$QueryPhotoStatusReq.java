package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$QueryPhotoStatusReq extends MessageMicro<QZonePhotoDegrade$QueryPhotoStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"status", "time_period"}, new Object[]{0, null}, QZonePhotoDegrade$QueryPhotoStatusReq.class);
    public final PBEnumField status = PBField.initEnum(0);
    public QZonePhotoDegrade$TimePeriod time_period = new QZonePhotoDegrade$TimePeriod();
}
