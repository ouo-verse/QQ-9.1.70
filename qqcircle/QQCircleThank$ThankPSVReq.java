package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleThank$ThankPSVReq extends MessageMicro<QQCircleThank$ThankPSVReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"op_type", "feed_id"}, new Object[]{0, ""}, QQCircleThank$ThankPSVReq.class);
    public final PBEnumField op_type = PBField.initEnum(0);
    public final PBStringField feed_id = PBField.initString("");
}
