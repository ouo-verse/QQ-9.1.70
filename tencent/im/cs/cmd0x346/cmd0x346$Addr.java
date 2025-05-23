package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$Addr extends MessageMicro<cmd0x346$Addr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint32_out_ip", "uint32_out_port", "uint32_inner_ip", "uint32_inner_port", "uint32_ip_type"}, new Object[]{0, 0, 0, 0, 0}, cmd0x346$Addr.class);
    public final PBUInt32Field uint32_out_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_out_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ip_type = PBField.initUInt32(0);
}
