package qqcircle;

import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$Categorys extends MessageMicro<QQCircleCounter$Categorys> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"unrealCategory", IVideoFilterTools.CATEGORYS}, new Object[]{0, 0}, QQCircleCounter$Categorys.class);
    public final PBEnumField unrealCategory = PBField.initEnum(0);
    public final PBRepeatField<Integer> categorys = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
