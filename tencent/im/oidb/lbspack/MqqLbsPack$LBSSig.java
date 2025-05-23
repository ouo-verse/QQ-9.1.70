package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$LBSSig extends MessageMicro<MqqLbsPack$LBSSig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int32_lat", "int32_lon", "uint32_time", "bytes_verify_key"}, new Object[]{900000000, 900000000, 0, ByteStringMicro.EMPTY}, MqqLbsPack$LBSSig.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBBytesField bytes_verify_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
