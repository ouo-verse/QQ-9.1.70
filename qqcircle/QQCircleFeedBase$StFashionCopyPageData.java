package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StFashionCopyPageData extends MessageMicro<QQCircleFeedBase$StFashionCopyPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"simulateInfo", "pageDesc", "subTitleEntry", "shareInfo"}, new Object[]{null, "", null, null}, QQCircleFeedBase$StFashionCopyPageData.class);
    public QQCircleFeedBase$StSimulateData simulateInfo = new QQCircleFeedBase$StSimulateData();
    public final PBStringField pageDesc = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> subTitleEntry = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
}
