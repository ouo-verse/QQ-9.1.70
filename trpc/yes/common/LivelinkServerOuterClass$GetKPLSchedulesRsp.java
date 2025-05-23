package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class LivelinkServerOuterClass$GetKPLSchedulesRsp extends MessageMicro<LivelinkServerOuterClass$GetKPLSchedulesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"total_count", "schedules"}, new Object[]{0, null}, LivelinkServerOuterClass$GetKPLSchedulesRsp.class);
    public final PBInt32Field total_count = PBField.initInt32(0);
    public final PBRepeatMessageField<LivelinkServerOuterClass$KPLDaySchedule> schedules = PBField.initRepeatMessage(LivelinkServerOuterClass$KPLDaySchedule.class);
}
