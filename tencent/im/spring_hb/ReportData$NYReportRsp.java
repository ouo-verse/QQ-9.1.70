package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportData$NYReportRsp extends MessageMicro<ReportData$NYReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56}, new String[]{"ret", "errMsg", "batchSize", "reportInterval", "switchToBgInterval", "reportLevel", "reportLevelTime"}, new Object[]{0, "", 0, 0, 0, 0, 0}, ReportData$NYReportRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public final PBUInt32Field batchSize = PBField.initUInt32(0);
    public final PBUInt32Field reportInterval = PBField.initUInt32(0);
    public final PBUInt32Field switchToBgInterval = PBField.initUInt32(0);
    public final PBUInt32Field reportLevel = PBField.initUInt32(0);
    public final PBUInt32Field reportLevelTime = PBField.initUInt32(0);
}
