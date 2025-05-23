package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDurationReport$ResetDurationReq extends MessageMicro<QQCircleDurationReport$ResetDurationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "dialog_id"}, new Object[]{0L, ""}, QQCircleDurationReport$ResetDurationReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField dialog_id = PBField.initString("");
}
