package tencent.im.s2c.msgtype0x210.submsgtype0x104;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x104$MsgBody extends MessageMicro<submsgtype0x104$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90}, new String[]{"uint64_from", "uint64_to", "uint32_topic_id", "bytes_wording"}, new Object[]{0L, 0L, 0, ByteStringMicro.EMPTY}, submsgtype0x104$MsgBody.class);
    public final PBUInt64Field uint64_from = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
