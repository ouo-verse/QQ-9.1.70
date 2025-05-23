package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$TryLockWorkerRsp extends MessageMicro<UserProxyCmdOuterClass$TryLockWorkerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"request_id"}, new Object[]{""}, UserProxyCmdOuterClass$TryLockWorkerRsp.class);
    public final PBStringField request_id = PBField.initString("");
}
