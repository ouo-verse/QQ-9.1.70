package tencent.im.oidb.cmd0xa8c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa8c$ReqBody extends MessageMicro<oidb_0xa8c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_poid", "uint64_flower_num", "uint64_flower_point"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L}, oidb_0xa8c$ReqBody.class);
    public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_flower_num = PBField.initUInt64(0);
    public final PBUInt64Field uint64_flower_point = PBField.initUInt64(0);
}
