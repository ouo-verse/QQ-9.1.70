package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMIDIPPlayerGameInfo extends MessageMicro<QsmDataOuterClass$QSMIDIPPlayerGameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 88, 96, 104}, new String[]{"speed_single_game", "prob_single_game", "speed_team_game", "prob_team_game", "encounter_speed_game", "encounter_prob_game", "skate_single_game", "normal_speed_match_count", "ladder_speed_match_count", "encounter_speed_match_count", "encounter_prob_match_count", "normal_prop_match_count", "ladder_prop_match_count"}, new Object[]{null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0}, QsmDataOuterClass$QSMIDIPPlayerGameInfo.class);
    public QsmDataOuterClass$QSMIDIPSingleGameStatistics speed_single_game = new MessageMicro<QsmDataOuterClass$QSMIDIPSingleGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPSingleGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"match_count", "complete_count", "add_together_game_index", "max_continue_complete_count", "all_kill_count"}, new Object[]{0, 0, 0L, 0, 0}, QsmDataOuterClass$QSMIDIPSingleGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field complete_count = PBField.initUInt32(0);
        public final PBUInt64Field add_together_game_index = PBField.initUInt64(0);
        public final PBUInt32Field max_continue_complete_count = PBField.initUInt32(0);
        public final PBUInt32Field all_kill_count = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMIDIPSingleGameStatistics prob_single_game = new MessageMicro<QsmDataOuterClass$QSMIDIPSingleGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPSingleGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"match_count", "complete_count", "add_together_game_index", "max_continue_complete_count", "all_kill_count"}, new Object[]{0, 0, 0L, 0, 0}, QsmDataOuterClass$QSMIDIPSingleGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field complete_count = PBField.initUInt32(0);
        public final PBUInt64Field add_together_game_index = PBField.initUInt64(0);
        public final PBUInt32Field max_continue_complete_count = PBField.initUInt32(0);
        public final PBUInt32Field all_kill_count = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMIDIPTeamGameStatistics speed_team_game = new MessageMicro<QsmDataOuterClass$QSMIDIPTeamGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPTeamGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"match_count", "win_count", "max_continue_win_count", "mvp_count", "all_win_count", "num_1_count"}, new Object[]{0, 0, 0, 0, 0, 0}, QsmDataOuterClass$QSMIDIPTeamGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field win_count = PBField.initUInt32(0);
        public final PBUInt32Field max_continue_win_count = PBField.initUInt32(0);
        public final PBUInt32Field mvp_count = PBField.initUInt32(0);
        public final PBUInt32Field all_win_count = PBField.initUInt32(0);
        public final PBUInt32Field num_1_count = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMIDIPTeamGameStatistics prob_team_game = new MessageMicro<QsmDataOuterClass$QSMIDIPTeamGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPTeamGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"match_count", "win_count", "max_continue_win_count", "mvp_count", "all_win_count", "num_1_count"}, new Object[]{0, 0, 0, 0, 0, 0}, QsmDataOuterClass$QSMIDIPTeamGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field win_count = PBField.initUInt32(0);
        public final PBUInt32Field max_continue_win_count = PBField.initUInt32(0);
        public final PBUInt32Field mvp_count = PBField.initUInt32(0);
        public final PBUInt32Field all_win_count = PBField.initUInt32(0);
        public final PBUInt32Field num_1_count = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMIDIPEncounterGameStatistics encounter_speed_game = new MessageMicro<QsmDataOuterClass$QSMIDIPEncounterGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPEncounterGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"match_count", "complete_count", "max_continue_complete_count", "team_first_count"}, new Object[]{0, 0, 0, 0}, QsmDataOuterClass$QSMIDIPEncounterGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field complete_count = PBField.initUInt32(0);
        public final PBUInt32Field max_continue_complete_count = PBField.initUInt32(0);
        public final PBUInt32Field team_first_count = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMIDIPEncounterGameStatistics encounter_prob_game = new MessageMicro<QsmDataOuterClass$QSMIDIPEncounterGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPEncounterGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"match_count", "complete_count", "max_continue_complete_count", "team_first_count"}, new Object[]{0, 0, 0, 0}, QsmDataOuterClass$QSMIDIPEncounterGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field complete_count = PBField.initUInt32(0);
        public final PBUInt32Field max_continue_complete_count = PBField.initUInt32(0);
        public final PBUInt32Field team_first_count = PBField.initUInt32(0);
    };
    public QsmDataOuterClass$QSMIDIPSkateSingleGameStatistics skate_single_game = new MessageMicro<QsmDataOuterClass$QSMIDIPSkateSingleGameStatistics>() { // from class: trpc.yes.common.QsmDataOuterClass$QSMIDIPSkateSingleGameStatistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"match_count", "complete_count", "add_together_game_index", "max_continue_complete_count", "all_kill_count"}, new Object[]{0, 0, 0L, 0, 0}, QsmDataOuterClass$QSMIDIPSkateSingleGameStatistics.class);
        public final PBUInt32Field match_count = PBField.initUInt32(0);
        public final PBUInt32Field complete_count = PBField.initUInt32(0);
        public final PBUInt64Field add_together_game_index = PBField.initUInt64(0);
        public final PBUInt32Field max_continue_complete_count = PBField.initUInt32(0);
        public final PBUInt32Field all_kill_count = PBField.initUInt32(0);
    };
    public final PBUInt32Field normal_speed_match_count = PBField.initUInt32(0);
    public final PBUInt32Field ladder_speed_match_count = PBField.initUInt32(0);
    public final PBUInt32Field encounter_speed_match_count = PBField.initUInt32(0);
    public final PBUInt32Field encounter_prob_match_count = PBField.initUInt32(0);
    public final PBUInt32Field normal_prop_match_count = PBField.initUInt32(0);
    public final PBUInt32Field ladder_prop_match_count = PBField.initUInt32(0);
}
