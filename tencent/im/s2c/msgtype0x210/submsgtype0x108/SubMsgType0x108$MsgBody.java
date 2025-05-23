package tencent.im.s2c.msgtype0x210.submsgtype0x108;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x108$MsgBody extends MessageMicro<SubMsgType0x108$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_type", "uint64_push_uin", "uint32_like_count", "push_time"}, new Object[]{0, 0L, 0, 0}, SubMsgType0x108$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_push_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field push_time = PBField.initUInt32(0);
}
