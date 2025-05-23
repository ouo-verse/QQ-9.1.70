package tencent.im.oidb.cmd0x625;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x625$TinyIDInfoRsp extends MessageMicro<Oidb_0x625$TinyIDInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_appid", "bytes_openid", "uint64_tinyid", "uint32_acounttype"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0}, Oidb_0x625$TinyIDInfoRsp.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_acounttype = PBField.initUInt32(0);
}
