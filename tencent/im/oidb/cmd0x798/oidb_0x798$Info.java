package tencent.im.oidb.cmd0x798;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x798$Info extends MessageMicro<oidb_0x798$Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_flag", "uint32_type", "uint32_count"}, new Object[]{0, 0, 0}, oidb_0x798$Info.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
}
