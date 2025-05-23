package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb6f$ReportFreqRspBody extends MessageMicro<oidb_0xb6f$ReportFreqRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 32, 40}, new String[]{"identity", "remain_times", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{null, 0L, 0}, oidb_0xb6f$ReportFreqRspBody.class);
    public oidb_0xb6f$Identity identity = new oidb_0xb6f$Identity();
    public final PBInt64Field remain_times = PBField.initInt64(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
}
