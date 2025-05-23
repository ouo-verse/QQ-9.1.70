package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomKickOutSpeakingAction extends MessageMicro<YoloRoomOuterClass$YoloRoomKickOutSpeakingAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"user_id", "room_speaking_pos", "speaking_pos_list_version", "reason"}, new Object[]{null, null, 0, 0}, YoloRoomOuterClass$YoloRoomKickOutSpeakingAction.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    public final PBInt32Field reason = PBField.initInt32(0);
}
