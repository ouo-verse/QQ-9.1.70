package tencent.im.oidb.cmd0x796;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x796$ReqBody extends MessageMicro<oidb_0x796$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48}, new String[]{"feedsid", "uint64_time", "uint64_uin", "uint32_type", "stLastInfo", "uint32_seq"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L, 0, null, 0}, oidb_0x796$ReqBody.class);
    public final PBBytesField feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public oidb_0x796$ItemInfo stLastInfo = new oidb_0x796$ItemInfo();
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}
