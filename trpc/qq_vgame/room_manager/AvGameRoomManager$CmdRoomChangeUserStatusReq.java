package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomChangeUserStatusReq extends MessageMicro<AvGameRoomManager$CmdRoomChangeUserStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"roomid", "uin", "user_status", "scene"}, new Object[]{0L, 0L, 0, 0}, AvGameRoomManager$CmdRoomChangeUserStatusReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField user_status = PBField.initEnum(0);
    public final PBEnumField scene = PBField.initEnum(0);
}
