package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StDividingLine extends MessageMicro<QQCircleDitto$StDividingLine> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"summary", "buttonInfo"}, new Object[]{"", null}, QQCircleDitto$StDividingLine.class);
    public final PBStringField summary = PBField.initString("");
    public QQCircleDitto$StButton buttonInfo = new QQCircleDitto$StButton();
}
