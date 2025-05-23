package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$QQGroupController extends MessageMicro<QQCircleProfile$QQGroupController> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"allow_bind_groups_count", "bind_notice_text", "can_bind_status"}, new Object[]{0, "", 0}, QQCircleProfile$QQGroupController.class);
    public final PBUInt32Field allow_bind_groups_count = PBField.initUInt32(0);
    public final PBStringField bind_notice_text = PBField.initString("");
    public final PBUInt32Field can_bind_status = PBField.initUInt32(0);
}
