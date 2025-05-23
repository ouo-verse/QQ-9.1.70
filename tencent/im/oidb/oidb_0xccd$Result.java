package tencent.im.oidb;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xccd$Result extends MessageMicro<oidb_0xccd$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_appid", "errcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, 0, ""}, oidb_0xccd$Result.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
}
