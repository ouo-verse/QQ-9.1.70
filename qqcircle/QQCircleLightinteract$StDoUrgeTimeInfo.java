package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StDoUrgeTimeInfo extends MessageMicro<QQCircleLightinteract$StDoUrgeTimeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userID", "urgeTimestamp"}, new Object[]{"", 0L}, QQCircleLightinteract$StDoUrgeTimeInfo.class);
    public final PBStringField userID = PBField.initString("");
    public final PBInt64Field urgeTimestamp = PBField.initInt64(0);
}
