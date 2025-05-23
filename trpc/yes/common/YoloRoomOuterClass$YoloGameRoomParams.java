package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloGameRoomParams extends MessageMicro<YoloRoomOuterClass$YoloGameRoomParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 74}, new String[]{"game_mode", "grade_list", "base_room_id", "is_off_double_check", "is_auto_dismiss", "gift_config", "qq_live_room_config", "list_param_list", "create_schema"}, new Object[]{0, 0, 0L, 0, 0, null, null, null, null}, YoloRoomOuterClass$YoloGameRoomParams.class);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBUInt64Field base_room_id = PBField.initUInt64(0);
    public final PBInt32Field is_off_double_check = PBField.initInt32(0);
    public final PBInt32Field is_auto_dismiss = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloGiftConfig gift_config = new YoloRoomOuterClass$YoloGiftConfig();
    public YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config = new YoloRoomOuterClass$QQLiveRoomConfig();
    public final PBRepeatMessageField<YoloRoomOuterClass$ListParam> list_param_list = PBField.initRepeatMessage(YoloRoomOuterClass$ListParam.class);
    public YoloRoomOuterClass$YoloRoomCreateSchema create_schema = new YoloRoomOuterClass$YoloRoomCreateSchema();
}
