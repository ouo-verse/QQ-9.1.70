package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$Ipv4Info extends MessageMicro<MultiMsg$Ipv4Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_ip_v4_addr", "uint32_ip_v4_port", "uint32_is_https_addr"}, new Object[]{0, 0, 0}, MultiMsg$Ipv4Info.class);
    public final PBUInt32Field uint32_ip_v4_addr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ip_v4_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_https_addr = PBField.initUInt32(0);
}
