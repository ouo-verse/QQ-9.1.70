package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$SwitchRoleReq extends MessageMicro<UserProxyCmdOuterClass$SwitchRoleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"user_id", "host_user_id", "game_id", "role", "role_index"}, new Object[]{"", "", "", "", 0}, UserProxyCmdOuterClass$SwitchRoleReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField host_user_id = PBField.initString("");
    public final PBStringField game_id = PBField.initString("");
    public final PBStringField role = PBField.initString("");
    public final PBInt32Field role_index = PBField.initInt32(0);
}
