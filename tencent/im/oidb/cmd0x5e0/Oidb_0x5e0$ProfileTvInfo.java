package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class Oidb_0x5e0$ProfileTvInfo extends MessageMicro<Oidb_0x5e0$ProfileTvInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_field_id", "uint32_field_type", "uint64_field_int_value", "bytes_field_str_value"}, new Object[]{0, 0, 0L, ByteStringMicro.EMPTY}, Oidb_0x5e0$ProfileTvInfo.class);
    public final PBUInt32Field uint32_field_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_field_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_field_int_value = PBField.initUInt64(0);
    public final PBBytesField bytes_field_str_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
