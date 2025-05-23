package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$StPMSettingData extends MessageMicro<QQCirclePrivateMsgShow$StPMSettingData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"privilgetype", "fuelCost"}, new Object[]{0, 0}, QQCirclePrivateMsgShow$StPMSettingData.class);
    public final PBEnumField privilgetype = PBField.initEnum(0);
    public final PBUInt32Field fuelCost = PBField.initUInt32(0);
}
