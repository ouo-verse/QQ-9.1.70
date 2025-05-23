package tianshu;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$GetAdLicenseRsp extends MessageMicro<TianShuQuantityLimit$GetAdLicenseRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"code", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "ad_licenses", "minIntervalSecs", "extInfo"}, new Object[]{0, "", null, 0, ""}, TianShuQuantityLimit$GetAdLicenseRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<TianShuQuantityLimit$MapEntry> ad_licenses = PBField.initRepeatMessage(TianShuQuantityLimit$MapEntry.class);
    public final PBInt32Field minIntervalSecs = PBField.initInt32(0);
    public final PBStringField extInfo = PBField.initString("");
}
