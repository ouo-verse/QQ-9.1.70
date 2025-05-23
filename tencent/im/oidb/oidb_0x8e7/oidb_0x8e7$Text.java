package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$Text extends MessageMicro<oidb_0x8e7$Text> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_context", "uint32_color"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8e7$Text.class);
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_color = PBField.initUInt32(0);
}
