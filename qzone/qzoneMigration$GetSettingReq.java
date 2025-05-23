package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneMigration$GetSettingReq extends MessageMicro<qzoneMigration$GetSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_id"}, new Object[]{""}, qzoneMigration$GetSettingReq.class);
    public final PBStringField space_id = PBField.initString("");
}
