package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$QueryPhotoListRsp extends MessageMicro<QZonePhotoDegrade$QueryPhotoListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"photos", "total", "cookie", "is_end"}, new Object[]{null, 0, "", Boolean.FALSE}, QZonePhotoDegrade$QueryPhotoListRsp.class);
    public final PBRepeatMessageField<QZonePhotoDegrade$PhotoInfo> photos = PBField.initRepeatMessage(QZonePhotoDegrade$PhotoInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBStringField cookie = PBField.initString("");
    public final PBBoolField is_end = PBField.initBool(false);
}
