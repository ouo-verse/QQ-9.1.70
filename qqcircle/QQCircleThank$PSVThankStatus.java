package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleThank$PSVThankStatus extends MessageMicro<QQCircleThank$PSVThankStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feed_id", "status"}, new Object[]{"", 0}, QQCircleThank$PSVThankStatus.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
}
