package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$LockPushTransInfo extends MessageMicro<QQCircleFeedBase$LockPushTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 66, 72, 80}, new String[]{"feedId", "author", "createTs", "feedType", "backFeedId", "backFeedType", "backFeedAuthor", "recomInfo", "recomUins", "recomReasonType"}, new Object[]{"", "", 0L, 0, "", 0, "", "", 0L, 0}, QQCircleFeedBase$LockPushTransInfo.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField author = PBField.initString("");
    public final PBInt64Field createTs = PBField.initInt64(0);
    public final PBInt32Field feedType = PBField.initInt32(0);
    public final PBStringField backFeedId = PBField.initString("");
    public final PBInt32Field backFeedType = PBField.initInt32(0);
    public final PBStringField backFeedAuthor = PBField.initString("");
    public final PBStringField recomInfo = PBField.initString("");
    public final PBRepeatField<Long> recomUins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field recomReasonType = PBField.initInt32(0);
}
