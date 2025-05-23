package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StModifyLimitItem extends MessageMicro<QQCircleProfile$StModifyLimitItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"type", "allowNum", "totalNum", "limitType"}, new Object[]{0, 0, 0, 0}, QQCircleProfile$StModifyLimitItem.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt32Field allowNum = PBField.initInt32(0);
    public final PBInt32Field totalNum = PBField.initInt32(0);
    public final PBEnumField limitType = PBField.initEnum(0);
}
