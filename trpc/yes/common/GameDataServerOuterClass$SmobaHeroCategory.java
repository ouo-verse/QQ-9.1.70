package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SmobaHeroCategory extends MessageMicro<GameDataServerOuterClass$SmobaHeroCategory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"name", "hero_ids"}, new Object[]{"", 0}, GameDataServerOuterClass$SmobaHeroCategory.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<Integer> hero_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
