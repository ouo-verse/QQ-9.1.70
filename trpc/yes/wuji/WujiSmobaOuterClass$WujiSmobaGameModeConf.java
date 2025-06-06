package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiSmobaOuterClass$WujiSmobaGameModeConf extends MessageMicro<WujiSmobaOuterClass$WujiSmobaGameModeConf> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBStringField mode_name = PBField.initString("");
    public final PBInt32Field game_type = PBField.initInt32(0);
    public final PBStringField mode_img = PBField.initString("");
    public final PBInt32Field min_player = PBField.initInt32(0);
    public final PBInt32Field max_player = PBField.initInt32(0);
    public final PBInt32Field battle_type = PBField.initInt32(0);
    public final PBBoolField is_use = PBField.initBool(false);
    public final PBBoolField is_use_in_room = PBField.initBool(false);
    public final PBBoolField is_time_limit = PBField.initBool(false);
    public final PBInt32Field start_week_day = PBField.initInt32(0);
    public final PBInt32Field end_week_day = PBField.initInt32(0);
    public final PBInt32Field battle_show_type = PBField.initInt32(0);
    public final PBInt32Field map_type = PBField.initInt32(0);
    public final PBInt32Field map_id = PBField.initInt32(0);
    public final PBInt32Field _sort = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 800}, new String[]{"game_mode", "mode_name", "game_type", "mode_img", "min_player", "max_player", "battle_type", "is_use", "is_use_in_room", "is_time_limit", "start_week_day", "end_week_day", "battle_show_type", "map_type", "map_id", "_sort"}, new Object[]{0, "", 0, "", 0, 0, 0, bool, bool, bool, 0, 0, 0, 0, 0, 0}, WujiSmobaOuterClass$WujiSmobaGameModeConf.class);
    }
}
