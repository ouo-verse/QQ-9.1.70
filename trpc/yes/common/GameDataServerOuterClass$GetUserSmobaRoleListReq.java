package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetUserSmobaRoleListReq extends MessageMicro<GameDataServerOuterClass$GetUserSmobaRoleListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uid"}, new Object[]{0L}, GameDataServerOuterClass$GetUserSmobaRoleListReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
