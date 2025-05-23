package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleCounter$PsvDetail extends MessageMicro<QQCircleCounter$PsvDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"feedType", "categoryID", "feedID", "pushUIN", "updateTimestamp", "ext"}, new Object[]{0, 0, "", "", 0L, null}, QQCircleCounter$PsvDetail.class);
    public final PBInt32Field feedType = PBField.initInt32(0);
    public final PBInt32Field categoryID = PBField.initInt32(0);
    public final PBStringField feedID = PBField.initString("");
    public final PBRepeatField<String> pushUIN = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt64Field updateTimestamp = PBField.initInt64(0);
    public FeedCloudCommon$StCommonExt ext = new FeedCloudCommon$StCommonExt();
}
