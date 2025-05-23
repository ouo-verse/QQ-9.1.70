package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleYuhengActivity$YuhengInfo extends MessageMicro<QQCircleYuhengActivity$YuhengInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"activity_id", "task_id", "rule_id"}, new Object[]{0L, 0L, 0L}, QQCircleYuhengActivity$YuhengInfo.class);
    public final PBInt64Field activity_id = PBField.initInt64(0);
    public final PBInt64Field task_id = PBField.initInt64(0);
    public final PBInt64Field rule_id = PBField.initInt64(0);
}
