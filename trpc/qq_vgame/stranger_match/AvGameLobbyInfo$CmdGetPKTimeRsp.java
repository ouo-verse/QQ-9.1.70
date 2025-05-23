package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$CmdGetPKTimeRsp extends MessageMicro<AvGameLobbyInfo$CmdGetPKTimeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"res", "start_time", "end_time"}, new Object[]{null, 0L, 0L}, AvGameLobbyInfo$CmdGetPKTimeRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
}
