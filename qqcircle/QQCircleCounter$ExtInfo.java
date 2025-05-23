package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$ExtInfo extends MessageMicro<QQCircleCounter$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, QQCircleCounter$ExtInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
