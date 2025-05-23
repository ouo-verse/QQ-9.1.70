package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StUrgeStatusInfo extends MessageMicro<QQCircleLightinteract$StUrgeStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"userID", "urgeStatus", "urgePosition"}, new Object[]{"", 0, 0}, QQCircleLightinteract$StUrgeStatusInfo.class);
    public final PBStringField userID = PBField.initString("");
    public final PBInt32Field urgeStatus = PBField.initInt32(0);
    public final PBInt32Field urgePosition = PBField.initInt32(0);
}
