package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo extends MessageMicro<QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_ret_code", "str_err_msg"}, new Object[]{0, ""}, QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
}
