package trpc.yes.common;

import com.tencent.luggage.wxa.gf.y;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomCmdReq extends MessageMicro<YoloRoomOuterClass$YoloRoomCmdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 194, 202, 210, 218, 234, 274, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, y.CTRL_INDEX, 1202, 1610, 1626, 1658, 1842, 1850}, new String[]{"yolo_room_speaking_pos_change_cmd", "yolo_room_ready_status_change_cmd", "yolo_room_voice_switch_change_cmd", "yolo_room_modify_info_cmd", "yolo_room_speaking_pos_status_change_cmd", "yolo_room_greet_user_cmd", "yolo_room_complaint_user_cmd", "yolo_room_kick_out_speaking_cmd", "yolo_room_kick_out_room_cmd", "yolo_room_start_game_cmd", "yolo_room_join_game_cmd", "yolo_room_double_check_cmd", "yolo_room_invited_speaking_cmd", "yolo_room_apply_speaking_cmd", "yolo_room_agree_speaking_cmd", "yolo_room_speaking_user_update_cmd", "yolo_room_forbidden_speech_cmd", "yolo_room_reject_speaking_cmd", "yolo_room_send_gift_cmd", "yolo_room_battle_result_cmd", "yolo_game_room_remind_start_game_cmd", "yolo_smoba_room_chooce_hero", "yolo_smoba_room_remind_start_game_cmd", "yolo_smoba_room_change_role_cmd", "yolo_start_battle_ob_cmd", "yolo_close_battle_ob_cmd"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomCmdReq.class);
    public YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd yolo_room_speaking_pos_change_cmd = new YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd();
    public YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd yolo_room_ready_status_change_cmd = new YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd();
    public YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd yolo_room_voice_switch_change_cmd = new YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd();
    public YoloRoomOuterClass$YoloRoomModifyInfoCmd yolo_room_modify_info_cmd = new YoloRoomOuterClass$YoloRoomModifyInfoCmd();
    public YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd yolo_room_speaking_pos_status_change_cmd = new YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd();
    public YoloRoomOuterClass$YoloRoomGreetUserCmd yolo_room_greet_user_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomGreetUserCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomGreetUserCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"greet_uid", "greet_nick", "greet_user_id"}, new Object[]{0L, "", null}, YoloRoomOuterClass$YoloRoomGreetUserCmd.class);
        public final PBUInt64Field greet_uid = PBField.initUInt64(0);
        public final PBStringField greet_nick = PBField.initString("");
        public CommonOuterClass$QQUserId greet_user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloRoomComplaintUserCmd yolo_room_complaint_user_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomComplaintUserCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomComplaintUserCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uid", "reason", "user_id"}, new Object[]{0L, "", null}, YoloRoomOuterClass$YoloRoomComplaintUserCmd.class);
        public final PBUInt64Field uid = PBField.initUInt64(0);
        public final PBStringField reason = PBField.initString("");
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd yolo_room_kick_out_speaking_cmd = new YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd();
    public YoloRoomOuterClass$YoloRoomKickOutRoomCmd yolo_room_kick_out_room_cmd = new YoloRoomOuterClass$YoloRoomKickOutRoomCmd();
    public YoloRoomOuterClass$YoloRoomStartGameCmd yolo_room_start_game_cmd = new YoloRoomOuterClass$YoloRoomStartGameCmd();
    public YoloRoomOuterClass$YoloRoomJoinGameCmd yolo_room_join_game_cmd = new YoloRoomOuterClass$YoloRoomJoinGameCmd();
    public YoloRoomOuterClass$YoloRoomDoubleCheckCmd yolo_room_double_check_cmd = new YoloRoomOuterClass$YoloRoomDoubleCheckCmd();
    public YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd yolo_room_invited_speaking_cmd = new YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd();
    public YoloRoomOuterClass$YoloRoomApplySpeakingCmd yolo_room_apply_speaking_cmd = new YoloRoomOuterClass$YoloRoomApplySpeakingCmd();
    public YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd yolo_room_agree_speaking_cmd = new YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd();
    public YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd yolo_room_speaking_user_update_cmd = new YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd();
    public YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd yolo_room_forbidden_speech_cmd = new YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd();
    public YoloRoomOuterClass$YoloRoomRejectSpeakingCmd yolo_room_reject_speaking_cmd = new YoloRoomOuterClass$YoloRoomRejectSpeakingCmd();
    public YoloRoomOuterClass$YoloRoomSendGiftCmd yolo_room_send_gift_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomSendGiftCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomSendGiftCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64, 74, 80, 90, 98, 104}, new String[]{"recv_user_id", "gift_id", "total_num", "bill_no", "base_num", "combo_seq", "scene_id", "gift_type", "gift_name", "combo_cnt", "client_str", "send_user_id_list", "gift_material_id"}, new Object[]{null, 0, 0, "", 0, 0, 0, 0, "", 0, "", null, 0}, YoloRoomOuterClass$YoloRoomSendGiftCmd.class);
        public CommonOuterClass$QQUserId recv_user_id = new CommonOuterClass$QQUserId();
        public final PBInt32Field gift_id = PBField.initInt32(0);
        public final PBInt32Field total_num = PBField.initInt32(0);
        public final PBStringField bill_no = PBField.initString("");
        public final PBInt32Field base_num = PBField.initInt32(0);
        public final PBUInt32Field combo_seq = PBField.initUInt32(0);
        public final PBUInt32Field scene_id = PBField.initUInt32(0);
        public final PBUInt32Field gift_type = PBField.initUInt32(0);
        public final PBStringField gift_name = PBField.initString("");
        public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
        public final PBStringField client_str = PBField.initString("");
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> send_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
        public final PBInt32Field gift_material_id = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloRoomBattleResultCmd yolo_room_battle_result_cmd = new MessageMicro<YoloRoomOuterClass$YoloRoomBattleResultCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomBattleResultCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"smoba_battle_result", "pubg_settle_data", "qsm_battle_result", "cfm_battle_result", "codm_team_settle_data"}, new Object[]{null, null, null, null, null}, YoloRoomOuterClass$YoloRoomBattleResultCmd.class);
        public YoloBattleSmobaOuterClass$YoloSmobaBattleResult smoba_battle_result = new YoloBattleSmobaOuterClass$YoloSmobaBattleResult();
        public YoloRoomOuterClass$YoloPubgSettleData pubg_settle_data = new YoloRoomOuterClass$YoloPubgSettleData();
        public QsmDataOuterClass$QSMBattleResult qsm_battle_result = new QsmDataOuterClass$QSMBattleResult();
        public CfmDataOuterClass$CFMBattleResult cfm_battle_result = new CfmDataOuterClass$CFMBattleResult();
        public CodmDataOuterClass$CODMTeamSettleEvent codm_team_settle_data = new CodmDataOuterClass$CODMTeamSettleEvent();
    };
    public YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd yolo_game_room_remind_start_game_cmd = new YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd();
    public YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd yolo_smoba_room_chooce_hero = new YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd();
    public YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd yolo_smoba_room_remind_start_game_cmd = new YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd();
    public YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd yolo_smoba_room_change_role_cmd = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"role_id", "role_abs_info", "role_info"}, new Object[]{null, null, null}, YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd.class);
        public GameDataServerOuterClass$GameRoleId role_id = new GameDataServerOuterClass$GameRoleId();
        public GameDataServerOuterClass$GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass$GameRoleAbsInfo();
        public GameDataServerOuterClass$GameRoleInfo role_info = new GameDataServerOuterClass$GameRoleInfo();
    };
    public YoloRoomOuterClass$YoloStartBattleOBCmd yolo_start_battle_ob_cmd = new MessageMicro<YoloRoomOuterClass$YoloStartBattleOBCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloStartBattleOBCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"device_id", "yolo_battle_id"}, new Object[]{"", 0L}, YoloRoomOuterClass$YoloStartBattleOBCmd.class);
        public final PBStringField device_id = PBField.initString("");
        public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    };
    public YoloRoomOuterClass$YoloCloseBattleOBCmd yolo_close_battle_ob_cmd = new MessageMicro<YoloRoomOuterClass$YoloCloseBattleOBCmd>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloCloseBattleOBCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ob_id", "yolo_battle_id"}, new Object[]{0L, 0L}, YoloRoomOuterClass$YoloCloseBattleOBCmd.class);
        public final PBInt64Field ob_id = PBField.initInt64(0);
        public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    };
}
