package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$Button extends MessageMicro<QZonePhotoDegrade$Button> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg", "url"}, new Object[]{"", ""}, QZonePhotoDegrade$Button.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f430341msg = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
