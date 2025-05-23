package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StDoUrgeReq extends MessageMicro<QQCircleLightinteract$StDoUrgeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"userID", "withoutRelationVerification", "urgePosition"}, new Object[]{"", Boolean.FALSE, 0}, QQCircleLightinteract$StDoUrgeReq.class);
    public final PBStringField userID = PBField.initString("");
    public final PBBoolField withoutRelationVerification = PBField.initBool(false);
    public final PBInt32Field urgePosition = PBField.initInt32(0);
}
