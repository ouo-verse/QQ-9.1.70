package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SmobaGameMode extends MessageMicro<GameDataServerOuterClass$SmobaGameMode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 40, 48}, new String[]{"game_mode", "mode_name", "game_type", "min_player", "max_player"}, new Object[]{0, "", 0, 0, 0}, GameDataServerOuterClass$SmobaGameMode.class);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBStringField mode_name = PBField.initString("");
    public final PBInt32Field game_type = PBField.initInt32(0);
    public final PBInt32Field min_player = PBField.initInt32(0);
    public final PBInt32Field max_player = PBField.initInt32(0);
}
