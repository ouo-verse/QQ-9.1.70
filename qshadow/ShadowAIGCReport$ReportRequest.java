package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCReport$ReportRequest extends MessageMicro<ShadowAIGCReport$ReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"busi_id", "type", "items"}, new Object[]{"", 0, null}, ShadowAIGCReport$ReportRequest.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBRepeatMessageField<ShadowAIGCReport$ReportItem> items = PBField.initRepeatMessage(ShadowAIGCReport$ReportItem.class);
}
