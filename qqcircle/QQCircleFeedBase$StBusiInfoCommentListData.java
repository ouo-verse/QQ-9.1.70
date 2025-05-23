package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StBusiInfoCommentListData extends MessageMicro<QQCircleFeedBase$StBusiInfoCommentListData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"comment", "reply", "reqType"}, new Object[]{null, null, 0}, QQCircleFeedBase$StBusiInfoCommentListData.class);
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StReply reply = new FeedCloudMeta$StReply();
    public final PBInt32Field reqType = PBField.initInt32(0);
}
