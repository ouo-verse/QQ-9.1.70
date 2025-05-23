package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$LiveRoomUpdateTeamInfoMsg extends MessageMicro<MessageOuterClass$LiveRoomUpdateTeamInfoMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"live_team_info", "game_start"}, new Object[]{null, 0}, MessageOuterClass$LiveRoomUpdateTeamInfoMsg.class);
    public YoloTeamOuterClass$YoloLiveTeamInfo live_team_info = new YoloTeamOuterClass$YoloLiveTeamInfo();
    public final PBInt32Field game_start = PBField.initInt32(0);
}
