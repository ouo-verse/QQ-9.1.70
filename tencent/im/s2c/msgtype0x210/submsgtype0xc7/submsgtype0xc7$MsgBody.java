package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$MsgBody extends MessageMicro<submsgtype0xc7$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_mod_infos"}, new Object[]{null}, submsgtype0xc7$MsgBody.class);
    public final PBRepeatMessageField<submsgtype0xc7$ForwardBody> rpt_msg_mod_infos = PBField.initRepeatMessage(submsgtype0xc7$ForwardBody.class);
}
