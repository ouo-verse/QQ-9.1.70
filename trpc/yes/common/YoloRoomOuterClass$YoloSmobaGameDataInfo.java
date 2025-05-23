package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaGameDataInfo extends MessageMicro<YoloRoomOuterClass$YoloSmobaGameDataInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "game_mode", "grade_list", "voice_control", "mode_name", "create_type", "is_auto_dismiss", "is_off_double_check", "base_room_id", "need_lane_type", "use_smoba_grade_check_rule"}, new Object[]{0, 0, 0, 0, "", 0, 0, 0, 0L, 0, Boolean.FALSE}, YoloRoomOuterClass$YoloSmobaGameDataInfo.class);
    public final PBUInt64Field base_room_id;
    public final PBInt32Field create_type;
    public final PBRepeatField<Integer> grade_list;
    public final PBInt32Field is_auto_dismiss;
    public final PBInt32Field is_off_double_check;
    public final PBStringField mode_name;
    public final PBRepeatField<Integer> need_lane_type;
    public final PBBoolField use_smoba_grade_check_rule;
    public final PBInt32Field voice_control;
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field game_mode = PBField.initInt32(0);

    public YoloRoomOuterClass$YoloSmobaGameDataInfo() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.grade_list = PBField.initRepeat(pBInt32Field);
        this.voice_control = PBField.initInt32(0);
        this.mode_name = PBField.initString("");
        this.create_type = PBField.initInt32(0);
        this.is_auto_dismiss = PBField.initInt32(0);
        this.is_off_double_check = PBField.initInt32(0);
        this.base_room_id = PBField.initUInt64(0L);
        this.need_lane_type = PBField.initRepeat(pBInt32Field);
        this.use_smoba_grade_check_rule = PBField.initBool(false);
    }
}
