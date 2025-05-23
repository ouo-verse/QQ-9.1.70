package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class cmd0x388$IPv6Info extends MessageMicro<cmd0x388$IPv6Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_ip6", "uint32_port"}, new Object[]{ByteStringMicro.EMPTY, 0}, cmd0x388$IPv6Info.class);
    public final PBBytesField bytes_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}
