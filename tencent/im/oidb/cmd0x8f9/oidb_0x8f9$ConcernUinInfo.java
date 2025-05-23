package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$ConcernUinInfo extends MessageMicro<oidb_0x8f9$ConcernUinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_concern_uin", "uint32_confirm_time", "uint32_read_time"}, new Object[]{0L, 0, 0}, oidb_0x8f9$ConcernUinInfo.class);
    public final PBUInt64Field uint64_concern_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
}
