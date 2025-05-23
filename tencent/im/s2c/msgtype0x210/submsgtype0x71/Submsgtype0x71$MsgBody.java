package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x71$MsgBody extends MessageMicro<Submsgtype0x71$MsgBody> {
    public static final int RPT_MSG_APP_INFO_FIELD_NUMBER = 1;
    public static final int UINT64_UIUIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_app_info", "uint64_uiUin"}, new Object[]{null, 0L}, Submsgtype0x71$MsgBody.class);
    public final PBRepeatMessageField<Submsgtype0x71$ReportAppInfo> rpt_msg_app_info = PBField.initRepeatMessage(Submsgtype0x71$ReportAppInfo.class);
    public final PBUInt64Field uint64_uiUin = PBField.initUInt64(0);
}
