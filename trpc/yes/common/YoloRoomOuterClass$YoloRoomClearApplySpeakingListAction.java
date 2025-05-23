package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomClearApplySpeakingListAction extends MessageMicro<YoloRoomOuterClass$YoloRoomClearApplySpeakingListAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_id", "clear_time_ms"}, new Object[]{null, 0L}, YoloRoomOuterClass$YoloRoomClearApplySpeakingListAction.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBUInt64Field clear_time_ms = PBField.initUInt64(0);
}
