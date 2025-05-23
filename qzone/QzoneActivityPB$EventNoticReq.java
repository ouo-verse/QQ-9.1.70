package qzone;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$EventNoticReq extends MessageMicro<QzoneActivityPB$EventNoticReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 58, 66, 74, 80}, new String[]{CGNonAgeReport.EVENT_TYPE, "tid", "tid_owner_uid", "tid_create_time", "comment_id", "shuoshuo_text", "ext_infos", "event_uid", "event_time"}, new Object[]{0, "", "", 0L, "", ByteStringMicro.EMPTY, null, "", 0L}, QzoneActivityPB$EventNoticReq.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBStringField tid = PBField.initString("");
    public final PBStringField tid_owner_uid = PBField.initString("");
    public final PBInt64Field tid_create_time = PBField.initInt64(0);
    public final PBStringField comment_id = PBField.initString("");
    public final PBBytesField shuoshuo_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<QzoneActivityPB$KVInfo> ext_infos = PBField.initRepeatMessage(QzoneActivityPB$KVInfo.class);
    public final PBStringField event_uid = PBField.initString("");
    public final PBInt64Field event_time = PBField.initInt64(0);
}
