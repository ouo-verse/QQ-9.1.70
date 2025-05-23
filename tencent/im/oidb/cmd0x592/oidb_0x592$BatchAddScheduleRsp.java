package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$BatchAddScheduleRsp extends MessageMicro<oidb_0x592$BatchAddScheduleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "rpt_msg_result"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x592$BatchAddScheduleRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592$BatchAddScheduleResult> rpt_msg_result = PBField.initRepeatMessage(oidb_0x592$BatchAddScheduleResult.class);
}
