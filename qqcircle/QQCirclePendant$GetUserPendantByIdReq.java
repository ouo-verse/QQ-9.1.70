package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetUserPendantByIdReq extends MessageMicro<QQCirclePendant$GetUserPendantByIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "pendantKey"}, new Object[]{0L, ""}, QQCirclePendant$GetUserPendantByIdReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField pendantKey = PBField.initString("");
}
