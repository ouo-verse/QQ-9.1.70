package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneHolidayshare$DisplayData extends MessageMicro<qzoneHolidayshare$DisplayData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"activity_name", "members", "desc1", "desc2", "pic", "addtional_msg", "activity_item_id"}, new Object[]{"", null, "", "", "", "", ""}, qzoneHolidayshare$DisplayData.class);
    public final PBStringField activity_name = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> members = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBStringField desc1 = PBField.initString("");
    public final PBStringField desc2 = PBField.initString("");
    public final PBRepeatField<String> pic = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField addtional_msg = PBField.initString("");
    public final PBStringField activity_item_id = PBField.initString("");
}
