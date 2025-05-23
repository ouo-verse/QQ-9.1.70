package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$ConfidentCircleMemberReq extends MessageMicro<QQCircleRead$ConfidentCircleMemberReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "circleInfo"}, new Object[]{null, null}, QQCircleRead$ConfidentCircleMemberReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCircleBase$UserCircleInfo circleInfo = new QQCircleBase$UserCircleInfo();
}
