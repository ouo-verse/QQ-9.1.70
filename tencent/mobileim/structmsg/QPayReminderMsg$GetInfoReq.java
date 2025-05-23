package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QPayReminderMsg$GetInfoReq extends MessageMicro<QPayReminderMsg$GetInfoReq> {
    public static final int INFO_DATE_FIELD_NUMBER = 3;
    public static final int SCENE_FIELD_NUMBER = 1;
    public static final int SUB_CMD_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"scene", "sub_cmd", "info_date"}, new Object[]{"", "", ""}, QPayReminderMsg$GetInfoReq.class);
    public final PBStringField scene = PBField.initString("");
    public final PBStringField sub_cmd = PBField.initString("");
    public final PBStringField info_date = PBField.initString("");
}
