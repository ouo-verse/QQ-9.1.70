package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StGetUrgeStatusReq extends MessageMicro<QQCircleLightinteract$StGetUrgeStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userID", "withoutRelationVerification"}, new Object[]{"", Boolean.FALSE}, QQCircleLightinteract$StGetUrgeStatusReq.class);
    public final PBStringField userID = PBField.initString("");
    public final PBBoolField withoutRelationVerification = PBField.initBool(false);
}
