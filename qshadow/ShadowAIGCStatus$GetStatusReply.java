package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCStatus$GetStatusReply extends MessageMicro<ShadowAIGCStatus$GetStatusReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"actions", "button_info", "usages", "pay_info"}, new Object[]{null, null, null, null}, ShadowAIGCStatus$GetStatusReply.class);
    public final PBRepeatMessageField<ShadowAIGCStatus$ActionStatus> actions = PBField.initRepeatMessage(ShadowAIGCStatus$ActionStatus.class);
    public ShadowAIGCStatus$ButtonInfo button_info = new ShadowAIGCStatus$ButtonInfo();
    public final PBRepeatMessageField<ShadowAIGCStatus$UsageInfo> usages = PBField.initRepeatMessage(ShadowAIGCStatus$UsageInfo.class);
    public ShadowAIGCStatus$PayInfo pay_info = new ShadowAIGCStatus$PayInfo();
}
