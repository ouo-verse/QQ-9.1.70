package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomGameConf extends MessageMicro<YoloRoomOuterClass$YoloRoomGameConf> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField room_background_img = PBField.initString("");
    public final PBBoolField is_use_voice = PBField.initBool(false);
    public final PBStringField room_background_img_v2 = PBField.initString("");
    public final PBStringField room_background_color_v2 = PBField.initString("");
    public final PBBoolField is_use_tgpa = PBField.initBool(false);
    public final PBStringField game_room_notice = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50}, new String[]{"room_background_img", "is_use_voice", "room_background_img_v2", "room_background_color_v2", "is_use_tgpa", "game_room_notice"}, new Object[]{"", bool, "", "", bool, ""}, YoloRoomOuterClass$YoloRoomGameConf.class);
    }
}
