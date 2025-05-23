package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$ModCustomFace extends MessageMicro<SubMsgType0x27$ModCustomFace> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_type", "uint64_uin", "uint64_group_code", "uint64_cmd_uin"}, new Object[]{0, 0L, 0L, 0L}, SubMsgType0x27$ModCustomFace.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0);
}
