package tencent.im.s2c.msgtype0x210.submsgtype0x15e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x15e$MsgBody extends MessageMicro<submsgtype0x15e$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82, 90}, new String[]{"uint32_msg_type", "msg_system_notify", "msg_signal_notify"}, new Object[]{0, null, null}, submsgtype0x15e$MsgBody.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public submsgtype0x15e$SystemNotify msg_system_notify = new submsgtype0x15e$SystemNotify();
    public submsgtype0x15e$SignalNofify msg_signal_notify = new MessageMicro<submsgtype0x15e$SignalNofify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x15e.submsgtype0x15e$SignalNofify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], submsgtype0x15e$SignalNofify.class);
    };
}
