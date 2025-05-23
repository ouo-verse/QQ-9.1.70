package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$GetNearbyChatSigReq extends MessageMicro<UserProxyCmdOuterClass$GetNearbyChatSigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"from_tiny_id", "to_tiny_id"}, new Object[]{0L, 0L}, UserProxyCmdOuterClass$GetNearbyChatSigReq.class);
    public final PBUInt64Field from_tiny_id = PBField.initUInt64(0);
    public final PBUInt64Field to_tiny_id = PBField.initUInt64(0);
}
