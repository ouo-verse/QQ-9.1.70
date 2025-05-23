package tencent.im.oidb.cmd0xdad;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xdad$RspBody extends MessageMicro<cmd0xdad$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0L, ""}, cmd0xdad$RspBody.class);
    public final PBInt64Field retcode = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
}
