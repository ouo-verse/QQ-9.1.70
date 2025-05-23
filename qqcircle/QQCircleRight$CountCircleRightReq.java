package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$CountCircleRightReq extends MessageMicro<QQCircleRight$CountCircleRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rightType", "type"}, new Object[]{0, 0}, QQCircleRight$CountCircleRightReq.class);
    public final PBEnumField rightType = PBField.initEnum(0);
    public final PBInt32Field type = PBField.initInt32(0);
}
