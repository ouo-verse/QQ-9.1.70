package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction extends MessageMicro<YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{AegisLogger.ROOM_INFO, "status_change_text", "room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, "", null, 0}, YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public final PBStringField status_change_text = PBField.initString("");
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}
