package tencent.im.s2c.msgtype0x210.submsgtype0x60;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x60$MsgBody extends MessageMicro<SubMsgType0x60$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_pushcmd", "int64_ts", "str_ssid", "str_content"}, new Object[]{0, 0L, "", ""}, SubMsgType0x60$MsgBody.class);
    public final PBUInt32Field uint32_pushcmd = PBField.initUInt32(0);
    public final PBInt64Field int64_ts = PBField.initInt64(0);
    public final PBStringField str_ssid = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
}
