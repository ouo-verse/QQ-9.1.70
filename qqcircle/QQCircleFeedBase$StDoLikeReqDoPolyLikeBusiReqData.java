package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData extends MessageMicro<QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"polyLikeInfo", "curPolyLikeInfo"}, new Object[]{null, null}, QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData.class);
    public QQCircleFeedBase$StPolyLike polyLikeInfo = new QQCircleFeedBase$StPolyLike();
    public QQCircleFeedBase$StPolyLike curPolyLikeInfo = new QQCircleFeedBase$StPolyLike();
}
