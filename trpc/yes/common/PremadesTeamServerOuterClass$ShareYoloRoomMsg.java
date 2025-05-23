package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.common.api.AegisLogger;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$ShareYoloRoomMsg extends MessageMicro<PremadesTeamServerOuterClass$ShareYoloRoomMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{AegisLogger.ROOM_INFO, "room_speaking_pos_list", "team_info"}, new Object[]{null, null, null}, PremadesTeamServerOuterClass$ShareYoloRoomMsg.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public PremadesTeamServerOuterClass$YesGamePremadesTeamInfo team_info = new PremadesTeamServerOuterClass$YesGamePremadesTeamInfo();
}
