package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetMyPendantByIdReq extends MessageMicro<QQCirclePendant$GetMyPendantByIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"pendantKey", "isPop"}, new Object[]{"", Boolean.FALSE}, QQCirclePendant$GetMyPendantByIdReq.class);
    public final PBStringField pendantKey = PBField.initString("");
    public final PBBoolField isPop = PBField.initBool(false);
}
