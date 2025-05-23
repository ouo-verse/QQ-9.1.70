package qzone;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ScoreInfo extends MessageMicro<QzoneActivityPB$ScoreInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CGNonAgeReport.EVENT_TYPE, "items"}, new Object[]{0, null}, QzoneActivityPB$ScoreInfo.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBRepeatMessageField<QzoneActivityPB$EventItem> items = PBField.initRepeatMessage(QzoneActivityPB$EventItem.class);
}
