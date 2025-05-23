package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$QuestionManagerAuthReq extends MessageMicro<AvGamePlay$QuestionManagerAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "scene", "play_game_id"}, new Object[]{0L, 0, ""}, AvGamePlay$QuestionManagerAuthReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBStringField play_game_id = PBField.initString("");
}
