package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$TextDetection extends MessageMicro<cmd0xe07$TextDetection> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"detectedText", "confidence", "polygon", "advancedInfo"}, new Object[]{"", 0, null, ""}, cmd0xe07$TextDetection.class);
    public final PBStringField detectedText = PBField.initString("");
    public final PBUInt32Field confidence = PBField.initUInt32(0);
    public cmd0xe07$Polygon polygon = new cmd0xe07$Polygon();
    public final PBStringField advancedInfo = PBField.initString("");
}
