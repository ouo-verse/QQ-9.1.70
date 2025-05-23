package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$IsGrayUinReq extends MessageMicro<QZonePhotoDegrade$IsGrayUinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, QZonePhotoDegrade$IsGrayUinReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
