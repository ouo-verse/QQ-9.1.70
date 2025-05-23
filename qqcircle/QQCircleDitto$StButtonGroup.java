package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StButtonGroup extends MessageMicro<QQCircleDitto$StButtonGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"leftMargin", "rightMargin", "margin", "buttons"}, new Object[]{0, 0, 0, null}, QQCircleDitto$StButtonGroup.class);
    public final PBUInt32Field leftMargin = PBField.initUInt32(0);
    public final PBUInt32Field rightMargin = PBField.initUInt32(0);
    public final PBUInt32Field margin = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleDitto$StButton> buttons = PBField.initRepeatMessage(QQCircleDitto$StButton.class);
}
