package tencent.im.s2c.msgtype0x210.submsgtype0x97;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x97$MsgBody extends MessageMicro<submsgtype0x97$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_business_uin", "string_json_context"}, new Object[]{"", ""}, submsgtype0x97$MsgBody.class);
    public final PBStringField string_business_uin = PBField.initString("");
    public final PBStringField string_json_context = PBField.initString("");
}
