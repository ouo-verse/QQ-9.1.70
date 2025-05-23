package seal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SealCloudRerankInfo$CloudReRankInfo extends MessageMicro<SealCloudRerankInfo$CloudReRankInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"interactive_feed_list", "candidate_feed_list"}, new Object[]{null, null}, SealCloudRerankInfo$CloudReRankInfo.class);
    public final PBRepeatMessageField<SealCloudRerankInfo$InteractiveFeed> interactive_feed_list = PBField.initRepeatMessage(SealCloudRerankInfo$InteractiveFeed.class);
    public final PBRepeatMessageField<SealCloudRerankInfo$IneterRecommendFeedDetail> candidate_feed_list = PBField.initRepeatMessage(SealCloudRerankInfo$IneterRecommendFeedDetail.class);
}
