package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.Qworkflow.Qworkflow$Timespan;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$ShareScheduleResult extends MessageMicro<oidb_0x592$ShareScheduleResult> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg;
    public final PBBytesField bytes_schedule_id;
    public final PBRepeatMessageField<Qworkflow$Timespan> rpt_msg_fail_timespan;
    public final PBUInt32Field uint32_result;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"bytes_schedule_id", "uint32_result", "bytes_error_msg", "rpt_msg_fail_timespan"}, new Object[]{byteStringMicro, 0, byteStringMicro, null}, oidb_0x592$ShareScheduleResult.class);
    }

    public oidb_0x592$ShareScheduleResult() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_schedule_id = PBField.initBytes(byteStringMicro);
        this.uint32_result = PBField.initUInt32(0);
        this.bytes_error_msg = PBField.initBytes(byteStringMicro);
        this.rpt_msg_fail_timespan = PBField.initRepeatMessage(Qworkflow$Timespan.class);
    }
}
