package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$CmdGetGameLobbyInfoReq extends MessageMicro<AvGameLobbyInfo$CmdGetGameLobbyInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"version"}, new Object[]{""}, AvGameLobbyInfo$CmdGetGameLobbyInfoReq.class);
    public final PBStringField version = PBField.initString("");
}
