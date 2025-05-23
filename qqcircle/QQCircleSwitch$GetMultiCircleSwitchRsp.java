package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$GetMultiCircleSwitchRsp extends MessageMicro<QQCircleSwitch$GetMultiCircleSwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sws"}, new Object[]{null}, QQCircleSwitch$GetMultiCircleSwitchRsp.class);
    public final PBRepeatMessageField<QQCircleSwitch$StSwitch> sws = PBField.initRepeatMessage(QQCircleSwitch$StSwitch.class);
}
