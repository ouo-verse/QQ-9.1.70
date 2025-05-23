package tencent.im.oidb.cmd0x66b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x66b$ReqBody extends MessageMicro<Oidb_0x66b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{480802, 481600, 482400, 483200, 484000, 484800}, new String[]{"bytes_reqbody_5eb", "uint32_req_likeinfo", "uint32_req_pansocialinfo", "uint32_req_giftinfo", "uint32_req_configinfo", "uint32_req_visitor"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, 0, 0}, Oidb_0x66b$ReqBody.class);
    public final PBBytesField bytes_reqbody_5eb = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_req_likeinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_pansocialinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_giftinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_configinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_visitor = PBField.initUInt32(0);
}
