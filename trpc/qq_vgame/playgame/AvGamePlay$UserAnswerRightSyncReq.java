package trpc.qq_vgame.playgame;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$GameQuestionInfo;

/* loaded from: classes29.dex */
public final class AvGamePlay$UserAnswerRightSyncReq extends MessageMicro<AvGamePlay$UserAnswerRightSyncReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uin", "play_game_id", "cur_question_info", LocalPhotoFaceInfo.SCORE}, new Object[]{0L, "", null, 0}, AvGamePlay$UserAnswerRightSyncReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField play_game_id = PBField.initString("");
    public AvGameCommon$GameQuestionInfo cur_question_info = new AvGameCommon$GameQuestionInfo();
    public final PBUInt32Field score = PBField.initUInt32(0);
}
