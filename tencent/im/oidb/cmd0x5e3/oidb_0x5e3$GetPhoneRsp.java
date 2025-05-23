package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x5e3$GetPhoneRsp extends MessageMicro<oidb_0x5e3$GetPhoneRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96}, new String[]{"bytes_phone", "uint64_contact_qq", "uint32_qq_status"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0}, oidb_0x5e3$GetPhoneRsp.class);
    public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_contact_qq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_qq_status = PBField.initUInt32(0);
}
