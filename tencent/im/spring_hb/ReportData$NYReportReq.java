package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportData$NYReportReq extends MessageMicro<ReportData$NYReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"commonInfo", "reportItems", "triggerSource", "uin"}, new Object[]{null, null, 0, 0L}, ReportData$NYReportReq.class);
    public ReportData$NYCommonInfo commonInfo = new ReportData$NYCommonInfo();
    public final PBRepeatMessageField<ReportData$NYReportItem> reportItems = PBField.initRepeatMessage(ReportData$NYReportItem.class);
    public final PBUInt32Field triggerSource = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
