package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGameLobbyInfo$PlayerInfo extends MessageMicro<AvGameLobbyInfo$PlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uid"}, new Object[]{0L}, AvGameLobbyInfo$PlayerInfo.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
