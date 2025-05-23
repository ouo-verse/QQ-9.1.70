package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportData$NYWinReportItem extends MessageMicro<ReportData$NYWinReportItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"promotion_id", "type", "prize_id", "value", "source", "subject", "logic_id", "business_id"}, new Object[]{0, 0, 0, 0, 2, 0, 0, ""}, ReportData$NYWinReportItem.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field prize_id = PBField.initUInt32(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBEnumField source = PBField.initEnum(2);
    public final PBUInt32Field subject = PBField.initUInt32(0);
    public final PBUInt32Field logic_id = PBField.initUInt32(0);
    public final PBStringField business_id = PBField.initString("");
}
