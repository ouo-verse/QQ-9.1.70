package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCGenerate$QueryTaskRequest extends MessageMicro<ShadowAIGCGenerate$QueryTaskRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"busi_id", "func_id", "task_id"}, new Object[]{"", "", ""}, ShadowAIGCGenerate$QueryTaskRequest.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBStringField func_id = PBField.initString("");
    public final PBStringField task_id = PBField.initString("");
}
