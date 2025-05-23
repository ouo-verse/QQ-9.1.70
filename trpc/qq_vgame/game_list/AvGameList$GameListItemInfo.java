package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import trpc.qq_vgame.common.AvGameCommon$GameInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$GameListItemInfo extends MessageMicro<AvGameList$GameListItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 96, 106, 114, 122, 130, 138, 144, 154, 162, 168, 176, 186, 192, 200, 210}, new String[]{"game_type", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_desc", "backgroup_pic_url", "game_info", "prepare_pic_url", "prepare_pic_tp_url", QzoneCameraConst.Tag.ARG_PARAM_MUSIC_NAME, "status", "online_time", "prepare_wording", "offline_time", "game_name_url", "answer_right_pic_url", "game_over_pic_url", "tips_one_line_pic_url", "tips_two_line_pic_url", "total_player_num", "backgroup_small_pic_url", "answer_right_pic_url_new", "operation_type", "player_list", "activity_background_url", "activity_background_start", "activity_background_end", "collaborator_logo_url"}, new Object[]{0, "", "", "", null, "", "", "", 0, 0L, "", 0L, "", "", "", "", "", 0L, "", "", 0, 0L, "", 0, 0, ""}, AvGameList$GameListItemInfo.class);
    public final PBEnumField game_type = PBField.initEnum(0);
    public final PBStringField game_name = PBField.initString("");
    public final PBStringField game_desc = PBField.initString("");
    public final PBStringField backgroup_pic_url = PBField.initString("");
    public AvGameCommon$GameInfo game_info = new AvGameCommon$GameInfo();
    public final PBStringField prepare_pic_url = PBField.initString("");
    public final PBStringField prepare_pic_tp_url = PBField.initString("");
    public final PBStringField music_name = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt64Field online_time = PBField.initUInt64(0);
    public final PBStringField prepare_wording = PBField.initString("");
    public final PBUInt64Field offline_time = PBField.initUInt64(0);
    public final PBStringField game_name_url = PBField.initString("");
    public final PBStringField answer_right_pic_url = PBField.initString("");
    public final PBStringField game_over_pic_url = PBField.initString("");
    public final PBStringField tips_one_line_pic_url = PBField.initString("");
    public final PBStringField tips_two_line_pic_url = PBField.initString("");
    public final PBUInt64Field total_player_num = PBField.initUInt64(0);
    public final PBStringField backgroup_small_pic_url = PBField.initString("");
    public final PBStringField answer_right_pic_url_new = PBField.initString("");
    public final PBUInt32Field operation_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> player_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField activity_background_url = PBField.initString("");
    public final PBUInt32Field activity_background_start = PBField.initUInt32(0);
    public final PBUInt32Field activity_background_end = PBField.initUInt32(0);
    public final PBStringField collaborator_logo_url = PBField.initString("");
}
