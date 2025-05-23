package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$ChannelEvents extends MessageMicro<msg_event$ChannelEvents> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"channel_id", "event_types", "begin_seq", "end_seq", "msg_events"}, new Object[]{0L, 0L, 0L, 0L, null}, msg_event$ChannelEvents.class);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> event_types = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field end_seq = PBField.initUInt64(0);
    public final PBRepeatMessageField<msg_event$MsgEvent> msg_events = PBField.initRepeatMessage(msg_event$MsgEvent.class);
}
