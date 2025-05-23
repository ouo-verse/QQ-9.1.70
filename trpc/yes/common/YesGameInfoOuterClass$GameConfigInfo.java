package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigInfo extends MessageMicro<YesGameInfoOuterClass$GameConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74, 82, 90, 98, 106, 112, 122, 130, 136, 146}, new String[]{"game_id", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_icon", "game_download_url", "game_ios_scheme", "game_adr_scheme", "game_room_type", "game_package_name", "team_info", AegisLogger.ROOM_INFO, "team_room_info", "game_helper_icon", "game_helper_name", "game_helper_uid", "game_teaming_icon", "team_float_window_icon", "style_mode", "game_input_common"}, new Object[]{0, "", "", "", "", "", 0, "", null, null, null, "", "", 0L, "", "", 0, null}, YesGameInfoOuterClass$GameConfigInfo.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField game_name = PBField.initString("");
    public final PBStringField game_icon = PBField.initString("");
    public final PBStringField game_download_url = PBField.initString("");
    public final PBStringField game_ios_scheme = PBField.initString("");
    public final PBStringField game_adr_scheme = PBField.initString("");
    public final PBInt32Field game_room_type = PBField.initInt32(0);
    public final PBStringField game_package_name = PBField.initString("");
    public YesGameInfoOuterClass$GameConfigTeamInfo team_info = new YesGameInfoOuterClass$GameConfigTeamInfo();
    public YesGameInfoOuterClass$GameConfigRoom room_info = new YesGameInfoOuterClass$GameConfigRoom();
    public YesGameInfoOuterClass$GameConfigTeamRoom team_room_info = new YesGameInfoOuterClass$GameConfigTeamRoom();
    public final PBStringField game_helper_icon = PBField.initString("");
    public final PBStringField game_helper_name = PBField.initString("");
    public final PBUInt64Field game_helper_uid = PBField.initUInt64(0);
    public final PBStringField game_teaming_icon = PBField.initString("");
    public final PBStringField team_float_window_icon = PBField.initString("");
    public final PBInt32Field style_mode = PBField.initInt32(0);
    public YesGameInfoOuterClass$InputCommonConfig game_input_common = new YesGameInfoOuterClass$InputCommonConfig();
}
