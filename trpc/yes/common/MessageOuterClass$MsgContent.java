package trpc.yes.common;

import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$MsgContent extends MessageMicro<MessageOuterClass$MsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 386, 442, P2VGlobalConfig.WATER_MARKER_WIDTH, 522, 530, 634, 642, 650, 658, 666, 674, 682, 690, 698, 706, 714, QVipServiceAccountFolderProcessor.CMD, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH, 738, 746, 754}, new String[]{"text_msg", "yolo_room_action_msg", "share_yolo_room_msg", "yolo_room_rotate_msg", "yolo_room_new_data_push_msg", "at_user_msg", "qq_user_info_msg", "gift_msg", "user_info_modify_notify_msg", "anchor_equip_status_notify_msg", "anchor_premades_team_msg", "share_ark_msg", "kpl_schedule_modify_notify_msg", "anchor_room_info_msg", "anchor_room_bullet_screen_msg", "live_room_lottery_result_msg", "timi_emo_msg", "live_room_enter_game_room_msg", "live_room_update_team_info_msg", "anchor_charge_msg", "pendant_msg", "power_redpacket_lottery_result_msg"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, MessageOuterClass$MsgContent.class);
    public MessageOuterClass$TextMsg text_msg = new MessageOuterClass$TextMsg();
    public MessageOuterClass$YoloRoomRotateMsg yolo_room_rotate_msg = new MessageOuterClass$YoloRoomRotateMsg();
    public MessageOuterClass$YoloRoomActionMsg yolo_room_action_msg = new MessageOuterClass$YoloRoomActionMsg();
    public PremadesTeamServerOuterClass$ShareYoloRoomMsg share_yolo_room_msg = new PremadesTeamServerOuterClass$ShareYoloRoomMsg();
    public MessageOuterClass$YoloRoomNewDataPushMsg yolo_room_new_data_push_msg = new MessageOuterClass$YoloRoomNewDataPushMsg();
    public MessageOuterClass$AtUserMsg at_user_msg = new MessageOuterClass$AtUserMsg();
    public MessageOuterClass$QQUserInfoMsg qq_user_info_msg = new MessageOuterClass$QQUserInfoMsg();
    public MessageOuterClass$GiftMsg gift_msg = new MessageOuterClass$GiftMsg();
    public MessageOuterClass$UserInfoModifyNotifyMsg user_info_modify_notify_msg = new MessageOuterClass$UserInfoModifyNotifyMsg();
    public MessageOuterClass$AnchorEquipStatusNotifyMsg anchor_equip_status_notify_msg = new MessageOuterClass$AnchorEquipStatusNotifyMsg();
    public MessageOuterClass$AnchorPremadesTeamMsg anchor_premades_team_msg = new MessageOuterClass$AnchorPremadesTeamMsg();
    public MessageOuterClass$ShareArkMsg share_ark_msg = new MessageOuterClass$ShareArkMsg();
    public MessageOuterClass$KPLScheduleModifyNotifyMsg kpl_schedule_modify_notify_msg = new MessageOuterClass$KPLScheduleModifyNotifyMsg();
    public MessageOuterClass$AnchorRoomInfoMsg anchor_room_info_msg = new MessageMicro<MessageOuterClass$AnchorRoomInfoMsg>() { // from class: trpc.yes.common.MessageOuterClass$AnchorRoomInfoMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MessageOuterClass$AnchorRoomInfoMsg.class);
    };
    public MessageOuterClass$AnchorRoomBulletScreenMsg anchor_room_bullet_screen_msg = new MessageOuterClass$AnchorRoomBulletScreenMsg();
    public MessageOuterClass$LiveRoomLotteryResultMsg live_room_lottery_result_msg = new MessageOuterClass$LiveRoomLotteryResultMsg();
    public MessageOuterClass$TimiEmoMsg timi_emo_msg = new MessageOuterClass$TimiEmoMsg();
    public MessageOuterClass$LiveRoomEnterGameTeamMsg live_room_enter_game_room_msg = new MessageOuterClass$LiveRoomEnterGameTeamMsg();
    public MessageOuterClass$LiveRoomUpdateTeamInfoMsg live_room_update_team_info_msg = new MessageOuterClass$LiveRoomUpdateTeamInfoMsg();
    public MessageOuterClass$AnchorChargeMsg anchor_charge_msg = new MessageOuterClass$AnchorChargeMsg();
    public PendantOuterClass$PendantMsg pendant_msg = new PendantOuterClass$PendantMsg();
    public MessageOuterClass$PowerRedpacketLotteryResultMsg power_redpacket_lottery_result_msg = new MessageOuterClass$PowerRedpacketLotteryResultMsg();
}
