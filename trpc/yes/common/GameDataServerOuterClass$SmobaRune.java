package trpc.yes.common;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SmobaRune extends MessageMicro<GameDataServerOuterClass$SmobaRune> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 66}, new String[]{"rune_id", "title", "name", "cate", "level", "comm_attr", WidgetCacheConstellationData.NUM, "icon"}, new Object[]{0, "", "", "", 0, null, 0, ""}, GameDataServerOuterClass$SmobaRune.class);
    public final PBInt32Field rune_id = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<String> cate = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaCommAttr> comm_attr = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaCommAttr.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
}
