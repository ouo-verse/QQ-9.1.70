package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTimestamp$SetTimestampListReq extends MessageMicro<QQCircleTimestamp$SetTimestampListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"reqList"}, new Object[]{null}, QQCircleTimestamp$SetTimestampListReq.class);
    public final PBRepeatMessageField<QQCircleTimestamp$SetTimestampReq> reqList = PBField.initRepeatMessage(QQCircleTimestamp$SetTimestampReq.class);
}
