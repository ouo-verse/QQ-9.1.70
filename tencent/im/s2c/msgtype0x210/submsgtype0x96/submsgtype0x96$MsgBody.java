package tencent.im.s2c.msgtype0x210.submsgtype0x96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x96$MsgBody extends MessageMicro<submsgtype0x96$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"string_push_msg", "uint32_push_type"}, new Object[]{"", 0}, submsgtype0x96$MsgBody.class);
    public final PBStringField string_push_msg = PBField.initString("");
    public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
}
