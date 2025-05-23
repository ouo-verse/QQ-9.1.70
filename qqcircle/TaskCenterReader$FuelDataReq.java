package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$FuelDataReq extends MessageMicro<TaskCenterReader$FuelDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "userId", "reqFrom", "optType"}, new Object[]{null, "", 0, 0}, TaskCenterReader$FuelDataReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> userId = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field reqFrom = PBField.initInt32(0);
    public final PBEnumField optType = PBField.initEnum(0);
}
