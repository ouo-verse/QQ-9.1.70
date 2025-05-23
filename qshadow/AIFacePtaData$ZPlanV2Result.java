package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class AIFacePtaData$ZPlanV2Result extends MessageMicro<AIFacePtaData$ZPlanV2Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"face_styles", "material_infos"}, new Object[]{null, null}, AIFacePtaData$ZPlanV2Result.class);
    public final PBRepeatMessageField<AIFacePtaData$ZplanFaceStyle> face_styles = PBField.initRepeatMessage(AIFacePtaData$ZplanFaceStyle.class);
    public final PBRepeatMessageField<AIFacePtaData$MaterialInfoTimiV2> material_infos = PBField.initRepeatMessage(AIFacePtaData$MaterialInfoTimiV2.class);
}
