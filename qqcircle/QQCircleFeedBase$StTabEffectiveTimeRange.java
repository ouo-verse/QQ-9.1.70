package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTabEffectiveTimeRange extends MessageMicro<QQCircleFeedBase$StTabEffectiveTimeRange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"beginTime", "endTime"}, new Object[]{0L, 0L}, QQCircleFeedBase$StTabEffectiveTimeRange.class);
    public final PBInt64Field beginTime = PBField.initInt64(0);
    public final PBInt64Field endTime = PBField.initInt64(0);
}
