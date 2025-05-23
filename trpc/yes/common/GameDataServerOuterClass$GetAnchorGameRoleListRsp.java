package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetAnchorGameRoleListRsp extends MessageMicro<GameDataServerOuterClass$GetAnchorGameRoleListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"equip_status", "role_list"}, new Object[]{0, null}, GameDataServerOuterClass$GetAnchorGameRoleListRsp.class);
    public final PBInt32Field equip_status = PBField.initInt32(0);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaGameRoleAbsInfo> role_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaGameRoleAbsInfo.class);
}
