package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterStyle$BubbleContent extends MessageMicro<QQCircleCounterStyle$BubbleContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"text", "color", "bold"}, new Object[]{"", "", Boolean.FALSE}, QQCircleCounterStyle$BubbleContent.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBBoolField bold = PBField.initBool(false);
}
