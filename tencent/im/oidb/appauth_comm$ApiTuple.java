package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$ApiTuple extends MessageMicro<appauth_comm$ApiTuple> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"auth_group_type", "api_name"}, new Object[]{0, ""}, appauth_comm$ApiTuple.class);
    public final PBUInt32Field auth_group_type = PBField.initUInt32(0);
    public final PBStringField api_name = PBField.initString("");
}
