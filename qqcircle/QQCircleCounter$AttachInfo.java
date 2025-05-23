package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$AttachInfo extends MessageMicro<QQCircleCounter$AttachInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"privateMsgList", "sence"}, new Object[]{null, 0}, QQCircleCounter$AttachInfo.class);
    public final PBRepeatMessageField<QQCircleCounter$PrivateMessage> privateMsgList = PBField.initRepeatMessage(QQCircleCounter$PrivateMessage.class);
    public final PBUInt32Field sence = PBField.initUInt32(0);
}
