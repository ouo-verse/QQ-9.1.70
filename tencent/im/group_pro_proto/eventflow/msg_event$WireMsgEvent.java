package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common$Event;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$WireMsgEvent extends MessageMicro<msg_event$WireMsgEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"guild_id", "channel_id", "msg_seq", "event"}, new Object[]{0L, 0L, 0L, null}, msg_event$WireMsgEvent.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public common$Event event = new common$Event();
}
