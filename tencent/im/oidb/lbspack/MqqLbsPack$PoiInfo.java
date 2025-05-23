package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$PoiInfo extends MessageMicro<MqqLbsPack$PoiInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addr;
    public final PBBytesField bytes_name;
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0);
    public final PBInt32Field int32_lat = PBField.initInt32(0);
    public final PBInt32Field int32_lon = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_poi_id", "int32_lat", "int32_lon", "bytes_name", "bytes_addr"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro}, MqqLbsPack$PoiInfo.class);
    }

    public MqqLbsPack$PoiInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_addr = PBField.initBytes(byteStringMicro);
    }
}
