package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$GetUserTaskDetailRsp extends MessageMicro<QzoneActivityPB$GetUserTaskDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, QzoneActivityPB$GetUserTaskDetailRsp.class);
    public final PBRepeatMessageField<QzoneActivityPB$ScoreInfo> list = PBField.initRepeatMessage(QzoneActivityPB$ScoreInfo.class);
}
