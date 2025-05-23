package tencent.im.s2c.msgtype0x210.submsgtype0xce;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xce$MsgBody extends MessageMicro<submsgtype0xce$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int64_startTime", "int64_endTime", "string_params"}, new Object[]{0L, 0L, ""}, submsgtype0xce$MsgBody.class);
    public final PBInt64Field int64_startTime = PBField.initInt64(0);
    public final PBInt64Field int64_endTime = PBField.initInt64(0);
    public final PBStringField string_params = PBField.initString("");
}
