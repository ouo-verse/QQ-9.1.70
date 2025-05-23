package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GetPsvDetailsRsp extends MessageMicro<QQCircleCounter$GetPsvDetailsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"psvDetails"}, new Object[]{null}, QQCircleCounter$GetPsvDetailsRsp.class);
    public final PBRepeatMessageField<QQCircleCounter$PsvDetail> psvDetails = PBField.initRepeatMessage(QQCircleCounter$PsvDetail.class);
}
