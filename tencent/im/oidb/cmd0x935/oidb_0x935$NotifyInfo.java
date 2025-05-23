package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x935$NotifyInfo extends MessageMicro<oidb_0x935$NotifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_notify_gc", "uint32_notify_type"}, new Object[]{0L, 0}, oidb_0x935$NotifyInfo.class);
    public final PBUInt64Field uint64_notify_gc = PBField.initUInt64(0);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
}
