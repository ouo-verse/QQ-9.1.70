package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.UinConfigManager;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field create_from = PBField.initInt32(0);
    public final PBStringField introduce = PBField.initString("");
    public final PBStringField notice = PBField.initString("");
    public final PBStringField room_cover = PBField.initString("");
    public final PBStringField room_background_img = PBField.initString("");
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem> online_num_items = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem.class);
    public final PBStringField room_detail_background_img = PBField.initString("");
    public final PBInt32Field max_user_limit = PBField.initInt32(0);
    public final PBStringField room_background_img_v2 = PBField.initString("");
    public final PBStringField room_background_color_v2 = PBField.initString("");
    public final PBBoolField speaking_list_switch = PBField.initBool(false);
    public final PBBoolField is_show_third_part_gift = PBField.initBool(false);
    public final PBInt32Field apply_speaking_time_interval = PBField.initInt32(0);
    public final PBInt32Field kick_out_speaking_normal_user_time_interval = PBField.initInt32(0);
    public final PBBoolField apply_speaking_switch = PBField.initBool(false);
    public final PBInt32Field last_comm_room_stay_time = PBField.initInt32(0);
    public final PBInt32Field last_comm_room_cache_time = PBField.initInt32(0);
    public final PBStringField room_pin_icon = PBField.initString("");

    static {
        String[] strArr = {"create_from", "introduce", UinConfigManager.KEY_ADS, "room_cover", "room_background_img", "online_num_items", "room_detail_background_img", "max_user_limit", "room_background_img_v2", "room_background_color_v2", "speaking_list_switch", "is_show_third_part_gift", "apply_speaking_time_interval", "kick_out_speaking_normal_user_time_interval", "apply_speaking_switch", "last_comm_room_stay_time", "last_comm_room_cache_time", "room_pin_icon"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 74, 82, 88, 96, 104, 112, 120, 128, 136, 146}, strArr, new Object[]{0, "", "", "", "", null, "", 0, "", "", bool, bool, 0, 0, bool, 0, 0, ""}, WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.class);
    }
}
