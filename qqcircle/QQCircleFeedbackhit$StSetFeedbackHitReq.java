package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedbackhit$StSetFeedbackHitReq extends MessageMicro<QQCircleFeedbackhit$StSetFeedbackHitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feedbackInfo", "type"}, new Object[]{null, null, 0}, QQCircleFeedbackhit$StSetFeedbackHitReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCircleFeedbackhit$StFeedbackCommonInfo feedbackInfo = new QQCircleFeedbackhit$StFeedbackCommonInfo();
    public final PBEnumField type = PBField.initEnum(0);
}
