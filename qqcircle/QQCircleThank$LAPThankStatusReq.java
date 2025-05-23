package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleThank$LAPThankStatusReq extends MessageMicro<QQCircleThank$LAPThankStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feed_id", "user_id", "action_type"}, new Object[]{"", "", 1}, QQCircleThank$LAPThankStatusReq.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBRepeatField<String> user_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField action_type = PBField.initEnum(1);
}
