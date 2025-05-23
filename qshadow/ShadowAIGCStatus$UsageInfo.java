package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCStatus$UsageInfo extends MessageMicro<ShadowAIGCStatus$UsageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"type", "available", "total"}, new Object[]{0, 0, 0}, ShadowAIGCStatus$UsageInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt32Field available = PBField.initInt32(0);
    public final PBInt32Field total = PBField.initInt32(0);
}
