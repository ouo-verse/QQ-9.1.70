package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleThank$PSVThankStatusReq extends MessageMicro<QQCircleThank$PSVThankStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_ids"}, new Object[]{""}, QQCircleThank$PSVThankStatusReq.class);
    public final PBRepeatField<String> feed_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
