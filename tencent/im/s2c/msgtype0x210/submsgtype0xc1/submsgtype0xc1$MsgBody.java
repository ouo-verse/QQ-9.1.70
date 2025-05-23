package tencent.im.s2c.msgtype0x210.submsgtype0xc1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc1$MsgBody extends MessageMicro<submsgtype0xc1$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_groupid", "uint32_member_num", "string_data"}, new Object[]{0L, 0, ""}, submsgtype0xc1$MsgBody.class);
    public final PBUInt64Field uint64_groupid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBStringField string_data = PBField.initString("");
}
