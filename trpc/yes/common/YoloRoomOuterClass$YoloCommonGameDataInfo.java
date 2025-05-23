package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloCommonGameDataInfo extends MessageMicro<YoloRoomOuterClass$YoloCommonGameDataInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field create_type = PBField.initInt32(0);
    public final PBInt32Field is_auto_dismiss = PBField.initInt32(0);
    public final PBInt32Field is_off_double_check = PBField.initInt32(0);
    public final PBUInt64Field base_room_id = PBField.initUInt64(0);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBStringField game_desc = PBField.initString("");
    public final PBStringField mode_name = PBField.initString("");
    public YoloRoomOuterClass$YoloGiftConfig gift_config = new YoloRoomOuterClass$YoloGiftConfig();
    public YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config = new YoloRoomOuterClass$QQLiveRoomConfig();
    public final PBRepeatMessageField<YoloRoomOuterClass$ListParam> list_param_list = PBField.initRepeatMessage(YoloRoomOuterClass$ListParam.class);
    public final PBStringField client_min_version = PBField.initString("");
    public final PBInt32Field launch_game_type = PBField.initInt32(0);
    public final PBBoolField create_with_battle = PBField.initBool(false);
    public final PBBoolField join_with_battle = PBField.initBool(false);
    public final PBBoolField owner_related_game_room = PBField.initBool(false);
    public final PBBoolField player_related_game_room = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 802, 808, 816, 824, 832, 840}, new String[]{"create_type", "is_auto_dismiss", "is_off_double_check", "base_room_id", "game_mode", "grade_list", "game_desc", "mode_name", "gift_config", "qq_live_room_config", "list_param_list", "client_min_version", "launch_game_type", "create_with_battle", "join_with_battle", "owner_related_game_room", "player_related_game_room"}, new Object[]{0, 0, 0, 0L, 0, 0, "", "", null, null, null, "", 0, bool, bool, bool, bool}, YoloRoomOuterClass$YoloCommonGameDataInfo.class);
    }
}
