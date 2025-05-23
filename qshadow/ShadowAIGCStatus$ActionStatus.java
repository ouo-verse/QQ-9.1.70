package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCStatus$ActionStatus extends MessageMicro<ShadowAIGCStatus$ActionStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "available"}, new Object[]{0, 0}, ShadowAIGCStatus$ActionStatus.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt32Field available = PBField.initInt32(0);
}
