package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleThank$ThankStatusRes extends MessageMicro<QQCircleThank$ThankStatusRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_id", "is_thanked"}, new Object[]{"", Boolean.FALSE}, QQCircleThank$ThankStatusRes.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBBoolField is_thanked = PBField.initBool(false);
}
