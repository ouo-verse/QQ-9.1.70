package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StActivityInfo extends MessageMicro<QQCircleSpringPrizePopup$StActivityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"activity_id", "task_id", "rule_id"}, new Object[]{"", 0L, 0L}, QQCircleSpringPrizePopup$StActivityInfo.class);
    public final PBStringField activity_id = PBField.initString("");
    public final PBUInt64Field task_id = PBField.initUInt64(0);
    public final PBUInt64Field rule_id = PBField.initUInt64(0);
}
