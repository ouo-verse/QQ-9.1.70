package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$GetUsersSpaceReadRightReq extends MessageMicro<QZIntimateSpaceProfile$GetUsersSpaceReadRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"spaces_id", "users"}, new Object[]{"", null}, QZIntimateSpaceProfile$GetUsersSpaceReadRightReq.class);
    public final PBStringField spaces_id = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> users = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
}
