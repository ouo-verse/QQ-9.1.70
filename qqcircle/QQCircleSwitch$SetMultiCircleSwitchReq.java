package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$SetMultiCircleSwitchReq extends MessageMicro<QQCircleSwitch$SetMultiCircleSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sws"}, new Object[]{null}, QQCircleSwitch$SetMultiCircleSwitchReq.class);
    public final PBRepeatMessageField<QQCircleSwitch$StSwitch> sws = PBField.initRepeatMessage(QQCircleSwitch$StSwitch.class);
}
