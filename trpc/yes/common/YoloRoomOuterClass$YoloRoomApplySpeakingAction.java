package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomApplySpeakingAction extends MessageMicro<YoloRoomOuterClass$YoloRoomApplySpeakingAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_id", "apply_time_ms"}, new Object[]{null, 0L}, YoloRoomOuterClass$YoloRoomApplySpeakingAction.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBUInt64Field apply_time_ms = PBField.initUInt64(0);
}
