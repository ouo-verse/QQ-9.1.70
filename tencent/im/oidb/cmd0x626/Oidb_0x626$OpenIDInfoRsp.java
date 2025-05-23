package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x626$OpenIDInfoRsp extends MessageMicro<Oidb_0x626$OpenIDInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_appid", "uint64_tinyid", "bytes_openid", "uint32_acounttype"}, new Object[]{0, 0L, ByteStringMicro.EMPTY, 0}, Oidb_0x626$OpenIDInfoRsp.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_acounttype = PBField.initUInt32(0);
}
