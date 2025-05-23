package qqcircle;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$StFuelCostRange extends MessageMicro<QQCirclePrivateMsgShow$StFuelCostRange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{Element.ELEMENT_NAME_MIN, "max"}, new Object[]{0, 0}, QQCirclePrivateMsgShow$StFuelCostRange.class);
    public final PBUInt32Field min = PBField.initUInt32(0);
    public final PBUInt32Field max = PBField.initUInt32(0);
}
