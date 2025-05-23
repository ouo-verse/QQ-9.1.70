package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fb$BufferExData extends MessageMicro<cmd0x3fb$BufferExData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_index", "uint32_value", "string_value", "bytes_value"}, new Object[]{0, 0, "", ByteStringMicro.EMPTY}, cmd0x3fb$BufferExData.class);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_value = PBField.initUInt32(0);
    public final PBStringField string_value = PBField.initString("");
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
