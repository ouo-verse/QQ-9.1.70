package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetNewestPendantReq extends MessageMicro<QQCirclePendant$GetNewestPendantReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{WidgetCacheConstellationData.NUM, "filterPop", "filterExpire"}, new Object[]{0, 0, 0}, QQCirclePendant$GetNewestPendantReq.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBInt32Field filterPop = PBField.initInt32(0);
    public final PBInt32Field filterExpire = PBField.initInt32(0);
}
