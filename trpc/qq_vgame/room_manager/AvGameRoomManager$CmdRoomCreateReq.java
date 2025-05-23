package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomCreateReq extends MessageMicro<AvGameRoomManager$CmdRoomCreateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"from", "creator_uin", "group_id", "game_type", "scene", "pk_id", "pool_id", "trans_mod"}, new Object[]{0, 0L, 0L, 0, 0, 0, 0, 0}, AvGameRoomManager$CmdRoomCreateReq.class);
    public final PBEnumField from = PBField.initEnum(0);
    public final PBUInt64Field creator_uin = PBField.initUInt64(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBEnumField game_type = PBField.initEnum(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
    public final PBUInt32Field pool_id = PBField.initUInt32(0);
    public final PBUInt32Field trans_mod = PBField.initUInt32(0);
}
