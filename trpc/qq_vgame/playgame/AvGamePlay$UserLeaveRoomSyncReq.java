package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$UserLeaveRoomSyncReq extends MessageMicro<AvGamePlay$UserLeaveRoomSyncReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "roomid", "scene"}, new Object[]{0L, 0L, 0}, AvGamePlay$UserLeaveRoomSyncReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt32Field scene = PBField.initUInt32(0);
}
