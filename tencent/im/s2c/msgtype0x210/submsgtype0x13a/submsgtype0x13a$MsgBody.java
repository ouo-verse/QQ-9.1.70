package tencent.im.s2c.msgtype0x210.submsgtype0x13a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x13a$MsgBody extends MessageMicro<submsgtype0x13a$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_push_type", "bytes_push_data", "uint32_timestamp", "msg_system_notify"}, new Object[]{0, ByteStringMicro.EMPTY, 0, null}, submsgtype0x13a$MsgBody.class);
    public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
    public final PBBytesField bytes_push_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public submsgtype0x13a$SystemNotify msg_system_notify = new submsgtype0x13a$SystemNotify();
}
