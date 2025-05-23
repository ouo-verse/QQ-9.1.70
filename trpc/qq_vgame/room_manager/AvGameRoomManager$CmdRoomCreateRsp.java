package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;
import trpc.qq_vgame.common.AvGameCommon$Result;
import trpc.qq_vgame.common.AvGameCommon$RoomInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomCreateRsp extends MessageMicro<AvGameRoomManager$CmdRoomCreateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"res", AegisLogger.ROOM_INFO, "auth_info", "black_ban_expire_time", "already_in_roomid"}, new Object[]{null, null, ByteStringMicro.EMPTY, 0, 0L}, AvGameRoomManager$CmdRoomCreateRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public AvGameCommon$RoomInfo room_info = new AvGameCommon$RoomInfo();
    public final PBBytesField auth_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field black_ban_expire_time = PBField.initUInt32(0);
    public final PBUInt64Field already_in_roomid = PBField.initUInt64(0);
}
