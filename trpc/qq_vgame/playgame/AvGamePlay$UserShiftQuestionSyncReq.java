package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$GameQuestionInfo;

/* loaded from: classes29.dex */
public final class AvGamePlay$UserShiftQuestionSyncReq extends MessageMicro<AvGamePlay$UserShiftQuestionSyncReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "play_game_id", "question_info"}, new Object[]{0L, "", null}, AvGamePlay$UserShiftQuestionSyncReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
}
