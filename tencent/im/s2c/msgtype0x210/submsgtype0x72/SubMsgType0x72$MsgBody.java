package tencent.im.s2c.msgtype0x210.submsgtype0x72;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x72$MsgBody extends MessageMicro<SubMsgType0x72$MsgBody> {
    public static final int STR_CONTENT_FIELD_NUMBER = 4;
    public static final int STR_INFO_DATE_FIELD_NUMBER = 5;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_TEMPLATE_NO_FIELD_NUMBER = 3;
    public static final int UINT32_URGENCY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint32_sub_cmd", "uint32_urgency", "uint32_template_no", "str_content", "str_info_date"}, new Object[]{0, 0, 0, "", ""}, SubMsgType0x72$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_urgency = PBField.initUInt32(0);
    public final PBUInt32Field uint32_template_no = PBField.initUInt32(0);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_info_date = PBField.initString("");
}
