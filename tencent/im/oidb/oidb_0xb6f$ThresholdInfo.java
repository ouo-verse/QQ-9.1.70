package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb6f$ThresholdInfo extends MessageMicro<oidb_0xb6f$ThresholdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"threshold_per_minute", "threshold_per_day", "threshold_per_hour", "threshold_per_week"}, new Object[]{0L, 0L, 0L, 0L}, oidb_0xb6f$ThresholdInfo.class);
    public final PBInt64Field threshold_per_minute = PBField.initInt64(0);
    public final PBInt64Field threshold_per_day = PBField.initInt64(0);
    public final PBInt64Field threshold_per_hour = PBField.initInt64(0);
    public final PBInt64Field threshold_per_week = PBField.initInt64(0);
}
