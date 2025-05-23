package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$Ipv6Info extends MessageMicro<MultiMsg$Ipv6Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_ip_v6_addr", "uint32_ip_v6_port", "uint32_is_https_addr"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, MultiMsg$Ipv6Info.class);
    public final PBBytesField bytes_ip_v6_addr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ip_v6_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_https_addr = PBField.initUInt32(0);
}
