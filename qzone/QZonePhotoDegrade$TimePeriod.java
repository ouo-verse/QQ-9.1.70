package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$TimePeriod extends MessageMicro<QZonePhotoDegrade$TimePeriod> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"begin", "end"}, new Object[]{0L, 0L}, QZonePhotoDegrade$TimePeriod.class);
    public final PBUInt64Field begin = PBField.initUInt64(0);
    public final PBUInt64Field end = PBField.initUInt64(0);
}
