package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.state.report.SquareReportConst;
import cooperation.qzone.report.QZonePushReporter;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$DatongReportData extends MessageMicro<QzoneActivityPB$DatongReportData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"event_code", QZonePushReporter.EVENT_CODE_TYPE1, QZonePushReporter.EVENT_CODE_TYPE2, QZonePushReporter.EVENT_CODE_TYPE3, "event_time", "uin", "touin", "uid", SquareReportConst.Key.KEY_ZPLAN_TO_UID, QZonePushReporter.EVENT_VALUE, "qua"}, new Object[]{"", "", "", "", "", "", "", "", "", "", ""}, QzoneActivityPB$DatongReportData.class);
    public final PBStringField event_code = PBField.initString("");
    public final PBStringField event_code_type1 = PBField.initString("");
    public final PBStringField event_code_type2 = PBField.initString("");
    public final PBStringField event_code_type3 = PBField.initString("");
    public final PBStringField event_time = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBStringField touin = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField touid = PBField.initString("");
    public final PBStringField event_value = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
}
