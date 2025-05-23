package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$RedPointJumpInfo extends MessageMicro<QQCircleCounter$RedPointJumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"jumpType", "jumpLink", "redPointSources"}, new Object[]{0, "", 0}, QQCircleCounter$RedPointJumpInfo.class);
    public final PBEnumField jumpType = PBField.initEnum(0);
    public final PBStringField jumpLink = PBField.initString("");
    public final PBRepeatField<Integer> redPointSources = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
