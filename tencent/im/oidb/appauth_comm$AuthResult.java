package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$AuthResult extends MessageMicro<appauth_comm$AuthResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"auth_group", "auth_result"}, new Object[]{null, 0}, appauth_comm$AuthResult.class);
    public appauth_comm$AuthGroupTuple auth_group = new appauth_comm$AuthGroupTuple();
    public final PBUInt32Field auth_result = PBField.initUInt32(0);
}
