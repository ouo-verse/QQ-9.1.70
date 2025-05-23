package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class adSchedule$ReportReq extends MessageMicro<adSchedule$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58}, new String[]{"action_type", "app_id", "download_link", "qq_ver", "os_type", "phone_model", "os_version"}, new Object[]{0, "", "", "", 0, "", ""}, adSchedule$ReportReq.class);
    public final PBEnumField action_type = PBField.initEnum(0);
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField download_link = PBField.initString("");
    public final PBStringField qq_ver = PBField.initString("");
    public final PBEnumField os_type = PBField.initEnum(0);
    public final PBStringField phone_model = PBField.initString("");
    public final PBStringField os_version = PBField.initString("");
}
