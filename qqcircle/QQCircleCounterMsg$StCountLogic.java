package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$StCountLogic extends MessageMicro<QQCircleCounterMsg$StCountLogic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds"}, new Object[]{null}, QQCircleCounterMsg$StCountLogic.class);
    public final PBRepeatMessageField<QQCircleCounterMsg$StCountLogicFeed> feeds = PBField.initRepeatMessage(QQCircleCounterMsg$StCountLogicFeed.class);
}
