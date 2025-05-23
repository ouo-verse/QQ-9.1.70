package tencent.im.oidb.cmd0xbd4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbd4$Invitee extends MessageMicro<oidb_cmd0xbd4$Invitee> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_from", "uint32_ts"}, new Object[]{0L, 0, 0}, oidb_cmd0xbd4$Invitee.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ts = PBField.initUInt32(0);
}
