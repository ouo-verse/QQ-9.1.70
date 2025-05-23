package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicKdReport$KdReportResever extends MessageMicro<DynamicKdReport$KdReportResever> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sreseverkey", "sresevervalue"}, new Object[]{"", ""}, DynamicKdReport$KdReportResever.class);
    public final PBStringField sreseverkey = PBField.initString("");
    public final PBStringField sresevervalue = PBField.initString("");
}
