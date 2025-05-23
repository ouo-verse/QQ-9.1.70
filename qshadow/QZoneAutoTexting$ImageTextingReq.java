package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneAutoTexting$ImageTextingReq extends MessageMicro<QZoneAutoTexting$ImageTextingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"imageUrls", "text", "isStream"}, new Object[]{"", "", Boolean.FALSE}, QZoneAutoTexting$ImageTextingReq.class);
    public final PBRepeatField<String> imageUrls = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField text = PBField.initString("");
    public final PBBoolField isStream = PBField.initBool(false);
}
