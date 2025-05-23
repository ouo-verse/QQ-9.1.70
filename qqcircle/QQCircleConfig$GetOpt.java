package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GetOpt extends MessageMicro<QQCircleConfig$GetOpt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, QQCircleConfig$GetOpt.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField val = PBField.initString("");
}
