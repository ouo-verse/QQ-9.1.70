package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StTagMedalInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$CircleFuelMedalInfo extends MessageMicro<QQCircleRankinglist$CircleFuelMedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "medalList"}, new Object[]{"", null}, QQCircleRankinglist$CircleFuelMedalInfo.class);
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StTagMedalInfo> medalList = PBField.initRepeatMessage(FeedCloudMeta$StTagMedalInfo.class);
}
