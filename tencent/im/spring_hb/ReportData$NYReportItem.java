package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportData$NYReportItem extends MessageMicro<ReportData$NYReportItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72}, new String[]{"bussID", "fromSrc", "moduleID", "subModuleID", "operationCode", "extParams", "optime", "count", "type"}, new Object[]{"", "", "", "", "", null, 0L, 0, 0}, ReportData$NYReportItem.class);
    public final PBStringField bussID = PBField.initString("");
    public final PBStringField fromSrc = PBField.initString("");
    public final PBStringField moduleID = PBField.initString("");
    public final PBStringField subModuleID = PBField.initString("");
    public final PBStringField operationCode = PBField.initString("");
    public final PBRepeatMessageField<ReportData$ExtendItem> extParams = PBField.initRepeatMessage(ReportData$ExtendItem.class);
    public final PBUInt64Field optime = PBField.initUInt64(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
}
