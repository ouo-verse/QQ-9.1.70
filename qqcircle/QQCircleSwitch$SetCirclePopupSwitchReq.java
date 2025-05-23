package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSwitch$SetCirclePopupSwitchReq extends MessageMicro<QQCircleSwitch$SetCirclePopupSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"enable"}, new Object[]{""}, QQCircleSwitch$SetCirclePopupSwitchReq.class);
    public final PBStringField enable = PBField.initString("");
}
