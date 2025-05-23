package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$ShareYoloTeamReq extends MessageMicro<YoloRoomOuterClass$ShareYoloTeamReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{AegisLogger.ROOM_INFO, "room_speaking_pos_list", "share_to_room_id"}, new Object[]{null, null, 0L}, YoloRoomOuterClass$ShareYoloTeamReq.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBUInt64Field share_to_room_id = PBField.initUInt64(0);
}
