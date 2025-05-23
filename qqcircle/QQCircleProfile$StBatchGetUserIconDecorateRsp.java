package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StBatchGetUserIconDecorateRsp extends MessageMicro<QQCircleProfile$StBatchGetUserIconDecorateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"iconDecorateInfos"}, new Object[]{null}, QQCircleProfile$StBatchGetUserIconDecorateRsp.class);
    public final PBRepeatMessageField<QQCircleProfile$IconDecorateInfo> iconDecorateInfos = PBField.initRepeatMessage(QQCircleProfile$IconDecorateInfo.class);
}
