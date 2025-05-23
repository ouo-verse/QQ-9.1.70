package trpc.qq_vgame.user_heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameHeartBeat$CmdUserHeartBeatReq extends MessageMicro<AvGameHeartBeat$CmdUserHeartBeatReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"roomid", "uin", "room_state"}, new Object[]{0L, 0L, 0}, AvGameHeartBeat$CmdUserHeartBeatReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField room_state = PBField.initEnum(0);
}
