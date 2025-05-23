package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$NegativeNotifyReq extends MessageMicro<QZonePhotoDegrade$NegativeNotifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene", "plat"}, new Object[]{0, 0}, QZonePhotoDegrade$NegativeNotifyReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBEnumField plat = PBField.initEnum(0);
}
