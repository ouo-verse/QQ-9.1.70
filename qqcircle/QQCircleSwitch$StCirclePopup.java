package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSwitch$StCirclePopup extends MessageMicro<QQCircleSwitch$StCirclePopup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"key", "type", "title", "subtitle", "content"}, new Object[]{"", 0, "", "", ""}, QQCircleSwitch$StCirclePopup.class);
    public final PBStringField key = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
