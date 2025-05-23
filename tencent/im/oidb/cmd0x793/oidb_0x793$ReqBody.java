package tencent.im.oidb.cmd0x793;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x793$ReqBody extends MessageMicro<oidb_0x793$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_uin", "feedsid", "uint64_time", "uint32_getnum"}, new Object[]{0L, ByteStringMicro.EMPTY, 0L, 0}, oidb_0x793$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_getnum = PBField.initUInt32(0);
}
