package qshadow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class AIFacePtaData$ZPlanV2Request extends MessageMicro<AIFacePtaData$ZPlanV2Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"input_image", "gender", "model_ver", "sequence_index", "render_engine"}, new Object[]{ByteStringMicro.EMPTY, "", "", 0, 0}, AIFacePtaData$ZPlanV2Request.class);
    public final PBBytesField input_image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField gender = PBField.initString("");
    public final PBStringField model_ver = PBField.initString("");
    public final PBInt32Field sequence_index = PBField.initInt32(0);
    public final PBEnumField render_engine = PBField.initEnum(0);
}
