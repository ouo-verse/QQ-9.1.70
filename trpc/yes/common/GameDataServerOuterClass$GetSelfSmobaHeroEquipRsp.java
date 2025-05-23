package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetSelfSmobaHeroEquipRsp extends MessageMicro<GameDataServerOuterClass$GetSelfSmobaHeroEquipRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"equip_configs"}, new Object[]{null}, GameDataServerOuterClass$GetSelfSmobaHeroEquipRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaEquipConfig> equip_configs = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaEquipConfig.class);
}
