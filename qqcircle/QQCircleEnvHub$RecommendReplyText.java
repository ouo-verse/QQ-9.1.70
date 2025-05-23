package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$RecommendReplyText extends MessageMicro<QQCircleEnvHub$RecommendReplyText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"replyTexts"}, new Object[]{""}, QQCircleEnvHub$RecommendReplyText.class);
    public final PBRepeatField<String> replyTexts = PBField.initRepeat(PBStringField.__repeatHelper__);
}
