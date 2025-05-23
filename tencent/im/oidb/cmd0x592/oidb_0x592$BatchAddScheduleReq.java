package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow$Workflow;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$BatchAddScheduleReq extends MessageMicro<oidb_0x592$BatchAddScheduleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_schedule_list"}, new Object[]{null}, oidb_0x592$BatchAddScheduleReq.class);
    public final PBRepeatMessageField<Qworkflow$Workflow> rpt_msg_schedule_list = PBField.initRepeatMessage(Qworkflow$Workflow.class);
}
