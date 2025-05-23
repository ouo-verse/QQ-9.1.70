package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$SnsUpdateOneFlag extends MessageMicro<SubMsgType0x27$SnsUpdateOneFlag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64__uin", "uint64_id", "uint32_flag"}, new Object[]{0L, 0L, 0}, SubMsgType0x27$SnsUpdateOneFlag.class);
    public final PBUInt64Field uint64__uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}
