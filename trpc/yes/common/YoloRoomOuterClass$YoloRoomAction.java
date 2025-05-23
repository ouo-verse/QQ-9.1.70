package trpc.yes.common;

import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomAction extends MessageMicro<YoloRoomOuterClass$YoloRoomAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 90, 98, 106, 114, 122, 130, 146, 154, 162, 170, 178, 194, 202, 210, 218, 234, 274, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, h.CTRL_INDEX, 858, 866, y.CTRL_INDEX, 1202, 1210, SubAccountBindActivity.ERROR_ACCOUNT_NOT_EXIST, 1226, 1234, 1610, 1626, 1634, 1658, 2010, 2018, 2082}, new String[]{"action_id", "action_time", "action_type", "client_seq_id", "yolo_room_speaking_pos_change_action", "yolo_room_ready_status_change_action", "yolo_room_voice_switch_change_action", "yolo_room_modify_info_action", "yolo_room_speaking_pos_status_change_action", "yolo_room_greet_user_action", "yolo_room_kick_out_speaking_action", "yolo_room_kick_out_room_action", "yolo_room_start_game_action", "yolo_room_join_game_action", "yolo_room_double_check_action", "yolo_room_invited_speaking_action", "yolo_room_apply_speaking_action", "yolo_room_agree_speaking_action", "yolo_room_speaking_user_status_update_action", "yolo_room_forbidden_speech_action", "yolo_room_reject_speaking_action", "yolo_room_enter_action", "yolo_room_leave_action", "yolo_room_send_gift_action", "yolo_room_speaking_pos_list_init_action", "yolo_room_close_game_action", "yolo_room_update_game_route_info_action", "yolo_room_battle_result_action", "yolo_game_room_remind_owner_start_game_action", "yolo_game_room_owner_change_action", "yolo_game_room_team_create_tips_action", "yolo_game_room_send_notice_action", "yolo_game_room_settle_gift_notice_action", "yolo_smoba_room_chooce_hero_action", "yolo_smoba_room_remind_owner_start_game_action", "yolo_smoba_room_remind_user_start_game_action", "yolo_smoba_room_change_role_action", "yolo_smoba_room_owner_change_action", "yolo_smoba_room_battle_result_action", "yolo_battle_ob_status_change_action"}, new Object[]{0L, 0L, 11, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomAction.class);
    public final PBUInt64Field action_id = PBField.initUInt64(0);
    public final PBUInt64Field action_time = PBField.initUInt64(0);
    public final PBEnumField action_type = PBField.initEnum(11);
    public final PBUInt64Field client_seq_id = PBField.initUInt64(0);
    public YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction yolo_room_speaking_pos_change_action = new YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction();
    public YoloRoomOuterClass$YoloRoomReadyStatusChangeAction yolo_room_ready_status_change_action = new YoloRoomOuterClass$YoloRoomReadyStatusChangeAction();
    public YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction yolo_room_voice_switch_change_action = new YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction();
    public YoloRoomOuterClass$YoloRoomModifyInfoAction yolo_room_modify_info_action = new YoloRoomOuterClass$YoloRoomModifyInfoAction();
    public YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction yolo_room_speaking_pos_status_change_action = new YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction();
    public YoloRoomOuterClass$YoloRoomGreetUserAction yolo_room_greet_user_action = new MessageMicro<YoloRoomOuterClass$YoloRoomGreetUserAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomGreetUserAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_id", "greet_user_id", "greet_words"}, new Object[]{null, null, ""}, YoloRoomOuterClass$YoloRoomGreetUserAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId greet_user_id = new CommonOuterClass$QQUserId();
        public final PBStringField greet_words = PBField.initString("");
    };
    public YoloRoomOuterClass$YoloRoomKickOutSpeakingAction yolo_room_kick_out_speaking_action = new YoloRoomOuterClass$YoloRoomKickOutSpeakingAction();
    public YoloRoomOuterClass$YoloRoomKickOutRoomAction yolo_room_kick_out_room_action = new YoloRoomOuterClass$YoloRoomKickOutRoomAction();
    public YoloRoomOuterClass$YoloRoomStartGameAction yolo_room_start_game_action = new YoloRoomOuterClass$YoloRoomStartGameAction();
    public YoloRoomOuterClass$YoloRoomJoinGameAction yolo_room_join_game_action = new YoloRoomOuterClass$YoloRoomJoinGameAction();
    public YoloRoomOuterClass$YoloRoomDoubleCheckAction yolo_room_double_check_action = new YoloRoomOuterClass$YoloRoomDoubleCheckAction();
    public YoloRoomOuterClass$YoloRoomInvitedSpeakingAction yolo_room_invited_speaking_action = new YoloRoomOuterClass$YoloRoomInvitedSpeakingAction();
    public YoloRoomOuterClass$YoloRoomApplySpeakingAction yolo_room_apply_speaking_action = new YoloRoomOuterClass$YoloRoomApplySpeakingAction();
    public YoloRoomOuterClass$YoloRoomAgreeSpeakingAction yolo_room_agree_speaking_action = new YoloRoomOuterClass$YoloRoomAgreeSpeakingAction();
    public YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction yolo_room_speaking_user_status_update_action = new YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction();
    public YoloRoomOuterClass$YoloRoomForbiddenSpeechAction yolo_room_forbidden_speech_action = new YoloRoomOuterClass$YoloRoomForbiddenSpeechAction();
    public YoloRoomOuterClass$YoloRoomRejectSpeakingAction yolo_room_reject_speaking_action = new MessageMicro<YoloRoomOuterClass$YoloRoomRejectSpeakingAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomRejectSpeakingAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomRejectSpeakingAction.class);
        public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    };
    public YoloRoomOuterClass$YoloRoomEnterAction yolo_room_enter_action = new YoloRoomOuterClass$YoloRoomEnterAction();
    public YoloRoomOuterClass$YoloRoomLeaveAction yolo_room_leave_action = new YoloRoomOuterClass$YoloRoomLeaveAction();
    public YoloRoomOuterClass$YoloRoomSendGiftAction yolo_room_send_gift_action = new MessageMicro<YoloRoomOuterClass$YoloRoomSendGiftAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloRoomSendGiftAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 74, 80, 88, 96, 104, 114, 122}, new String[]{"send_user_id", "recv_user_id", "gift_id", "total_num", "bill_no", "base_num", QZoneDTLoginReporter.SCHEMA, AudienceReportConst.ROOM_ID, "gift_name", "combo_seq", "scene_id", "gift_type", "combo_cnt", "client_str", "send_user_id_list"}, new Object[]{null, null, 0, 0, "", 0, "", 0L, "", 0, 0, 0, 0, "", null}, YoloRoomOuterClass$YoloRoomSendGiftAction.class);
        public CommonOuterClass$QQUserId send_user_id = new CommonOuterClass$QQUserId();
        public CommonOuterClass$QQUserId recv_user_id = new CommonOuterClass$QQUserId();
        public final PBInt32Field gift_id = PBField.initInt32(0);
        public final PBInt32Field total_num = PBField.initInt32(0);
        public final PBStringField bill_no = PBField.initString("");
        public final PBInt32Field base_num = PBField.initInt32(0);
        public final PBStringField schema = PBField.initString("");
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField gift_name = PBField.initString("");
        public final PBUInt32Field combo_seq = PBField.initUInt32(0);
        public final PBUInt32Field scene_id = PBField.initUInt32(0);
        public final PBUInt32Field gift_type = PBField.initUInt32(0);
        public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
        public final PBStringField client_str = PBField.initString("");
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> send_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    };
    public YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction yolo_room_speaking_pos_list_init_action = new YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction();
    public YoloRoomOuterClass$YoloRoomCloseGameAction yolo_room_close_game_action = new YoloRoomOuterClass$YoloRoomCloseGameAction();
    public YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction yolo_room_update_game_route_info_action = new YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction();
    public YoloRoomOuterClass$YoloRoomBattleResultAction yolo_room_battle_result_action = new YoloRoomOuterClass$YoloRoomBattleResultAction();
    public YoloRoomOuterClass$YoloGameRoomRemindOwnerStartGameAction yolo_game_room_remind_owner_start_game_action = new YoloRoomOuterClass$YoloGameRoomRemindOwnerStartGameAction();
    public YoloRoomOuterClass$YoloGameRoomOwnerChangeAction yolo_game_room_owner_change_action = new YoloRoomOuterClass$YoloGameRoomOwnerChangeAction();
    public YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction yolo_game_room_team_create_tips_action = new YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction();
    public YoloRoomOuterClass$YokoGameRoomSendNoticeAction yolo_game_room_send_notice_action = new YoloRoomOuterClass$YokoGameRoomSendNoticeAction();
    public YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction yolo_game_room_settle_gift_notice_action = new YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction();
    public YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction yolo_smoba_room_chooce_hero_action = new YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction();
    public YoloRoomOuterClass$YoloSmobaRoomRemindOwnerStartGameAction yolo_smoba_room_remind_owner_start_game_action = new YoloRoomOuterClass$YoloSmobaRoomRemindOwnerStartGameAction();
    public YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction yolo_smoba_room_remind_user_start_game_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id_list"}, new Object[]{null}, YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction.class);
        public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    };
    public YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction yolo_smoba_room_change_role_action = new MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloSmobaRoomChangeRoleAction.class);
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    };
    public YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction yolo_smoba_room_owner_change_action = new YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction();
    public YoloRoomOuterClass$YoloSmobaRoomBattleResultAction yolo_smoba_room_battle_result_action = new YoloRoomOuterClass$YoloSmobaRoomBattleResultAction();
    public YoloRoomOuterClass$YoloBattleOBStatusChangeAction yolo_battle_ob_status_change_action = new YoloRoomOuterClass$YoloBattleOBStatusChangeAction();
}
