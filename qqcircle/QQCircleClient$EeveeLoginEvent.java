package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClient$EeveeLoginEvent extends MessageMicro<QQCircleClient$EeveeLoginEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"toast_text", "toast_count"}, new Object[]{"", 0}, QQCircleClient$EeveeLoginEvent.class);
    public final PBStringField toast_text = PBField.initString("");
    public final PBUInt32Field toast_count = PBField.initUInt32(0);
}
