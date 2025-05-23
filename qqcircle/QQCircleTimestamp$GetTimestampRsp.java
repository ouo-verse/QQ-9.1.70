package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTimestamp$GetTimestampRsp extends MessageMicro<QQCircleTimestamp$GetTimestampRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"timestamp"}, new Object[]{0L}, QQCircleTimestamp$GetTimestampRsp.class);
    public final PBInt64Field timestamp = PBField.initInt64(0);
}
