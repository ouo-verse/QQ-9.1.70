package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$ChannelCount extends MessageMicro<msg_event$ChannelCount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"channel_id", "event_types", "begin_seq", "end_seq", "event_count"}, new Object[]{0L, 0L, 0L, 0L, 0L}, msg_event$ChannelCount.class);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> event_types = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field end_seq = PBField.initUInt64(0);
    public final PBUInt64Field event_count = PBField.initUInt64(0);
}
