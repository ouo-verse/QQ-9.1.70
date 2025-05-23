package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3bb$AnonyStatus extends MessageMicro<cmd0x3bb$AnonyStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82}, new String[]{"uint32_forbid_talking", "str_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x3bb$AnonyStatus.class);
    public final PBUInt32Field uint32_forbid_talking = PBField.initUInt32(0);
    public final PBBytesField str_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
