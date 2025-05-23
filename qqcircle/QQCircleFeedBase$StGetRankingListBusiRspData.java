package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StGetRankingListBusiRspData extends MessageMicro<QQCircleFeedBase$StGetRankingListBusiRspData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"urlInfo", "rankName"}, new Object[]{null, ""}, QQCircleFeedBase$StGetRankingListBusiRspData.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField rankName = PBField.initString("");
}
