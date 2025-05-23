package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$TerminateTaskReq extends MessageMicro<SuperResolution$TerminateTaskReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"task_id"}, new Object[]{""}, SuperResolution$TerminateTaskReq.class);
    public final PBStringField task_id = PBField.initString("");
}
