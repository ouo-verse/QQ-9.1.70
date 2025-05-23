package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$ConfInfo extends MessageMicro<QQCircleSmartMatchMusic$ConfInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"startPos", "isCollected"}, new Object[]{0, 0}, QQCircleSmartMatchMusic$ConfInfo.class);
    public final PBInt32Field startPos = PBField.initInt32(0);
    public final PBInt32Field isCollected = PBField.initInt32(0);
}
