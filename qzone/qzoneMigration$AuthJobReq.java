package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneMigration$AuthJobReq extends MessageMicro<qzoneMigration$AuthJobReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"space_id", "auth_action"}, new Object[]{"", 0}, qzoneMigration$AuthJobReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBEnumField auth_action = PBField.initEnum(0);
}
