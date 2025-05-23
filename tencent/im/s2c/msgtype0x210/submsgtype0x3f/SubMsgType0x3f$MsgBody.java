package tencent.im.s2c.msgtype0x210.submsgtype0x3f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x3f$MsgBody extends MessageMicro<SubMsgType0x3f$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_pubunikey"}, new Object[]{null}, SubMsgType0x3f$MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x3f$PubUniKey> rpt_msg_pubunikey = PBField.initRepeatMessage(SubMsgType0x3f$PubUniKey.class);
}
