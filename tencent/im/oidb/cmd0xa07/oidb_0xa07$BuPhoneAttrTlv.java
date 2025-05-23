package tencent.im.oidb.cmd0xa07;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xa07$BuPhoneAttrTlv extends MessageMicro<oidb_0xa07$BuPhoneAttrTlv> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_tag", "uint32_len", "bytes_values"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, oidb_0xa07$BuPhoneAttrTlv.class);
    public final PBUInt32Field uint32_tag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_len = PBField.initUInt32(0);
    public final PBBytesField bytes_values = PBField.initBytes(ByteStringMicro.EMPTY);
}
