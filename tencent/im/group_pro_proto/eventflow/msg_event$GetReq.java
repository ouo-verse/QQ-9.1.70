package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$GetReq extends MessageMicro<msg_event$GetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"guild_id", "channel_id", "cookie", "direct_message_flag"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0}, msg_event$GetReq.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field direct_message_flag = PBField.initInt32(0);
}
