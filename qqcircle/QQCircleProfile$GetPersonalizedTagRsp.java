package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$GetPersonalizedTagRsp extends MessageMicro<QQCircleProfile$GetPersonalizedTagRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"selected", "all"}, new Object[]{null, null}, QQCircleProfile$GetPersonalizedTagRsp.class);
    public final PBRepeatMessageField<QQCircleProfile$ContentFirstClass> selected = PBField.initRepeatMessage(QQCircleProfile$ContentFirstClass.class);
    public final PBRepeatMessageField<QQCircleProfile$ContentFirstClass> all = PBField.initRepeatMessage(QQCircleProfile$ContentFirstClass.class);
}
