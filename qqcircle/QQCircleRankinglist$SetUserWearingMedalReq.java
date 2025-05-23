package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StMedalInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$SetUserWearingMedalReq extends MessageMicro<QQCircleRankinglist$SetUserWearingMedalReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "uid", "medalInfos"}, new Object[]{null, "", null}, QQCircleRankinglist$SetUserWearingMedalReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta$StMedalInfo.class);
}
