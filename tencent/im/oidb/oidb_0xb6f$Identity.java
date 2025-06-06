package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb6f$Identity extends MessageMicro<oidb_0xb6f$Identity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 80, 162}, new String[]{"apiName", "appid", "apptype", TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, "int_ext1", "str_ext1"}, new Object[]{"", 0, 0, 0, 0L, ""}, oidb_0xb6f$Identity.class);
    public final PBStringField apiName = PBField.initString("");
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field apptype = PBField.initInt32(0);
    public final PBInt32Field bizid = PBField.initInt32(0);
    public final PBInt64Field int_ext1 = PBField.initInt64(0);
    public final PBStringField str_ext1 = PBField.initString("");
}
