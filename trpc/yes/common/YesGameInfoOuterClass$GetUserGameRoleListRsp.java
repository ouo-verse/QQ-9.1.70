package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GetUserGameRoleListRsp extends MessageMicro<YesGameInfoOuterClass$GetUserGameRoleListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"role_list", "openid"}, new Object[]{null, ""}, YesGameInfoOuterClass$GetUserGameRoleListRsp.class);
    public final PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAbsInfo> role_list = PBField.initRepeatMessage(YesGameInfoOuterClass$YesGameRoleAbsInfo.class);
    public final PBStringField openid = PBField.initString("");
}
