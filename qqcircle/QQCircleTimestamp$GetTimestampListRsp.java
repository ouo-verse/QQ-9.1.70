package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTimestamp$GetTimestampListRsp extends MessageMicro<QQCircleTimestamp$GetTimestampListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rspList"}, new Object[]{null}, QQCircleTimestamp$GetTimestampListRsp.class);
    public final PBRepeatMessageField<QQCircleTimestamp$BatchGetTimestampField> rspList = PBField.initRepeatMessage(QQCircleTimestamp$BatchGetTimestampField.class);
}
