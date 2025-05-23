package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCGenerate$GenerateRequest extends MessageMicro<ShadowAIGCGenerate$GenerateRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"busi_id", "extra", "medias", "func_id"}, new Object[]{"", "", null, ""}, ShadowAIGCGenerate$GenerateRequest.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBStringField extra = PBField.initString("");
    public final PBRepeatMessageField<ShadowAIGCGenerate$Media> medias = PBField.initRepeatMessage(ShadowAIGCGenerate$Media.class);
    public final PBStringField func_id = PBField.initString("");
}
