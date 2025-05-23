package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.raft.codegenmeta.utils.Constants;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$QueryUserTaskRsp extends MessageMicro<QzoneActivityPB$QueryUserTaskRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{Constants.Raft.TASKS}, new Object[]{null}, QzoneActivityPB$QueryUserTaskRsp.class);
    public final PBRepeatMessageField<QzoneActivityPB$TaskInfo> tasks = PBField.initRepeatMessage(QzoneActivityPB$TaskInfo.class);
}
