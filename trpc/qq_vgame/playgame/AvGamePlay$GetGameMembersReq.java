package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$GetGameMembersReq extends MessageMicro<AvGamePlay$GetGameMembersReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "play_game_id"}, new Object[]{0L, ""}, AvGamePlay$GetGameMembersReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
}
