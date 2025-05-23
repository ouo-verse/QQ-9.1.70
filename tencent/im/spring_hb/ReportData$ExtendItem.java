package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportData$ExtendItem extends MessageMicro<ReportData$ExtendItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ReportData$ExtendItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
