package tencent.im.s2c.msgtype0x210.submsgtype0x11e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x11e$MsgBody extends MessageMicro<SubMsgType0x11e$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "str_reason"}, new Object[]{0, ""}, SubMsgType0x11e$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_reason = PBField.initString("");
}
