package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$PKCardInfo extends MessageMicro<AvGameLobbyInfo$PKCardInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
    public final PBStringField title_url = PBField.initString("");
    public final PBStringField backgroud_url = PBField.initString("");
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
    public final PBBoolField is_reserve = PBField.initBool(false);
    public final PBUInt32Field reserve_user_num = PBField.initUInt32(0);
    public final PBUInt32Field play_user_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<AvGameLobbyInfo$PlayerInfo> player_list = PBField.initRepeatMessage(AvGameLobbyInfo$PlayerInfo.class);
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field color_start = PBField.initUInt32(0);
    public final PBUInt32Field color_end = PBField.initUInt32(0);
    public final PBStringField time_wording = PBField.initString("");
    public final PBEnumField game_type = PBField.initEnum(0);
    public final PBStringField background_color_url = PBField.initString("");
    public final PBBoolField is_qqcj_activity = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 106, 112, 122, 128}, new String[]{"pk_id", "title_url", "backgroud_url", "start_time", "end_time", "is_reserve", "reserve_user_num", "play_user_num", "player_list", "wording", "color_start", "color_end", "time_wording", "game_type", "background_color_url", "is_qqcj_activity"}, new Object[]{0, "", "", 0L, 0L, bool, 0, 0, null, "", 0, 0, "", 0, "", bool}, AvGameLobbyInfo$PKCardInfo.class);
    }
}
