package trpc.qq_vgame.pk_reserve;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGameLobbyPKReserve$ReserveRsp extends MessageMicro<AvGameLobbyPKReserve$ReserveRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res"}, new Object[]{null}, AvGameLobbyPKReserve$ReserveRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
