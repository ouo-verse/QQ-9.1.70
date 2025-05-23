package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StBatchDoUrgeReq extends MessageMicro<QQCircleLightinteract$StBatchDoUrgeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userIDs", "withoutRelationVerification"}, new Object[]{"", Boolean.FALSE}, QQCircleLightinteract$StBatchDoUrgeReq.class);
    public final PBRepeatField<String> userIDs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField withoutRelationVerification = PBField.initBool(false);
}
