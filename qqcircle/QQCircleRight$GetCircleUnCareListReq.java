package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$GetCircleUnCareListReq extends MessageMicro<QQCircleRight$GetCircleUnCareListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"extInfo", "rightType", "type", "flag", WidgetCacheConstellationData.NUM}, new Object[]{null, 0, 0, 0, 0}, QQCircleRight$GetCircleUnCareListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBEnumField rightType = PBField.initEnum(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field flag = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
}
