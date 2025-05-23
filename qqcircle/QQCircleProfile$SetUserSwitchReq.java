package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$SetUserSwitchReq extends MessageMicro<QQCircleProfile$SetUserSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"switchType", "value"}, new Object[]{0, 0}, QQCircleProfile$SetUserSwitchReq.class);
    public final PBInt32Field switchType = PBField.initInt32(0);
    public final PBInt32Field value = PBField.initInt32(0);
}
