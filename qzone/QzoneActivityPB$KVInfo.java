package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$KVInfo extends MessageMicro<QzoneActivityPB$KVInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, QzoneActivityPB$KVInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField val = PBField.initString("");
}
