package tencent.mobileim.structmsg;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QPayReminderMsg$GetInfoRsp extends MessageMicro<QPayReminderMsg$GetInfoRsp> {
    public static final int CONTENT_FIELD_NUMBER = 5;
    public static final int INFO_DATE_FIELD_NUMBER = 6;
    public static final int RESULT_CODE_FIELD_NUMBER = 1;
    public static final int RESULT_INFO_FIELD_NUMBER = 2;
    public static final int TEMPLATE_NO_FIELD_NUMBER = 4;
    public static final int URGENCY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"result_code", "result_info", RemoteMessageConst.URGENCY, "template_no", "content", "info_date"}, new Object[]{0, "", 0, 0, "", ""}, QPayReminderMsg$GetInfoRsp.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField result_info = PBField.initString("");
    public final PBUInt32Field urgency = PBField.initUInt32(0);
    public final PBUInt32Field template_no = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBStringField info_date = PBField.initString("");
}
