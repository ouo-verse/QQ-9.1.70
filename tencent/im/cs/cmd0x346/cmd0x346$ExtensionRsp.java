package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ExtensionRsp extends MessageMicro<cmd0x346$ExtensionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_transfer_type", "uint32_channel_type", "uint32_allow_retry", "server_addr_ipv6_list"}, new Object[]{0, 0, 0, null}, cmd0x346$ExtensionRsp.class);
    public final PBUInt32Field uint32_transfer_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
    public cmd0x346$AddrList server_addr_ipv6_list = new cmd0x346$AddrList();
}
