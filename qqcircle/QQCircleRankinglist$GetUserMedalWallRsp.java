package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StMedalInfo;
import feedcloud.FeedCloudMeta$StWearingMedal;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetUserMedalWallRsp extends MessageMicro<QQCircleRankinglist$GetUserMedalWallRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "medalInfos", "wearingMedal"}, new Object[]{null, null, null}, QQCircleRankinglist$GetUserMedalWallRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta$StMedalInfo.class);
    public FeedCloudMeta$StWearingMedal wearingMedal = new MessageMicro<FeedCloudMeta$StWearingMedal>() { // from class: feedcloud.FeedCloudMeta$StWearingMedal
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"medalInfos"}, new Object[]{null}, FeedCloudMeta$StWearingMedal.class);
        public final PBRepeatMessageField<FeedCloudMeta$StWearingMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta$StWearingMedalInfo.class);
    };
}
