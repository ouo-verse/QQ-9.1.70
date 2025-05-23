package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$NetAddr extends MessageMicro<hd_video_comm$NetAddr> {
    public static final int PT_TCP = 1;
    public static final int PT_UDP = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_inner_ipv6;
    public final PBBytesField bytes_ipv6;
    public final PBFixed32Field fixed32_IP = PBField.initFixed32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    public final PBEnumField enum_proto_type = PBField.initEnum(1);
    public final PBFixed32Field fixed32_inner_IP = PBField.initFixed32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 24, 37, 42, 50}, new String[]{"fixed32_IP", "uint32_port", "enum_proto_type", "fixed32_inner_IP", "bytes_ipv6", "bytes_inner_ipv6"}, new Object[]{0, 0, 1, 0, byteStringMicro, byteStringMicro}, hd_video_comm$NetAddr.class);
    }

    public hd_video_comm$NetAddr() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_ipv6 = PBField.initBytes(byteStringMicro);
        this.bytes_inner_ipv6 = PBField.initBytes(byteStringMicro);
    }
}
