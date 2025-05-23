package tencent.im.s2c.msgtype0x210.submsgtype0xb3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xb3$MsgBody extends MessageMicro<SubMsgType0xb3$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "msg_add_frd_notify"}, new Object[]{0, null}, SubMsgType0xb3$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public SubMsgType0xb3$PushAddFrdNotify msg_add_frd_notify = new SubMsgType0xb3$PushAddFrdNotify();
}
