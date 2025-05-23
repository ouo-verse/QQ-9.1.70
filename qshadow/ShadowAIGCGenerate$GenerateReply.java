package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCGenerate$GenerateReply extends MessageMicro<ShadowAIGCGenerate$GenerateReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extra", "medias"}, new Object[]{"", null}, ShadowAIGCGenerate$GenerateReply.class);
    public final PBStringField extra = PBField.initString("");
    public final PBRepeatMessageField<ShadowAIGCGenerate$Media> medias = PBField.initRepeatMessage(ShadowAIGCGenerate$Media.class);
}
