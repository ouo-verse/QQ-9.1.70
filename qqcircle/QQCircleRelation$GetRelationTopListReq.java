package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$GetRelationTopListReq extends MessageMicro<QQCircleRelation$GetRelationTopListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{WidgetCacheConstellationData.NUM, "relType", "needCount", "page"}, new Object[]{0, 0, 0, 0}, QQCircleRelation$GetRelationTopListReq.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBInt32Field relType = PBField.initInt32(0);
    public final PBInt32Field needCount = PBField.initInt32(0);
    public final PBInt32Field page = PBField.initInt32(0);
}
