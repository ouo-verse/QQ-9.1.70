package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$BatchGetPenguinProfileRsp extends MessageMicro<QQCircleProfile$BatchGetPenguinProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"penguinProfiles"}, new Object[]{null}, QQCircleProfile$BatchGetPenguinProfileRsp.class);
    public final PBRepeatMessageField<QQCircleProfile$PenguinProfile> penguinProfiles = PBField.initRepeatMessage(QQCircleProfile$PenguinProfile.class);
}
