package qzone;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$TaskInfo extends MessageMicro<QzoneActivityPB$TaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{CGNonAgeReport.EVENT_TYPE, "name", "status", "desc"}, new Object[]{0, "", 0, ""}, QzoneActivityPB$TaskInfo.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
}
