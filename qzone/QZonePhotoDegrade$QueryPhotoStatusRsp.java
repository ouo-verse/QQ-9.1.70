package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$QueryPhotoStatusRsp extends MessageMicro<QZonePhotoDegrade$QueryPhotoStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"total", "earliest_time"}, new Object[]{0L, 0L}, QZonePhotoDegrade$QueryPhotoStatusRsp.class);
    public final PBUInt64Field total = PBField.initUInt64(0);
    public final PBUInt64Field earliest_time = PBField.initUInt64(0);
}
