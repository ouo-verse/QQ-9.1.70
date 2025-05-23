package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp extends MessageMicro<PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public PremadesTeamServerOuterClass$AnchorGameInfo game_info = new PremadesTeamServerOuterClass$AnchorGameInfo();
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$TextShowInfo> text_show_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$TextShowInfo.class);
    public final PBStringField tips = PBField.initString("");
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
    public final PBInt32Field equip_setting_status = PBField.initInt32(0);
    public PremadesTeamServerOuterClass$YesGamePremadesTeamInfo team_info = new PremadesTeamServerOuterClass$YesGamePremadesTeamInfo();
    public final PBInt32Field play_together_status = PBField.initInt32(0);
    public final PBInt32Field equip_open_status = PBField.initInt32(0);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$RoomTabInfo> room_tab_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$RoomTabInfo.class);
    public final PBRepeatField<Long> duration_room_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$WebResourceInfo> web_resource_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$WebResourceInfo.class);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$FloatingIconInfo> floating_icon_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$FloatingIconInfo.class);
    public final PBInt32Field hide_nick_status = PBField.initInt32(0);
    public final PBInt32Field hide_warning = PBField.initInt32(0);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$GuideBubbleInfo> guide_bubbles = PBField.initRepeatMessage(PremadesTeamServerOuterClass$GuideBubbleInfo.class);
    public final PBInt32Field multi_channel_refresh_interval = PBField.initInt32(0);
    public final PBInt32Field push_interval = PBField.initInt32(0);
    public final PBBoolField floating_ball_flag = PBField.initBool(false);
    public final PBStringField default_tab_id = PBField.initString("");
    public YoloTeamOuterClass$YoloLiveTeamInfo live_team_info = new YoloTeamOuterClass$YoloLiveTeamInfo();
    public final PBBoolField bullet_screen_setting_flag = PBField.initBool(false);
    public final PBInt32Field one_live_status = PBField.initInt32(0);
    public final PBInt32Field yes_game_id = PBField.initInt32(0);
    public PremadesTeamServerOuterClass$NewPlayTogetherInfo new_play_together_info = new PremadesTeamServerOuterClass$NewPlayTogetherInfo();

    static {
        String[] strArr = {"game_info", "text_show_list", "tips", "refresh_interval", "equip_setting_status", "team_info", "play_together_status", "equip_open_status", AudienceReportConst.ANCHOR_ID, "room_tab_list", "duration_room_id_list", "room_type", "web_resource_list", "floating_icon_list", "hide_nick_status", "hide_warning", "guide_bubbles", "multi_channel_refresh_interval", "push_interval", "floating_ball_flag", "default_tab_id", "live_team_info", "bullet_screen_setting_flag", "one_live_status", "yes_game_id", "new_play_together_info"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56, 64, 74, 82, 88, 96, 106, 114, 120, 128, 138, 144, 152, 160, 170, 178, 184, 192, 200, 210}, strArr, new Object[]{null, null, "", 0, 0, null, 0, 0, "", null, 0L, 0, null, null, 0, 0, null, 0, 0, bool, "", null, bool, 0, 0, null}, PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp.class);
    }
}
