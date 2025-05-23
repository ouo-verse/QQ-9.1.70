package tencent.im.cs.faceroam_sso;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$RspBody extends MessageMicro<faceroam_sso$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "sub_cmd", "rspcmd_0x01", "rspcmd_0x02"}, new Object[]{0L, "", 0, null, null}, faceroam_sso$RspBody.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public faceroam_sso$RspUserInfo rspcmd_0x01 = new faceroam_sso$RspUserInfo();
    public faceroam_sso$RspDeleteItem rspcmd_0x02 = new faceroam_sso$RspDeleteItem();
}
