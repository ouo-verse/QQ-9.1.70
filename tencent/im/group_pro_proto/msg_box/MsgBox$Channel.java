package tencent.im.group_pro_proto.msg_box;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$Channel extends MessageMicro<MsgBox$Channel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"channel_id", "event_types", "begin_seq", "end_seq", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{0L, 0L, 0L, 0L, null}, MsgBox$Channel.class);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> event_types = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field end_seq = PBField.initUInt64(0);
    public final PBRepeatMessageField<MsgBox$Event> events = PBField.initRepeatMessage(MsgBox$Event.class);
}
