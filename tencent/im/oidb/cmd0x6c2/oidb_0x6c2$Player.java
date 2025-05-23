package tencent.im.oidb.cmd0x6c2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x6c2$Player extends MessageMicro<oidb_0x6c2$Player> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_uin", "uint64_time", "int32_amount", "int32_index", "bytes_tips"}, new Object[]{0L, 0L, 0, 0, ByteStringMicro.EMPTY}, oidb_0x6c2$Player.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
    public final PBInt32Field int32_index = PBField.initInt32(0);
    public final PBBytesField bytes_tips = PBField.initBytes(ByteStringMicro.EMPTY);
}
