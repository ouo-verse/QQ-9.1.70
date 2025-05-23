package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomEnterRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomEnterRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 66, 74}, new String[]{AegisLogger.ROOM_INFO, "room_speaking_pos_list", "speaking_pos_list_version", "room_conf", "cur_action_id", "rotate_messsage_list", "room_user_data", "ieg_real_name_result"}, new Object[]{null, null, 0, null, 0L, null, null, null}, YoloRoomOuterClass$YoloRoomEnterRsp.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloRoomConf room_conf = new YoloRoomOuterClass$YoloRoomConf();
    public final PBUInt64Field cur_action_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomRotateMessage> rotate_messsage_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomRotateMessage.class);
    public YoloRoomOuterClass$YoloRoomUserData room_user_data = new YoloRoomOuterClass$YoloRoomUserData();
    public SafeOuterClass$SafeCheckResult ieg_real_name_result = new SafeOuterClass$SafeCheckResult();
}
