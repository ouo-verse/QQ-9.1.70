package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameRoomManager$CmdRoomDestroyRsp extends MessageMicro<AvGameRoomManager$CmdRoomDestroyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res"}, new Object[]{null}, AvGameRoomManager$CmdRoomDestroyRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
