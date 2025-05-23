package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Unisso$UniSsoServerReqComm extends MessageMicro<Unisso$UniSsoServerReqComm> {
    public static final int MQQVER_FIELD_NUMBER = 3;
    public static final int OSVER_FIELD_NUMBER = 2;
    public static final int PLATFORM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, Unisso$UniSsoServerReqComm.class);
    public final PBInt64Field platform = PBField.initInt64(0);
    public final PBStringField osver = PBField.initString("");
    public final PBStringField mqqver = PBField.initString("");
}
