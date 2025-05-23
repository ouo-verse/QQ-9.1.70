package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$CommentEffectInfo extends MessageMicro<QQCircleEnvHub$CommentEffectInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"activityInfo", "inputToolsBarConfigInfo"}, new Object[]{null, null}, QQCircleEnvHub$CommentEffectInfo.class);
    public final PBRepeatMessageField<QQCircleEnvHub$CommentActivityInfo> activityInfo = PBField.initRepeatMessage(QQCircleEnvHub$CommentActivityInfo.class);
    public QQCircleEnvHub$InputToolsBarConfigInfo inputToolsBarConfigInfo = new QQCircleEnvHub$InputToolsBarConfigInfo();
}
