package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloGameRoomOwnerChangeAction extends MessageMicro<YoloRoomOuterClass$YoloGameRoomOwnerChangeAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"from_user_id", "to_user_id", "room_speaking_pos_list", "speaking_pos_list_version", "reason"}, new Object[]{null, null, null, 0, 0}, YoloRoomOuterClass$YoloGameRoomOwnerChangeAction.class);
    public CommonOuterClass$QQUserId from_user_id = new CommonOuterClass$QQUserId();
    public CommonOuterClass$QQUserId to_user_id = new CommonOuterClass$QQUserId();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    public final PBInt32Field reason = PBField.initInt32(0);
}
