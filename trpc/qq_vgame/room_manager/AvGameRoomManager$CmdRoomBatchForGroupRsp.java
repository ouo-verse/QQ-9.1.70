package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;
import trpc.qq_vgame.common.AvGameCommon$RoomInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomBatchForGroupRsp extends MessageMicro<AvGameRoomManager$CmdRoomBatchForGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"res", "total_room_num", "next", "is_end", "room_infos"}, new Object[]{null, 0, 0, 0, null}, AvGameRoomManager$CmdRoomBatchForGroupRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt32Field total_room_num = PBField.initUInt32(0);
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<AvGameCommon$RoomInfo> room_infos = PBField.initRepeatMessage(AvGameCommon$RoomInfo.class);
}
