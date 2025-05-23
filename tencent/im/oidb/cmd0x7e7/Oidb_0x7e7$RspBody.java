package tencent.im.oidb.cmd0x7e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x7e7$RspBody extends MessageMicro<Oidb_0x7e7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, Oidb_0x7e7$RspBody.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBBytesField ret_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
