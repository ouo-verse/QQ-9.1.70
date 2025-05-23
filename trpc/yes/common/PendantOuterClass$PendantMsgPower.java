package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class PendantOuterClass$PendantMsgPower extends MessageMicro<PendantOuterClass$PendantMsgPower> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"recent_task_watch_time", "prepare_recv_task_total", "day_task_status", "prepare_recv_power_total"}, new Object[]{0, 0, 0, 0}, PendantOuterClass$PendantMsgPower.class);
    public final PBInt32Field recent_task_watch_time = PBField.initInt32(0);
    public final PBInt32Field prepare_recv_task_total = PBField.initInt32(0);
    public final PBInt32Field day_task_status = PBField.initInt32(0);
    public final PBInt32Field prepare_recv_power_total = PBField.initInt32(0);
}
