package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$TimestampInfo extends MessageMicro<QQCircleCounter$TimestampInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"key", "value"}, new Object[]{"", 0L}, QQCircleCounter$TimestampInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBInt64Field value = PBField.initInt64(0);
}
