package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterStyle$StyleBubble extends MessageMicro<QQCircleCounterStyle$StyleBubble> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"styleType", "contents", "icons", "id", "expireTime"}, new Object[]{0, null, null, "", 0L}, QQCircleCounterStyle$StyleBubble.class);
    public final PBEnumField styleType = PBField.initEnum(0);
    public final PBRepeatMessageField<QQCircleCounterStyle$BubbleContent> contents = PBField.initRepeatMessage(QQCircleCounterStyle$BubbleContent.class);
    public final PBRepeatMessageField<QQCircleCounterStyle$StyleIcon> icons = PBField.initRepeatMessage(QQCircleCounterStyle$StyleIcon.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429298id = PBField.initString("");
    public final PBInt64Field expireTime = PBField.initInt64(0);
}
