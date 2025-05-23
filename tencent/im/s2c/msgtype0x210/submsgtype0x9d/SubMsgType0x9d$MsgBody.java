package tencent.im.s2c.msgtype0x210.submsgtype0x9d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x9d$MsgBody extends MessageMicro<SubMsgType0x9d$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_sub_cmd", "lola_module_update"}, new Object[]{0, null}, SubMsgType0x9d$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<SubMsgType0x9d$ModuleUpdateNotify> lola_module_update = PBField.initRepeatMessage(SubMsgType0x9d$ModuleUpdateNotify.class);
}
