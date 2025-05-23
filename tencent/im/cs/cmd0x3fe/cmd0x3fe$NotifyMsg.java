package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$NotifyMsg extends MessageMicro<cmd0x3fe$NotifyMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint32_subcmd", "uint64_from_uin", "uint64_to_uin", "uint64_guin", "uint32_count"}, new Object[]{0, 0L, 0L, 0L, 0}, cmd0x3fe$NotifyMsg.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_guin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
}
