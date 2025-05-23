package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb6f$ReportFreqReqBody extends MessageMicro<oidb_0xb6f$ReportFreqReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"identity", "invoke_times"}, new Object[]{null, 1L}, oidb_0xb6f$ReportFreqReqBody.class);
    public oidb_0xb6f$Identity identity = new oidb_0xb6f$Identity();
    public final PBInt64Field invoke_times = PBField.initInt64(1);
}
