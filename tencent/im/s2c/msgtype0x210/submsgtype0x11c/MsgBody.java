package tencent.im.s2c.msgtype0x210.submsgtype0x11c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBody extends MessageMicro<MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_cmd", "uint32_timestamp", "bytes_data"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, MsgBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
