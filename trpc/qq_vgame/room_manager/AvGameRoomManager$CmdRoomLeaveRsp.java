package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqlive.common.api.AegisLogger;
import trpc.qq_vgame.common.AvGameCommon$Result;
import trpc.qq_vgame.common.AvGameCommon$RoomInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomLeaveRsp extends MessageMicro<AvGameRoomManager$CmdRoomLeaveRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"res", AegisLogger.ROOM_INFO}, new Object[]{null, null}, AvGameRoomManager$CmdRoomLeaveRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
}
