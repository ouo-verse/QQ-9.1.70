package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$BatchGetGameDefaultRoleRsp extends MessageMicro<GameDataServerOuterClass$BatchGetGameDefaultRoleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"role_list"}, new Object[]{null}, GameDataServerOuterClass$BatchGetGameDefaultRoleRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$UserDefaultRole> role_list = PBField.initRepeatMessage(GameDataServerOuterClass$UserDefaultRole.class);
}
