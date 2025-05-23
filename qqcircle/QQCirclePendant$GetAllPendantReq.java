package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetAllPendantReq extends MessageMicro<QQCirclePendant$GetAllPendantReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"count", "attachInfo"}, new Object[]{0, ""}, QQCirclePendant$GetAllPendantReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField attachInfo = PBField.initString("");
}
