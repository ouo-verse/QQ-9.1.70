package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomGameStatusChangeReq extends MessageMicro<AvGameRoomManager$CmdRoomGameStatusChangeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"roomid", "uin", "type"}, new Object[]{0L, 0L, 0}, AvGameRoomManager$CmdRoomGameStatusChangeReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}
