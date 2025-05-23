package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5e0$GroupName extends MessageMicro<Oidb_0x5e0$GroupName> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_group_uin", "bytes_value"}, new Object[]{0L, ByteStringMicro.EMPTY}, Oidb_0x5e0$GroupName.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
