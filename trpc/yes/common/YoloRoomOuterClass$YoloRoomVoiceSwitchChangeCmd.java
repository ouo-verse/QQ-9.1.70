package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 800}, new String[]{"uid", "op", "user_id", "change_switch_by_time_out"}, new Object[]{0L, 0, null, 0}, YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);

    /* renamed from: op, reason: collision with root package name */
    public final PBInt32Field f437266op = PBField.initInt32(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBInt32Field change_switch_by_time_out = PBField.initInt32(0);
}
