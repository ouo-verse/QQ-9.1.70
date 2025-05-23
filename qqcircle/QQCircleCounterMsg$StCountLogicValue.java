package qqcircle;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$StCountLogicValue extends MessageMicro<QQCircleCounterMsg$StCountLogicValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{QQBrowserActivity.KEY_MSG_TYPE, "operuin", "operTs"}, new Object[]{0, 0, 0}, QQCircleCounterMsg$StCountLogicValue.class);
    public final PBEnumField msgType = PBField.initEnum(0);
    public final PBUInt32Field operuin = PBField.initUInt32(0);
    public final PBUInt32Field operTs = PBField.initUInt32(0);
}
