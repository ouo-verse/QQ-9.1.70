package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSwitch$SetCirclePopupReq extends MessageMicro<QQCircleSwitch$SetCirclePopupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"key", "type", "action"}, new Object[]{"", 0, 0}, QQCircleSwitch$SetCirclePopupReq.class);
    public final PBStringField key = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBEnumField action = PBField.initEnum(0);
}
