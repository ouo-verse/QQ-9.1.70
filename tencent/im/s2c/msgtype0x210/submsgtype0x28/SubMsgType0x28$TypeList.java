package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x28$TypeList extends MessageMicro<SubMsgType0x28$TypeList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_puin", "uint32_flag", "uint32_type"}, new Object[]{0L, 0, 0}, SubMsgType0x28$TypeList.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
