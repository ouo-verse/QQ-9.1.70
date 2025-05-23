package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField room_background_img = PBField.initString("");
    public final PBBoolField is_use_voice = PBField.initBool(false);
    public final PBStringField room_background_img_v2 = PBField.initString("");
    public final PBStringField room_background_color_v2 = PBField.initString("");
    public final PBInt32Field lanetype_message_send_time_interval = PBField.initInt32(0);
    public final PBBoolField is_use_tgpa = PBField.initBool(false);
    public final PBInt32Field room_expire_user_timeout = PBField.initInt32(0);
    public final PBInt32Field wait_join_game_timeout = PBField.initInt32(0);
    public final PBInt32Field wait_battle_begin_timeout = PBField.initInt32(0);
    public final PBInt32Field wait_battle_end_timeout = PBField.initInt32(0);
    public final PBInt32Field daily_user_create_limit = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 800, 808, 816, 824, 832}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "lanetype_message_send_time_interval", "is_use_tgpa", "room_expire_user_timeout", "wait_join_game_timeout", "wait_battle_begin_timeout", "wait_battle_end_timeout", "daily_user_create_limit"}, new Object[]{"", bool, "", "", 0, bool, 0, 0, 0, 0, 0}, WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf.class);
    }
}
