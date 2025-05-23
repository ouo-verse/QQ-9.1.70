package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleProfile$CheckBindGroupReq extends MessageMicro<QQCircleProfile$CheckBindGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"extInfo", "groupIDList", "source"}, new Object[]{null, 0L, 0}, QQCircleProfile$CheckBindGroupReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Long> groupIDList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field source = PBField.initUInt32(0);
}
