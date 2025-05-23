package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiSafeOuterClass$WujiSafeConf extends MessageMicro<WujiSafeOuterClass$WujiSafeConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64}, new String[]{"id", "send_interval_times", "forbidden_speech_time", "system_notice_message_num", "introduce", "game_room_send_interval_times", "send_greet_interval_times", "forbidden_speech_time_list"}, new Object[]{0, 0, 0, 0, "", 0, 0, 0}, WujiSafeOuterClass$WujiSafeConf.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f437267id = PBField.initInt32(0);
    public final PBInt32Field send_interval_times = PBField.initInt32(0);
    public final PBInt32Field forbidden_speech_time = PBField.initInt32(0);
    public final PBInt32Field system_notice_message_num = PBField.initInt32(0);
    public final PBStringField introduce = PBField.initString("");
    public final PBInt32Field game_room_send_interval_times = PBField.initInt32(0);
    public final PBInt32Field send_greet_interval_times = PBField.initInt32(0);
    public final PBRepeatField<Integer> forbidden_speech_time_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
