package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomJoinGameAction extends MessageMicro<YoloRoomOuterClass$YoloRoomJoinGameAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{AegisLogger.ROOM_INFO, "user_id", "room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, null, null, 0}, YoloRoomOuterClass$YoloRoomJoinGameAction.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}
