package tencent.im.oidb.cmd0xd82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd82$RspBody extends MessageMicro<oidb_cmd0xd82$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_entrance", "uint32_redpoint", "uint64_blocked_uin", "uint32_unread"}, new Object[]{0, 0, 0L, 0}, oidb_cmd0xd82$RspBody.class);
    public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_redpoint = PBField.initUInt32(0);
    public final PBUInt64Field uint64_blocked_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_unread = PBField.initUInt32(0);
}
