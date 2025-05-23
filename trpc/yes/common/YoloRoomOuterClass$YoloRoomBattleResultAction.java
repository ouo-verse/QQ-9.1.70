package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomBattleResultAction extends MessageMicro<YoloRoomOuterClass$YoloRoomBattleResultAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"game_id", "smoba_battle_result_action", "pubg_battle_result_action", "qsm_battle_result_action", "cfm_battle_result_action", "codm_battle_result_action"}, new Object[]{0, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomBattleResultAction.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloSmobaRoomBattleResultAction smoba_battle_result_action = new YoloRoomOuterClass$YoloSmobaRoomBattleResultAction();
    public YoloRoomOuterClass$YoloPubgRoomBattleResultAction pubg_battle_result_action = new MessageMicro<YoloRoomOuterClass$YoloPubgRoomBattleResultAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloPubgRoomBattleResultAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"pubg_settle_data", "user_id_list", "battle_result_text"}, new Object[]{null, null, ""}, YoloRoomOuterClass$YoloPubgRoomBattleResultAction.class);
        public YoloRoomOuterClass$YoloPubgSettleData pubg_settle_data = new YoloRoomOuterClass$YoloPubgSettleData();
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
        public final PBRepeatField<String> battle_result_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public YoloRoomOuterClass$YoloQsmRoomBattleResultAction qsm_battle_result_action = new MessageMicro<YoloRoomOuterClass$YoloQsmRoomBattleResultAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloQsmRoomBattleResultAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"qsm_battle_result", "user_id_list", "battle_result_text"}, new Object[]{null, null, ""}, YoloRoomOuterClass$YoloQsmRoomBattleResultAction.class);
        public QsmDataOuterClass$QSMBattleResult qsm_battle_result = new QsmDataOuterClass$QSMBattleResult();
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
        public final PBRepeatField<String> battle_result_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public YoloRoomOuterClass$YoloCfmRoomBattleResultAction cfm_battle_result_action = new MessageMicro<YoloRoomOuterClass$YoloCfmRoomBattleResultAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCfmRoomBattleResultAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cfm_battle_result", "user_id_list", "battle_result_text"}, new Object[]{null, null, ""}, YoloRoomOuterClass$YoloCfmRoomBattleResultAction.class);
        public CfmDataOuterClass$CFMBattleResult cfm_battle_result = new CfmDataOuterClass$CFMBattleResult();
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
        public final PBRepeatField<String> battle_result_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public YoloRoomOuterClass$YoloCodmRoomBattleResultAction codm_battle_result_action = new MessageMicro<YoloRoomOuterClass$YoloCodmRoomBattleResultAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCodmRoomBattleResultAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"codm_team_settle_data", "user_id_list", "battle_result_text"}, new Object[]{null, null, ""}, YoloRoomOuterClass$YoloCodmRoomBattleResultAction.class);
        public CodmDataOuterClass$CODMTeamSettleEvent codm_team_settle_data = new CodmDataOuterClass$CODMTeamSettleEvent();
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
        public final PBRepeatField<String> battle_result_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
