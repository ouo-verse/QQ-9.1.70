package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$FeedEvent extends MessageMicro<servtype$FeedEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint64_guild_id", "uint64_channel_id", "str_feed_id", "str_msg_summary", "uint64_event_time"}, new Object[]{0L, 0L, "", "", 0L}, servtype$FeedEvent.class);
    public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBStringField str_msg_summary = PBField.initString("");
    public final PBUInt64Field uint64_event_time = PBField.initUInt64(0);
}
