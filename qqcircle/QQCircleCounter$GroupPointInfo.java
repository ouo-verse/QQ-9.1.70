package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GroupPointInfo extends MessageMicro<QQCircleCounter$GroupPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"touin", WidgetCacheConstellationData.NUM, "jumpSchema"}, new Object[]{"", 0, ""}, QQCircleCounter$GroupPointInfo.class);
    public final PBStringField touin = PBField.initString("");
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBStringField jumpSchema = PBField.initString("");
}
