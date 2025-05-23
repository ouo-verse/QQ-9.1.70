package tencent.im.oidb.cmd0x625;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x625$OpenIDInfoReq extends MessageMicro<Oidb_0x625$OpenIDInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_appid", "bytes_openid", "uint32_acounttype"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, Oidb_0x625$OpenIDInfoReq.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_acounttype = PBField.initUInt32(0);
}
