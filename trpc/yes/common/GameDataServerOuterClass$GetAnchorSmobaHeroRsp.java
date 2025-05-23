package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetAnchorSmobaHeroRsp extends MessageMicro<GameDataServerOuterClass$GetAnchorSmobaHeroRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"hero_info", "category"}, new Object[]{null, null}, GameDataServerOuterClass$GetAnchorSmobaHeroRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$AnchorSmobaHeroInfo> hero_info = PBField.initRepeatMessage(GameDataServerOuterClass$AnchorSmobaHeroInfo.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaHeroCategory> category = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaHeroCategory.class);
}
