package tencent.im.s2c.msgtype0x210.submsgtype0x3e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x3e$MsgBody extends MessageMicro<Submsgtype0x3e$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint32_subcmd", "uint32_random", "uint32_result", "bytes_device", "uint32_sid"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY, 0}, Submsgtype0x3e$MsgBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_random = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_device = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_sid = PBField.initUInt32(0);
}
