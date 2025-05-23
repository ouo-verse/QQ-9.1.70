package seal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SealCloudRerankInfo$InteractiveFeed extends MessageMicro<SealCloudRerankInfo$InteractiveFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"feedid", "interactive_timestamp", "play_duration", "physical_duration", "interactive_count", "interactive_type_array", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID}, new Object[]{"", 0L, 0L, 0L, 0L, 0L, 0L}, SealCloudRerankInfo$InteractiveFeed.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBUInt64Field interactive_timestamp = PBField.initUInt64(0);
    public final PBUInt64Field play_duration = PBField.initUInt64(0);
    public final PBUInt64Field physical_duration = PBField.initUInt64(0);
    public final PBUInt64Field interactive_count = PBField.initUInt64(0);
    public final PBRepeatField<Long> interactive_type_array = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field contentid = PBField.initUInt64(0);
}
