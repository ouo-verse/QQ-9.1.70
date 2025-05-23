package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$CommonBody extends MessageMicro<oidb_0xcf4$CommonBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26, 40}, new String[]{"string_oidb_body", "uint32_oidb_cmd"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0xcf4$CommonBody.class);
    public final PBBytesField string_oidb_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_oidb_cmd = PBField.initUInt32(0);
}
