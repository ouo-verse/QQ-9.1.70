package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMBattleResult extends MessageMicro<QsmDataOuterClass$QSMBattleResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{"game_type", "race_game_play", "map_id", "winning_camp", "game_time", "game_finish_time", "player_battle_result"}, new Object[]{0, 0, 0L, 0, 0, 0L, null}, QsmDataOuterClass$QSMBattleResult.class);
    public final PBInt32Field game_type = PBField.initInt32(0);
    public final PBInt32Field race_game_play = PBField.initInt32(0);
    public final PBUInt64Field map_id = PBField.initUInt64(0);
    public final PBRepeatField<Integer> winning_camp = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field game_time = PBField.initInt32(0);
    public final PBInt64Field game_finish_time = PBField.initInt64(0);
    public final PBRepeatMessageField<QsmDataOuterClass$QSMPlayerBattleResult> player_battle_result = PBField.initRepeatMessage(QsmDataOuterClass$QSMPlayerBattleResult.class);
}
