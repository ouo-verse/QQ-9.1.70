package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$BindFarmRoleEvent extends MessageMicro<QzoneActivityPB$BindFarmRoleEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uin", "activity_id", "role_uid"}, new Object[]{"", "", 0L}, QzoneActivityPB$BindFarmRoleEvent.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField activity_id = PBField.initString("");
    public final PBUInt64Field role_uid = PBField.initUInt64(0);
}
