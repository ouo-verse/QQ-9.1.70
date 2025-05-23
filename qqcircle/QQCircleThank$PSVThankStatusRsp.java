package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleThank$PSVThankStatusRsp extends MessageMicro<QQCircleThank$PSVThankStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"status_results"}, new Object[]{null}, QQCircleThank$PSVThankStatusRsp.class);
    public final PBRepeatMessageField<QQCircleThank$PSVThankStatus> status_results = PBField.initRepeatMessage(QQCircleThank$PSVThankStatus.class);
}
