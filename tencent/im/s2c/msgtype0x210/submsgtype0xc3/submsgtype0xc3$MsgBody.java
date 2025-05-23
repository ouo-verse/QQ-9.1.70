package tencent.im.s2c.msgtype0x210.submsgtype0xc3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc3$MsgBody extends MessageMicro<submsgtype0xc3$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_push_data", "uint64_timestamp"}, new Object[]{0, ByteStringMicro.EMPTY, 0L}, submsgtype0xc3$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBytesField bytes_push_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
}
