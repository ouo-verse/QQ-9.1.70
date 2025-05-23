package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$SimpleRedPointInfo extends MessageMicro<QQCircleCounter$SimpleRedPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"type", WidgetCacheConstellationData.NUM, "infos"}, new Object[]{0, 0L, null}, QQCircleCounter$SimpleRedPointInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt64Field num = PBField.initInt64(0);
    public final PBRepeatMessageField<QQCircleCounter$FeedInfo> infos = PBField.initRepeatMessage(QQCircleCounter$FeedInfo.class);
}
