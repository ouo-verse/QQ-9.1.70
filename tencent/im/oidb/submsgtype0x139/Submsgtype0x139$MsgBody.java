package tencent.im.oidb.submsgtype0x139;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x139$MsgBody extends MessageMicro<Submsgtype0x139$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint64_friend", "uint32_op_type"}, new Object[]{0L, 0L, 0}, Submsgtype0x139$MsgBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_friend = PBField.initUInt64(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}
