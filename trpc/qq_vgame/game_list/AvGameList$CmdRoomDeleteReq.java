package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$CmdRoomDeleteReq extends MessageMicro<AvGameList$CmdRoomDeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"roomid"}, new Object[]{0L}, AvGameList$CmdRoomDeleteReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
}
