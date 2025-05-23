package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$CmdGetPKTimeReq extends MessageMicro<AvGameLobbyInfo$CmdGetPKTimeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"pk_id"}, new Object[]{0}, AvGameLobbyInfo$CmdGetPKTimeReq.class);
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
}
