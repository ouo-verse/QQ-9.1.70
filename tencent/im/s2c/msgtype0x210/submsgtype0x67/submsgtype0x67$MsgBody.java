package tencent.im.s2c.msgtype0x210.submsgtype0x67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x67$MsgBody extends MessageMicro<submsgtype0x67$MsgBody> {
    public static final int RPT_MSG_GRPINFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_grpinfo"}, new Object[]{null}, submsgtype0x67$MsgBody.class);
    public final PBRepeatMessageField<submsgtype0x67$GroupInfo> rpt_msg_grpinfo = PBField.initRepeatMessage(submsgtype0x67$GroupInfo.class);
}
