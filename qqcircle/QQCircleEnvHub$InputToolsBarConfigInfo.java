package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$InputToolsBarConfigInfo extends MessageMicro<QQCircleEnvHub$InputToolsBarConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"recommendEmotionTexts", "recommendReplyText"}, new Object[]{"", null}, QQCircleEnvHub$InputToolsBarConfigInfo.class);
    public final PBRepeatField<String> recommendEmotionTexts = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<QQCircleEnvHub$RecommendReplyText> recommendReplyText = PBField.initRepeatMessage(QQCircleEnvHub$RecommendReplyText.class);
}
