package trpc.yes.common;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloCommonUserGameData extends MessageMicro<YoloRoomOuterClass$YoloCommonUserGameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 74, 82, 88, 96, 106, 802, 810}, new String[]{"game_status", "game_status_desc", "user_room_status", "user_room_status_desc", "update_status", "update_process", MsfConstants.ATTRIBUTE_LOGIN_TYPE, "phone_system", "game_openid", "game_role_info", "user_room_status_button_style", "user_room_status_button_event", "game_gopenid", "gift_data", "tgpa_version_info"}, new Object[]{0, "", 0, "", 0, 0, 0, 0, "", null, 0, 0, "", null, null}, YoloRoomOuterClass$YoloCommonUserGameData.class);
    public final PBInt32Field game_status = PBField.initInt32(0);
    public final PBStringField game_status_desc = PBField.initString("");
    public final PBInt32Field user_room_status = PBField.initInt32(0);
    public final PBStringField user_room_status_desc = PBField.initString("");
    public final PBInt32Field update_status = PBField.initInt32(0);
    public final PBInt32Field update_process = PBField.initInt32(0);
    public final PBInt32Field login_type = PBField.initInt32(0);
    public final PBInt32Field phone_system = PBField.initInt32(0);
    public final PBStringField game_openid = PBField.initString("");
    public YesGameInfoOuterClass$YesGameRoleInfo game_role_info = new YesGameInfoOuterClass$YesGameRoleInfo();
    public final PBInt32Field user_room_status_button_style = PBField.initInt32(0);
    public final PBInt32Field user_room_status_button_event = PBField.initInt32(0);
    public final PBStringField game_gopenid = PBField.initString("");
    public YoloRoomOuterClass$YoloGiftData gift_data = new MessageMicro<YoloRoomOuterClass$YoloGiftData>() { // from class: trpc.yes.common.YoloRoomOuterClass$YoloGiftData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"task_id", "bill_no"}, new Object[]{"", ""}, YoloRoomOuterClass$YoloGiftData.class);
        public final PBStringField task_id = PBField.initString("");
        public final PBStringField bill_no = PBField.initString("");
    };
    public UserProxyCmdOuterClass$TgpaNewVersionInfo tgpa_version_info = new UserProxyCmdOuterClass$TgpaNewVersionInfo();
}
