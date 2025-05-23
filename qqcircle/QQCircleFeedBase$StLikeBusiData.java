package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StLikeBusiData extends MessageMicro<QQCircleFeedBase$StLikeBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"polyLikeInfo", "curPolyLikeInfo", "rewardstatus", "likestatus", "likeIDs"}, new Object[]{null, null, 0, 0, ""}, QQCircleFeedBase$StLikeBusiData.class);
    public final PBRepeatMessageField<QQCircleFeedBase$StPolyLike> polyLikeInfo = PBField.initRepeatMessage(QQCircleFeedBase$StPolyLike.class);
    public QQCircleFeedBase$StPolyLike curPolyLikeInfo = new QQCircleFeedBase$StPolyLike();
    public final PBInt32Field rewardstatus = PBField.initInt32(0);
    public final PBInt32Field likestatus = PBField.initInt32(0);
    public final PBRepeatField<String> likeIDs = PBField.initRepeat(PBStringField.__repeatHelper__);
}
