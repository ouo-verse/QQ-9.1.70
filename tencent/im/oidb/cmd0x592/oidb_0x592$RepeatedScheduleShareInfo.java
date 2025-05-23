package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow$Timespan;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$RepeatedScheduleShareInfo extends MessageMicro<oidb_0x592$RepeatedScheduleShareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_schedule_id", "rpt_msg_share_timespan"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x592$RepeatedScheduleShareInfo.class);
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow$Timespan> rpt_msg_share_timespan = PBField.initRepeatMessage(Qworkflow$Timespan.class);
}
