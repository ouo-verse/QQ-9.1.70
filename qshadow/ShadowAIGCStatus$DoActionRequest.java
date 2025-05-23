package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCStatus$DoActionRequest extends MessageMicro<ShadowAIGCStatus$DoActionRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"busi_id", "action"}, new Object[]{"", 0}, ShadowAIGCStatus$DoActionRequest.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBEnumField action = PBField.initEnum(0);
}
