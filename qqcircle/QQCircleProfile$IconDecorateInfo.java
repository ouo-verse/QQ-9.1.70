package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StIconDecorate;

/* loaded from: classes29.dex */
public final class QQCircleProfile$IconDecorateInfo extends MessageMicro<QQCircleProfile$IconDecorateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "iconDecorate"}, new Object[]{0, null}, QQCircleProfile$IconDecorateInfo.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public FeedCloudMeta$StIconDecorate iconDecorate = new FeedCloudMeta$StIconDecorate();
}
