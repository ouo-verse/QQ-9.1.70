package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomEnterReq extends MessageMicro<AvGameRoomManager$CmdRoomEnterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"from", "roomid", "uin", "invitor_uin", "init_status", "scene", "pk_opponent_uin", "trans_mod"}, new Object[]{0, 0L, 0L, 0L, 0, 0, 0L, 0}, AvGameRoomManager$CmdRoomEnterReq.class);
    public final PBEnumField from = PBField.initEnum(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field invitor_uin = PBField.initUInt64(0);
    public final PBUInt32Field init_status = PBField.initUInt32(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt64Field pk_opponent_uin = PBField.initUInt64(0);
    public final PBUInt32Field trans_mod = PBField.initUInt32(0);
}
