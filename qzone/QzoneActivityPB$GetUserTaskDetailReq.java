package qzone;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$GetUserTaskDetailReq extends MessageMicro<QzoneActivityPB$GetUserTaskDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", CGNonAgeReport.EVENT_TYPE}, new Object[]{"", 0}, QzoneActivityPB$GetUserTaskDetailReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatField<Integer> event_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
