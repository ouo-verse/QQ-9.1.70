package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StBatchGetProfileReq extends MessageMicro<QQCircleProfile$StBatchGetProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "userId", "infoTypes"}, new Object[]{null, "", 0}, QQCircleProfile$StBatchGetProfileReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> userId = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Integer> infoTypes = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
