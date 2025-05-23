package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseCommon$Entry extends MessageMicro<QZoneBaseCommon$Entry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"key", "value", "number_key"}, new Object[]{"", "", 0}, QZoneBaseCommon$Entry.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
    public final PBInt32Field number_key = PBField.initInt32(0);
}
