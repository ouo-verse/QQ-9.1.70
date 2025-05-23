package tencent.im.group_pro_proto.channel_share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ChannelShareRequest$ScheduleParam extends MessageMicro<ChannelShareRequest$ScheduleParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"id"}, new Object[]{0L}, ChannelShareRequest$ScheduleParam.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435938id = PBField.initUInt64(0);
}
