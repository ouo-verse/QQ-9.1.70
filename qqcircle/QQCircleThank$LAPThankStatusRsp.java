package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleThank$LAPThankStatusRsp extends MessageMicro<QQCircleThank$LAPThankStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{null}, QQCircleThank$LAPThankStatusRsp.class);
    public final PBRepeatMessageField<QQCircleThank$ThankStatusRes> result = PBField.initRepeatMessage(QQCircleThank$ThankStatusRes.class);
}
