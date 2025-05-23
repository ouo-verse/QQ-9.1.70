package tencent.im.group_pro_proto.msg_box;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$ChannelEvent extends MessageMicro<MsgBox$ChannelEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"guild_id", "channel_id", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{0L, 0L, null}, MsgBox$ChannelEvent.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<MsgBox$Event> events = PBField.initRepeatMessage(MsgBox$Event.class);
}
