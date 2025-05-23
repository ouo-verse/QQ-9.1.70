package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QeventPB$ActivityTime extends MessageMicro<QeventPB$ActivityTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"start_time", "end_time", "repeat_type", "repeat_end_time"}, new Object[]{0L, 0L, 0, 0L}, QeventPB$ActivityTime.class);
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
    public final PBUInt32Field repeat_type = PBField.initUInt32(0);
    public final PBUInt64Field repeat_end_time = PBField.initUInt64(0);
}
