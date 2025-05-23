package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$MsgBody extends MessageMicro<SubMsgType0x6f$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_mod_infos"}, new Object[]{null}, SubMsgType0x6f$MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x6f$ForwardBody> rpt_msg_mod_infos = PBField.initRepeatMessage(SubMsgType0x6f$ForwardBody.class);
}
