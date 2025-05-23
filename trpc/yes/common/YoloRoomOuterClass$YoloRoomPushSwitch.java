package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomPushSwitch extends MessageMicro<YoloRoomOuterClass$YoloRoomPushSwitch> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_off_all = PBField.initBool(false);
    public final PBBoolField is_off_battle_result_push = PBField.initBool(false);
    public final PBBoolField is_off_send_gift_push = PBField.initBool(false);
    public final PBBoolField is_off_user_enter_push = PBField.initBool(false);
    public final PBBoolField is_off_other_push = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 80}, new String[]{"is_off_all", "is_off_battle_result_push", "is_off_send_gift_push", "is_off_user_enter_push", "is_off_other_push"}, new Object[]{bool, bool, bool, bool, bool}, YoloRoomOuterClass$YoloRoomPushSwitch.class);
    }
}
