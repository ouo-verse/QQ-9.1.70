package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReader$TaskListReq extends MessageMicro<QQCircleReader$TaskListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"extInfo", "userId", "reqFrom", WidgetCacheConstellationData.NUM, "ext"}, new Object[]{null, "", 0, 0, ""}, QQCircleReader$TaskListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBInt32Field reqFrom = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBStringField ext = PBField.initString("");
}
