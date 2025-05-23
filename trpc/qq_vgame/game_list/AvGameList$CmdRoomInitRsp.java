package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$CmdRoomInitRsp extends MessageMicro<AvGameList$CmdRoomInitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res"}, new Object[]{null}, AvGameList$CmdRoomInitRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
