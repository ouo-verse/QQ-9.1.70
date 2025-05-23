package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8b4$ReqBody extends MessageMicro<cmd0x8b4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 168, 176, 184, 194}, new String[]{"uint64_gc", "uint64_guin", "uint32_flag", "uint64_dst_uin", "uint32_start", "uint32_cnt", "bytes_tag"}, new Object[]{0L, 0L, 0, 0L, 0, 0, ByteStringMicro.EMPTY}, cmd0x8b4$ReqBody.class);
    public final PBUInt64Field uint64_gc = PBField.initUInt64(0);
    public final PBUInt64Field uint64_guin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cnt = PBField.initUInt32(0);
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
}
