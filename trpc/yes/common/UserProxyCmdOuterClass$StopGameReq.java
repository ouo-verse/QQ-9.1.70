package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$StopGameReq extends MessageMicro<UserProxyCmdOuterClass$StopGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"user_id", "host_user_id"}, new Object[]{"", ""}, UserProxyCmdOuterClass$StopGameReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField host_user_id = PBField.initString("");
}
