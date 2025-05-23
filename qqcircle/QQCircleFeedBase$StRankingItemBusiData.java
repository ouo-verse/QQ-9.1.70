package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StFeedAbstract;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StRankingItemBusiData extends MessageMicro<QQCircleFeedBase$StRankingItemBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feedList"}, new Object[]{null}, QQCircleFeedBase$StRankingItemBusiData.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
}
