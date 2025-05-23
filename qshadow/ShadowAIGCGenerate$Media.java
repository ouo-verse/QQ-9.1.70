package qshadow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCGenerate$Media extends MessageMicro<ShadowAIGCGenerate$Media> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"type", "byte_data", "string_data", "scene", "extra"}, new Object[]{0, ByteStringMicro.EMPTY, "", 0, ""}, ShadowAIGCGenerate$Media.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBytesField byte_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_data = PBField.initString("");
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBStringField extra = PBField.initString("");
}
