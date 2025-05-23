package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StNegativeFbButton extends MessageMicro<QQCircleDitto$StNegativeFbButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 32, 42}, new String[]{"buttonType", "needShow", "buttonValue", "color"}, new Object[]{1, Boolean.FALSE, 0, ""}, QQCircleDitto$StNegativeFbButton.class);
    public final PBEnumField buttonType = PBField.initEnum(1);
    public final PBBoolField needShow = PBField.initBool(false);
    public final PBUInt32Field buttonValue = PBField.initUInt32(0);
    public final PBStringField color = PBField.initString("");
}
