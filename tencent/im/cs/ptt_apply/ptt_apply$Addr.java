package tencent.im.cs.ptt_apply;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ptt_apply$Addr extends MessageMicro<ptt_apply$Addr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint32_out_ip", "uint32_out_port", "uint32_inner_ip", "uint32_inner_port", "uint32_ip_type"}, new Object[]{0, 0, 0, 0, 0}, ptt_apply$Addr.class);
    public final PBUInt32Field uint32_out_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_out_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ip_type = PBField.initUInt32(0);
}
