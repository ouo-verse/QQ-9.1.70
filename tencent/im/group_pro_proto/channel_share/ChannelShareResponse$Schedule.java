package tencent.im.group_pro_proto.channel_share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ChannelShareResponse$Schedule extends MessageMicro<ChannelShareResponse$Schedule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"id", "start_time_ms", "end_time_ms"}, new Object[]{0L, 0L, 0L}, ChannelShareResponse$Schedule.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435939id = PBField.initUInt64(0);
    public final PBUInt64Field start_time_ms = PBField.initUInt64(0);
    public final PBUInt64Field end_time_ms = PBField.initUInt64(0);
}
