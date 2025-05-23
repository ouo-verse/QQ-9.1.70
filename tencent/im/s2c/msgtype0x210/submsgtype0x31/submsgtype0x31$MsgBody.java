package tencent.im.s2c.msgtype0x210.submsgtype0x31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x31$MsgBody extends MessageMicro<submsgtype0x31$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 37}, new String[]{"uint32_flag", "uint64_uin", "uint64_bind_uin", "uint32_time"}, new Object[]{0, 0L, 0L, 0}, submsgtype0x31$MsgBody.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0);
    public final PBFixed32Field uint32_time = PBField.initFixed32(0);
}
