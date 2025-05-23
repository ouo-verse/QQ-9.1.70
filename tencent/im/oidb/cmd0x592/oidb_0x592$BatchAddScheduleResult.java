package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$BatchAddScheduleResult extends MessageMicro<oidb_0x592$BatchAddScheduleResult> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg;
    public final PBBytesField bytes_schedule_id;
    public final PBUInt32Field uint32_result;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_schedule_id", "uint32_result", "bytes_error_msg"}, new Object[]{byteStringMicro, 0, byteStringMicro}, oidb_0x592$BatchAddScheduleResult.class);
    }

    public oidb_0x592$BatchAddScheduleResult() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_schedule_id = PBField.initBytes(byteStringMicro);
        this.uint32_result = PBField.initUInt32(0);
        this.bytes_error_msg = PBField.initBytes(byteStringMicro);
    }
}
