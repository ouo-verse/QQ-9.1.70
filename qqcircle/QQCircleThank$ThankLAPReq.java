package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleThank$ThankLAPReq extends MessageMicro<QQCircleThank$ThankLAPReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"feed_id", "user_id", "action_type", "op_type"}, new Object[]{"", "", 1, 0}, QQCircleThank$ThankLAPReq.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField user_id = PBField.initString("");
    public final PBEnumField action_type = PBField.initEnum(1);
    public final PBEnumField op_type = PBField.initEnum(0);
}
