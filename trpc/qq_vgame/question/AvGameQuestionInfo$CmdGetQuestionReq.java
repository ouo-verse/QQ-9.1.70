package trpc.qq_vgame.question;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameQuestionInfo$CmdGetQuestionReq extends MessageMicro<AvGameQuestionInfo$CmdGetQuestionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"play_game_id", "uin", "req_src", AppConstants.Key.SHARE_REQ_TYPE}, new Object[]{"", 0L, 0, 0}, AvGameQuestionInfo$CmdGetQuestionReq.class);
    public final PBStringField play_game_id = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field req_src = PBField.initUInt32(0);
    public final PBUInt32Field req_type = PBField.initUInt32(0);
}
