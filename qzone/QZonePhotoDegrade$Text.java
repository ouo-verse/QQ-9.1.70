package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$Text extends MessageMicro<QZonePhotoDegrade$Text> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg", "url", "type"}, new Object[]{"", "", 0}, QZonePhotoDegrade$Text.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f430343msg = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
}
