package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameQuestionInfo$CmdAnswerQuestionReq extends MessageMicro<AvGameQuestionInfo$CmdAnswerQuestionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uin", "play_game_id", "answer", "trans_mod", "trans_cost"}, new Object[]{0L, "", "", 0, 0}, AvGameQuestionInfo$CmdAnswerQuestionReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBStringField answer = PBField.initString("");
    public final PBUInt32Field trans_mod = PBField.initUInt32(0);
    public final PBUInt32Field trans_cost = PBField.initUInt32(0);
}
