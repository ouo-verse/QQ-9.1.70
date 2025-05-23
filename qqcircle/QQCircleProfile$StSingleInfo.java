package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StSingleInfo extends MessageMicro<QQCircleProfile$StSingleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "value"}, new Object[]{0, ""}, QQCircleProfile$StSingleInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField value = PBField.initString("");
}
