package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePhotocatemetadata$PhotoTagInfo extends MessageMicro<QQCirclePhotocatemetadata$PhotoTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 29}, new String[]{"classifyType", "classifyName", "classifyConfidence"}, new Object[]{"", "", Float.valueOf(0.0f)}, QQCirclePhotocatemetadata$PhotoTagInfo.class);
    public final PBStringField classifyType = PBField.initString("");
    public final PBStringField classifyName = PBField.initString("");
    public final PBFloatField classifyConfidence = PBField.initFloat(0.0f);
}
