package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StHotTagInfo;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StPushList;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StFeedBusiReqData extends MessageMicro<QQCircleFeedBase$StFeedBusiReqData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{"allPushList", "pushList", "uninterest_buttons", "recomFeedTypeDescribe", "hotTagInfo", "bottomButtons", "new_uninterest"}, new Object[]{null, null, 0, "", null, null, null}, QQCircleFeedBase$StFeedBusiReqData.class);
    public FeedCloudMeta$StLike allPushList = new FeedCloudMeta$StLike();
    public FeedCloudMeta$StPushList pushList = new FeedCloudMeta$StPushList();
    public final PBRepeatField<Integer> uninterest_buttons = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField recomFeedTypeDescribe = PBField.initString("");
    public FeedCloudMeta$StHotTagInfo hotTagInfo = new FeedCloudMeta$StHotTagInfo();
    public QQCircleDitto$StButtonGroup bottomButtons = new QQCircleDitto$StButtonGroup();
    public QQCircleFeedBase$NewUninterest new_uninterest = new QQCircleFeedBase$NewUninterest();
}
