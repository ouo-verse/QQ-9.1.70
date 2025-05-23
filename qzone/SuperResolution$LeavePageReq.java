package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class SuperResolution$LeavePageReq extends MessageMicro<SuperResolution$LeavePageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"task_id"}, new Object[]{""}, SuperResolution$LeavePageReq.class);
    public final PBStringField task_id = PBField.initString("");
}
