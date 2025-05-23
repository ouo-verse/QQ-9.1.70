package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterStyle$StyleTabButton extends MessageMicro<QQCircleCounterStyle$StyleTabButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"icons", "ext", "id"}, new Object[]{null, "", ""}, QQCircleCounterStyle$StyleTabButton.class);
    public final PBRepeatMessageField<QQCircleCounterMsg$RedDisplayInfo> icons = PBField.initRepeatMessage(QQCircleCounterMsg$RedDisplayInfo.class);
    public final PBStringField ext = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429299id = PBField.initString("");
}
