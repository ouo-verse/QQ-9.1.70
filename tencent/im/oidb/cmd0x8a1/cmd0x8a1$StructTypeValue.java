package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8a1$StructTypeValue extends MessageMicro<cmd0x8a1$StructTypeValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "bytes_value"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x8a1$StructTypeValue.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
