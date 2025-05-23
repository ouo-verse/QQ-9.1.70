package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CfmDataOuterClass$CFMBattleResult extends MessageMicro<CfmDataOuterClass$CFMBattleResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 88}, new String[]{"game_mode", "map_id", "match_service_module", "winning_camp", "game_time", "game_finish_time", "player_battle_result", "defender_kill_cnt", "attacker_kill_cnt", "defender_win_round", "attacker_win_round"}, new Object[]{0, 0L, 0, 0, 0, 0L, null, 0, 0, 0, 0}, CfmDataOuterClass$CFMBattleResult.class);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBUInt64Field map_id = PBField.initUInt64(0);
    public final PBInt32Field match_service_module = PBField.initInt32(0);
    public final PBInt32Field winning_camp = PBField.initInt32(0);
    public final PBInt32Field game_time = PBField.initInt32(0);
    public final PBUInt64Field game_finish_time = PBField.initUInt64(0);
    public final PBRepeatMessageField<CfmDataOuterClass$CFMPlayerBattleResult> player_battle_result = PBField.initRepeatMessage(CfmDataOuterClass$CFMPlayerBattleResult.class);
    public final PBUInt32Field defender_kill_cnt = PBField.initUInt32(0);
    public final PBUInt32Field attacker_kill_cnt = PBField.initUInt32(0);
    public final PBUInt32Field defender_win_round = PBField.initUInt32(0);
    public final PBUInt32Field attacker_win_round = PBField.initUInt32(0);
}
