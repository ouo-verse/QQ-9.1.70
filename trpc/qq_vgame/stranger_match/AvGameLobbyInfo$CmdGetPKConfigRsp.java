package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$CmdGetPKConfigRsp extends MessageMicro<AvGameLobbyInfo$CmdGetPKConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"res", "pk_config_list"}, new Object[]{null, null}, AvGameLobbyInfo$CmdGetPKConfigRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBRepeatMessageField<AvGameLobbyInfo$PkConfig> pk_config_list = PBField.initRepeatMessage(AvGameLobbyInfo$PkConfig.class);
}
