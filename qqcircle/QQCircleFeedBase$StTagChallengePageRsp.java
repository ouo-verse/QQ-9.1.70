package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StTagInfo;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTagChallengePageRsp extends MessageMicro<QQCircleFeedBase$StTagChallengePageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"challengeTagList", "needPreLoad"}, new Object[]{null, Boolean.FALSE}, QQCircleFeedBase$StTagChallengePageRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> challengeTagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBBoolField needPreLoad = PBField.initBool(false);
}
