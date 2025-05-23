package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomLeaveReq extends MessageMicro<AvGameRoomManager$CmdRoomLeaveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"roomid", "reason", "operator_uin", "target_uin", "no_need_ban", "scene"}, new Object[]{0L, 0, 0L, 0L, Boolean.FALSE, 0}, AvGameRoomManager$CmdRoomLeaveReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt32Field reason = PBField.initUInt32(0);
    public final PBUInt64Field operator_uin = PBField.initUInt64(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
    public final PBBoolField no_need_ban = PBField.initBool(false);
    public final PBEnumField scene = PBField.initEnum(0);
}
