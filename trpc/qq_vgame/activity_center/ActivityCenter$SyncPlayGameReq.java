package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ActivityCenter$SyncPlayGameReq extends MessageMicro<ActivityCenter$SyncPlayGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"play_game_id", "uin_list"}, new Object[]{"", 0L}, ActivityCenter$SyncPlayGameReq.class);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
