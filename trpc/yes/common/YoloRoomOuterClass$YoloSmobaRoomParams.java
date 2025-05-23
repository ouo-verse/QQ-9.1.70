package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaRoomParams extends MessageMicro<YoloRoomOuterClass$YoloSmobaRoomParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 80, 90, 98}, new String[]{"game_mode", "grade_list", "voice_control", "is_off_double_check", "is_auto_dismiss", "base_room_id", "role_id", "role_abs_info", "role_info", "need_lane_type", "gift_config", "qq_live_room_config"}, new Object[]{0, 0, 0, 0, 0, 0L, null, null, null, 0, null, null}, YoloRoomOuterClass$YoloSmobaRoomParams.class);
    public final PBUInt64Field base_room_id;
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloGiftConfig gift_config;
    public final PBRepeatField<Integer> grade_list;
    public final PBInt32Field is_auto_dismiss;
    public final PBInt32Field is_off_double_check;
    public final PBRepeatField<Integer> need_lane_type;
    public YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config;
    public GameDataServerOuterClass$GameRoleAbsInfo role_abs_info;
    public GameDataServerOuterClass$GameRoleId role_id;
    public GameDataServerOuterClass$GameRoleInfo role_info;
    public final PBInt32Field voice_control;

    public YoloRoomOuterClass$YoloSmobaRoomParams() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.grade_list = PBField.initRepeat(pBInt32Field);
        this.voice_control = PBField.initInt32(0);
        this.is_off_double_check = PBField.initInt32(0);
        this.is_auto_dismiss = PBField.initInt32(0);
        this.base_room_id = PBField.initUInt64(0L);
        this.role_id = new GameDataServerOuterClass$GameRoleId();
        this.role_abs_info = new GameDataServerOuterClass$GameRoleAbsInfo();
        this.role_info = new GameDataServerOuterClass$GameRoleInfo();
        this.need_lane_type = PBField.initRepeat(pBInt32Field);
        this.gift_config = new YoloRoomOuterClass$YoloGiftConfig();
        this.qq_live_room_config = new YoloRoomOuterClass$QQLiveRoomConfig();
    }
}
