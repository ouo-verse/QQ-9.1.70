package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.raft.codegenmeta.utils.Constants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$QueryTasksRsp extends MessageMicro<SuperResolution$QueryTasksRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{Constants.Raft.TASKS, "attach_info", PictureConst.KEY_HAS_MORE}, new Object[]{null, "", Boolean.FALSE}, SuperResolution$QueryTasksRsp.class);
    public final PBRepeatMessageField<SuperResolution$SRTask> tasks = PBField.initRepeatMessage(SuperResolution$SRTask.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
}
