package tencent.im.s2c.msgtype0x210.submsgtype0x157;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.util.notification.NotificationController;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x157$MsgBody extends MessageMicro<SubMsgType0x157$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"withdraw_begin", "withdraw_end", "msg_begin", "msg_end", NotificationController.Constants.CONFIG_VERSION}, new Object[]{0L, 0L, 0L, 0L, 0}, SubMsgType0x157$MsgBody.class);
    public final PBUInt64Field withdraw_begin = PBField.initUInt64(0);
    public final PBUInt64Field withdraw_end = PBField.initUInt64(0);
    public final PBUInt64Field msg_begin = PBField.initUInt64(0);
    public final PBUInt64Field msg_end = PBField.initUInt64(0);
    public final PBUInt32Field config_version = PBField.initUInt32(0);
}
