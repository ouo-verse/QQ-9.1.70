package tencent.im.cs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x2323$BodyMsg extends MessageMicro<cmd0x2323$BodyMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"group_code", "user_num", "action", "video_user_list", "stage_mode", "live_extra_mode", "game_id"}, new Object[]{0L, 0, 0, 0L, 0, 0, 0}, cmd0x2323$BodyMsg.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field user_num = PBField.initUInt32(0);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBRepeatField<Long> video_user_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field stage_mode = PBField.initUInt32(0);
    public final PBUInt32Field live_extra_mode = PBField.initUInt32(0);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
}
