package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.qq_vgame.common.AvGameCommon$GameInfo;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$CmdGetConfigRsp extends MessageMicro<AvGameList$CmdGetConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"game_info", "res"}, new Object[]{null, null}, AvGameList$CmdGetConfigRsp.class);
    public AvGameCommon$GameInfo game_info = new AvGameCommon$GameInfo();
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
