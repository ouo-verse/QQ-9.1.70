package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$SpaceCheckinEntry extends MessageMicro<QZIntimateCheckIn$SpaceCheckinEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"space_id", "users", "comm_checkin_days"}, new Object[]{"", null, 0}, QZIntimateCheckIn$SpaceCheckinEntry.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBRepeatMessageField<QZIntimateCheckIn$SpaceCheckinUserEntry> users = PBField.initRepeatMessage(QZIntimateCheckIn$SpaceCheckinUserEntry.class);
    public final PBUInt32Field comm_checkin_days = PBField.initUInt32(0);
}
