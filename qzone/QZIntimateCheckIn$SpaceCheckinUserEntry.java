package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$SpaceCheckinUserEntry extends MessageMicro<QZIntimateCheckIn$SpaceCheckinUserEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", "is_today_checked"}, new Object[]{"", Boolean.FALSE}, QZIntimateCheckIn$SpaceCheckinUserEntry.class);
    public final PBStringField uid = PBField.initString("");
    public final PBBoolField is_today_checked = PBField.initBool(false);
}
