package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StGetPrePullInfoRspV2 extends MessageMicro<QQCircleFeedBase$StGetPrePullInfoRspV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"prePullMD", "redTouchFeedOpActions", "normalFeedOpActions"}, new Object[]{null, null, null}, QQCircleFeedBase$StGetPrePullInfoRspV2.class);
    public QQCircleFeedBase$PrePullMetaData prePullMD = new QQCircleFeedBase$PrePullMetaData();
    public QQCircleFeedBase$PrePullRspFeedsOpActionDesc redTouchFeedOpActions = new QQCircleFeedBase$PrePullRspFeedsOpActionDesc();
    public QQCircleFeedBase$PrePullRspFeedsOpActionDesc normalFeedOpActions = new QQCircleFeedBase$PrePullRspFeedsOpActionDesc();
}
