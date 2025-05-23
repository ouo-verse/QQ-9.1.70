package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCommercialDataworksReport$RetMsg extends MessageMicro<QQCircleCommercialDataworksReport$RetMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_msg"}, new Object[]{0, ""}, QQCircleCommercialDataworksReport$RetMsg.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
